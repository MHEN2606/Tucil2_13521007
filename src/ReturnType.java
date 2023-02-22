public class ReturnType {
    point p1;
    point p2;
    double dist;

    ReturnType(point p1, point p2, double dist){
        this.p1 = p1;
        this.p2 = p2;
        this.dist = dist;
    }

    public point getP1() {
        return p1;
    }

    public point getP2() {
        return p2;
    }

    public double getDist() {
        return dist;
    }
}
