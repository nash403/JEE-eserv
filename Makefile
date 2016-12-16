.PHONY: clean

MY_PWD=$(shell pwd)

all: resolve compiling

resolve:
	mvn dependency:resolve

eclipse:
	mvn eclipse:eclipse

compiling:
	mvn compile

package:
	mvn package -Dmaven.test.skip=true

deploy:
	mvn deploy

clean:
	rm -rf target/
