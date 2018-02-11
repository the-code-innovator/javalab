//Including this file under the package exception_handling :
package exception_handling;

//importing io for exception handling :
import java.io.*;

//Bad Operator Exception for handling Invalid Operators :
public class BadOperatorException extends Exception{
  //Declaration of the operator :
  private char operator;

  //Constructor for BadOperatorException :
  public BadOperatorException(char operator){
    //Assigning values to the local Operator variable :
    this.operator = operator;
  }

  //toString() function to print the exception description :
  public String toString(){
    return ("\nERROR EH002-BOR: Operator - " + this.operator + " is not one of { + , - , * , / }");
  }
}
