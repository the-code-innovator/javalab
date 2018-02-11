#!/bin/bash

#compiling other auxillary sources
javac ./sources/InsufficientFundsException.java -d ./
javac ./sources/Interest.java -d ./
javac ./sources/Transaction.java -d ./
javac ./sources/Account.java -d ./
javac ./sources/SbAccount.java -d ./
javac ./sources/FDAccount.java -d ./
javac ./sources/Customer.java -d ./

#compiling the main File
javac ./sources/BankDemo.java -d ./

#moving into ./class_files/ sub directory.
# cd ./class_files/

#executing the Program
java BankDemo
