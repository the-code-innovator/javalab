#!/bin/bash

#compiling other auxillary source_files
javac ./source_files/InsufficientFundsException.java -d ./
javac ./source_files/InterestRate.java -d ./
javac ./source_files/Transaction.java -d ./

javac ./source_files/Account.java -d ./
javac ./source_files/SBAccount.java -d ./
javac ./source_files/FDAccount.java -d ./
javac ./source_files/Customer.java -d ./

#compiling the main File
javac ./source_files/BankDemo.java -d ./

#moving into ./class_files/ sub directory.
# cd ./class_files/

#executing the Program
java BankDemo
