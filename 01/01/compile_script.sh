#!/bin/bash

#compilation of main source file from the ./source_files/ directory
# and dumping the class files into ./class_files/ directory.
javac ./source_files/BookDemo.java -d ./class_files/

#notifying the end user that the compilation is over.
echo "compilation of source files completed ..."

#moving into ./class_files/ directory.
cd ./class_files/

#notifying the end user that the program is about to begin.
echo "execution of program begins ..."

#executing the program from the present working directory (./class_files/).
java BookDemo
