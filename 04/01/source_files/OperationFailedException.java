//Including this file under the package exception_handling :
package exception_handling;

//importing io for exception handling :
import java.io.*;

//Operation Failed Exception for handling Operation Failure encompassing both { BadOperandException, BadOperatorException } :
public class OperationFailedException extends Exception{
  //local description string :
  private String description;

  //Constructor for OperationFailedException :
  public OperationFailedException(String str){
    this.description = str;
  }

  //Constructor for OperationFailedException :
  public OperationFailedException(String str, Throwable thrown){
    this.description = str;
    System.out.print(this.toString());
    this.initCause(thrown);
  }

  //toString() for printing Exception :
  public String toString(){
    return ("\nException Encountered : " + "\nRoot Cause : " + this.description);
  }
}
