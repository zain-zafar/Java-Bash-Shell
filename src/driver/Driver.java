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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Driver {

  /**
   * Collaborate with JShell
   */
  private static JShell shell = new JShell();

  /**
   * Default constructor.
   */
  public Driver() {

  }

  /**
   * Main method.
   */
  public static void main(String[] args) {
    // Run the JShell
    //shell.input();
  }

  /**
   * The runCommands method will take in a command given in the JShell as an
   * Array of Strings and will call the appropriate class to run the
   * corresponding command.
   *
   * @param cleanedInput Given command in JShell as an Array of Strings.
   */
  public static void runCommands(String[] cleanedInput) {

    // Create a array of CASE SENSITIVE commands
    List<String> commands = Arrays.asList("exit", "mkdir", "cd", "ls", "pwd",
        "pushd", "popd", "history", "cat", "echo", "man", "find", "tree");

    // Check the null case
    if (cleanedInput[0].equals("")) {
      // Do nothing and allow for re-run of loop.
    } else { // If user enters something
      // Check if a valid command is entered
      if (commands.contains(cleanedInput[0]) ||
          cleanedInput[0].substring(0, 1).equals("!")) {
        /*
         * Checking for all possible outcomes, as user has entered valid
         * command for the shell
         */
        // ---- Check for all commands that require no arguments ----
        // 1. Check for the exit command
        if (cleanedInput[0].equals("exit") && cleanedInput.length == 1) {
          // Do nothing; program exits
        }
        // 2. Check for pwd, ls, popd, or tree command
        // pwd command
        else if (cleanedInput[0].equals("pwd") && cleanedInput.length == 1) {
          PrintWorkingDirectory pwd = new PrintWorkingDirectory();
          pwd.printCurrDirr();
        }

        // ls command
        else if (cleanedInput[0].equals("ls")) {
          ListFiles ls = new ListFiles();
          // IF no argument is given, just pass the current directory
          String[] noArgsPassed = {};
          if (cleanedInput.length == 1) {
            ls.listFilesAndDirectories(noArgsPassed);
          }
          // If an argument/directory is given, then use it
          else if (cleanedInput.length > 1) {
            ls.listFilesAndDirectories(cleanedInput);
          }
          // Raise error
          else {
            System.out.println("Invalid command, please try again");
          }
        }

        // popd command (Incomplete)
        else if (cleanedInput[0].equals("popd") && cleanedInput.length == 1) {

        }

        // tree command
        else if (cleanedInput[0].equals("tree") && cleanedInput.length == 1) {
          // Create a tree object
          Tree tree = new Tree();
          System.out.println("/");
          tree.makeTree();
        }
      
        // Number Command
        // Check if the first character is ! and the command has one argument
        else if (cleanedInput[0].substring(0,1).equals("!") &&
            cleanedInput.length == 1 && cleanedInput[0].length() > 1) {
          // Create a number object
          Number num = new Number();
          try {
            // Retrieve the rest of the string
            String number = 
                cleanedInput[0].substring(1, cleanedInput[0].length());
            // Turn the string number into an integer
            int index = Integer.parseInt(number);
            // If the number is greater than 0 and less than the
            // number of commands made
            if (index > 0 && index < shell.getLog().getSize() - 1) {
              index -= 1;
              String command = 
                  num.getCommandFromHistory(shell.getLog(), index);
              // Remove the last command made
              shell.getLog().removeElement(shell.getLog().getSize() - 1);
              // Store the command that was at the index the user wanted
              shell.getLog().storeInput(command);
              OutputToConsole.print(index + 1 + ". " + command);
            }
          }
          // If the String parsed is not an Integer
          catch (NumberFormatException e) {
            System.out.println("Invalid index of history.");
          }
          
        }

        // ---- Check for all commands that require more than 1 argument ----
        // Check for cd command
        else if ((cleanedInput[0].equals("cd"))
            && cleanedInput.length == 2) {
          ChangeDirectory cd = new ChangeDirectory();
          cd.checkAndChangeDir(cleanedInput[1]);
          shell.setCurrentDirectory(shell.getCommand().getCurrentDir());
        }

        // mkdir command
        else if (cleanedInput[0].equals("mkdir")) {
          MakeDirectory mkdir = new MakeDirectory();
          // make a new directory or new directories the user requested
          mkdir.makeDirectory(cleanedInput);
        }

        //pushd command (Incomplete)
        else if (cleanedInput[0].equals("pushd") && cleanedInput.length == 2) {
        }

        // man command
        else if (cleanedInput[0].equals("man") && cleanedInput.length == 2) {
          ManCmd manCommand = new ManCmd();
          // print the documentation the user requested
          manCommand.printDocumentation(cleanedInput[1]);
        }
        
        // ---- Check for all commands that require 2 arguments ----
        // Check for history command
        else if (cleanedInput[0].equals("history")) {
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
        // ---- Check for echo command with 3 arguments ----
        else if (cleanedInput.length == 3 && cleanedInput[0].equals("echo")) {
          // If the user wants to overwrite a file
          if (cleanedInput[2].equals(">")) {
            // Create an EchoOverwrite object
            EchoOverwrite overwrite = new EchoOverwrite();
            // Call the method to print to file
            overwrite.printToFile(cleanedInput[1]);
          }
          // If the user wants to append to a file
          else if (cleanedInput[2].equals(">>")) {
            // Create an EchoAppend object
            EchoAppend append = new EchoAppend();
            // Call the method to print to file
            append.printToFile(cleanedInput[1]);
          }
        }
        // ---- Check for echo command with 4 arguments ----
        // echo works but items created are not removed LOL
        else if (cleanedInput.length == 4 && cleanedInput[0].equals("echo")) {
          // If the user wants to overwrite a file
          if (cleanedInput[2].equals(">")) {
            EchoOverwrite overwrite = new EchoOverwrite();
            overwrite.printToFile(cleanedInput[1], cleanedInput[3]);
            //if file is not already in existing file list, create file,
            //add it in filelist, and add to path
            if(!shell.getCommand().getFileList().checkKey(cleanedInput[3])) {
              overwrite.createFile(cleanedInput[3]);
            }
            overwrite.addFileToPath(cleanedInput[3]);
          }
          // If the user wants to append to a file
          else if (cleanedInput[2].equals(">>")) {
            EchoAppend append = new EchoAppend();
            append.printToFile(cleanedInput[1], cleanedInput[3]);
            if(!shell.getCommand().getFileList().checkKey(cleanedInput[3])) {
              append.createFile(cleanedInput[3]);
            }
            append.addFileToPath(cleanedInput[3]);
          }
        }
        else if (cleanedInput[0].equals("cat") && (cleanedInput.length>1)) {
          Cat cat = new Cat();
          cat.showContents(cleanedInput, shell.getCommand().getFileList());
        }
        // ---- Check for find command ----
        // If the correct arguments were passed
        else if (cleanedInput[0].equals("find")
            && cleanedInput.length >= 6
            && cleanedInput[cleanedInput.length - 4].equals("-type")
            && cleanedInput[cleanedInput.length - 2].equals("-name")
            && (cleanedInput[cleanedInput.length - 3].equals("f")
            || cleanedInput[cleanedInput.length - 3].equals("d"))) {
          // Create a file object
          // Find find = new Find();
          // Create an ArrayList of paths for all paths given
          ArrayList<String> paths = new ArrayList<>();
          // Loop through all paths given
          for (int i = 1; i < cleanedInput.length - 4; i++) {
            paths.add(cleanedInput[i]);
            System.out.println(cleanedInput[i]);
          }
          //find.findFile(paths, cleanedInput[3], cleanedInput[5]);

        }
        // User has not entered valid arguments
        else {
          System.out.println("Invalid command, please try again");
        }
      } else { // User has not entered valid command
        System.out.println("Invalid command, please try again");
      }
    }
  }

}