# `igpay`

This is a simple command line application that transforms input into [Pig
Latin][1].  It reads lines from standard input and writes the translated lines
to standard output.  The `Igpay` class exists to hold the `main()` method.  The
`Translator` class implements the loop that reads input and writes translated
output.  There are also some unit tests for the `Translator` class.

[1]: https://en.wikipedia.org/wiki/Pig_Latin

The `Makefile` implements targets to run unit tests (`check`), build a jar
file, run the app, download dependencies and clean up (`clean` removes `.class`
files and the jar file, `clobber` cleans and removes downloaded dependencies).

The project doesn't use Maven, but adopts Maven's standard source directory
layout.

