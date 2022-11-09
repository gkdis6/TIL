# git config 설정

---

계정을 하나만 사용할 때는 git config의 global 설정과 local 설정에 대해 이해가 되지 않았다.
회사를 다니게 되고 회사에서 사용하는 git 계정과 나 개인이 사용하는 git 계정을 분리하기 위해 생각하던 중 혹시 이건가 싶어 찾아보니 당연스럽게도 있던 기능이었다.
아직도 깃에 대해 모르는 것이 많다는 걸 깨달은 날이다.

## 사용 예

```bash
git config -l #깃에 대한 설정을 리스트 형식으로 볼 수 있는 명령어
git comfig --global property.name "설정할 값" #전체(default) git에 대한 프로필 property 값을 변경할 수 있는 명령어
git config --local property.name "설정할 값" #해당 repository에 대한 프로필 property 값을 변경할 수 있는 명령어
cat .git/config #해당 리포지토리에 해당하는 로컬 config 파일
```

위의 명령어들을 통해 기본으로 사용되는 깃과 리포지토리에 사용되는 깃을 분리할 수 있었다.
요즘같은 경우 계정을 사용해서 로그인이 되지 않고 access token을 사용하여 로그인하기 때문에 설정을 좀 더 조심할 필요가 있을 것 같다.



