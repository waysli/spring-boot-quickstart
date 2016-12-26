Spring Boot Quickstart Maven Archetype
=========================================

[![Build Status](https://travis-ci.org/suzel/spring-boot-quickstart-archetype.svg?branch=master)](https://git.xiaojukeji.com/Base/spring-boot-quickstart)
[![License Status](https://img.shields.io/badge/license-MIT-blue.svg)](https://git.xiaojukeji.com/Base/spring-boot-quickstart/blob/master/LICENSE)

Summary
-------
The project is a Maven archetype for Spring Boot web application.

Installation
------------

To install the archetype in your local repository execute following commands:

```sh
$ git clone git@git.xiaojukeji.com:Base/spring-boot-quickstart.git
$ cd spring-boot-quickstart
$ mvn clean install
```

Create a project
-----------------

Create a new empty directory for your project and navigate into it and then run:

with Bash :

```sh
$ mvn archetype:generate \
     -DarchetypeCatalog=local \
     -DarchetypeGroupId=com.xiaojukeji.base \
     -DarchetypeArtifactId=spring-boot-quickstart \
     -DarchetypeVersion=1.0.0 \
     -DgroupId=your.project.groupId \
     -DartifactId=your-project-name \
     -Dversion=0.0.1-SNAPSHOT \
     -DinteractiveMode=false
```

with CommandPrompt (Windows) :

```sh
> mvn archetype:generate^
     -DarchetypeCatalog=local^
     -DarchetypeGroupId=com.xiaojukeji.base^
     -DarchetypeArtifactId=spring-boot-quickstart^
     -DarchetypeVersion=1.0.0^
     -DgroupId=your.project.groupId^
     -DartifactId=your-project-name^
     -Dversion=0.0.1-SNAPSHOT^
     -DinteractiveMode=false
```

Note: No additional services are required in order to start the application.
