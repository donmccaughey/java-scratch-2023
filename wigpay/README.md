# `wigpay`

This is a simple web application that transforms input into [Pig Latin][1].  The
`WigpayApplication` class holds the `main()` method.  The `TranslationController`

The `Translator`
class implements the loop that reads input and writes translated output. There
are also some unit tests for the `Translator` class.

[1]: https://en.wikipedia.org/wiki/Pig_Latin

`wigpay` is based on [`igpay`](../igpay) but replaces the `Makefile` with a
Maven build system and the `Igpay` class with a [Spring Boot][2] web
application.

[2]: https://spring.io/projects/spring-boot/
