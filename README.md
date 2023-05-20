# Carrot-SERVER
당근이세요?
  <br><br>
  
## 팀원
유서린 | 장유진 |
:---------:|:----------:|
[SeorinY](https://github.com/SeorinY) | [jinchiim](https://github.com/jinchiim) | 
관련 기능 | 관련 기능 |

<br><br>


## 코드 컨벤션
<details>
<summary> 코드 컨벤션 </summary>
<div markdown="1">

- **자바 코드 컨벤션을 지키면서 프로그래밍했는가?**

- **한 메서드에 최소한의 들여쓰기(indent)만 허용했는가?**
    - **최대 depth : 2** 까지만 허용

- **else 예약어를 쓰지 않았는가?**

- **setter 없이 구현했는가?**

- **핵심 로직을 구현하는 도메인 객체에 setter를 쓰지 않고 구현했는가? 단, DTO는 허용한다.**

- **코드 한 줄에 점(.)을 하나만 허용했는가?**

- **메소드의 인자 수를 제한했는가? 4개 이상의 인자는 허용하지 않는다. 3개도 가능하면 줄이기 위해 노력해 본다.**

- **메소드가 한가지 일만 담당하도록 구현했는가?**

- **클래스를 작게 유지하기 위해 노력했는가?**

    메서드당 line을 10까지만 허용

    길이가 길어지면 메서드로 분리


- **매직 넘버 사용을 자제하고** **상수 사용**

- entity에서는 newInstance

- dto에서는 of 생성자 사용

- SuccessType에 CRUE_what_SUCCESS 사용

</details>
  <br><br>

## 깃 컨벤션
<details>
<summary> 공통 타입 </summary>
<div markdown="1">
[feat] : 새로운 기능 추가

[add] : Feat 이외의 부수적인 코드 추가, 라이브러리 추가, 새로운 View나 Activity 생성

[fix] : 잘못된 부분 수정

[chore] : 버전 코드 수정, 패키지 구조 변경, 파일 이동, 가독성이나 변수명, reformat 등

[delete] : 쓸모없는 코드 삭제

[refact] : 내부 로직은 변경 하지 않고 기존의 코드를 개선하는 리팩토링 시

[hotfix] : 해결이 급한 부분 수정

[docs] : README나 WIKI 등의 문서 개정

[merge] : 머지할때
</details>
  
<details>
<summary> 브랜치명 </summary>
<div markdown="1">
  
```
feature/{#이슈번호}-이슈내용

ex)
feature/#11-fix-userList
```
 
</details>
    
<details>
<summary>   이슈템플릿 </summary>
<div markdown="1">
  
```
## 📌 Feature Issue
<!-- 구현할 기능에 대한 내용을 설명해주세요. -->

## 📝 To-do
<!-- 해야 할 일들을 적어주세요. -->

- [ ]
```
  
</details>
  
<details>
<summary>   pr템플릿 </summary>
<div markdown="1">
  
```
## ✒️ 관련 이슈번호

- Closes #

## 🔑 Key Changes

1. 

## 📢 To Reviewers
-
```
  
</details>
  
<details>
<summary> 커밋 </summary>
<div markdown="1">
  
```
{#이슈번호} [type] : 작업 내용

ex)
#11 [add] : 유저 리스트 엔티티 추가
```
  
</details>
    <br><br>
                
## 프로젝트 구조
  
  ```
├── 📂 controller
│   ├── 📂 user
│   │   ├── UserController
│   │   └── 📂 dto
│   │        └── 📂 request
│   │        └── 📂 response
│   ├── 📂 review
│   └── 📂 post
│
├── 📂 service
│   ├── 📂 user
│   │   ├── UserService
│   │   └── UserServiceImpl
│   ├── 📂 review
│   └── 📂 post
│
├── 📂 infrastructure
│   ├── 📂 user
│   │   ├── UserEntity
│   │   ├── UserRepository
│   │   └── UserRepositoryImpl
│   ├── 📂 review
│   └── 📂 post
│
├── 📂 common
│   ├── 📂 advice
│   └── 📂 dto
│
└── 📂 exception
    ├── 📂 model
    ├── Error
    └── Success
```
  <br><br>
  
  
## ERD

  <img width="1258" alt="image" src="https://github.com/SOPT-TEAM9-Carrot/Carrot-SERVER/assets/81281190/8ba6a609-1289-4f0d-a9c9-0ed227af44e3">
