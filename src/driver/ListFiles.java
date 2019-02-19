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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListFiles extends Commands implements CommandsInterface {

  /**
   * var relativeToAbsolute: Utilizes ValidateDirectory class to
   * turn relative directories to absolute.
   *
   * var allChildren: Stores all directories and files to be printed.
   */
  private ValidateDirectory relativeToAbsolute;
  private ArrayList<String> allChildren;
  private int directorySize = 0;

  /**
   * Default constructor which initializes 2 variables.
   */
  public ListFiles() {
    relativeToAbsolute = new ValidateDirectory();
    allChildren = new ArrayList<>();
  }

  /**
   * Utilizes helper functions to first get all the children of the
   * passed directory and then prints them.
   *
   * @param directories the user inputted directory; if nothing was
   * entered, the current directory is passed instead.
   */
  public void listFilesAndDirectories(String[] directories) {
    /*
     * List that stores all children of the directory passed as absolute
     * directories.
     */
    ArrayList<String> absoluteDirs = new ArrayList<>();
    boolean recurse = false;
    int numbOfElemToSkip = 1;

    // Get current working directory
    String currDir = this.getCurrentDir();

    // If no args were passed
    if (directories.length == 0) {
      absoluteDirs = this.getChildren(currDir, currDir);
      // Use another helper function to print contents
      this.toString(absoluteDirs, "", recurse);
    } else { // Arguments were given, could be several
      
      // First check if -R is present...
      if (directories[1].equals("-R")) {
        recurse = true;
        numbOfElemToSkip = 2;
        
       // If nothing was passed with -R, use current directory
        if (directories.length == 2) {
          directories[1] = currDir;
          numbOfElemToSkip = 1;
          this.directorySize = 2;
        }
      }
      // Remove and store directories in an arraylist
      for (int i = numbOfElemToSkip; i < directories.length; i++) {
        if (directories[i].endsWith("/") && directories[i].length() != 1) {
          directories[i] = directories[i].substring(0,
              directories[i].length()-1);
        }
        absoluteDirs = this.getChildren(directories[i], currDir);
        // If ../ case occurs, go back to the parent in the directory given
        if (directories[i].startsWith("../")) {
          // Find index of last slash
          int idxOfLastSlash = currDir.lastIndexOf("/");
          // Go back to parent in the current directory and append user input
          directories[i] = currDir.substring(0, idxOfLastSlash) +
              directories[i].substring(2);
        }
        else if (directories[i].startsWith("..")) {
          // Find index of last slash
          int idxOfLastSlash = currDir.lastIndexOf("/");
          directories[i] = currDir.substring(0,idxOfLastSlash);
        }
        
        // Use the toString method to print the files ---------
        // If directory[i] is empty, set it equal to root.
        if (directories[i].equals("")) {
          directories[i] = "/";
          this.toString(absoluteDirs, directories[i], recurse);
        }
        else { // If it not empty, go back a directory and print its children.
          this.toString(absoluteDirs, directories[i], recurse);
        }
        // Clear children after each loop
        this.allChildren.clear();
      }
    }
  }

  /**
   * Prints out all the files or directories that are a child of the
   * directory passed.
   *
   * @param children All the children of the passed directory
   * @param directory The directory passed by the user
   */
  private void toString(ArrayList<String> children, String directory, boolean recurse) {
    ArrayList<String> subDir = new ArrayList<>();
    // If children are null, that means no directory was found
    if (children == null) {
      System.out.println("ls: Cannot find " +directory);
    }

    // If nothing exists and directory has length 0, do nothing.
    else if (children.size() == 0 && directory.length() == 0) {
    }

    // If directory exists, but no children, then show empty directory
    else if (children.size() == 0) {
      System.out.println(directory + ": ");
    }

    // If user didn't pass a directory, then list all children one at a time.
    else if (directory.length() == 0 || (recurse == true && this.directorySize == 2)) {
      // Sorting and removing duplicates
      Collections.sort(children);
      Set removeDuplicates = new HashSet();
      // Removing duplicates
      for (String child : children) {
        removeDuplicates.add(child);
      }
      // Iterate through every child if -R is not present
      if (recurse == false) {
        for (Object child : removeDuplicates) {
          if (!child.equals("")) {
            System.out.println(child);
          }
        }
      }
      // Use helper to print sub directories
      else {
        subDir.addAll(removeDuplicates);
        printSubDirectories(subDir, "new line");
      }
    }
    // Something else was entered by the user, possibly .. or ../
    else {
      // Sort the children in alphabetical order and remove duplicates
      int counter = 0;
      Collections.sort(children);
      Set removeDuplicates = new HashSet();
      // Removing duplicates
      for (String child : children) {
        removeDuplicates.add(child);
      }
      // Loop through each child and print as necessary
      if (recurse == false) {
      for (Object dir : removeDuplicates) {
        if (counter == 0) {
          System.out.print(directory + ": ");
        }
        System.out.print(dir + " ");
        counter += 1;
        }
      }
      // Otherwise use helper function to recurse subdirectories
      else {
        System.out.print(directory + ": ");
        subDir.addAll(removeDuplicates);
        printSubDirectories(subDir, "space");
      }
      // As long as children exist, keep printing
      if (children.size() != 0) {
        System.out.println();
      }
    }
  }

  /**
   * This will get all the children of the directory given by the user,
   * returns null if directory does not exist.
   *
   * @param directory The directory given by user
   * @param currDir The current directory
   * @return All the children of the passed directory
   */
  private ArrayList<String> getChildren(String directory, String currDir) {
    // Array to be returned
    ArrayList<String> children = new ArrayList<>();

    // Get all the directories made
    ArrayList<String> existingDirs = this.getTrackD().getTrackedDirectories();

    // Check if directory is not absolute
    if (!directory.startsWith("/")) {
      /*
       * Use the ValidateDirectory instance method to change relative
       * directory to absolute
       */
      directory = this.relativeToAbsolute.dirToAbsolute(directory, currDir);
    }

    // Just make sure if the directory passed is the root, then add it
    if (directory.equals("/") && existingDirs.size() == 0) {
      // Run TrackDirectoriesMade addDir method which will add / to array
      ArrayList<String>  addRoot = new ArrayList<>();
      this.getTrackD().addDir(addRoot);
    }

    // Check if the absolute directory exists inside
    if (existingDirs.contains(directory)) {
      /*
       * Once we know the directory exists, then we can list the files or
       * directories inside ....
       */

      // First lets count the number of slashes in the passed directory
      int slashesInDirectory =
          directory.replaceAll("[^/]","").length();
      // Loop through each directory
      for (String dir : existingDirs) {
        // Count the number of slashes in each dir
        int slashesInDir = dir.replaceAll("[^/]","").length();

        /*
         * Find the directories that start with the given directory AND
         * have exactly 1 more slash or same slash/depth.
         */
        if (dir.startsWith(directory) &&
            (slashesInDir == slashesInDirectory + 1 || directory.equals("/"))) {
          // If the dir has the same length as the given directory, ignore it
          if (dir.length() != directory.length()) {
            // Get the child directory of the given directory and remove 1st /
            String child = dir.substring(directory.length());
            //System.out.println("THE CHILDREN: "+child);
            /*
             * Now find the index of the first slash if it exists, this
             * will indicate if the absolute child directory of the given
             * directory has more children
             */
            String copy = child;
            // Count the number of slashes
            int lastIndexOfSlash = child.lastIndexOf("/");

            int firstIndexOfSlash = child.indexOf("/");
            // This indicates that there is no other directory inside the child
            if (firstIndexOfSlash == -1) {
              allChildren.add(child);
            }
            // If the number of slashes is greater is 1, dont add
            else if (firstIndexOfSlash == 0 && firstIndexOfSlash != -1) {
              if (!allChildren.contains(child.substring(lastIndexOfSlash + 1))) {
                allChildren.add(child.substring(lastIndexOfSlash + 1));
              }
            }
            else { // Remove the other children and print the child
              child = child.substring(0, firstIndexOfSlash);
              if (!children.contains(child)) {
                allChildren.add(child);
              }
            }
          }
        }
      }
      return allChildren;
    } else { // It does not exist inside
    }
    return null;
  }

  private void printSubDirectories(ArrayList<String> subDirectories,
      String howToPrint) {
    // Recurse if size > 0
    if (subDirectories.size() > 0) {
      // If string is "new line", then print each sub-directory on a newline
      if (howToPrint.equals("new line")) {
        System.out.println(subDirectories.get(0));
      }
      else if (howToPrint.equals("space")) {
        System.out.print(subDirectories.get(0) + " ");
      }
      subDirectories.remove(0);
      printSubDirectories(subDirectories, howToPrint);
    }
  }
  
  /**
   * Lists all the files in all the subdirectories. If no paths are given,
   * the contents of the current directory are printed.
   * @param shell The JShell object.
   * @param instanceOfClass An object of the class being executed.
   * @param cleanedInput The array of the input command in the shell.
   */
  @Override
  public void execute(JShell shell, Object instanceOfClass,
      String[] cleanedInput) {
    // IF no argument is given, just pass the current directory
    String[] noArgsPassed = {};
    if (cleanedInput.length == 1) {
      ((ListFiles) instanceOfClass).listFilesAndDirectories(noArgsPassed);
    }
    // If an argument/directory is given, then use it
    else if (cleanedInput.length > 1) {
      ((ListFiles) instanceOfClass).listFilesAndDirectories(cleanedInput);
    }
    // More than 1 argument have been passed... raised error
    else {
      System.out.println("Invalid command, please try again");
    }
    
  }
}
