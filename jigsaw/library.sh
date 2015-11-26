#!/bin/sh -x

mkdir mlib

$JAVA_HOME/bin/jar --create --file=mlib/dpr.api@1.0.0.jar --module-version=1.0.0 -C modules/dpr.api .

$JAVA_HOME/bin/jar --create --file=mlib/dpr.impl@1.0.0.jar --module-version=1.0.0 -C modules/dpr.impl .

$JAVA_HOME/bin/jar --create --file=mlib/dpr.runner@1.0.0.jar --module-version=1.0.0 --main-class=com.dpr.runner.Main -C modules/dpr.runner .

$JAVA_HOME/bin/java -mp mlib -m dpr.runner
