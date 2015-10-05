#!/bin/sh -x
JAVA_HOME=../..

mkdir mlib

$JAVA_HOME/bin/jar --create --file=mlib/example.api@1.0.0.jar --module-version=1.0.0 -C modules/example.api .

$JAVA_HOME/bin/jar --create --file=mlib/example.impl@1.0.0.jar --module-version=1.0.0 -C modules/example.impl .

$JAVA_HOME/bin/jar --create --file=mlib/example.runner@1.0.0.jar --module-version=1.0.0 --main-class=com.example.runner.ExampleRunner -C modules/example.runner .

$JAVA_HOME/bin/java -mp mlib -m example.runner
