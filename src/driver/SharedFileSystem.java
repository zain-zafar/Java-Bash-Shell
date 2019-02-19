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

public class SharedFileSystem {

  /**
   * The file system object which all JShell objects will have
   */
  private static SharedFileSystem fs = null;
  
  /**
   * The Commands class object
   */
  private static Commands command = new Commands();
  
  /**
   * String variable which stores the current directory.
   */
  private static String currentDirectory = command.getCurrentDir();
  
  /**
   * The HashDriver object.
   */
  private HashDriver hashDriver;
  
  /**
   * Creates a Shared File System (All shells will refer to 1 file system)
   */
  public SharedFileSystem() {
    // Initialize HashDriver 
    hashDriver = new HashDriver();
    System.out.println("Created the file system -----------------");
  }
  
  /**
   * Static method to be called before the SharedFileSystem constructor.
   * This way all shells can be referred to 1 file system.
   *  ------ I looked at Abbas's lecture slide and used his idea -------
   *  ------ Credit to Abbas -------
   * @return SharedFileSystem object
   */
  public static SharedFileSystem initialize() {
    // Check to see if a file system has not been created
    if (fs == null) {
      fs = new SharedFileSystem();
    }
    // If a file system already exists, DON'T create another
    return fs;
  }
  
  /**
   * Gets the current directory.
   * 
   * @return The current directory
   */
  public String getCurrDir() {
    return currentDirectory;
  }
  
  /**
   * Gets the Command object which the shell can refer too.
   * 
   * @return The Command object.
   */
  public Commands getCommand() {
    return command; 
  }
  
  /**
   * Sets the current directory to the passed one.
   * 
   * @param dir The directory to become the current directory. 
   */
  public void setCurrDir(String dir) {
    currentDirectory = dir;
  }
  
  /**
   * Returns the Driver for shell reference.
   * 
   * @return The HashDriver object.
   */
  public HashDriver getDriver() {
    return hashDriver;
  }
}
