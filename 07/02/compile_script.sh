#!/bin/bash
javac ./source_files/PointOps.java -d ./class_files
cd ./class_files
echo "complilation over ..."
echo "execution ..."
java PointOps
