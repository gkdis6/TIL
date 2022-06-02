'use strict';

const business = require('./12_monolithic_members');
const cluster = require('cluster');

class members extends require('./17_server.js'){
    constructor() {
        super("members"
            , process.argv[2] ? Number(process.argv[2]) : 9020
            , ["POST/members", "GET/members", "DELETE/members"]
        );

        this.connectToDistributor("127.0.0.1", 9000, (data) => {
            console.log("Distributor Notification", data);
        });
    }

    onRead(socket, data) {
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
    new members();
}