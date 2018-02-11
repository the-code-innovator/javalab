#!/bn/bash

# compile the main file in spurce_files
javac ./source_files/Multiple_Threads.java -d ./class_files
# execute the Program
cd ./class_files
java Multiple_Threads
