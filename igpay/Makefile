.SECONDEXPANSION :


sources := \
	src/cc/donm/igpay/Igpay.java \
	src/cc/donm/igpay/Translator.java

classes := $(patsubst src/%.java,bin/%.class, $(sources))


.PHONY : all
all : $(classes)


.PHONY : run
run : all
	java -cp bin cc.donm.igpay.Igpay


.PHONY : clean
clean :
	rm -rf bin


bin/%.class : $(sources)
	javac -d bin $^