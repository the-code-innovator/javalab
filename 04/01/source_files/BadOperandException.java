//Including this file under the package exception_handling :
package exception_handling;

//importing io for exception handling :
import java.io.*;

//Bad Operand Exception for handling Out of Bounds Operands :
public class BadOperandException extends Exception{
  //Declaration of operand :
  private int operand;

  //Declaration of Limits :
  private int startlimit;
  private int endlimit;

  //Constructor for BadOperandException :
  public BadOperandException(int operand, int startlimit, int endlimit){
    //Assigning values to the local Operand & Limits variables :
    this.operand = operand;
    this.startlimit = startlimit;
    this.endlimit = endlimit;
  }

  //toString() function to print the exception description :
  public String toString(){
    return ("\nERROR EH001-BOD: Operand - " + this.operand + " is not within range : { " + this.startlimit + " : " + this.endlimit + " } ");
  }
}
