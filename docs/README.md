# 크리스마스 구현하기

</div>


### 기능 목록
### 로또 구매 기능
-[x] 날짜 요구 문장 출력 기능
-[x] 날짜 입력 기능 
  - (예외 사항 검사)
    - null 아닌지 / int 변환가능한지 /1~31 사이인지 확인
- [x] 메뉴와 개수 요구 문장 출력 기능
- [X] 메뉴와 개수 입력 하는 기능
  - (예외 사항 검사)
    - null 아닌지 / int 변환 가능한지 확인 기능
    - 메뉴판에 있는 메뉴인지 확인
    - 각 메뉴 개수가 1 이상인지, 총 개수가 20개인지 확인
    - 메뉴 형식이 예시와 다른지 확인
    - 중복 메뉴가 있는지 확인
    - 음료만 주문하는지 확인
  - String 스플릿 후 [메뉴, 개수] Hashmap 변환 기능
- [x] 할인 확인 기능
  - 총 주문 금액 10,000원 이상인지 확인 (10,000원 이하 할인 x)
  - 날짜 확인해 평일/주말 구분 후 할인 금액 반환 기능
  - 디데이 할인 구분 및 할인 금액 계산 기능 (12.01~12.25)
  - 날짜 확인해 특별 할인 (별) 구분 및 할인 금액 계산 기능
  - 총주문 금액 확인해 증정 이벤트 여부 구분 및 증정 상품 추가
- [x] 총 혜택 금액에 따른 이벤트 배지 확인 기능
    ```
  5천 원 이상: 별
  1만 원 이상: 트리
  2만 원 이상: 산타

- [x] 최종 결과 출력 기능 (예시)
  
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

- [x] 

---

## 📦 패키지 구조 (!!수정 예정!!)

<div align="center">
<table>
    <tr>
        <th align="center">Package</th>
        <th align="center">Class</th>
        <th align="center">Description</th>
    </tr>
    <tr>
        <td rowspan="5"> Controller</b></td>
        <td><b>&nbsp;BuyerController</b></td>
        <td>구입 금액 입/출력(View) ↔️ Buyer (Model)</td>
    </tr>
    <tr>
        <td><b>&nbsp;FinalResultController</b></td>
        <td>FinalResults 객체를 바탕으로 최종 결과 산출 요청 및 출력</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;LottoMainController</b></td>
        <td>게임 로직을 메인으로 동작하는 컨트롤러</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;PrizeController</b></td>
        <td>당첨 번호, 보너스 번호 입/출력(View) ↔️ Prize (Model)</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;PurchaseController</b></td>
        <td>Buyer 객체를 바탕으로 로또 구매 요청 및 출력</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="4">
&nbsp;&nbsp;<b>domain<br></b>
&nbsp;&nbsp;lottery</td>
        <td><b>
&nbsp;&nbsp;Buyer</b></td>
        <td>구입 금액과 로또 구입 갯수를 갖는 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;Lotto</b></td>
        <td>로또의 숫자들을 List 일급 컬렉션 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;Lottos</b></td>
        <td>구입한 로또들을 갖는 List 일급 컬렉션 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;NumberChecker</b></td>
        <td>Prize, Lotto의 공통 검증 요건에 대한 추상 클래스</td>
    </tr>
    <tr>
        <td>
&nbsp;&nbsp;constants</td>
        <td><b>&nbsp;&nbsp;LottoConstraint</b></td>
        <td>로또 게임에 필요한 전역 제약조건 열거형 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="5">
&nbsp;&nbsp;<b>domain<br></b>
&nbsp;&nbsp;prize</td>
        <td><b>
&nbsp;&nbsp;FinalResults</b></td>
        <td>최종 로또 등급/갯수를 갖는 EnumMap 일급 컬렉션 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;MatchingResult</b></td>
        <td>로또의 PrizeMatchingCount와,<br>보너스 번호 매칭 여부를 갖는 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;MatchingResults</b></td>
        <td>로또들의 PrizeMatchingCount와,<br>보너스 번호 매칭 여부를 갖는 List 일급 컬렉션 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;Prize</b></td>
        <td>당첨 로또 번호와, 보너스 번호를 갖는 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;Revenue</b></td>
        <td>로또 결과로 얻은 수익과 수익률을 갖는 클래스</td>
    </tr>
    <tr>
        <td rowspan="2">
&nbsp;&nbsp;constants</td>
        <td><b>
&nbsp;&nbsp;PrizeGrade</b></td>
        <td>당첨 등급 별 prizeMatchingCount, 보너스 매칭 조건 검증,<br>당첨 금액을 갖는 열거형 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;PrizeMatchingCount</b></td>
        <td>상품의 매칭 횟수를 갖는 열거형 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="3">&nbsp;&nbsp;<b>dto</b></td>
        <td><b>
&nbsp;&nbsp;FinalResultResponse</b></td>
        <td>최종 수익률을 전달하는 DTO 레코드/td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;LottoNumberResponse</b></td>
        <td>구매한 로또의 번호를 전달하는 DTO 레코드</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;LottoNumberResponses</b></td>
        <td>구매한 로또들의 번호를 전달하는 DTO 레코드</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="2"><b><b>&nbsp;&nbsp;exception</b></td>
        <td><b>
&nbsp;&nbsp;ErrorMessage</b></td>
        <td>예외를 던질 때 사용되는 에러 메세지 열거형 클래스</td>
    </tr>
    <tr>
        <td><b></td>
        <td>전역에서 에러를 핸들링하는 Custom Exception</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="3">
&nbsp;&nbsp;<b>service</b></td>
        <td><b>
&nbsp;&nbsp;FinalResultService</b></td>
        <td>최종 결과를 담은 EnumMap을 컬렉션 생성하는 서비스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;LottoService</b></td>
        <td>자동 로또 숫자를 생성하는 서비스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;Parser</b></td>
        <td>문자형 입력을 정수형, List형으로 파싱하는 서비스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="1"><b>&nbsp;&nbsp;view<br></b>
&nbsp;&nbsp;input</td>
        <td><b>
&nbsp;&nbsp;InputReader</b></td>
        <td>표준 입력을 담당하는 클래스</td>
    </tr>
    <tr>
        <td rowspan="3"><b>&nbsp;&nbsp;view<br></b>
&nbsp;&nbsp;output</td>
        <td><b>
&nbsp;&nbsp;FinalResultWriter</b></td>
        <td>FinalResponse를 활용해 결과를 출력하는 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;OutputWriter</b></td>
        <td>표준 출력을 담당하는 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;PurchaseWriter</b></td>
        <td>LottoNumberResponses를 활용해 결과를 출력하는 클래스</td>
    </tr>
    <tr>
        <td rowspan="4"><b>&nbsp;&nbsp;view<br></b>
&nbsp;&nbsp;constants</td>
        <td><b>
&nbsp;&nbsp;PrintablePrizeGrade</b></td>
        <td>전체 등급 중, 사용자에게 결과로 출력할 등급을 갖는 열거형 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;PrintFormat</b></td>
        <td>소수와, 정수의 구두점 표시에 대한 제약조건을 갖는 열거형 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;PrintMessage</b></td>
        <td>사용자에게 출력할 메세지를 담은 열거형 클래스</td>
    </tr>
    <tr>
        <td><b>
&nbsp;&nbsp;PrizeResultFormat</b></td>
        <td>보너스 볼 매칭 여부에 따라 분기하는<br>출력 메세지를 담은 열거형 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr><th colspan="3">Project Test Result</th></tr>
    <tr>
      <td colspan="3"></td>
    </tr>
    <tr>
      <td colspan="3"></td>
    </tr>
</table>
</div>

<br>

---