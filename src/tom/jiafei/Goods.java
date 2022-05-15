package tom.jiafei;
public class Goods  {

   String a1;
   String a2;
   String oper;

   public String getA1() {
      return a1;
   }

   public void setA1(String a1) {
      this.a1 = a1;
   }

   public String getA2() {
      return a2;
   }

   public void setA2(String a2) {
      this.a2 = a2;
   }

   public String getOper() {
      return oper;
   }

   public void setOper(String oper) {
      this.oper = oper;
   }

   public double ch() {
      switch (oper) {
         case "+":
            return Double.parseDouble(a1) + Double.parseDouble(a2);
         case "-":
            return Double.parseDouble(a1) - Double.parseDouble(a2);
         case "*":
            return Double.parseDouble(a1) * Double.parseDouble(a2);
         case "/":
            return Double.parseDouble(a1) / Double.parseDouble(a2);
         default:
            break;
      }
      return 0.0;
   }
}

