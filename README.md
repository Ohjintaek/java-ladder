# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 구현 목록

- [x] 사다리 게임의 참여자가 있다. (Users)
    - [x] 참여자의 이름은 최대 5글자이다.
    - [x] 이름은 공백일 수 없다.
    - [] 참여자의 이름은 `all`일 수 없다.
- [x] 사다리를 출력할 때 사람 이름도 같이 출력한다. (OutputView)
    - [x] 사람 이름을 출력할 때 모든 사람 이름이 같은 공간을 가지고 우측정렬한다.
- [x] 사람 이름을 쉼표(,)를 기준으로 입력받는다. (InputView)
- [x] 라인을 생성할 때 연속된 부분이 없도록 해야 한다. (LineGenerator)
    - [x] `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
- [x] 랜덤으로 사다리를 생성하는 기능 추가. (Ladder)
- [x] 사다리 게임 실행 결과를 출력한다. (OutputView)
    - [x] 출력할 때 사다리 폭도 넓게 설정한다.
- [x] 사다리 높이를 입력받는다. (InputView)
    - [x] 사다리 높이는 양수여야 한다.
    - [x] 사다리 높이는 정수여야 한다.
    - (논의 사항) 사다리 높이를 입력받을 때 0으로 시작하면 예외처리한다.
- [x] 사다리 게임의 실행 결과들이 존재한다. (Results)
    - [x] 실행 결과의 수는 참여자의 수와 같아야 한다.
    - [x] 각 실행 결과의 길이는 최대 8글자이다. (임의)
- [ ] 사다리 실행 결과를 입력받는다. (InputView)
    - [ ] 실행 결과들은 쉼표로 구분되는 입력이어야 한다.
    - [x] 실행 결과는 공백일 수 없다.
- [ ] 유저의 사다리 게임 결과를 계산한다. (CalculateLadderGameResult)
- [ ] 결과를 보고 싶은 사람은 입력받는다. (InputView)
    - [ ] 입력된 사람 이름이 참여자 중 존재해야 한다.
    - [ ] 예외적으로 `all`은 입력가능하다.
- [ ] 각 유저의 결과를 출력할 수 있다. (OutputView)
- [ ] 모든 유저의 결과를 한 번에 출력할 수 있다. (OutputView)

## 예외 처리 목록
- [x] 입력된 사다리 높이가 0 이하인 경우 예외처리 (Ladder)
- [x] 입력된 사다리 높이가 정수형이 아닌 경우 예외처리 (InputView)
- [x] 유저의 이름은 5자 초과인 경우 예외처리 (User)
- [x] 유저의 이름이 공백인 경우 예외처리 (User)
- [x] 유저의 이름에 아스키코드가 아닌 문자가 포함된 경우 예외처리 (InputView)
- [x] 유저의 이름으로 쉼표만 입력됐을 경우 예외처리 (InputView)
- [x] 입력된 실행 결과의 수가 유저의 수와 다를 경우 예외처리 (Results)
- [x] 실행 결과의 길이가 8자 초과인 경우 예외처리 (Result)
- [x] 실행 결과가 공백인 경우 예외처리 (Result)
- [ ] 실행 결과로 쉼표만 입력됐을 경우 예외처리 (InputView)
- [ ] 결과를 보고 싶은 사람 입력이 참여자 중 존재하지 않을 경우 예외처리 (CalculateLadderGameResult)
