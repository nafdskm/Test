package tom.jiafei;

public class Good {
    /*public static void main(String[] args) {
        Good g = new Good();
        g.a = 2.0;
        g.b = 3.0;
        g.oper = "+";
        System.out.println(g.Zhi());
    }*/
    double a;
    double b;
    String oper;
//    double zhi;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double Zhi() {
        /*if (oper.equals("+")) {
            double zhi = a + b;
        } else if (oper.equals("-")) {
            double zhi = a - b;
        } else if (oper.equals("*")) {
            double zhi = a * b;
        } else if (oper.equals("/")) {
            double zhi = a / b;
        }


        return zhi;*/
        switch (oper) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                break;
        }
        return 0.0;
    }
}

