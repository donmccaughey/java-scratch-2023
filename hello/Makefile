.SECONDEXPANSION :


sources := src/cc/donm/hello/Hello.java

classes := $(patsubst src/%.java,bin/%.class, $(sources))


.PHONY : all
all : $(classes)


.PHONY : run
run : all
	java -cp bin cc.donm.hello.Hello


.PHONY : clean
clean :
	rm -rf bin


bin/%.class : $(sources)
	javac -d bin $^

