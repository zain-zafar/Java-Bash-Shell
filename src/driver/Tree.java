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

public class Tree extends Commands implements CommandsInterface {

  /**
   * var organizeDirectories: organizes directories based on
   * depth/numberOfSlashes in each string directory.
   *
   * var toBePrinted: Stores the directory needed to be printed.
   */
  private ArrayList<ArrayList> orgranizeDirectories;
  private String toBePrinted = "";

  /**
   * Initial constructor
   */
  public Tree () {
    this.orgranizeDirectories = new ArrayList<>();
  }

  /**
   * This method finds all the children of root and
   * utilizes helper functions to print out a tree.
   */
  public void makeTree() {
    //
    ArrayList<String> childDirectories = new ArrayList<>();

    // Get children of root and loop through them
    for (String child : getChildrenOfRoot()) {
      // Loop through all the existing directories
      for (String dir : this.getTrackD().getTrackedDirectories()) {
        // Get all directories beginning with child
        if (dir.startsWith("/" + child)) {
          // Add the child with the root.
          childDirectories.add(dir);
        }
      }
      // Sort the directories
      Collections.sort(childDirectories);
      // Use helper to organize directories and print them
      arrangeDirectories(childDirectories);
      // Clear the array after it has been printed.
      childDirectories.clear();
    }
  }

  /**
   * Method iterates through common directories and splits each
   * directory by /. It then populates the directories into an array
   * based on index and sends the directory to be printed iff it does
   * not exist already inside the array at a certain index.
   *
   * @param directories List of directories to be printed if not already done.
   */
  private void arrangeDirectories(ArrayList<String> directories) {
    // Loop through each directory in directories array
    for (String dir : directories) {

      // find number of slashes/depth and directory split at each /
      int numbOfSlashes = dir.replaceAll("/","").length();
      String[] dirsToBePrinted = dir.split("/");

      /*
       * Start at depth 0 and increase depth while making sure to
       * insert each directory into the array at the corresponding depth
       */
      for (int i = 0; i < dirsToBePrinted.length; i++) {
        ArrayList<String> initializeDepth = new ArrayList<>();
        // Ignore empty strings
        if (!dirsToBePrinted[i].equals("")) {
          /*
           * If organizeDirectories array does not contain an array
           * at the specific depth, then add an empty array until
           * it exists at the specified depth
           */
          while (orgranizeDirectories.size() < i + 1) {
            orgranizeDirectories.add(initializeDepth);
          }
          // Check if directory exists at the given depth inside array

          if (!orgranizeDirectories.get(i).contains(dirsToBePrinted[i])) {
            toBePrinted = dirsToBePrinted[i];
            orgranizeDirectories.get(i).add(dirsToBePrinted[i]);
            // If it does, print it using helper function.
            toString(i, dirsToBePrinted[i]);
          }
        }
      }
    }
  }

  /**
   * Prints out each directory at a specific depth/spaces to resemble
   * a tree.
   *
   * @param depth Indicates how many spaces to travel.
   * @param child What is to be printed.
   */
  private void toString (int depth, String child) {

    String spaces = "";
    // Add spaces
    for (int i = 0; i < depth; i++) {
      spaces += "    ";
    }
    if (toBePrinted.equals("")) {
      toBePrinted = "/";
    }
    System.out.println(spaces + child);
  }

  /**
   * Gets the children of root. For example, /a, then "a" is a child of root.
   *
   * @return List of children of root.
   */
  private ArrayList<String> getChildrenOfRoot () {
    // Create return variable which stores all children of root
    ArrayList<String> children = new ArrayList<>();

    // Iterate through all directories made
    for (String dir : this.getTrackD().getTrackedDirectories()) {

      // If directory starts with root directory and isn't root, continue..
      if (dir.startsWith("/")  && dir.length() > 1) {

        // Remove the first /
        dir = dir.replaceFirst("/","");
        // Check to see if there are more slashes/inner directories
        if (dir.contains("/")) {
          int idxOfFirstSlash = dir.indexOf("/");
          // Add the child of root if it doesn't exist inside array
          if (!children.contains(dir.substring(0, idxOfFirstSlash))) {
            children.add(dir.substring(0, idxOfFirstSlash));
          }
        }
        else { // There are no inner directories
          if (!children.contains(dir)) {
            // Add the child iff it doesn't exist in the array
            children.add(dir);
          }
        }
      }
    }
    return children;
  }

  /**
   * Prints the string representation of a tree of the file system.
   * @param shell The JShell object.
   * @param instanceOfClass An object of the class being executed.
   * @param cleanedInput The array of the input command in the shell.
   */
  @Override
  public void execute(JShell shell, Object instanceOfClass,
      String[] cleanedInput) {
    System.out.println("/");
    ((Tree) instanceOfClass).makeTree();
    
  }
}
