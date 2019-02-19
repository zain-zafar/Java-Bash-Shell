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

public class EchoAppend extends Echo {
  
  /**
   * This method will append strings to a file without clearing it
   * beforehand by calling its super class.
   * @param toPrint The string that is going to be printed on the file.
   * @param fileName The name of the file to print a given string on.
   */
  public void printToFile(String toPrint, String fileName) {
    // call super class to append to file
    super.printToFile(toPrint, fileName);
    
  }
}
