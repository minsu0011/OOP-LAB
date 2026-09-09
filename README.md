# Java OOP Labs
객체 설계 연습과 Pizza Store 과제를 모은 Java 학습 저장소입니다. 기존 실습별 구조와 Git 이력을 유지합니다.

## 구조
`Practice`는 정렬·singleton·producer/consumer 등 작은 개념 연습입니다. `Project/PizzaStore`는 Pizza/Order, OnlineOrder/InStoreOrder, PizzaOven, Observer/Observable, CSV/TXT 파일 처리 역할을 나눕니다. 상속과 인터페이스가 주문·알림·저장 책임을 분리하는 방식을 살펴볼 수 있습니다.

## 실행
과제마다 class 이름과 package 구성이 다릅니다. PizzaStore 관련 Java 파일을 함께 컴파일하세요:
`javac -encoding UTF-8 -d build Project/PizzaStore/*.java`.
실행 main은 해당 과제 source에서 확인합니다. 전체 Practice를 한 classpath로 무조건 합치지 않습니다.

## 검증 및 결과
현재 검증은 실제 javac 컴파일을 시도하고 결과를 validation receipt에 기록합니다. 대화형 주문 시나리오·동시성·파일 장애 테스트를 모두 수행한 것은 아닙니다. 과거 제출 기록은 제품 수준 안정성 보증이 아닙니다.

## 학습과 한계
상태와 책임의 분리, observer notification, 파일 포맷별 전략, 공유 상태의 동기화가 주요 학습 주제입니다. 외부 starter·과제 설명의 권리는 원저작자에게 남습니다. [구현 인덱스](docs/source-index.csv)를 참고하세요.
