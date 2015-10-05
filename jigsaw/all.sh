#!/bin/sh -x
./clean.sh
./build2.sh
./library.sh
./printModules.sh
./createImage.sh
./runImage.sh
