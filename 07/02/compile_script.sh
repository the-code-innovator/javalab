#!/bin/bash
javac ./source_files/PointOps.java -d ./class_files -Xlint
cd ./class_files
echo "complilation over ..."
echo "execution ..."
java PointOps
