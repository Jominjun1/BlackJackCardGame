# 🃏 블랙잭 카드 게임 (BlackJack Card Game)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-007396?style=for-the-badge&logo=java&logoColor=white)

## 📖 프로젝트 소개

52장의 카드를 사용하여 딜러(인공지능 컴퓨터)와 대결하는 블랙잭 카드 게임입니다. 21에 가까운 숫자를 만든 플레이어가 배팅한 금액만큼 획득하는 전통적인 카지노 게임을 Java Swing으로 구현했습니다.

## 🎮 게임 특징

- **실시간 게임 진행**: Java Swing을 활용한 직관적인 GUI
- **배경음악**: 게임 중 배경음악 재생 기능
- **승률 시스템**: 게임 종료 후 승률 표시
- **자동 카드 셔플**: 52장 카드 소진 시 자동으로 덱 재셔플
- **에이스 처리**: 1 또는 11로 계산되는 스마트한 에이스 처리

## 🛠️ 기술 스택

- **언어**: Java
- **GUI 프레임워크**: Java Swing
- **이미지 처리**: Java AWT Graphics
- **음악 재생**: JLayer MP3 Player
- **개발 환경**: IntelliJ IDEA / Eclipse

## 📦 설치 및 실행

### 요구사항
- Java 8 이상
- Windows/Linux/macOS

### 실행 방법

1. **JAR 파일 실행** (권장)
   ```bash
   java -jar BlackJack.jar
   ```

2. **소스코드 컴파일 및 실행**
   ```bash
   # 소스코드 컴파일
   javac -d bin src/blackjack/*.java
   
   # 게임 실행
   java -cp bin blackjack.BlackJackGame
   ```

3. **IDE에서 실행**
   - `src/blackjack/BlackJackGame.java`의 `main` 메소드 실행

## 🎯 게임 규칙

### 기본 규칙
- **목표**: 카드 합계가 21에 가장 가까운 플레이어가 승리
- **시작 잔액**: 200원
- **기본 배팅**: 10원
- **카드 값**: 
  - 숫자 카드: 해당 숫자 값
  - 페이스 카드(J, Q, K): 10점
  - 에이스(A): 1점 또는 11점 (자동 계산)

### 게임 진행
1. **배팅**: 잔액 내에서 배팅 금액 설정
2. **카드 분배**: 플레이어 2장, 딜러 2장 (딜러 첫 번째 카드는 숨김)
3. **플레이어 턴**: 
   - **HIT**: 카드 추가
   - **STAY**: 카드 받기 중단
4. **딜러 턴**: 합계 17 이상이 될 때까지 자동으로 카드 추가
5. **승패 판정**: 21에 가까운 쪽이 승리

### 특별 규칙
- **버스트**: 21을 초과하면 즉시 패배
- **무승부**: 동점일 경우 추가 카드로 승부 결정
- **파산**: 잔액이 0원이 되면 게임 종료

## 📁 프로젝트 구조

```
BlackJackCardGame/
├── src/blackjack/           # 소스코드
│   ├── BlackJackGame.java   # 메인 프레임 (메뉴)
│   ├── BlackJack.java       # 게임 패널 (메인 게임 화면)
│   ├── Table.java           # 게임 로직 (카드 분배, 승패 판정)
│   ├── Card.java            # 카드 데이터 클래스
│   ├── HowToPlay.java       # 게임 규칙 화면
│   └── BGM.java             # 배경음악 재생
├── img/                     # 게임 리소스
│   ├── *.png               # 카드 이미지 (52장)
│   ├── *.png               # UI 이미지 (버튼, 배경)
│   └── *.mp3               # 배경음악
├── bin/                     # 컴파일된 클래스 파일
├── BlackJack.jar           # 실행 파일
└── README.md               # 프로젝트 문서
```

## 🎨 주요 클래스 설명

### BlackJackGame.java
- 게임의 진입점
- 메인 메뉴 화면 (Start, HowToPlay, Exit)
- 배경 이미지와 버튼 UI 관리

### BlackJack.java
- 메인 게임 화면
- 마우스 이벤트 처리
- 실시간 화면 업데이트 (Thread)

### Table.java
- 게임의 핵심 로직
- 카드 셔플 및 분배
- 점수 계산 및 승패 판정
- 배팅 시스템 관리

### Card.java
- 카드 데이터 구조
- 카드 이미지 및 위치 정보 저장

### BGM.java
- MP3 배경음악 재생
- 반복 재생 기능

## 🎮 게임 화면

### 메인 메뉴
- 게임 시작, 규칙 보기, 종료 버튼
- 아름다운 배경 이미지

### 게임 화면
- 플레이어/딜러 카드 표시
- HIT, STAY, BETTING 버튼
- 실시간 배팅 금액 및 잔액 표시
- 승률 정보 표시

## 🚀 향후 개선 계획

- [ ] 멀티플레이어 지원
- [ ] 다양한 카지노 게임 추가
- [ ] 온라인 대전 기능
- [ ] 모바일 버전 개발
- [ ] 더 많은 사운드 효과

## 📝 라이선스

이 프로젝트는 교육 목적으로 제작되었습니다.

## 👨‍💻 개발자

블랙잭 카드 게임 개발팀

---

**즐거운 게임 되세요! 🎰**


