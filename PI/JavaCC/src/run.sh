#!/bin/bash
java -jar javacc-full.jar JasminParser.jj

javac *.java -d ../build

javac Jasmin/*.java -d ../build

java -cp ../build Launcher ../../Exercises/ex.j

java -cp ../build Launcher ../../Exercises/ex1.j

java -cp ../build Launcher ../../Exercises/ExMain.j

