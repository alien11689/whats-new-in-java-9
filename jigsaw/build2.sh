#!/bin/sh -x
./clean.sh

JAVA_HOME=../..

mkdir modules

$JAVA_HOME/bin/javac -d modules -modulesourcepath src `find src -name '*.java'`

$JAVA_HOME/bin/java -modulepath modules -m dpr.runner/com.dpr.runner.Main
