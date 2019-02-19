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

public class Number extends Commands implements CommandsInterface {
  
  /**
   * Default constructor.
   */
  public Number() {
    
  }
  
  /**
   * Given the index of a command, this method will retrieve
   * that command from the log of commands.
   * @param index The index at which a command was made and is to be returned.
   * @return The command that was made at  the given index.
   */
  public String getCommandFromHistory(Log log, int index) {
    // Use method created in Log class to get a specific element
    String command = log.getElement(index);
    return command;
  }

  /**
   * 
   * @param shell The JShell object.
   * @param instanceOfClass An object of the class being executed.
   * @param cleanedInput The array of the input command in the shell.
   */
  @Override
  public void execute(JShell shell, Object instanceOfClass,
      String[] cleanedInput) {
    try {
      // Retrieve the rest of the string
      String number = 
          cleanedInput[0].substring(1, cleanedInput[0].length());
      // Turn the string number into an integer
      int index = Integer.parseInt(number);
      // If the number is greater than 0 and less than the
      // number of commands made
      if (index > 0 && index < shell.getLog().getSize()) {
        index -= 1;
        String command = 
            ((Number) instanceOfClass).getCommandFromHistory(shell.getLog(),
                index);
        // Remove the last command made
        shell.getLog().removeElement(shell.getLog().getSize() - 1);
        // Store the command that was at the index the user wanted
        shell.getLog().storeInput(command);
        OutputToConsole.print(index + 1 + ". " + command);
      }
      // If the number is larger than the number of commands made
      else {
        System.out.println("Invalid index of history.");
      }
    }
    // If the String parsed is not an Integer
    catch (NumberFormatException e) {
      System.out.println("Invalid index of history.");
    }
    
  }

}
