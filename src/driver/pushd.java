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

/**
 * @author kia
 * Saves the current working 
 * directory by pushing onto directory stack
 * and then changes the new current working
 * directory to DIR
 *
 */
public class pushd extends Commands {
  /**
   * Default constructor.
   * Adds the directory into the stack Array
   * @param string that represents directory
   */
  public pushd(String Dir) {
    this.getStackDir().add(this.getCurrentDir());
    this.setCurrentDir(Dir);
  }
}
