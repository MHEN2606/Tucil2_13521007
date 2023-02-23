import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        ShortestDistance sd = new ShortestDistance();
        Scanner in = new Scanner(System.in);
        // Make array of points
        System.out.println("Masukkan jumlah titik: ");
        int n = in.nextInt();
        while(n < 2){
            System.out.println("Jumlah titik minimal adalah 2. Silakan ulangi masukan!");
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

        try{
            FileWriter outputFile = new FileWriter("sol.txt");

            outputFile.write(n + "\n");
            outputFile.write(d + "\n");
            if( d== 3 || d == 2){
                for(int i = 0; i < n; i++){
                    if(d == 3){
                        outputFile.write(ap.array[i].buffer[0] + " " + ap.array[i].buffer[1] + " " + ap.array[i].buffer[2] + "\n");
                    }else{
                        outputFile.write(ap.array[i].buffer[0] + " " + ap.array[i].buffer[1] + "\n");
                    }
                }

                if(d == 3){
                    outputFile.write(out.getP1().buffer[0] + " " + out.getP1().buffer[1] + " " + out.getP1().buffer[2] + "\n");
                }else{
                    outputFile.write(out.getP1().buffer[0] + " " + out.getP1().buffer[1] + "\n");
                }

                if(d == 3){
                    outputFile.write(out.getP2().buffer[0] + " " + out.getP2().buffer[1] + " " + out.getP2().buffer[2]);
                }else{
                    outputFile.write(out.getP2().buffer[0] + " " + out.getP2().buffer[1]);
                }
            }
            outputFile.close();

        } catch (IOException e) {
            System.out.println("Error Occured.");
            e.printStackTrace();
        }
        in.close();
    }
}
