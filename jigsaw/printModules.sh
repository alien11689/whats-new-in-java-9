#!/bin/sh -x
JAVA_HOME=../..

$JAVA_HOME/bin/jar --print-module-descriptor --file=mlib/example.api@1.0.0.jar
$JAVA_HOME/bin/jar --print-module-descriptor --file=mlib/example.impl@1.0.0.jar
$JAVA_HOME/bin/jar --print-module-descriptor --file=mlib/example.runner@1.0.0.jar
