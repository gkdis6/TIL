# Promise 정리

## Promise.all 예제 코드

```js
const projectListView = async (item) => {
  const colabo_srno = $(item).attr("colabo_srno");
  const widget_user_srno = $(item).attr("id");
  
  Promise.all([
		new Promise( (resolve) => {if(colabo_srno !== '0') resolve()}), //colabo_srno가 0이면 reject 반환 => catch로 이동, 마지막에 resolve가 들어오지 않으면 reject로 처리됨
		new Promise((resolve) => {
			resolve(DashboardApi.getProjectInfo()) //dat2, async 동작, 해당 결과값을 통해 접근권한 조회, 호출 자체에서 error 처리를 해도 되지만, 그렇게 할 경우 Ajax 클래스 단에 정의된 Error confirm 창이 표출되어 나온 결과값을 바탕으로 에러 처리
		}),
		new Promise((resolve) => {
			resolve(DashboardApi.postList()); //dat3, 접근 권한이 있을 경우 실데이터를 가져오는 부분
		})
	]).then(([dat1, dat2, dat3]) => {
		setProjectTtl(item, dat2);
		drawProjectList(item, dat3);
	}).catch((e) => {
		//중간에 에러가 날 경우의 동작 처리, then 내의 함수에서 error가 발생해도 catch로 돌아오게 되어 있음
	})
}
const setProjectTtl = (item, {TTL}) => {
   if (TTL === null) { //접근 권한이 없을 경우 이름을 못가져오고 에러 처리
      throw new Error(); //reject(new Error()); == throw new Error(); 여기선 promise 함수가 아니기 때문에 reject가 정의되지 않아 throw new Error();만 동작함
   }
   $(item).find('h3 span span').text(TTL);
   $(item).find('h3').css('display', 'flex');
}
```

## Promise.allSettled 예제 코드

```js
const refresh = async () => {
	await Promise.allSettled([ //이 중에서 하나가 에러가 나더라도 나머지는 정상 작동, 각자 연관되지 않고 따로 load될 때 유용함.
		mentionList(),
		bookmarkList(),
		alarmList(),
		projectList(),
		workList(),
		chatList(),
		projectTaskReport(),
		taskCount()
	]);
}
```

