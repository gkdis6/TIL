var http = require('http');

var options = { //호출 페이지 정보 설정
    host: "127.0.0.1",
    port: 8000,
    path: "/"
};

var req = http.request(options, (res) => {
    var data = "";
    res.on('data', (chunk) => {
        data += chunk;
    });

    res.on('end', () => {
        console.log(data);
    });
});

req.end();