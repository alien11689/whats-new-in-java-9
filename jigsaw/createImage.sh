#!/bin/sh -x
JAVA_HOME=../..

$JAVA_HOME/bin/jlink --modulepath $JAVA_HOME/jmods:mlib --addmods dpr.runner --addmods dpr.impl --output dprApp
