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
public class PushDirectory extends Commands implements CommandsInterface {
  
  /**
   * Pushes the current directory onto the directory stack.
   * Then the current directory will be changed to the new one passed in.
   * @param string that represents directory
   */
  public void pushd (String Dir) {
    this.getStackDir().add(this.getCurrentDir());
    this.setCurrentDir(Dir);
  }

  /**
   * Calls the pushd method to push the given directory onto the stack.
   * @param shell The JShell object.
   * @param instanceOfClass An object of the class being executed.
   * @param cleanedInput The array of the input command in the shell.
   */
  @Override
  public void execute(JShell shell, Object instanceOfClass,
      String[] cleanedInput) {
    // Pushes the directory given as an input
    ((PushDirectory) instanceOfClass).pushd(cleanedInput[1]);
    
  }
}
