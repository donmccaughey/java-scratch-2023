# `migpay`

This is a simple command line application that transforms input into [Pig
Latin][1].  It reads lines from standard input and writes the translated lines
to standard output.  The `Igpay` class exists to hold the `main()` method.  The
`Translator` class implements the loop that reads input and writes translated
output.  There are also some unit tests for the `Translator` class.

[1]: https://en.wikipedia.org/wiki/Pig_Latin

`migpay` is based on [`igpay`](../igpay) but replaces the `Makefile` with a
Maven build system.

