| client                                                       | server                                                       |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| initialize                                                   |                                                              |
| discover peers                                               |                                                              |
| request peer                                                 |                                                              |
| 기기 클릭 시 connect                                         |                                                              |
|                                                              | connect 요청 받음                                            |
|                                                              | wifiP2pmanger.groupInfo의 host address를 통해 Inetaddress로 접속<br />Inetaddress는 port와 hostaddress만으로 간단한 정보를 짧게 주고받을 수 있게 해줌(10초 정도) |
|                                                              | ip주소 전송. 현재 변수명 clientIP로 되어있음 수정해야함      |
| ip주소 수신                                                  | socket 연결(port) - setServer(Thread)                        |
| socket 연결(수신받은 ip주소, port)<br />Connect(Thread) - ClientSocket(Thread) |                                                              |

- 현재 포트 종료가 제대로 되지 않고 있음.
- 다 기기 연결을 하려고 했지만 ip가 전송되지 않는지 socket이 하나라 그런지 다음 기기가 ip를 전송받지 못하고 있음.
- onCreate되었을 때 server와 socket을 닫게 해봤지만 먹히지 않음
- detail페이지가 없기 때문에 내 기기의 현재 상태가 변했을 때 표시해주는 **WIFI_P2P_THIS_DEVICE_CHANGED_ACTION** 사용되지 않음

## 전체 과정

1. initP2p( initialize )
2. 이후는 회사 가서 수정