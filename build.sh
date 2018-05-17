#!/bin/bash
source ./config.sh
setup(){
	if [ ! -d "./jdk1.8.0_131" ]; then
	  	  curl -L -b "oraclelicense=a" http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.tar.gz | tar -xzC $BASE_HOME
	fi
	
	if [ ! -d "./apache-maven-3.0.5" ]; then 
	  curl -sL http://www-eu.apache.org/dist/maven/maven-3/3.0.5/binaries/apache-maven-3.0.5-bin.tar.gz | tar -xzC $BASE_HOME
	fi

	export M2_HOME=$BASE_HOME/apache-maven-3.0.5/
	export M2=$M2_HOME/bin
	export JAVA_HOME=$BASE_HOME/jdk1.8.0_131
	export PATH=$PATH:$JAVA_HOME/bin/
	export PATH=$M2:$PATH

      #	cp -fR settings.xml $BASE_HOME/apache-maven-3.5.2/conf/settings.xml

	echo $PATH
}
setup

build(){
	cd $1
	mvn clean install -DskipTests
}

builddocker() {
    cd ..
	docker build -f memoryloadergenerator/Dockerfile -t sairaghavarram/memoryloadergenerator .
}


build memoryloadgenerator

builddocker
