#!/bin/sh -x
./clean.sh

JAVA_HOME=../..

mkdir -p modules/example.api modules/example.impl modules/example.runner

$JAVA_HOME/bin/javac -d modules/example.api -modulepath modules -sourcepath src `find src/example.api -name '*.java'`

$JAVA_HOME/bin/javac -d modules/example.impl -modulepath modules -sourcepath src `find src/example.impl -name '*.java'`

$JAVA_HOME/bin/javac -d modules/example.runner -modulepath modules -sourcepath src `find src/example.runner -name '*.java'`

$JAVA_HOME/bin/java -modulepath modules -m example.runner/com.example.runner.ExampleRunner
