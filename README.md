# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 별 구현목록
1. 사용자로부터 자동차의 이름을 ,로 구분하여 입력받는다.
   *  자동차는 최소 2종류 이상을 입력받는다.
2. 시도 횟수를 입력받는다.
    * 시도 횟수는 0을 초과하는 숫자여야 한다.
3. 0부터 9까지 수 중 랜덤 값을 구하여, 값이 4이상일 경우 전진하고 그렇지 않으면 그대로 있는다.
    * 시도 횟수마다 "자동차의 이름 : 전진 횟수"으로 화면에 출력한다.
    * 전진 횟수는 "-"로 출력한다.
4. 시도 횟수까지 게임을 진행하고, 전진 횟수가 가장 많은 자동차를 출력한다.
    * 우승자가 2명 이상일 경우 ","로 구분하여 출력한다.

## 클래스 설계
* Class1. (DTO) 자동차, 자동차 이름, 이동 거리를 관리하는 클래스
* Class2. (일급 컬렉션) 자동차 리스트를 담고 있는 클래스
* Class3. (View) 게임 진행에 필요한 정보들을 사용자로부터 입력받아 화면에 출력
* Class4. (View) 게임 진행 관련하여 화면에 출력되는 메세지 정보를 담고 있는 클래스
* Class5. (Model) 게임 진행 관련 로직들을 처리하는 클래스(게임 시도 횟수만큼 자동차들의 전진 및 우승자를 선출하는 로직)
* Class6. (Model) 사용자 입력이 적절한지 검증하는 클래스

## 구현내용 점검
1. racinggame
   * Application.java: (Controller) 사용자 입력을 받고(View), 게임진행로직으로(Domain) 분기하는 역할
   * GameMessage.java: 게임 진행 관련 입/출력 메세지를 정의한 클래스
   * GameRule.java:  게임 진행 관련 룰을 담고 있는 클래스

2. racinggame.domain
   * CarComparator.java: 우승자 판별을 위해 Comparator를 상속하여 거리비교를 하는 역할
   * Client.java: 사용자로부터 입력을 받는 역할
   * GameManager.java: 게임 진행 관련 메인 로직을 처리하는 역할

3. racinggame.dto
   * Car.java: 자동차이름과 이동거리를 속성으로 갖는 클래스
   * CarList.java: 게임에 참가한 자동차들의 리스트를 속성으로 갖는 일급컬렉션
   * CarName.java: 자동차 이름을 정의한 클래스
   * Distance.java: 게임 중 이동거리를 정의한 클래스

4. racinggame.validation
   * InputValidationCheck.java: 사용자 입력이 적절한 값인지 판단하여 예외처리를 담당하는 역할

5. racinggame.view
   * RacingGameView.java: (View) 게임 진행에 필요한 정보들을 사용자로부터 입력받아 화면에 출력하는 역할
