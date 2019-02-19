package driver;

public interface CommandsInterface {
  
  // execute command to be implemented by all commands classes
  void execute(JShell shell, Object instanceOfClass, String[] cleanedInput);

}
