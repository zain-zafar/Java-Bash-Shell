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

public class ChangeDirectory extends Commands implements CommandsInterface {

  /**
   * Collaborating with Valiadate directory in order to use its method to turn
   * relative directories to absolute.
   */
  private ValidateDirectory checkDir = new ValidateDirectory();


  /**
   * Checks to see if user input is a valid existing directory and only then
   * changes the directory to current directory.
   *
   * @param directory The directory to be checked and set as current dir.
   */
  public void checkAndChangeDir(String directory) {

    // Get all the directories made
    ArrayList<String> existingDirs = this.getTrackD().getTrackedDirectories();

    // Get current working directory
    String currDir = this.getCurrentDir();

    // If directory ends with / , remove it
    if (directory.endsWith("/") && directory.length() != 1) {
      directory = directory.substring(0,directory.length() - 1);
    }

    // Check if directory is not absolute
    if (!directory.startsWith("/")) {
      /*
       * Use the ValidateDirectory instance method to change relative
       * directory to absolute
       */
     directory = this.checkDir.dirToAbsolute(directory, currDir);
    }

    // Check if the absolute directory exists inside
    if (existingDirs.contains(directory) || directory.equals("/")) {
      this.setCurrentDir(directory);
    } else { // It does not exist inside
      System.out.println("The directory does not exist. Please try again.");
    }

  }

  /**
   * Changes the current directory the a given path.
   * @param shell The JShell object.
   * @param instanceOfClass An object of the class being executed.
   * @param cleanedInput The array of the input command in the shell.
   */
  @Override
  public void execute(JShell shell, Object instanceOfClass,
      String[] cleanedInput) {
    
    // Check if the path is valid and changes the current directory
    ((ChangeDirectory) instanceOfClass).checkAndChangeDir(cleanedInput[1]);
    shell.setCurrentDirectory(shell.getCommand().getCurrentDir());

  }
}
