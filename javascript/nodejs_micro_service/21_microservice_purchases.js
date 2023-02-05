'use strict';

const business = require('./14_monolithic_purchases.js');
const cluster = require('cluster');

class purchases extends require('./17_server.js') {
    constructor() {
        super("purchases"
            , process.argv[2] ? Number(process.argv[2]) : 9030
            , ["POST/purchases", "GET/purchases"]
        );

        this.connectToDistributor("127.0.0.1", 9000, (data) => {
            console.log("Distributor Notification", data);
        });
    }

    onRead(socket, data){
        console.log("onRead", socket.remoteAddress, socket.remotePort, data);
        business.onRequest(socket, data.method, data.uri, data.params, (s, packet) => {
            socket.write(JSON.stringify(packet) + '¶');
        });
    }
}

if(cluster.isMaster){
    cluster.fork();

    cluster.on('exit', (worker, code, signal) => { // 자식 프로세스 종료 이벤트 감지
        console.log(`worker ${worker.process.pid} died`);
        cluster.fork();
    });
} else {
    new purchases();
}