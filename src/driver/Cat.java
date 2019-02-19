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

public class Cat extends Commands implements CommandsInterface {

  
  public Cat() {
    
  }
  

  /**
   * Shows the content of the given files.
   * 
   * @param cleanedInput The user input
   * @param fileList The set of all files

   * Calls method in File class to show contents in given file
   * This method displays the contents of the file provided
   * @param cleanedInput The array of input strings by user
   * @param fileList The list that contains all files created
   */
  public void showContents(String[] cleanedInput, FileList fileList) {

    
    // Remove the first element and add everything else to array
    ArrayList<String> filesPath = new ArrayList<>();
    
    // Iterate through each file path...

    //if one argument is provided
    ArrayList<String> test = new ArrayList<>();

    //create an array list that stores all the input strings except for the
    //command
    ArrayList<String> newCleanedInput = new ArrayList<>();

    for(int i=1; i<=cleanedInput.length-1; i++) {
      
      // Turn each file path to Absolute using helper function
      String absolutePath = this.toAbsolutePath(cleanedInput[i]);
      System.out.println(absolutePath);
      
      // Check if path exists, if it does, print file content
      if (this.getTrackD().getTrackedDirectories().contains(absolutePath)) {
        System.out.println(this.getFileList().getValue(absolutePath));

      test.add(cleanedInput[i]);
      }
      
      // now that we have the args, check size of args
      if(test.size()>=1) {
        for(String t: test) {
          //loop through args and check if they are in fileList
          // f.printFileContents(f.getFileName());
          if(fileList.checkKey(t)) {
            File f = fileList.getValue(t);
            System.out.println(f.getFileName());
            f.printFileContents(f.getFileName());
          }
          else {
            System.out.println("u dun goofed");
          }
          newCleanedInput.add(cleanedInput[i]);
        }  
        
        // now that we have the args, check size of args
        if(newCleanedInput.size()>=1) {
          for(String arg: newCleanedInput) {
            //loop through args and check if they are in fileList
            //f.printFileContents(f.getFileName());
            if(fileList.checkKey(arg)) {
              File f = fileList.getValue(arg);
              //System.out.println(f.getFileName());
              f.printFileContents(f.getFileName());
            }
            else {
              System.out.println("Invalid File.");
            }
          }
        }
        // File not found... Error
        else {
          System.err.println("File Not Found: " +cleanedInput[i]);
        }
      }
    }
  }

  
  /**
   * Converts given string/path to absolute if not already
   * 
   * @param path The directory/path given
   * @return The absolute directory
   */
  private String toAbsolutePath(String path) {
    // Check if absolute path
    if (path.startsWith("/")) {
      return path;
    }
    // Otherwise it is relative path, so get current dir
    String currDir = this.getCurrentDir();
    // Append the path to the current directory with a slash; return
    return "/" + path; 
  }
  
  /**
   * Prints all the contents of the files passed in onto the console.
   * @param shell The JShell object.
   * @param instanceOfClass An object of the class being executed.
   * @param cleanedInput The array of the input command in the shell.
   */
  @Override
  public void execute(JShell shell, Object instanceOfClass,
      String[] cleanedInput) {
    // Call the showContents method to prints the contents of the file
    ((Cat) instanceOfClass).showContents(cleanedInput,
        shell.getCommand().getFileList());
    
  }
  
}
