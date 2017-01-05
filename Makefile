.PHONY: clean

MY_PWD=$(shell pwd)
TOMPATH=../apache-tomcat-8.5.4/webapps

all: resolve compiling

resolve:
	mvn dependency:resolve

eclipse:
	mvn eclipse:eclipse

compiling:
	mvn compile

package: clean
	mvn package -Dmaven.test.skip=true
	
tomcat: package
	ln -s $(MY_PWD)/target/structure-srv-1.0-SNAPSHOT.war $(TOMPATH)/structure-srv.war || (rm $(TOMPATH)/structure-srv.war && ln -s $(MY_PWD)/target/structure-srv-1.0-SNAPSHOT.war $(TOMPATH)/structure-srv.war)

install: package
	mvn install:install-file -Dfile=./target/structure-srv-1.0-SNAPSHOT.jar -DgroupId=fr.eservices.structure -DartifactId=structure-srv -Dversion=1.0-SNAPSHOT -Dpackaging=jar

deploy:
	mvn deploy

clean:
	rm -rf target/
