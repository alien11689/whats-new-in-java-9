#!/bin/sh -x

$JAVA_HOME/bin/jimage extract --dir=extractedImageLocation dprApp.jimage

chmod +x ./extractedImageLocation/bin/dpr.runner ./extractedImageLocation/bin/java
