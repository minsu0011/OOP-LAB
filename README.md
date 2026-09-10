# Java 객체지향 실습과 Pizza Store

객체지향 수업의 개념 실습과 피자 주문 프로그램을 모았습니다. 작은 예제에서 상속·인터페이스·공유 상태를 익힌 뒤 주문·조리·알림·파일 저장의 역할을 나눴습니다.

## 사용 기술

Java와 표준 파일 입출력, thread/synchronization을 사용합니다. 웹 프레임워크 없이 객체 간 협력과 상태 관리를 연습합니다.

## 구성

[Practice](Practice)는 정렬, singleton, producer/consumer를 다룹니다. [Project/PizzaStore](Project/PizzaStore)는 여러 객체가 함께 주문을 처리합니다.

| 역할 | 클래스 |
|---|---|
| 피자와 주문 상태 | Pizza, Order |
| 주문 방식 | OnlineOrder, InStoreOrder |
| 조리 자원 | PizzaOven |
| 상태 변화 알림 | Observer, Observable |
| 저장 형식 | IFileHandler, CSVHandler, TXTHandler |

## 설계 과정

주문 방식이 달라도 공통 상태는 함께 다루도록 구성했습니다. 알림은 Observer/Observable로 연결하고 저장 형식은 인터페이스 뒤로 나눴습니다. 호출하는 쪽이 CSV인지 TXT인지 세부 처리를 모두 알 필요가 없도록 책임을 분리하는 연습입니다.

Producer/consumer 예제에서는 객체를 나누는 것만으로 공유 상태가 안전해지지 않는다는 점을 다룹니다. Pizza Store도 주문과 조리 상태가 언제 바뀌는지 따라가며 읽을 수 있습니다. 인증·결제 기능은 범위에 포함하지 않았습니다.

## 실행

```bash
javac -encoding UTF-8 -d build Project/PizzaStore/*.java
```

실행할 `main` 클래스와 package는 과제 소스에서 확인합니다. Practice의 예제는 같은 클래스 이름을 사용할 수 있으므로 각각 컴파일합니다. 파일 처리 예제는 입력 파일과 작업 디렉터리도 맞춰야 합니다.

[구현 노트](docs/implementation.md) · [소스 목록](docs/source-index.csv) · [출처](ATTRIBUTION.md)
