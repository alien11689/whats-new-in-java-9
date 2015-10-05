#!/bin/sh -x
JAVA_HOME=../..

$JAVA_HOME/bin/jlink --modulepath $JAVA_HOME/jmods:mlib --addmods example.runner --output exampleApp
