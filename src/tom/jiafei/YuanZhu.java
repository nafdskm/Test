package tom.jiafei;

public class YuanZhu {
    private double r;
    private double h;
    private double S;

    public double mj() {
        S = Math.PI * r * r * h;
        return S;
    }

    public YuanZhu() {
    }

    public YuanZhu(double r, double h) {
        this.r = r;
        this.h = h;
    }



    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
}
