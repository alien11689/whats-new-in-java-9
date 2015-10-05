#!/bin/sh -x
./clean.sh

JAVA_HOME=../..

mkdir -p modules/dpr.api modules/dpr.impl modules/dpr.runner

$JAVA_HOME/bin/javac -d modules/dpr.api -modulepath modules -sourcepath src `find src/dpr.api -name '*.java'`

$JAVA_HOME/bin/javac -d modules/dpr.impl -modulepath modules -sourcepath src `find src/dpr.impl -name '*.java'`

$JAVA_HOME/bin/javac -d modules/dpr.runner -modulepath modules -sourcepath src `find src/dpr.runner -name '*.java'`

$JAVA_HOME/bin/java -modulepath modules -m dpr.runner/com.dpr.runner.Main
