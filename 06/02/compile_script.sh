#!/bin/bash
javac ./source_files/PointDemo.java -d ./class_files/
echo "compilation over ..."
echo "execution begins ..."
cd ./class_files/
java PointDemo
