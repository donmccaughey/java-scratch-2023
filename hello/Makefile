.SECONDEXPANSION :


.PHONY : all
all : bin/cc/donm/hello/Hello.class


.PHONY : run
run : all
	java -cp bin cc.donm.hello.Hello


.PHONY : clean
clean :
	rm -rf bin


sources := src/cc/donm/hello/Hello.java

classes := $(patsubst src/%.java,bin/%.class, $(sources))


$(classes) : bin/%.class : src/%.java
	javac -d bin $<

