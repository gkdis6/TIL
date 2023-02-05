'use strict'

const http = require('http');
const url = require('url');
const querystring = require('querystring');
const tcpClient = require('./16_client.js');

var mapClients = {};
var mapUrls = {};
var mapResponse = {};
var mapRR = {};
var index = 0;

//HTTP 서버 생성
var server = http.createServer((req, res) => {
    var method = req.method;
    var uri = url.parse(req.url, true);
    var pathname = uri.pathname;

    if(method === "POST" || method === "PUT"){
        var body = "";

        req.on('data', function (data){
            body += data;
        });
        req.on('end', function () {
            var params;
            if(req.headers['content-type'] == "application/json") {
                params = JSON.parse(body);
            }else {
                params = querystring.parse(body);
            }

            onRequest(res, method, pathname, params);
        });
    }else {
        onRequest(res, method, pathname, uri.query);
    }
}).listen(8000, () => {
    console.log('listen', server.address());

    //Distributor와 통신 처리
    var packet = {
        uri: "/distributes",
        method: "POST",
        key: 0,
        params: {
            port: 8000,
            name: "gate",
            urls: []
        }
    };
    var isConnectedDistributor = false;

    this.clientDistributor = new tcpClient(
        "127.0.0.1"
        , 9000
        , (options) => { //접속 이벤트
            isConnectedDistributor = true;
            this.clientDistributor.write(packet);
        }
        , (options, data) => { onDistribute(data); } // 데이터 수신 이벤트
        , (options) => { isConnectedDistributor = false; } // 접속 종료 이벤트
        , (options) => { isConnectedDistributor = false; } // 에러 이벤트
    );

    // 주기적인 Distributor 접속 상태 확인
    setInterval(() => {
        if(isConnectedDistributor != true) {
            this.clientDistributor.connect();
        }
    }, 3000);
});

//API 호출 처리
function onRequest(res, method, pathname, params){
    var key = method + pathname;
    var client = mapUrls[key];
    if(client == null){ // 처리 가능한 API만 처리
        res.writeHead(404);
        res.end();
        return;
    }else{
        params.key = index; // 고유키 발급
        var packet = {
            uri: pathname,
            method: method,
            params: params
        };

        mapResponse[index] = res; // 요청에 대한 응답 객체 저장
        index++; // 고유 값 증가

        if(mapRR[key] == null) // 라운드 로빈 처리
            mapRR[key] = 0;
        mapRR[key]++;
        client[mapRR[key] % client.length].write(packet); // 마이크로서비스에 요청
    }
}

//Distributor 접속 처리
function onDistribute(data) {
    for(var n in data.params) {
        var node = data.params[n];
        var key = node.host + ":" + node.port;
        if(mapClients[key] == null && node.name != "gate"){
            var client = new tcpClient(node.host, node.port, onCreateClient,
                onReadClient, onEndClient, onErrorClient);

            mapClients[key] = {
                client: client,
                info: node
            };
            for(var m in node.urls){
                var key = node.urls[m];
                if(mapUrls[key] == null){
                    mapUrls[key] = [];
                }
                mapUrls[key].push(client);
            }
            client.connect();
        }
    }
}

//마이크로서비스 접속 이벤트 처리
function onCreateClient(options) {
    console.log("onCreateClient");
}

function onReadClient(options, packet){ // 마이크로서비스 응답
    console.log("onReadClient", packet);
    mapResponse[packet.key].writeHead(200, {'Content-Type':'application/json'});
    mapResponse[packet.key].end(JSON.stringify(packet));
    delete mapResponse[packet.key]; // 응답 객체 삭제
}

function onEndClient(options){
    var key = options.host + ":" + options.port;
    console.log("onEndClient", mapClients[key]);
    for(var n in mapClients[key].info.urls){
        var node = mapClients[key].info.urls[n];
        delete mapUrls[node];
    }
    delete mapClients[key];
}

function onErrorClient(options) {
    console.log("onErrorClient");
}