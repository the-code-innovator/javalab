#!/bin/bash
javac ./source_files/stringops.java -d ./class_files
cd ./class_files
java stringops
