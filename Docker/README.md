# Docker

## docker images

Docker 내에 있는 이미지의 내역을 보여줌

## docker pull {image name}

docker hub에 있는 이미지를 가져와서 pull해줌

## docker ps {-a}

docker의 컨테이너 리스트를 출력

## docker run {--name name} {-p local port:port} {image name}

docker image를 실행시켜 container로 만듬

## docker stop {image name}

docker container를 정지시킴

## docker log {-f} {image name}

Docker container의 log를 출력

## docker exec {image name} {실행할 명령어}

docker container 내에 실행할 명령어를 실행

### docker exec {-it} {image name} /bin/sh

- docker container에 지속적인 명령을 할 때 shell을 열어 위의 명력어를 반복적으로 치지 않고도 실행할 명령어만 typing하면 되게 창을 띄움

- docker desktop에서 CLI버튼을 눌러도 같은 화면이 뜸
- exit로 나올 수 있음
- docker exec {-it} {image name} /bin/bash가 좀 더 자주 쓰이지만 없는 경우도 있음

## docker host와 container 연동

docker run {--name container name} -p {host port:port} -v {host 절대경로}:/usr/local/apache2/htdocs/ {image name}



## EC2 와 연결

1. ```cd .ssh```
2. ```ssh oneline```

우분투 환경인 EC2로 이동

config 파일을 열어 ec2 설정을 열어볼 수 있다.