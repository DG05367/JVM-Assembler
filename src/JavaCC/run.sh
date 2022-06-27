#!/bin/bash
rm *.java

rm *.class

java -jar javacc-full.jar JasminParser.jj

javac *.java

java JasminParser TeamsExamples/ex.j

java JasminParser TeamsExamples/ex1.j

java JasminParser TeamsExamples/ExMain.j

