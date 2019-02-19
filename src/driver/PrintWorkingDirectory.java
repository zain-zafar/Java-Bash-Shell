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

public class PrintWorkingDirectory extends Commands
implements CommandsInterface {

  /**
   * Prints the working directory.
   */
  public void printCurrDirr() {
    System.out.println(this.getCurrentDir());
  }

  /**
   * Prints the current working directory.
   * @param shell The JShell object.
   * @param instanceOfClass An object of the class being executed.
   * @param cleanedInput The array of the input command in the shell.
   */
  @Override
  public void execute(JShell shell, Object instanceOfClass,
      String[] cleanedInput) {
    ((PrintWorkingDirectory) instanceOfClass).printCurrDirr();
    
  }
}
