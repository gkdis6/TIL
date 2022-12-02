# Service(android)

백그라운드에서 오래 실행되는 작업을 수행할 수 있는 애플리케이션 구성 요소. 사용자 인터페이스를 제공하지 않음.
다른 애플리케이션 구성 요소가 서비스를 시작할 수 있으며, 이는 사용자가 다른 애플리케이션으로 전환하더라도 백그라운드에서 계속 해서 실행됨. 이외에도, 구성 요소를 서비스에 바인딩하여 서비스와 상호작용할 수 있으며, 심지어는 프로세스 간 통신(IPC)도 수행하 수 있음. 예를 들어 한 서비스는 네트워크 트랙잭션을 처리하고, 음악을 재생하고, 파일 I/O를 수행하거나 콘텐츠 제공자와 상호작용할 수 있으며 이 모든 것을 백그라운드에서 수행할 수 있다.

## Service의 종류

1. Foreground
   사용자에게 잘 보이는 몇몇 작업을 수행. 오디오 앱이라면 오디오 트랙을 재생할 때 포그라운드 서비스를 사용. 포그라운드 서비스는 **알림**을 표시해야 함. 포그라운드 서비스는 사용자가 앱과 상호작용을 하지 않을 때도 계속 실행
2. Background
   사용자에게 직접 보이지 않는 작업을 수행. 어느 앱이 저장소를 압축하는 데 서비스를 사용했다면 대개 백그라운드 서비스
3. Bind
   애플리케이션 구성 요소가 `bindService()`를 호출하여 해당 서비스에 바인딩되면 서비스가 바인딩됨. 바인딩된 서비스는 클라이언트 - 서버 인터페이스를 제공하여 구성 요소가 서비스와 상호작용하게 하며, 결과르 받을 수도 있고 심지어 이와 같은 작업을 여러 프로세스에 걸쳐 프로세스 간 통신(IPC)으로 수행할 수도 있습니다. 바인딩된 서비스는 또 다른 애플리케이션 구성 요소가 이에 바인딩되어 있는 경우에만 실행됨. 여러 개의 구성 요소가 서비스에 한꺼번에 바인딩 될 수 있지만, 이 모든 것에서 바인딩이 해제되면 해당 서비스는 소멸.

시작된 서비스와 바인딩된 서비스를 전반적으로 별도로 논하지만, 서비스는 양쪽 방식으로 둘 다 작동할 수 있다. 즉 시작해서(무한히 실행되도록) 바인드도 허용할 수 있다. 이것은 단순히 두어 가지 콜백 메서드를 구현했는지 여부에 좌우되는 문제. `onStartCommand()`는 구성 요소가 서비스를 시작하게 하고 `onBind()`는 바인드를 허용하게 함.

서비스가 시작되었든, 바인딩되었든 아니면 양쪽 모두이든 모든 애플리케이션 구성 요소가 해당 서비스를 사용할 수 있으며(심지어 별도의 애플리케이션에서도 사용 가능), 이는 어느 구성 요소든 액티비티를 사용할 수 있는 것과 같다. 이를 `Intent`로 시작하면 됨.

## 기본사항

재정의가 필요한 콜백 메서드

### `onStartCommand()`

시스템이 이 메서드를 호출하느 것은 또 다른 구성 요소(예: 엑티비티)가 서비스를 시작하도록 요청하는 경우. 이 때 `startService()`를 호출하는 방법을 씀. 이 메서드가 실행되면 서비스가 시작되고 백그라운드에서 무한히 실행될 수 있다. 이것을 구현하면 서비스의 작업이 완료되었을 때 해당 서비스를 중단하는 것은 개발자 본인의 책임이며, 이 때 `stopSelf()` 또는 `stopService()`를 호출하면 됨. 바인딩만 제공하고자 하는 경우, 이 메서드를 구현하지 않아도 됨.

### `onBind()`

시스템은 다른 구성요소가 해당 서비스에 바인딩되고자 하는 경우(예를 들어 RPC를 수행하기 위해)에도 이 메서드를 호출함. 이 때 `bindService()`를 호출하는 방법을 사용. 이 메서드를 구현할 때에는 클라이언트가 서비스와 통신을 주고받기 위해 사용할 인터페이스를 제공해야 함. 이 때 IBinder를 반환하면 됨. 이 메서드는 항상 구현해야 하지만, **바인딩을 허용하지 않으려면 null을 반환해야 함.**

### `onCreate()`

시스템은 서비스가 처음 생성되었을 때(즉 서비스가 `onStartCommand()` 또는 `onBind()`를 호출하기 전에) 이 메서드를 호출하여 일회성 설정 절차를 수행. 서비스가 이미 실행 중인 경우, 이 메서드는 호출되지 않음.

### `onDestroy()`

시스템이 이 메서드를 호출하는 것은 서비스를 더 이상 사용하지 않고 소멸시킬 때. 서비스는 스레드, 등록된 리스너 또는 수신기 등의 각종 리소스를 정리하기 위해 이것을 구현. 이는 서비스가 수신하는 마지막 호출.

## 동작방식

한 구성 요소가 `startService()`를 호출하여 서비스를 시작하면(`onStartCommand()`에 대한 호출 발생), 해당 서비스는 알아서 `stopSelf()`로 스스로 중단할 때까지 또는 다른 구성 요소가 `stopService()`를 호출하여 서비스를 중단시킬 때까지 실행 중인 상태로 유지됩니다.

한 구성 요소가 `bindService()`를 호출하여 서비스를 생성하는 경우(그리고 `onStartCommand()`를 호출하지 *않은* 경우), 해당 서비스는 해당 구성 요소가 바인딩된 경우에만 실행됩니다. 서비스가 모든 클라이언트로부터 바인딩이 해제되면 시스템이 이를 소멸시킵니다.

## 서비스 선언

```xml
<manifest ... >
  ...
  <application ... >
      <service android:name=".ExampleService" />
      ...
  </application>
</manifest>
```

<service> 요소에 포함할 수 있는 다른 특성도 있습니다. 이 요소를 포함하여 서비스를 시작하는 데 필요한 권한과 서비스를 실행해야 하는 프로세스 등의 특성을 정의할 수 있습니다. [`android:name`](https://developer.android.com/guide/topics/manifest/service-element?hl=ko#nm) 특성이 유일한 필수 특성인데, 이는 서비스의 클래스 이름을 나타냅니다. 애플리케이션을 게시한 후에는 이 이름을 그대로 두어야 서비스를 시작 또는 바인딩할 명시적 인텐트에 대한 종속성 때문에 코드가 깨질 위험을 막을 수 있습니다.