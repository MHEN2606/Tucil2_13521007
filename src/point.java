import java.util.Random;
class point{
    public int derajat;
    public double[] buffer;
    point(int derajat){
        Random rand = new Random();
        /* Derajat dari tiap titik */
        this.derajat = derajat;

        /* Komponen x,y,z,... dari tiap titik */
        this.buffer = new double[derajat];
        for(int i = 0; i < derajat; i++){
            buffer[i] = rand.nextDouble(100.0);
        }
    }

    /* Getter untuk x,y,dan z */
    public double getX(){
        return buffer[0];
    }
    public double getY(){
        return buffer[1];
    }
    public double getZ(){
        return buffer[2];
    }

    public String printPoint(){
        String ret = "";
        ret+=("(");
        for(int i = 0; i < derajat; i++){
            if(i != derajat-1)
                ret+=(buffer[i]+",");
            else
                ret+=(buffer[i]);
        }
        ret+=(")");
        return ret;
    }
}