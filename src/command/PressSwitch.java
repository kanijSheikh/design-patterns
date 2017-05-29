package command;
import java.util.List;
import java.util.ArrayList;

/*the Command interface*/
interface Command1 {
   void execute();
}
 
 
/*the Invoker class*/
 
class Switch {
 
   private List<Command1> history = new ArrayList<Command1>();
 
   public Switch() {
   }
 
   public void storeAndExecute(Command1 cmd) {
      this.history.add(cmd); // optional 
      cmd.execute();        
   }
 
}
 
 
/*the Receiver class*/
class Light {
 
   public Light() {
   }
 
   public void turnOn() {
      System.out.println("The light is on");
   }
 
   public void turnOff() {
      System.out.println("The light is off");
   }
 
}
 
 
/*the Command1 for turning on the light - ConcreteCommand #1*/
class FlipUpCommand implements Command1 {
 
   private Light theLight;
 
   public FlipUpCommand(Light light) {
      this.theLight = light;
   }
 
   public void execute(){
      theLight.turnOn();
   }
 
}
 
 
/*the Command1 for turning off the light - ConcreteCommand #2*/
class FlipDownCommand implements Command1 {
 
   private Light theLight;
 
   public FlipDownCommand(Light light) {
      this.theLight = light;
   }
 
   public void execute() {
      theLight.turnOff();
   }
 
}
 
 
/*The test class or client*/
public class PressSwitch {
 
   public static void main(String[] args){
      Light lamp = new Light();
      Command1 switchUp = new FlipUpCommand(lamp);
      Command1 switchDown = new FlipDownCommand(lamp);
 
      Switch s = new Switch();
 
      try {
         if (args[0].equalsIgnoreCase("ON")) {
            s.storeAndExecute(switchUp);
            System.exit(0);
         }
         if (args[0].equalsIgnoreCase("OFF")) {
            s.storeAndExecute(switchDown);
            System.exit(0);
         }
         System.out.println("Argument \"ON\" or \"OFF\" is required.");
      } catch (Exception e) {
         System.out.println("Argument's required.");
      }
   }
 
}