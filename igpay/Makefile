.SECONDEXPANSION :


sources := src/cc/donm/igpay/Igpay.java

classes := $(patsubst src/%.java,bin/%.class, $(sources))


.PHONY : all
all : $(classes)


.PHONY : run
run : all
	java -cp bin cc.donm.igpay.Igpay


.PHONY : clean
clean :
	rm -rf bin


$(classes) : bin/%.class : src/%.java
	javac -d bin $<
