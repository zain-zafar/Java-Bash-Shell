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


public class TrackDirectoriesMade {
  /**
   * var directories: Stores all directories made.
   */
  private static ArrayList<String> directories;

  /**
   * Initial constructor which initializes directories variable.
   */
  public TrackDirectoriesMade() {
    directories = new ArrayList<>();
  }

  /**
   * Pushes given directories into instance ArrayList variable iff directory
   * does not exist inside the instance variable. This method is trigged by
   * MakeDirectory class which is triggered by mkdir command.
   *
   * @param absolutePathDirs The array contains all the ABSOLUTE path
   * directories to be pushed into instance variable.
   */
  public void addDir (ArrayList<String> absolutePathDirs) {
    // Add the root directory it directory is empty...
    if (directories.size() == 0) {
      directories.add("/");
    }
    // Loop through each ABSOLUTE path directory....
    for (String dir : absolutePathDirs) {
      // COUNT THE NUMBER OF SLASHES --------------
      int numbOfSlashes = 0;
      for (int i = 0; i < dir.length(); i++) {
        if (dir.substring(i).startsWith("/")) {
          numbOfSlashes += 1;
        }
      }
      // If 1 slash, and if dir is not in array, add it
      if (numbOfSlashes == 1 && !directories.contains(dir)) {
        directories.add(dir);
      }
      /*
       * If there are more than 1 slashes, then find index of last slash
       * and slice the list from 0 index upto it, this way we can check if
       * absolute parent directory for dir is inside the list. If it is, add
       * dir.
       */
      else {
        int indxOfLastSlash = dir.lastIndexOf("/");
        if (directories.contains(dir.substring(0,indxOfLastSlash)) &&
            !directories.contains(dir)) {
          directories.add(dir);
        }
        else if (directories.contains(dir)) {
          System.out.println("Directory already exists. Please try again.");
        }
        else {
          System.out.println("Invalid directory. Please try again.");
        }
      }
    }
  }

  /**
   * Returns the array which stores all directories made
   *
   * @return Array which holds all directories made.
   */
  public ArrayList<String> getTrackedDirectories () {
    return directories;
  }
}
