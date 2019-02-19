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


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class ManCmd extends Commands implements CommandsInterface {

  public void printDocumentation(String command) {

    // Create Hashtable and populate it.
    Hashtable<String, String> ht = new Hashtable<>();
    this.populate(ht);

    // Run...
    try {
      
      // Use class name to initialize class object.
      Class<?> className = Class.forName("driver.ManCmd");
      Object initializeClass = className.newInstance();

      // Get the method to be called.
      String methodName = ht.get(command);

      // Create method object and call it using class object.
      Method methodObj = className.getDeclaredMethod(methodName);
      methodObj.invoke(initializeClass);
    }

    catch (Exception e) { // Catch the error. 
      System.out.println("Error: No such command exists.");
    }
  }

  /**
   * Populates the given Hashtable with keys and values.
   * 
   * @param ht Takes in a Hashtable and populates it
   */
  private void populate(Hashtable<String, String> ht) {
    // Assign a key and its values, where key is a command
    // and the value is a method name.
    ht.put("exit", "exitDoc");
    ht.put("mkdir", "mkdirDoc");
    ht.put("cd", "cdDoc");
    ht.put("ls", "lsDoc");
    ht.put("pwd", "pwdDoc");
    ht.put("pushd", "pushdDoc");
    ht.put("popd", "popdDoc");
    ht.put("history", "historyDoc");
    ht.put("cat", "catDoc");
    ht.put("echo", "echoDoc");
    ht.put("man", "manDoc");
  }

  /**
   * Prints documentation for exit command.
   */
  private void exitDoc() {
    System.out.println("NAME: exit" + " -- Quit the program");
  }

  /**
   * Prints documentation for the mkdir command.
   */
  private void mkdirDoc() {
    System.out.println("NAME: mkdir" + " -- Create directories; "
        + "paths may be relative or absolute");
  }

  /**
   * Prints documentation for the cd command.
   */
  private void cdDoc() {
    System.out.println("NAME: cd" + " -- Change directory as "
        + "indicated; paths may be relative or absolute");
    System.out.println(".. -- parent directory");
    System.out.println(". -- current directory");
  }

  /**
   * Prints documentation for the ls command.
   */
  private void lsDoc() {
    System.out.println("NAME: ls" + " -- If no paths are given, "
        + "print the contents of current directory where each content "
        + "is separated by a new line ");
    System.out.println("Otherwise, for each path p: ");
    System.out.println("p = file -- print p");
    System.out.println("p = directory -- print p, a colon, contents of "
        + "that directory, then a new line");
    System.out.println("p DNE -- print Cannot find directory");
  }

  /**
   * Prints the documentation for the pwd command.
   */
  private void pwdDoc() {
    System.out.println("NAME: pwd" + " -- Print current working"
        + "directory (including the whole path)");
  }

  /**
   * Prints the documentation for the pushd command.
   */
  private void pushdDoc() {
    System.out.println("NAME: pushd" + " -- Save current working"
        + "directory by pushing it onto a directory stack + change new "
        + "current working directory to given DIR. Must behave in LIFO. "
        + "The size of the directory stack is dynamic and dependent "
        + "on pushd and popd commands");
  }

  /**
   * Prints the documentation for the popd command.
   */
  private void popdDoc() {
    System.out.println("NAME: popd" + " -- Remove top entry from"
        + "directory stack and cd into it. Removal must behave in LIFO. "
        + "The current directory is now the removed directory. If there is "
        + "no directory in stack, print Invalid directory");
  }

  /**
   * Prints the documentation for the history command.
   */
  private void historyDoc() {
    System.out.println("NAME: history" + " -- Print all commands input "
        + "by user (1 command/line). The number on the left col is in "
        + "hierarchical order and the right col contains the input command."
        + " Invalid commands should also be available.");
    System.out.println("Example: ");
  }

  /**
   * Prints the documentation for the cat command.
   */
  private void catDoc() {
    System.out.println(
        "NAME: cat" + " -- Display" + "directory (including the whole path)");
  }

  /**
   * Prints the documentation for the echo command.
   */
  private void echoDoc() {
    System.out.println("");
  }

  /**
   * Prints the documentation for the man command.
   */
  private void manDoc() {
    System.out.println("");
  }

  /**
   * Prints the string documentation of each command onto the console.
   * @param shell The JShell object.
   * @param instanceOfClass An object of the class being executed.
   * @param cleanedInput The array of the input command in the shell.
   */
  @Override
  public void execute(JShell shell, Object instanceOfClass,
      String[] cleanedInput) {
    ((ManCmd) instanceOfClass).printDocumentation(cleanedInput[1]);    
  }
}
