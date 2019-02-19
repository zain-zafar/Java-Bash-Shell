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

import java.util.Scanner;

public class JShell {

 
  /**
   * File System shared by all Shell instances.
   */
  private SharedFileSystem fs; 
  
  /**
   * Log reference; Every shell will have a log. 
   */
  private Log log;

  /**
   * Default constructor.
   */
  public JShell() {
    // Create a new log for each JShell instance
    log = new Log();
    
    // Initialize the file system
    fs = SharedFileSystem.initialize();
  }

  /**
   * Gets the current Directory
   *
   * @return The current directory
   */
  public String getCurrentDirectory () {
    return fs.getCurrDir();
  }

  /**
   * Sets the current directory to the one provided.
   *
   * @param dir The directory which will be set as current directory.
   */
  public void setCurrentDirectory (String dir) {
    fs.setCurrDir(dir);
  }

  /**
   * Gets the command object.
   *
   * @return The Commands object
   */
  public Commands getCommand() {
    return fs.getCommand();
  }
  
  /**
   * The method input will read in a user input for a command
   */
  public void input() {
    String input = "";

    Scanner in = new Scanner(System.in);
    // Use do-while to ask for user input at least once.
    do {
      System.out.print(fs.getCurrDir() +"# "); // Print required symbol.
      input = in.nextLine();
      // store the input in the log
      this.log.storeInput(input);
      /*
       * Removing trailing spaces and 1 or more spaces that occur
       * between syntax and replacing with 1 space so that the string can be
       * split into an array.
       */
      input = input.trim();
      input = input.replaceAll("\\s+", " ");

      // Track the tasks
      String[] cleanedInput = input.split(" ");
      // Call the Driver class with the input
      fs.getDriver().instantiateCommand(cleanedInput[0], cleanedInput, this);
    }
    while (!input.equals("exit")); // Condition for do-while.
  }
  
  /**
   * This method will return the log of a specific JShell instance.
   * @return The log corresponding to a specific JShell instance.
   */
  public Log getLog() {
    return this.log;
  }
}