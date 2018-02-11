#!/bin/bash

#compilation of auxillary source files from the ./source_files subdirectory.
javac ./source_files/Transaction.java -d ./
javac ./source_files/InterestRate.java -d ./
javac ./source_files/Account.java -d ./
javac ./source_files/SBAccount.java -d ./
javac ./source_files/FDAccount.java -d ./
javac ./source_files/Customer.java -d ./

#compilation of the BankDemo source file that contains the main method.
javac ./source_files/BankDemo.java -d ./

#notifying the end user that the compilation is over.
echo "compilation of source files completed ..."

# cd ./class_files

#notifying the end user that the program is about to begin.
echo "execution of program begins ..."

#executing the program from the present working directory.
java BankDemo
