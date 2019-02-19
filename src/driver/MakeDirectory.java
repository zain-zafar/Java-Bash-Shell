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

public class MakeDirectory extends Commands implements CommandsInterface {

  /**
   * var dirsToBeMade: Stores the directories entered by the user which need to
   * be turned into absolute directories if not already. These are then turned
   * into directories.
   */
  private ArrayList<String> dirsToBeMade = new ArrayList<>();

  /**
   * Takes in array of directories based on mkdir command and pushes each
   * directory into an ArrayList. Triggers helper function to format each
   * directory into an ABSOLUTE path directory; pushes each ABSOLUTE directory
   * into the instance variable and triggers TrackDirectoriesMade.
   *
   * @param directories The array containing all the ABSOLUTE path directories
   * to be made.
   */
  public void makeDirectory(String[] directories) {

    ArrayList<String> directory = new ArrayList<>();

    if (directories.length == 1) {
      System.out.println("Invalid command, please try again");
    } else {
      // The first argument passed is always a command... remove it
      for (int i = 1; i < directories.length; i++) {
        directory.add(directories[i]);
      }
      // Iterate through each dir the user passed and add it to list
      if (directory.size() > 1) {
        for (String dir : directory) {
          String cleanedDir = cleanInput(dir); // Run helper....
          if (!cleanedDir.contains(" ")) {
            dirsToBeMade.add(cleanedDir);
          } else {
            System.out.println(cleanedDir);
          }
        }
      }
      // Only 1 argument was passed....
      else {
        String cleanedDir = "";
        cleanedDir = cleanInput(directory.get(0));
        if (!cleanedDir.contains(" ")) {
          dirsToBeMade.add(cleanedDir);
        } else {
          System.out.println(cleanedDir);
        }
      }
      /*
       * Now the Array of absolute path directories has been made....
       * Use the Track Directory collaborator in Commands to access
       * addDir.
       */
      this.getTrackD().addDir(dirsToBeMade);
    }
  }


  /**
   * Takes in a string directory and formats it into ABSOLUTE directory path to
   * be returned. Raises errors if ASSIGNMENT CONDITIONS are not met.
   *
   * @param dir The directory to be formatted into ABSOLUTE directory.
   * @return A string that is either an error or an ABSOLUTE directory path.
   */
  public String cleanInput(String dir) {

    // Get current directory.
    String currDirr = this.getCurrentDir();

    // If current directory and directory inputted are same, raise error.
    if (dir.equals(currDirr)) {
      return "This directory already exists.";
    }

    // Remove the last slash, if it exists, this is based on our design
    if (dir.endsWith("/")) {
      int lastIndexofSlash = dir.lastIndexOf("/");
      dir = dir.substring(0, lastIndexofSlash);
    }

    // End if string without slashes contains invalid inputs
    String removeSlashes = dir.replaceAll("/", "");

    // If the dir is an absolute path, just add it to the list
    if (dir.startsWith("/") && removeSlashes.matches("[a-zA-Z0-9/]*")) {
      // System.out.println("Absolute path ----------------");
      return dir;
    }

    // If the dir is relative, make it absolute....
    else if (removeSlashes.matches("[a-zA-Z0-9/]*")) {

      // System.out.println("RELATIVE PATH -----------------");

      /*
       * CONDITIONS ----------
       * 1. There can be .. which means to go back to parent..
       * 2. There are no dots, then add append to the current directory.
       */

      // Case 1:  Dir starts with .. and current directory isn't root
      // Check to see .. is followed by a / otherwise its error
      if (dir.startsWith("..") && dir.length() > 2 &&
          !(dir.substring(2, 3).equals("/"))) {

        return "Invalid input. Please try again.....";
      }

      if (dir.startsWith("..") && !currDirr.equals("/")) {

        // Check to see .. is followed by a / otherwise its error
        if (!dir.substring(2, 3).equals("/")) {

          return "Invalid input. Please try again.";
        }
        // If there is a ../ then go back to parent in current dir and append
        int lastIndexOfSlash = currDirr.lastIndexOf("/");
        return currDirr.substring(0, lastIndexOfSlash + 1) + dir.substring(3);
      }
      // There is no parent of root directory, so return error
      else if (dir.startsWith("..") && currDirr.equals("/")) {
        return "Invalid input. No parent of root directory. Try again.";
      }
      // Case 2 -------------- Does not start with ..
      else {
        if (currDirr.equals("/")) {
          return currDirr + dir;
        }
        return currDirr + "/" + dir;
      }
    } else {
      return "Invalid input";
    }
  }

  /**
   * Makes a directory given an array of paths.
   * @param shell The JShell object.
   * @param instanceOfClass An object of the class being executed.
   * @param cleanedInput The array of the input command in the shell.
   */
  @Override
  public void execute(JShell shell, Object instanceOfClass,
      String[] cleanedInput) {
    // make a new directory or new directories the user requested
    ((MakeDirectory) instanceOfClass).makeDirectory(cleanedInput);
  }
}