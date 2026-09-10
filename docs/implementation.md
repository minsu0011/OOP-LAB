# 객체별 책임

Pizza·Order는 주문 상태, OnlineOrder·InStoreOrder는 주문 방식, PizzaOven은 조리 자원입니다. Observer·Observable은 상태 알림을, IFileHandler·CSVHandler·TXTHandler는 저장 형식을 분리합니다.

`Practice` 예제는 독립 실행 단위입니다. 같은 클래스 이름이 겹칠 수 있어 각각 컴파일합니다. 파일 저장과 공유 상태를 함께 다룰 때는 경로·예외 처리·동기화까지 확인해야 합니다.
