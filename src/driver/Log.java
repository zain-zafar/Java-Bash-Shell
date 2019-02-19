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

public class Log {
  
  private ArrayList<String> log;

  /**
   * Constructor that creates a Log as an ArrayList to
   * store all the commands made in the shell.
   */
  public Log() {
    // create an ArrayList of Strings to store commands
    log = new ArrayList<>();
  }
  
  /**
   * The method storeInput will append a new command given
   * to the ArrayList.
   * @param input The command given in the shell.
   */
  public void storeInput(String input) {
    // add an element in the log
    this.log.add(input);
  }
  
  /**
   * The method getElement will return any command given in the shell
   * when given the index of the command in the ArrayList.
   * @param index The index at which a command is located in the ArrayList.
   * @return command The command at a given index.
   */
  public String getElement(int index) {
    // get an item at a specified index
    String command = this.log.get(index);
    return command;
  }
  
  /**
   * The method getSize will return the number of commands that
   * were given in the shell.
   * @return size The number of commands in the ArrayList.
   */
  public int getSize() {
    // get the size of the array
    int size = this.log.size();
    return size;
  }
  
  /**
   * This method removes a command that was made at a given index.
   * @param index The index at which a command is located in the ArrayList
   */
  public void removeElement(int index) {
    // remove the element at a given index
    this.log.remove(index);
  }

}
