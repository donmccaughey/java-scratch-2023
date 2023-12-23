TMP ?= $(abspath tmp)

junit_url := https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.9.3/junit-platform-console-standalone-1.9.3.jar
junit_jar := $(notdir $(junit_url))


.SECONDEXPANSION :


sources := \
	src/main/cc/donm/igpay/Igpay.java \
	src/main/cc/donm/igpay/Space.java \
	src/main/cc/donm/igpay/Text.java \
	src/main/cc/donm/igpay/Translator.java \
	src/main/cc/donm/igpay/Word.java

classes := $(patsubst src/main/%.java,bin/%.class, $(sources))

tests := \
	src/test/cc/donm/igpay/TranslatorTest.java

test_classes := $(patsubst src/test/%.java,bin/%.class, $(tests))


.PHONY : all
all : check


.PHONY : run
run : all
	java -cp bin cc.donm.igpay.Igpay


.PHONY : check
check : tmp/check.stamp.txt


.PHONY : clean
clean :
	rm -rf bin
	rm -rf tmp


.PHONY : clobber
clobber : clean
	rm -rf deps


$(classes) : bin/%.class : $(sources)
	javac -d bin $^


$(test_classes) : bin/%.class : $(tests) $(classes) deps/$(junit_jar)
	javac \
		-cp bin:deps/$(junit_jar) \
		-d bin \
		$(tests)


deps/$(junit_jar) : | $$(dir $$@)
	cd deps && curl --remote-name $(junit_url)


tmp/check.stamp.txt : deps/$(junit_jar) $(test_classes) | $$(dir $$@)
	java -jar deps/$(junit_jar) \
		-cp bin \
		--disable-banner \
		--fail-if-no-tests \
		--scan-classpath
	date > $@


deps \
tmp :
	mkdir -p $@
