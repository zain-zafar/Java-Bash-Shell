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

public class History extends Commands implements CommandsInterface {
  
  /**
   * Default Constructor.
   */
  public History() {
    
  }
  
  /**
   * The method getCommand will return the most recent command
   * made in the shell that is stored in the Log.
   * @param log The log where all commands are stored.
   * @return command The most recent command made.
   */
  public static String getCommand(Log log) {
    // get the most recent element from the log
    String command = log.getElement(log.getSize() - 1);
    return command;
  }
  
  /**
   * This method will print a list of all commands where the highest
   * number corresponds to the most recent command.
   * @param log The log where all commands are stored.
   */
  public static void printRecentCommands(Log log) {
    // initialize an index
    int index = 0;
    // access most recent commands in log
    for (int count = 0; count < log.getSize(); count++) {
      // print the most recent command
      OutputToConsole.print(index + 1 + ". " + log.getElement(index));
      // increase the index
      index += 1;
    }
  }
  
  /**
   * This method will print a list of a specific number of commands
   * given the number of commands wanted to be printed. The highest
   * number corresponds to the most recent command.
   * @param log The log where all commands are stored.
   * @param numberOfCommands The number of commands wanted to be printed.
   */
  public static void printRecentCommands(Log log, int numberOfCommands) {
    
    // if  the requested number of commands to print is greater than
    // the number of commands actually made
    if (numberOfCommands > log.getSize()) {
      // change the number of commands requested to the number of commands made
      numberOfCommands = log.getSize();
      // initialize an index
    }
    int index = log.getSize() - numberOfCommands;
    // access most recent commands in log
    for (int count = 0; count < numberOfCommands; count++) {
      // print the most recent command
      OutputToConsole.print(index + 1 + ". " + log.getElement(index));
      // increase the index
      index += 1;
    
    }
  }

  /**
   * Executes the command History. If no additional parameters were
   * passed in the shell, the entire history is printed. If history is
   * followed by a number, then it prints that specific number of
   * commands made in the shell.
   * @param shell The JShell object.
   * @param instanceOfClass An object of the class being executed.
   * @param cleanedInput The array of the input command in the shell.
   */
  @Override
  public void execute(JShell shell, Object instanceOfClass, String[] cleanedInput) {
    
    // The optional parameter was not passed
    if (cleanedInput.length == 1) {
      History.printRecentCommands(shell.getLog());
    }
    // The optional parameter was passed
    else if (cleanedInput.length == 2) {
      History.printRecentCommands(shell.getLog(),
          Integer.parseInt(cleanedInput[1]));
    }
    
  }


}
