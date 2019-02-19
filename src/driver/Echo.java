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

public class Echo extends Commands implements CommandsInterface {

  private String fileName;
  /**
   * Default constructor.
   */
  public Echo() {
  }
  
  /**
   * This method will print a string toPrint to the shell
   * because an output file was not provided.
   * @param toPrint The string that is going to be printed on the shell.
   */
  public void printToFile(String toPrint) {
    // print toPrint on the shell
    OutputToConsole.print(toPrint);
  }
  
  /**
   * This method will collaborate with the class OutputToFile to
   * print toString onto a file with the name given as fileName. 
   * @param toPrint The string that is going to be printed on the file.
   * @param fileName The name of the file to print a given string on.
   */
  public void printToFile(String toPrint, String fileName) {
    // call the OutputToFile class
    OutputToFile.printToFile(toPrint, fileName);
  }
  
  public void createFile(String name) {
    File file = new File(name);
    this.getFileList().setFileList(file);
  }
  
  public String addFileToPath(String fileName) {
    // get current directory and add file to the path
    String currdirr = this.getCurrentDir();
    // if current directory is root, only concatenate fileName
    if(currdirr.endsWith("/")) {
      currdirr+=fileName;
    }
    // otherwise, concatenate / and fileName
    else {
      //if file is not already in path, add it in
      if(!currdirr.contains(fileName)) {
        currdirr+="/" + fileName;
      }
    }
    return currdirr;
  }

  @Override
  public void execute(JShell shell, Object instanceOfClass,
      String[] cleanedInput) {
    // Trigger the Echo constructor
    ArrayList<String> input = cleanInput(cleanedInput);
  
    if (input.size() == 3 || input.size() == 1) {
      if (input.size() == 1) {
        System.out.println(input.get(0));
      }
      else {
        // Call EchoAppend 
        ArrayList<String> array = new ArrayList<>();
        if (!this.getFileList().getKeys().contains(input.get(2))) {
          this.createFile(input.get(2));
          String gg = this.addFileToPath(input.get(2)) + "*";
          this.fileName = input.get(2) + "*";
          array.add(gg);
          this.getTrackD().addDir(array);
        }
        
        if (input.get(1).equals(">")) {
          EchoOverwrite echoA = new EchoOverwrite();
          System.out.println(this.fileName);
          echoA.printToFile(input.get(0), this.fileName);
        }
      }
    }
  }
  
  public ArrayList<String> cleanInput (String[] userInput) {
    ArrayList<String> cleaned = new ArrayList<>();
    for (int i = 1; i < userInput.length; i++) {
      cleaned.add(userInput[i]);
    }
    return cleaned;
  }
}
