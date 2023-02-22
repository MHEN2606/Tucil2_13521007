import java.util.Scanner;
public class Main {
    public static boolean isPangkatDua(int n){
        while(n%2==0){
            n=n/2;
        }
        if(n==1){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        ShortestDistance sd = new ShortestDistance();
        Scanner in = new Scanner(System.in);
        // Make array of points
        System.out.println("Masukkan jumlah titik: ");
        int n = in.nextInt();
        while(!isPangkatDua(n)){
            System.out.println("Jumlah titik minimal adalah 2 dan harus pangkat 2. Silakan ulangi masukan!");
            System.out.println("Masukkan jumlah titik: ");
            n = in.nextInt();
        }

        System.out.println("Masukkan derajat titik: ");
        int d = in.nextInt();
        while(d < 2){
            System.out.println("Jumlah derajat terkecil adalah 2. Silakan ulangi masukan derajat!");
            System.out.println("Masukkan derajat tiap titik: ");
            d = in.nextInt();
        }

        // Make n points with degree of d
        ArrayPoint ap = new ArrayPoint(n, d);

        // sort point berdasarkan x
        ap.sortArray(ap.array, 0);

        long startDNC = System.currentTimeMillis();
        ReturnType out = sd.findShortestDistance(ap);
        long endDNC = System.currentTimeMillis();

        System.out.println("Shortest Distance is " + out.getDist() + " with points " + out.getP1().printPoint() + " and " + out.getP2().printPoint());
        System.out.println("Count of Euclidean Distance Operation is " + sd.countOfEuc);

        long startB = System.currentTimeMillis();
        System.out.println("Shortest Distance using Brute Force is " + sd.findShortestDistanceBrute(ap).getDist() + " with points " + sd.findShortestDistanceBrute(ap).getP1().printPoint() + " and " + sd.findShortestDistanceBrute(ap).getP2().printPoint());
        long endB = System.currentTimeMillis();

        /* Print Runtime */
        System.out.println("Divide and Conquer Runtime: " + (endDNC-startDNC) + "ms");
        System.out.println("Bruteforce Runtime: " + (endB-startB) + "ms");

        in.close();
    }
}
