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

public class Move extends Commands implements CommandsInterface {
  
  private TrackDirectoriesMade directories;
  private ValidateDirectory relativeToAbsolute;
  private ArrayList<String> directoriesMade;
  
  /**
   * Default constructor.
   */
  public Move() {
    relativeToAbsolute = new ValidateDirectory();
    directories = new TrackDirectoriesMade();
    directoriesMade = directories.getTrackedDirectories();
    
  }
  
  /**
   * If the newPath is a directory, oldPath will be moved into newPath.
   * Otherwise, item newPath will be replaced with the item oldPath.
   * @param oldPath The item to be moved.
   * @param newPath The place the item will be moved to.
   */
  public void moveFiles(String oldPath, String newPath) {
    // Get the absolute paths of oldPath and newPath
    String oldPathAbs = relativeToAbsolute.dirToAbsolute(oldPath, 
        this.getCurrentDir());
    String newPathAbs = relativeToAbsolute.dirToAbsolute(newPath, 
        this.getCurrentDir());
    System.out.println(oldPathAbs + " " + newPathAbs);
    
    // Find the last occurrence of '/'
    int lastIndexOld = oldPathAbs.lastIndexOf("/");
    int lastIndexNew = oldPathAbs.lastIndexOf("/");
    // If newPath is a directory, add item at oldPath to newPath
    if (directoriesMade.contains(newPathAbs)) {
      newPathAbs += oldPathAbs.substring(lastIndexOld, oldPathAbs.length());
      System.out.println(newPathAbs);
    }
    // (If it is a file *needs fixing*)
    else {
      // Otherwise, replace the item at newPath with the one at oldPath
      newPathAbs = newPathAbs.substring(0, lastIndexNew) + 
          oldPathAbs.substring(lastIndexOld, oldPathAbs.length());
      System.out.println(newPathAbs);
    }
  }

  /**
   * Moves an item from a given old path to a given new path. If the
   * new path happens to be a directory, the item being moved will be
   * moved into the directory.
   * @param shell The JShell object.
   * @param instanceOfClass An object of the class being executed.
   * @param cleanedInput The array of the input command in the shell.
   */
  @Override
  public void execute(JShell shell, Object instanceOfClass,
      String[] cleanedInput) {
    // If exactly 3 arguments were passed
    if (cleanedInput.length == 3) {
      // Call the moveFiles class with the oldpath and newpath
      ((Move) instanceOfClass).moveFiles(cleanedInput[1], cleanedInput[2]);
    }
    // Otherwise, it is an invalid command
    else {
      System.out.println("Invalid command, please try again.");
    }
    
  }





}
