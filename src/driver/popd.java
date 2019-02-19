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

import java.util.ArrayList;

/**
 * @author kia
 * Removes the top entry from the directory stack, and cds into it
 */
public class popd extends Commands {
  /**
   * Default constructor.
   * Removes the top entry from the directory stack
   * changes the current working directory to it
   * @param string that represents directory
   */
  public popd() {
    ArrayList<String> StackDir = this.getStackDir();
    String removedDir = StackDir.get(StackDir.size() - 1);
    this.setCurrentDir(removedDir);
    this.getStackDir().remove(StackDir.size() - 1);
  }

}
