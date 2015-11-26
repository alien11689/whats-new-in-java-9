What's new in Java 9
====================

Newest Java 9 on docker
-----------------------

`docker` and `docker-compose` must be installed.

First create docker images:

```
git submodule init
git submodule update
cd BuildHelpers/openjdk-docker/OpenJDK-baseimage/
./buildImageFromDockerfile.sh
cd -
cd BuildHelpers/openjdk-docker/OpenJDK9
./buildImageFromDockerfile.sh
cd -
```

Run containers:

```
cd docker
docker-compose up
```

Jigsaw example
--------------

1.	Download java with jigsaw attached: TODO link
2.	Extract it
3.	set JAVA_HOME to extracted DIR
4.	`cd jigsaw/`
5.	`./all.sh`

Money example
-------------

```
cd money
mvn clean install
```

Kulla example
-------------

```
cd kulla
./start.sh
```
