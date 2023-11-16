# 크리스마스 구현하기

## 📋 기능 목록
-[x] 날짜 요구 문장 출력 기능
-[x] 날짜 입력 기능 
  - (예외 사항 검사)
    - null 아닌지 / int 변환가능한지 /1~31 사이인지 확인
- [x] 메뉴와 수량 요구 문장 출력 기능
- [X] 메뉴와 수량 입력 하는 기능
  - (예외 사항 검사)
    - null 아닌지 / int 변환 가능한 지 확인
    - 메뉴판에 있는 메뉴인지 확인
    - 각 메뉴 수량이 1 이상인지, 총 수량이 20개 이하인지 확인
    - 메뉴 형식이 예시와 같은지 확인
    - 중복 메뉴가 있는지 확인
    - 음료만 주문하는지 확인
  - 유저 입력에서 각 메뉴를 ','로 구분하고 -'로 메뉴와 수량 구분한 뒤 Hashmap {메뉴, 수량} 형태로 변환
  - 메뉴 타입 별 갯수 확인 및 저장
    - 메뉴 타입 : 에피타이저 / 메인 메뉴 / 디저트 / 음료수
- [x] 할인 확인 기능
  - 할인 전 총 주문 금액 10,000원 이상인지 확인 (10,000원 이하는 할인 x)
  - 디데이 할인 구분 및 할인 금액 계산 (12.01~12.25까지 디폴트 1000원에서 하루 100원씩 증가)
  - 평일/주말 구분 후 디저트/메인 메뉴 수량에 따라 할인 금액 반환
  - 날짜 확인해 특별 할인(⭐️) 구분 및 할인 금액 반환
  - 총 주문 금액 확인해 증정 이벤트 여부 구분 및 증정 상품 추가
- [x] 총 혜택 금액에 따른 이벤트 배지 확인 기능
    ```
  5천 원 이상: 별
  1만 원 이상: 트리
  2만 원 이상: 산타

- [x] 최종 결과 출력 기능
  - 결과를 출력하기 전 StringBuilder 사용해 출력문 생성
  - 예시
  ```
  12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
  <주문 메뉴>
  타파스 1개
  제로콜라 1개

  <할인 전 총주문 금액>
  8,500원

  <증정 메뉴>
  없음

  <혜택 내역>
  없음

  <총혜택 금액>
  0원

  <할인 후 예상 결제 금액>
  8,500원

  <12월 이벤트 배지>
  없음

---

## 📦 패키지 구조

<table>
    <tr>
        <th>Package</th>
        <th>Class</th>
        <th>Description</th>
    </tr>
    <tr>
        <td rowspan="2"> <b>constants</b></td>
        <td><b>Constants</b></td>
        <td>전체 상수를 관리 클래스</td>
    </tr>
    <tr>
        <td><b>MenuConstants</b></td>
        <td>주문 메뉴 상수를 관리 하는 열거형 클래스</td>
    </tr>
<tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="1"> <b>controller</b></td>
        <td><b>MainController</b></td>
        <td>날짜, 메뉴 입/출력(View) ↔️ 객체 (Model)</td>
    </tr>
<tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="5"><b>model<br></b></td>
        <td><b>Badge</b></td>
        <td>할인 금액에 따라 뱃지를 갖는 클래스</td>
    </tr>
    <tr>
        <td><b>Bill</b></td>
        <td>주문 메뉴 타입에 따라 갯수를 갖는 클래스</td>
    </tr>
    <tr>
        <td><b>Date</b></td>
        <td>방문 날짜를 갖는 클래스</td>
    </tr>
    <tr>
        <td><b>Discount</b></td>
        <td>할인 이벤트 종류에 따른 금액을 리스트 형태로 갖는 클래스</td>
    </tr>
    <tr>
        <td><b>Dishes</b></td>
        <td>주문 메뉴 입력값을 받아 HashMap 형태로 갖는 클래스</td>
    </tr>
<tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="3"><b>service</b></td>
        <td><b>DiscountService</b></td>
        <td> 요청하는 이벤트 종류에 따라 할인 금액을 반환하는 서비스</td>
    </tr>
    <tr>
        <td><b>InputService</b></td>
        <td>유저가 주문한 메뉴 입력을 자르고 HashMap 형태로 반환하는 서비스</td>
    </tr>
    <tr>
        <td><b>OutputService</b></td>
        <td>최종 출력을 위해 복잡하고 긴 출력문을 미리 만들어 반환하는 서비스</td>
    </tr>
<tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="2"><b>template</b></td>
        <td><b>Callback</b></td>
        <td>예외처리 템플릿 적용을 위한 Callback 인터페이스</td>
    </tr>
    <tr>
        <td><b>ExceptionTemplate</b></td>
        <td>예외처리 템플릿 적용을 위한 템플릿</td>
    </tr>
<tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="1"><b>validator</b></td>
        <td><b>InputValidator</b></td>
        <td>유저의 입력과 내부 로직 실행 중 발생할 수 있는 예외 검증 클래스</td>
    </tr>
<tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="2"><b>view</b></td>
        <td><b>InputView</b></td>
        <td>유저의 표준 입력을 담당하는 클래스</td>
    </tr>
    <tr>
        <td><b>OutputView</b></td>
        <td>표준 출력을 담당하는 클래스</td>
    </tr>
</table>

---