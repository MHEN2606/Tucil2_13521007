import argparse
import matplotlib.pyplot as plt
import numpy as np

parser = argparse.ArgumentParser()
parser.add_argument("path")
args = parser.parse_args()

f = open(args.path, 'r')

# num of points
n = int(f.readline())
# degree of points
d = int(f.readline())

if(d == 2):
# Plot 2D
    # PLOT ALL POINTS
    xpoints = np.array([])
    ypoints = np.array([])
    xpointSol = np.array([])
    ypointSol = np.array([])

    for i in range(n):
        x = f.readline().split()
        for j in range(d):
            x[j] = float(x[j])
        
        xpoints = np.append(xpoints, x[0])
        ypoints = np.append(ypoints, x[1])

    # GET SOLUTION
    for i in range(2):
        x = f.readline().split()
        for j in range(d):
            x[j] = float(x[j])
        
        xpointSol = np.append(xpointSol, x[0])
        ypointSol = np.append(ypointSol, x[1])
    
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
        x = f.readline().split()
        for j in range(d):
            x[j] = float(x[j])
        
        xpoints = np.append(xpoints, x[0])
        ypoints = np.append(ypoints, x[1])
        zpoints = np.append(zpoints, x[2])

    # GET SOLUTION
    for i in range(2):
        x = f.readline().split()
        for j in range(d):
            x[j] = float(x[j])
        
        xpointSol = np.append(xpointSol, x[0])
        ypointSol = np.append(ypointSol, x[1])
        zpointsSol = np.append(zpointsSol, x[2])

    for i in range(n):
        ax.plot(xpoints[i], ypoints[i],zpoints[i], 'ok')

    for i in range(2):
        ax.plot(xpointSol[i], ypointSol[i], zpointsSol[i], 'or')

    ax.set_xlabel('Sumbu X')
    ax.set_ylabel('Sumbu Y')
    ax.set_zlabel('Sumbu Z')

    plt.show()

f.close()