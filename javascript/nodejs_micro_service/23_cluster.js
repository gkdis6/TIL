const cluster = require('cluster');
const http = require('http');
const numCPUs = require('os').cpus().length; // CPU 코어 수를 알아옴

if(cluster.isMaster){
    console.log(`Master ${process.pid} is running`);

    for(let i = 0; i < numCPUs; i++){
        cluster.fork(); // 코어 수만큼 자식 프로세스 실행
    }

    cluster.on('exit', (worker, code, signal) => { // 자식 프로세스 종료 이벤트 감지
        console.log(`worker ${worker.process.pid} died`);
    });
} else {
    http.createServer((req, res) =>{
        res.writeHead(200);
        res.end('hello world\n');
    }).listen(8000);

    console.log(`Worker ${process.pid} started`);
}