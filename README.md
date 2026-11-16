# Java OOP Lab

Java 객체지향 실습과 피자 주문 프로그램입니다. 상속·인터페이스, Observer, 파일 처리와 thread synchronization을 다룹니다.

## 구성

- [Practice](Practice): 정렬, singleton, producer/consumer 예제
- [PizzaStore](Project/PizzaStore): 주문·조리·알림·파일 저장

| 역할 | 클래스 |
| --- | --- |
| 피자·주문 상태 | `Pizza`, `Order` |
| 주문 방식 | `OnlineOrder`, `InStoreOrder` |
| 조리 자원 | `PizzaOven` |
| 상태 알림 | `Observer`, `Observable` |
| 저장 | `IFileHandler`, `CSVHandler`, `TXTHandler` |

## 컴파일

```bash
javac -encoding UTF-8 -d build Project/PizzaStore/*.java
```

실행할 `main`과 package는 각 소스에서 확인합니다. Practice 예제는 같은 클래스 이름을 사용할 수 있으므로 따로 컴파일합니다.

[구현 노트](docs/implementation.md) · [소스 목록](docs/source-index.csv) · [출처](ATTRIBUTION.md)

[전체 문서 안내](docs/README.md)
