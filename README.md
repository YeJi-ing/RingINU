# RingINU: Healthy Battle
2022-12-29: Participating in Hackathons
           
## Team Members
* [**YeJi-ing**](https://github.com/YeJi-ing) (Back-End)
* [**ChoiYJ2**](https://github.com/ChoiYJ2) (Back-End)
* [**lightpipo-cre20**](https://github.com/lightpipo-cre20) (Front-End)
* [**rimi3226**](https://github.com/rimi3226) (Front-End)


## 1. Introduction

Healthy Battle is a program that is effective in motivating exercise and improving exercise posture.

<a href="https://youtu.be/7pjDYl7Kd_k" target="_blank"><img src="https://img.youtube.com/vi/7pjDYl7Kd_k/0.jpg" 
alt="RingINU" width="480" height="360" border="10" /></a>


## 2. Language 

- [ ] `Java 11`
    - [Spring Boot 2.7.7](https://start.spring.io/)
- [ ] `HTML`
- [ ] `JavaScript`
- [ ] `Python`

## 3. Building RingINU
Clone the repository:

```
  git clone https://github.com/YeJi-ing/RingINU.git Ring-spring
  ```

Execute:
```
  gradlew.bat build
  ```
This will create **Ring-spring-0.0.1-SNAPSHOT.jar**  at */build/libs* folder.


## 4. info Schema

The database `UserInfo.db` includes a single `info` table:

| field    | data type        | metadata              |
| :------- | :--------------- | :---------------------|
| userID   | VARCHAR          | primary key, NOT NULL |
| score    | INT              |                       |
