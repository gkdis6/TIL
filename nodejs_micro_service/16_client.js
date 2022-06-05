'use strict'; //문법에 기초적인 실수가 있을 경우 실행 시점에 에러 표시

const { connect } = require('http2');
const net = require('net');

//생성자
class tcpClient {
    constructor(host, port, onCreate, onRead, onEnd, onError){
        this.options = {
            host: host,
            port: port
        };
        this.onCreate = onCreate;
        this.onRead = onRead;
        this.onEnd = onEnd;
        this.onError = onError;
    }

    //접속함수
    connect(){
        this.client = net.connect(this.options, () => {
            if(this.onCreate)
                this.onCreate(this.options);
        });
        //데이터 수신 처리
        this.client.on('data', (data) => {
            var sz = this.merge ? this.merge + data.toString() : data.toString();
            var arr = sz.split('¶');
            for (var n in arr){
                if(sz.charAt(sz.length -1) != '¶' && n == arr.length -1) {
                    this.merge = arr[n];
                    break;
                } else if (arr[n] == ""){
                    break;
                } else {
                    this.onRead(this.options, JSON.parse(arr[n]));
                }
            }
        });
        //접속 종료 처리
        this.client.on('close', () => {
            if(this.onEnd)
                this.onEnd(this.options);
        });
        //에러 처리
        this.client.on('error', (err) => {
            if(this.onError)
                this.onError(this.options, err);
        });
    }
    //데이터 발송
    write(packet){
        this.client.write(JSON.stringify(packet) + '¶');
    }
}

module.exports = tcpClient; //외부 참조할 수 있게 exports 하는 부분