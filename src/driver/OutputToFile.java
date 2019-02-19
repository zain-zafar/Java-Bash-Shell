// **********************************************************
// Assignment2: JShell
// Student1: Syed Zain Zafar
// UTORID user_name: zafarsy4
// UT Student #: 1002534705
// Author: Syed Zain Zafar
//
// Student2: Anna Liang
// UTORID user_name: lianga17
// UT Student #: 1004355976
// Author: Anna Liang
//
// Student3: Ryan Low
// UTORID user_name: lowryan1
// UT Student #: 1003215601
// Author: Ryan Low
//
// Student4: Kia Naderi 
// UTORID user_name: naderiki
// UT Student #: 1002886549
// Author: Kia Naderi 
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package driver;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class OutputToFile {
  
  /**
   * Default constructor.
   */
  public OutputToFile() {
    
  }
  
  /**
   * This method will append any string to the end of a given file.
   * @param toPrint The string that is going to be printed on the file.
   * @param fileName The name of the file to print a given string on.
   */
  public static void printToFile(String toPrint, String fileName) {
    try {
      // new BufferedWriter which will append
      BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
      bw.write(toPrint);
      // start a new line
      bw.newLine();
      bw.close();
    }
    
    catch (IOException e) {

    }

  }

}
