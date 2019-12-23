## SolbyCloud

> SolbyCloud is a Spring cloud-based scaffolding that has been combed out in the process of continuous improvement.

![apache](http://jaywcjlove.github.io/sb/license/apache.svg)     ![passing](http://jaywcjlove.github.io/sb/build/passing.svg)   [![follow](http://jaywcjlove.github.io/sb/github/w-follow.svg)](https://github.com/acehjm/solby/blob/master/README.md)      [![fork](http://jaywcjlove.github.io/sb/github/w-fork.svg)](https://github.com/acehjm/solby/blob/master/README.md)    [![star](http://jaywcjlove.github.io/sb/github/w-star.svg)](https://github.com/acehjm/solby/blob/master/README.md)

English | [中文文档]()

### Project environment

- Development environment：[OpenJDK11](https://openjdk.java.net/projects/jdk/11)；
- Build tool：[Gradle](https://gradle.org/)；
- Development Framework：[Spring boot](https://spring.io/projects/spring-boot)，[mybatis-plus](https://github.com/baomidou/mybatis-plus), etc；
- Database：[Redis](https://redis.io/)，[MySQL](https://www.mysql.com/)；

### Project module description

***common-auth***

Authorization service based on oauth2 protocol and spring security.

***common-gateway***

Gateway service based on Spring cloud gateway.

***common-boot***

General Business Services.


### Usage

*By IDEA:* In module, run a configuration with main class of `xxxApplication` using `Run` or `Debug` mode.

*By Gradle:* with gradle, you can using `gradle bootRun` to boot application.
