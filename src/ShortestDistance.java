import java.lang.Math;
public class ShortestDistance{
    int countOfEuc = 0;

    public double euclideanDistance(point p1, point p2){
        countOfEuc++;
        double buffer = 0;
        for(int i = 0; i < p1.derajat; i++){
            buffer += (p1.buffer[i]-p2.buffer[i]) * (p1.buffer[i]-p2.buffer[i]);
        }
        return Math.sqrt(buffer);
    }

    public ReturnType findShortestDistance(ArrayPoint ap){
        // ap sudah terurut terhadap x
        ReturnType ret;
        if(ap.n == 2){
            ret = new ReturnType(ap.array[0], ap.array[1], euclideanDistance(ap.array[0], ap.array[1]));
            return ret;
        }else{
            // DIVIDE
            point[] p1_arr = new point[ap.n/2];
            point[] p2_arr = new point[ap.n/2];

            for(int i = 0; i < ap.n/2; i++){
                p1_arr[i] = ap.array[i];
            }

            for(int i = 0; i < ap.n/2; i++){
                p2_arr[i] = ap.array[i + ap.n/2];
            }

            ArrayPoint p1 = new ArrayPoint(ap.n/2, p1_arr);
            ArrayPoint p2 = new ArrayPoint(ap.n/2, p2_arr);
            
            // Combine
            ReturnType d1 = findShortestDistance(p1);
            ReturnType d2 = findShortestDistance(p2);

            // Conquer
            if(d1.dist < d2.dist){
                ret = new ReturnType(d1.getP1(), d1.getP2(), d1.dist);
            }else{
                ret = new ReturnType(d2.getP1(), d2.getP2(), d2.dist);
            }

            // Make Slab
            int nslab = 0;
            for(int i = 0; i < p1.n; i++){
                if(p1.array[i].getX() >= ap.array[ap.n/2].getX()-ret.dist){
                    nslab++;
                }
            }

            for(int i = 0; i < p2.n; i++){
                if(p2.array[i].getX() <= ap.array[ap.n/2].getX()+ret.dist){
                    nslab++;
                }
            }

            ArrayPoint slab = new ArrayPoint(nslab);
            slab.array = new point[nslab];
            // fill the slab
            int nfill = 0;

            for(int i = 0; i < p1.n; i++){
                if(p1.array[i].getX() >= ap.array[ap.n/2].getX()-ret.dist){
                    slab.array[nfill] = p1.array[i];
                    nfill++;
                }
            }

            for(int i = 0; i < p2.n; i++){
                if(p2.array[i].getX() <= ap.array[ap.n/2].getX()+ret.dist){
                    slab.array[nfill] = p2.array[i];
                    nfill++;
                }
            }

            // Urutkan y
            slab.sortArray(slab.array, 1);
            
            // Hitung Jarak
            for (int i = 0; i < slab.n; i++){
                for(int j = i+1; j < slab.n; j++){
                    if(Math.abs(slab.array[i].getX() - slab.array[j].getX()) < ret.dist || Math.abs(slab.array[i].getY() - slab.array[j].getY()) < ret.dist){
                        ReturnType newret = new ReturnType(slab.array[i], slab.array[j], euclideanDistance(slab.array[i], slab.array[j]));
                        if(ret.dist > newret.dist){
                            ret = newret;
                        }
                    }
                }
            }

            return ret;
        }
    }

    public ReturnType findShortestDistanceBrute(ArrayPoint ap){
        // Mencari Shortest Distance Menggunakan Algoritma Bruteforce
        double d = euclideanDistance(ap.array[0], ap.array[1]);
        point p1 = ap.array[0];
        point p2 = ap.array[1];
        for(int i = 0; i < ap.n; i++){
            for(int j = 0; j < ap.n; j++){
                if(i != j){
                    double temp = euclideanDistance(ap.array[i], ap.array[j]);
                    if(temp < d){
                        d = temp;
                        p1 = ap.array[i];
                        p2 = ap.array[j];
                    }
                }
            }
        }

        ReturnType ret = new ReturnType(p1,p2,d);

        return ret;
    }
}
