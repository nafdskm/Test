package Final;

public class MyBean {
    private double high = 0.0;
    private double sd = 0.0;
    private double xd = 0.0;
    private double S = 0.0;

    public double qiuS() {
        S = (sd + xd) * high / 2;
        return S;
    }

    public MyBean() {
    }

    public MyBean(double high, double sd, double xd) {
        this.high = high;
        this.sd = sd;
        this.xd = xd;
    }

    public double getS() {
        return S;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getSd() {
        return sd;
    }

    public void setSd(double sd) {
        this.sd = sd;
    }

    public double getXd() {
        return xd;
    }

    public void setXd(double xd) {
        this.xd = xd;
    }
}
