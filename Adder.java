public class Adder {
   double memory;
   
   public Adder() {
      memory = 0.0;
   } // C1
   
   public double readout() {
      return memory;
   } 
   
   public void add(double parameter) {
      memory = memory + parameter;
   }
   
   public void subtract(double parameter) {
      memory = memory - parameter;
   }
   
   public void clear() {
      memory = 0.0;
   }
   
} // end class Adder

class FourFunction extends Adder {
   double memory2;
   
   public FourFunction() {
      super();
      memory2 = 0.0;
   }
   
   public void switchMemory() {
      double temp = memory;
      memory = memory2;
      memory2 = temp;
   }
   
   public void multiply(double parameter) {
      memory = memory * parameter;
   }
   
   public void divide(double parameter) {
      if (parameter != 0.0) {
         memory = memory / (parameter*1.0);
      }
   }
   
   public void multiply() {
      memory = memory * memory2;
   }
   
   public void divide() {
      if(memory2 != 0){
         memory = memory / memory2;
      }}
   
   public void add() {
      memory = memory + memory2;
   }
   
   public void subtract() {
      memory = memory - memory2;
   }
   
   public void clearAll() {
      super.clear(); // using super??
      memory2 = 0.0;
   }
   
} // end class FourFunction

class Scientific extends FourFunction {
   
   public void sin() {
      memory = Math.sin(memory);
   }
   
   public void cos() {
      memory = Math.cos(memory);
   }
   
   public void tan() {
      memory = Math.tan(memory);
   }
   
   public void square() {
      memory = Math.pow(memory, 2);
   }
   
   public void squareRoot() {
      memory = Math.sqrt(memory);
   }
   
   
} // end class Scientific

class Financial extends FourFunction {

   public void interest(double time) {
      double I = memory*Math.pow(1+memory2, time) - memory;
      
      System.out.println("Interest: " + I);
   }

} // end class Financial

class Test4 {
   public static void main (String[] args) {
      Adder object1 = new Adder();
         
      object1.add(129);
      object1.add(10056);
      object1.subtract(28);
    
      System.out.println("Object 1 printout: " + object1.readout() );
      
      FourFunction object2 = new FourFunction();
      object2.add(12*3);
      object2.switchMemory();
      object2.add(67/9); //9.0???
      object2.switchMemory();
      object2.subtract();
      System.out.println ("Object 2 printout: " + object2.readout() );
      
      Scientific object3 = new Scientific();
      object3.add(90);
      object3.sin();
      System.out.println ("Object 3 printout, part 1: " + object3.readout() );
      
      object3.clearAll();
      object3.add(3);
      object3.square();
      object3.switchMemory();
      object3.add(4);
      object3.square();
      object3.add();
      object3.squareRoot();
      System.out.println ("Object 3 printout, part 2: " + object3.readout() );
         
      Financial object4 = new Financial();
      object4.add(0.05);
      object4.switchMemory();
      object4.add(1000);
      object4.interest(20);
      
   }
}