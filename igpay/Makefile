TMP ?= $(abspath tmp)

junit_url := https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.9.3/junit-platform-console-standalone-1.9.3.jar
junit_jar := $(notdir $(junit_url))


.SECONDEXPANSION :


resources := \
	src/main/resources/META-INF/MANIFEST.MF

sources := \
	src/main/java/cc/donm/igpay/Igpay.java \
	src/main/java/cc/donm/igpay/Space.java \
	src/main/java/cc/donm/igpay/Text.java \
	src/main/java/cc/donm/igpay/Translator.java \
	src/main/java/cc/donm/igpay/Word.java

classes := $(patsubst src/main/java/%.java,bin/main/%.class, $(sources))

tests := \
	src/test/java/cc/donm/igpay/TranslatorTest.java

test_classes := $(patsubst src/test/java/%.java,bin/test/%.class, $(tests))


.PHONY : check
check : tmp/check.stamp.txt


.PHONY : jar
jar : bin/igpay.jar


.PHONY : run
run : check
	java -cp bin/main cc.donm.igpay.Igpay


.PHONY : clean
clean :
	rm -rf bin
	rm -rf tmp


.PHONY : clobber
clobber : clean
	rm -rf deps


$(classes) : bin/main/%.class : $(sources)
	javac -d bin/main $^


$(test_classes) : bin/test/%.class : $(tests) $(classes) deps/$(junit_jar)
	javac \
		-cp bin/main:deps/$(junit_jar) \
		-d bin/test \
		$(tests)


deps/$(junit_jar) : | $$(dir $$@)
	cd deps && curl --remote-name $(junit_url)


tmp/check.stamp.txt : deps/$(junit_jar) $(test_classes) | $$(dir $$@)
	java -jar deps/$(junit_jar) \
		-cp bin/main \
		-cp bin/test \
		--disable-banner \
		--fail-if-no-tests \
		--scan-classpath
	date > $@


bin/igpay.jar : $(resources) $(classes) tmp/check.stamp.txt | $$(dir $$@)
	jar \
		--create \
		--file $@ \
		--no-manifest \
		-C src/main/resources . \
		-C bin/main .


bin \
deps \
tmp :
	mkdir -p $@
