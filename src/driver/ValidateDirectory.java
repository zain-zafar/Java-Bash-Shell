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

public class ValidateDirectory {

  /**
   * Changes relative path directories to absolute path directories.
   *
   * @param dirPassed The directory to be changed
   * @param currDir The current directory
   * @return The absolute directory
   */
  public String dirToAbsolute(String dirPassed, String currDir) {

    // Get the index of last slash in current directory
    int indexOfLastSlash = currDir.lastIndexOf("/");

    // First check if ../ is given...
    if (dirPassed.startsWith("../") &&
        dirPassed.substring(3).matches("[a-zA-Z0-9/]*")) {
      // Append the parent of dir to the given dir after ../
      // TURN INTO ABSOULTE DIR ----
      dirPassed =
          currDir.substring(0, indexOfLastSlash + 1) + dirPassed.substring(3);
    }
    // Check the .. case
    else if (dirPassed.startsWith("..")) {
      // If ONLY .. is entered
      // 1. Check if .. is given and current directory is not root.
      if (dirPassed.equals("..") && indexOfLastSlash == 0 &&
          !currDir.equals("/")) {
        dirPassed = currDir.substring(0, indexOfLastSlash + 1);
      }
      // Something after .. is entered, make sure it is valid
      else if (dirPassed.substring(2).matches("[a-zA-Z0-9/]*")) {
        dirPassed = currDir.substring(0, indexOfLastSlash);
      }
    }

    // Turn anything else into absolute as well
    else if (!dirPassed.startsWith("/") && !dirPassed.startsWith("../")
        && !dirPassed.startsWith("..")) {
      if (!currDir.endsWith("/")) {
        dirPassed = currDir + "/" + dirPassed;
      } else {
        dirPassed = currDir + dirPassed;
        //System.out.println(directory);
      }
    }
    return dirPassed;
  }
}
