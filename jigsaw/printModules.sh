#!/bin/sh -x

$JAVA_HOME/bin/jar --print-module-descriptor --file=mlib/dpr.api@1.0.0.jar
$JAVA_HOME/bin/jar --print-module-descriptor --file=mlib/dpr.impl@1.0.0.jar
$JAVA_HOME/bin/jar --print-module-descriptor --file=mlib/dpr.runner@1.0.0.jar
