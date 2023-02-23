import point as pt
import ShortestDistance as sd
import time as tm
import numpy as np
import matplotlib.pyplot as plt

### HEADER ###
print("========================")
print(" CLOSEST PAIR OF POINTS ")
print("========================")

# Input Program
n = int(input("Masukkan jumlah titik: "))

while(n < 2):
    print("Jumlah titik minimal adalah 2. Silakan ulangi masukan!")
    print("Masukkan jumlah titik: ")
    n = int(input("Masukkan jumlah titik (n): "))

d = int(input("Masukkan dimensi titik: "))

while(d < 2):
    print("Dimensi terkecil adalah 2. Silakan ulangi masukan derajat!")
    d = int(input("Masukkan dimensi titik: "))

# Make Points
ap = pt.makeArrayPoint(n,d)

# sort point berdasarkan x
ap = pt.sortArray(ap, 0)

startDNC = tm.time()
out = sd.findShortestDistance(ap, d)
endDNC = tm.time()
coe = sd.countOfEuc
print("========================")
print("        RESULT     ")
print("========================")
print("USING DIVIDE AND CONQUER")
print("========================")
print("Shortest Distance is", round(out[2],2), "with points", pt.printPoint(out[0], d), "and", pt.printPoint(out[1], d))
print("Euclidean Distance operations count:", coe)

startB = tm.time()
brute = sd.findShortestDistanceBrute(ap)
endB = tm.time()
print("========================")
print("   USING BRUTE FORCE")
print("========================")
print("Shortest Distance using Brute Force is", round(brute[2],2), "with points", pt.printPoint(brute[0], d), "and", pt.printPoint(brute[1], d))
print("Euclidean Distance operations count:", (sd.countOfEuc-coe))
# Print Runtime
print("========================")
print("        RUNTIME         ")
print("========================")
print("Divide and Conquer Runtime:", round((endDNC-startDNC)*1000,2), "ms");
print("Bruteforce Runtime:", round((endB-startB)*1000,2), "ms");

if(d == 2 or d == 3):
    choice = input("Apakah Anda ingin melihat visualisasi pada 2D atau 3D? (y/n) ")
    if(choice == "y"):
        if(d == 2):
        # Plot 2D
            # PLOT ALL POINTS
            xpoints = np.array([])
            ypoints = np.array([])
            xpointSol = np.array([])
            ypointSol = np.array([])

            for i in range(n):
                xpoints = np.append(xpoints, ap[i][0])
                ypoints = np.append(ypoints, ap[i][1])

            # GET SOLUTION
            for i in range(2):
                xpointSol = np.append(xpointSol, out[i][0])
                ypointSol = np.append(ypointSol, out[i][1])
            
            plt.plot(xpoints, ypoints, 'ok')
            plt.plot(xpointSol, ypointSol, 'or')
            plt.plot(xpointSol, ypointSol, 'r')
            plt.show()
        elif(d==3):
        # Plot 3D
            fig = plt.figure()
            ax = fig.add_subplot(projection='3d')

            # PLOT ALL POINTS
            xpoints = np.array([])
            ypoints = np.array([])
            zpoints = np.array([])
            xpointSol = np.array([])
            ypointSol = np.array([])
            zpointsSol = np.array([])

            for i in range(n):
                xpoints = np.append(xpoints, ap[i][0])
                ypoints = np.append(ypoints, ap[i][1])
                zpoints = np.append(zpoints, ap[i][2])

            # GET SOLUTION
            for i in range(2):
                xpointSol = np.append(xpointSol, out[i][0])
                ypointSol = np.append(ypointSol, out[i][1])
                zpointsSol = np.append(zpointsSol, out[i][2])

            for i in range(n):
                ax.plot(xpoints[i], ypoints[i],zpoints[i], 'ok')

            for i in range(2):
                ax.plot(xpointSol[i], ypointSol[i], zpointsSol[i], 'or')

            ax.set_xlabel('Sumbu X')
            ax.set_ylabel('Sumbu Y')
            ax.set_zlabel('Sumbu Z')

            plt.show()