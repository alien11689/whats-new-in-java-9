#!/bin/sh -ex
./clean.sh
./build2.sh
./library.sh
./printModules.sh
./createImage.sh
./runImage.sh
./packImage.sh
./unpackImage.sh
./runExtractedImage.sh
