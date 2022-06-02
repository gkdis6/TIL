'use strict';

//비즈니스 로직 파일 참조
const business = require('./13_monolithic_goods.js');
const cluster = require('cluster');

//Server 클래스 참조
class goods extends require('./17_server.js'){
    constructor(){
        super("goods" //부모 클래스 생성자 호출
            , process.argv[2]? Number(process.argv[2]) : 9010
            , ["POST/goods", "GET/goods", "DELETE/goods"]
        );

        this.connectToDistributor("127.0.0.1", 9000, (data) => { //Distributor 접속
            console.log("Distributor Notification", data);
        });
    }

    //클라이언트 요청에 따른 비즈니스 로직 호출
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
    new goods();
}
