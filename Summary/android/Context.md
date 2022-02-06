# Context

액티비티, 서비스 등의 컴포넌트와 스피너, 리사이클러뷰와 같은 화면 요소를 사용하기 위해서 필요한 것으로 앱을 실행하기 위해 잘 짜여진 설계도의 개념으로 앱에서 사용하는 기본 기능이 담겨 있는 기본 클래스.
액티비티는 컨텍스트를 상속받아 구현된다.
액티비티처럼 컨텍스트를 상속받은 컴포넌트들은 코드상에서 baseContext를 호출하는 것만으로 안드로이드의 기본 기능을 사용할 수 있다. 
예로 액티비티 안에서 startActivity() 메서드를 통해 다른 액티비티를 호출할 수 있는 것도 모든 액티비티가 startActivity()가 설계되어 있는 컨텍스트를 상속받아 구현되어 있기 때문이다.

Context는 시스템을 사용하기 위한 정보(property)와 도구(method)가 담겨있는 클래스.
대부분의 컨텍스트는 컴포넌트 실행(runtime)시 함께 생성되고, 생성된 컴포넌트가 가지고 있는 메서드를 호출해서 각각의 도구들을 사용할 수 있다.

## Context의 종류

1. Application Context
   애플리케이션 컨텍스트는 애플리케이션과 관련된 핵심 기능을 담고 있는 클래스
   앱을 통틀어서 하나의 인스턴스만 생성
   액티비티나 서비스 같은 컴포넌트에서 Application Context를 직접 호출해서 사용할 수 있는데 **호출하는 지점과 관계없이 모두 동일한 Context가 호출**됨
2. Base Context
   Base Context는 안드로이드의 4대 메이저 컴포넌트인 Activity, Service, Content Provider, Broadcast Receiver의 기반 클래스
   각각의 컴포넌트에서 baseContext 또는 this로 컨텍스트를 사용할 수 있고 컴포넌트의 개수만큼 컨텍스트도 함께 생성되기 때문에 **호출되는 지점에 따라 서로 다른 Context가 호출**됨

## 컴포넌트별 컨텍스트의 기능

|                             | Application | Activity | Service | Content Provider | Broadcast Receiver |
| --------------------------- | ----------- | -------- | ------- | ---------------- | ------------------ |
| Show a Dialog               | X           | O        | X       | X                | X                  |
| Start an Activity           | X           | O        | X       | X                | X                  |
| Layout Inflation            | X           | O        | X       | X                | X                  |
| Start a Service             | O           | O        | O       | O                | O                  |
| Bind to Service             | O           | O        | O       | O                | X                  |
| Send a Broadcast            | O           | O        | O       | O                | O                  |
| Register Broadcast Receiver | O           | O        | O       | O                | X                  |
| Load Resource Values        | O           | O        | O       | O                | O                  |

아직 무슨 기능인지 전부는 모르겠음

