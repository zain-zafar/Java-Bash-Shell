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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class File {
  
  private String fileName;
  
  public File(String name) {
    // Add a special character to identify file
    fileName = name + "*";
  }
  
  /**
   * Prints the contents of the given files
   * @param fileName
   */
  public void printFileContents(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line = null;
      while((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
    }
  }
  
  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName + "*";
  }
  
}
