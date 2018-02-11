#!/bin/bash

#compilation of auxillary source files from the ./source_files subdirectory.
javac ./source_files/BadOperandException.java -d ./
javac ./source_files/BadOperatorException.java -d ./
javac ./source_files/OperationFailedException.java -d ./

#compilation of the ExceptionHandlingDemo source file which contains the main method.
javac ./source_files/ExceptionHandlingDemo.java -d ./

#notifying the end user that the compilation is over.
echo "compilation of source files completed ..."

#moving into class_files subdirectory.
# cd ./

#notifying the end user that the program is about to begin.
echo "execution of program begins ..."

#executing the program from the present working directory.
java ExceptionHandlingDemo
