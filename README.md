# 👩‍⚕️ Smart Doctor 그룹웨어

## Contents
1. 팀 소개
2. 프로젝트 개요
3. 개발환경
4. 주요기능
5. Document

## 1️⃣ 팀 소개
![팀 소개](https://user-images.githubusercontent.com/103404636/205049066-d27a3045-1bab-40ef-83e5-cacb856dc2dd.png)

## 2️⃣ 프로젝트 개요
**CRM + GROUPWARE의 융합으로 고객관리와 소통 모두 가능한 시스템**
- 한눈에 확인하고 빠르게 소통하여 편의성을 높인 협업
- 병원 내부 소통과 행정을 체계화하여 스마트한 소통
- 쉽고 간편한 실시간 고객 관리

## 3️⃣ 개발환경
- Language : Java (OpenJDK 11)
- DBMS : Oracle (11g)
- Front : HTML5, CSS3, JavaScript, jQuery, Bootstrap
- Server : Apache Tomcat (9.0)
- Server Programming : JSP/Servlet, AJAX
- Framework : Spring, MyBatis
- 프로젝트 관리도구 : Maven
- IDE : STS3, Visual Studio Code, sqlDeveloper
- Modeling Tool : StarUML, erdcloud, 카카오오븐
- 형상 관리 : Github
- 사용 API : fullcalendar, summernote, fancytree plugin

## 4️⃣ 주요 기능 (담당역할 : 전자결재)
## ✔️ 관리자
### 1. 결재양식 조회, 수정 및 삭제
![관리자_결재양식 수정](https://user-images.githubusercontent.com/103404636/205036937-89087c31-98e0-4791-9c6c-e84691f62985.gif)
- 기존 결재양식 조회
- 결재양식 수정 및 삭제 가능
- 사용여부 '사용' 체크 시 결재문 작성 - 결재양식 선택창에 보여짐
---
### 2. 결재양식 추가
![관리자_결재양식 추가](https://user-images.githubusercontent.com/103404636/205035390-07ed1cb5-acd2-4dea-805c-fa8a7c686ef7.gif)
- summernote 에디터를 이용하여 결재양식 추가

---

## ✔️ 사용자
### 1. 결재문 작성
#### 1) 결재양식 선택
![결재양식 선택](https://user-images.githubusercontent.com/103404636/205039820-16855cf6-935d-49fc-96c3-51e54c281bec.gif)
- 관리자 페이지에서 추가한 결재양식을 선택하여 저장된 양식을 summernote에 불러올 수 있음
---
#### 2) 결재라인 지정
![결재라인 지정](https://user-images.githubusercontent.com/103404636/205040591-91c6bdee-df1e-4c31-a578-e2105b7ea4b3.gif)
- fancytree plugin으로 구현된 조직도에서 직원 조회 가능
- 최대 3명까지 결재자, 참조자 지정 및 삭제 가능
---
![결재 요청](https://user-images.githubusercontent.com/103404636/205041784-a0c506ad-179d-4af8-be1a-c4c674fc9c8d.gif)
- 파일 첨부하여 결재 요청 가능
- 임시저장 시 임시저장함에 보관됨

---

### 2. 결재대기 문서함
#### 1) 일괄결재
![일괄결재](https://user-images.githubusercontent.com/103404636/205042849-c851001b-126b-4a85-9445-305026c0a4bd.gif)
- 본인이 현재 결재 순번일 경우 결재대기함에서 처리 가능
- 원하는 문서만 선택하여 일괄결재 가능
- 일괄결재 시 결재의견은 '승인합니다.'로 통일됨
---
#### 2) 결재 처리
![결재 처리](https://user-images.githubusercontent.com/103404636/205043091-d6b7f8ed-a07f-49e2-b7e4-299be6971d19.gif)
- 본인이 현재 결재순번일 경우 결재대기함에서 결재 처리 가능
- 결재 시 결재의견을 남길 수 있음
- 결재된 문서는 결재대기함에서 사라지고, 결재문서함에서 조회 가능
- 결재처리 시 결재 날짜와 승인 도장이 출력됨
---
#### 3) 반려 처리
![반려 처리](https://user-images.githubusercontent.com/103404636/205043856-694f2c1f-4781-4aec-8cb1-167a3b33227e.gif)
- 결재 시 반려의견을 남길 수 있음
- 반려처리 시 반려 날짜와 반려 도장이 출력됨
---
#### 4) 전결 처리
![전결 처리](https://user-images.githubusercontent.com/103404636/205044397-39bb4b38-e90a-4b7a-8c92-6b0cb634edf6.gif)
- 현재 결재순번에서 결재를 종결하는 '전결' 처리 가능
- 전결 처리 시 결재날짜와 전결 도장이 출력됨
- 전결 처리 시 결재상태가 '완료' 상태로 변경됨

---

### 3. 결재문서함
![문서함 양식 조회](https://user-images.githubusercontent.com/103404636/205045101-c4a4f065-7348-4b39-b1dc-31fe1a725972.gif)
- 본인이 결재한 문서들을 조회 가능
- 결재 처리상태에 따라 결재도장이 날짜와 함께 부여됨
- 결재양식에 따라 다른 양식으로 조회됨(일반, 휴가, 연장근무 3가지)
- 결재자의 결재의견 확인 가능

---

### 4. 기안문서함
#### 1) 상신취소
![상신취소-임시저장](https://user-images.githubusercontent.com/103404636/205047552-d9c16714-aed9-4bc4-b172-32d012536012.gif)
- 기안문서함에서 본인이 결재요청한 문서 조회 가능
- 아직 결재한 결재자가 없는 경우, 상신취소하여 결재요청을 취소할 수 있음
- 상신취소된 문서는 임시저장함에 저장됨
- 결재양식, 내용 및 결재라인이 모두 그대로 저장되어 일부만 수정한 후 결재요청 가능
---
#### 2) 재기안
![재기안](https://user-images.githubusercontent.com/103404636/205048179-58ea651c-4e90-487b-8bf9-6fbfa2640d1d.gif)
- 결재상태가 '반려' 혹은 '완료' 상태인 경우, 재기안 가능
- 재기안 시 결재양식, 내용 및 결재라인이 그대로 복사되어 곧바로 결재요청 가능

---

### 5. 그 외
#### 1) 임시저장함, 참조문서함
- 임시저장된 문서는 수정 후 임시저장 및 결재요청 가능
- 본인이 참조자로 등록된 결재문서는 참조문서함에서 조회 가능
#### 2) 연장근무 신청
- 출퇴근 관리 탭에서 연장근무 결재요청 가능
- 결재가 승인될 경우, 신청자의 근태정보에 연장근무 시간이 업데이트 되도록 트리거 처리 
#### 3) 휴가 신청
- 휴가 관리 탭에서 휴가 결재요청 가능
- 결재가 완료 처리될 경우, 신청자의 근태테이블에 휴가정보가 업데이트됨

---

## 5️⃣ Document
## 1. 개발 일정
![개발 일정](https://user-images.githubusercontent.com/103404636/204216491-72ea3f2a-5c16-4a03-baba-5c02352dd604.png)

## 2. 유스케이스
![유스케이스](https://user-images.githubusercontent.com/103404636/204216635-4770306f-e918-427c-afaa-95083f2f7a9a.png)

## 3. ERD
![SMART DOCTOR 캡쳐용](https://user-images.githubusercontent.com/103404636/204216046-10adf758-fc41-41f2-8cd1-5c3761e31d76.png)

