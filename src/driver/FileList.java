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

import java.util.HashMap;
import java.util.Set;

public class FileList {

  /**
   * HashMap which store all the File objects and the string name
   * of the File.
   */
  private static HashMap<String, File> fileList;
  
  /**
   * Constructor for FileList
   */
  public FileList() {
    fileList = new HashMap<>();
  }
  
  /**
   * Gets the list of files.
   *
   * @return The list of files.
   */
  public HashMap<String, File> getFileList(){
    return fileList;
  }

  /**
   * Adds a like to the list of files
   *
   * @param file The file to be added to the array.array
   */
  public void setFileList(File file) {
    this.fileList.put(file.getFileName(), file);
  }
  
  /**
   * Gets the size of the FileList
   * 
   * @return Size of the FileList
   */
  public int getSize() {
    int size = this.fileList.size();
    return size;
  }
  
  /**
   * Gets the File object with the given File name.
   * 
   * @param t The file name
   * @return The File object containing that name.
   */
  public File getValue(String t) {
    File value = this.fileList.get(t);
    return value;
  }
  
  /**
   * Get the names of the Files
   * 
   * @return Set of all names of the Files.
   */
  public Set<String> getKeys() {
    return this.fileList.keySet();
  }
  
  /**
   * Check if the File name exists inside the HashSet.
   * 
   * @param key The File object's name variable 
   * @return Boolean; True iff the name exists = File already created. 
   */
  public boolean checkKey(String key) {
    boolean check = false;
    if(this.fileList.containsKey(key)) {
      check = true;
    }
    return check;
  }

}
