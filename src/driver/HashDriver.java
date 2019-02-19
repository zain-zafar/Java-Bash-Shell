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

import java.util.Hashtable;

public class HashDriver {

  /**
   * Static Hashtable variable which will store command classes
   */
  private static Hashtable<String, String> 
  commandsHashTable = new Hashtable<String, String>();

  /**
   * Main method.
   */
  public static void main(String[] args) {
    // Add the commands
    addCommand(commandsHashTable);
    
    // Create and run shell(s)
    JShell shell1 = new JShell();
   // JShell shell2 = new JShell();
    shell1.input();
   // System.out.println("Shell 1 ended -----");
   // shell2.input();
   // System.out.println("Shell 2 ended -----");
  }

/**
 * Runs the execute command for the given command class iff the 
 * command is valid and is not exit.
 * 
 * @param command The command name
 * @param fullCommand The user input as an array.
 */
  public void instantiateCommand(String command, String[] fullCommand,
      JShell shell) {

    // If the command is valid
    if (commandsHashTable.containsKey(command) || 
        (!command.equals("")
            && commandsHashTable.containsKey(command.substring(0,1)) 
            && command.substring(0,1).equals("!"))) {
      try {
        // Get the appropriate class.
        String commandClass = commandsHashTable.get(command);
        // If the command is the !number command
        if (commandsHashTable.containsKey(command.substring(0,1)) &&
            command.substring(0,1).equals("!")) {
          commandClass = commandsHashTable.get(command.substring(0,1));
        }

        // Use the Class.forName method to get the class
        Class<?> className = Class.forName("driver." + commandClass);

        /*
         * All commands classes, such as MakeDirectory IS-A CommandsInterface, 
         * so we can directly call the method "execute" using the interface 
         * and class object.
         */
        CommandsInterface instanceOfClass =
            (CommandsInterface) className.newInstance();

        // Don't do anything if exit command is entered
        if (command.equals("exit")) {
        }
        // All other commands ...
        else {
          instanceOfClass.execute(shell, instanceOfClass, fullCommand);
        }
      } catch (Exception e) {
        System.out.println("Invalid command, please try again.");
        // Run the JShell
        shell.input();
      }
    }
    // If no command was entered
    else if (command.equals("")) {
      shell.input();
    }
    // An invalid command was made
    else {
      System.out.println("Invalid command, please try again.");
    }

  }

  private static void addCommand(Hashtable commandsHashTable) {
    commandsHashTable.put("exit", "Exit");
    commandsHashTable.put("mkdir", "MakeDirectory");
    commandsHashTable.put("cd", "ChangeDirectory");
    commandsHashTable.put("ls", "ListFiles");
    commandsHashTable.put("pwd", "PrintWorkingDirectory");
    commandsHashTable.put("pushd", "PushDirectory");
    commandsHashTable.put("popd", "PopDirectory");
    commandsHashTable.put("history", "History");
    commandsHashTable.put("cat", "Cat");
    commandsHashTable.put("echo", "Echo");
    commandsHashTable.put("man", "ManCmd");
    commandsHashTable.put("find", "Find");
    commandsHashTable.put("tree", "Tree");
    commandsHashTable.put("!", "Number");
    commandsHashTable.put("mv", "MoveFile");
    commandsHashTable.put("cp", "CopyFile");
    commandsHashTable.put("curl", "Curl");
    commandsHashTable.put("grep", "Grep");

  }

  // might not need this method
  public Hashtable<String, String> getHashTable() {
    return HashDriver.commandsHashTable;
  }

}
