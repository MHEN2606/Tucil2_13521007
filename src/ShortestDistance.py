# Filename: ShortestDistance.py
# Matthew Mahendra - 13521007
import point as pt
import math

countOfEuc = 0

# Fungsi untuk menentukan euclidean distance antar dua titik
def euclideanDistance(p1, p2):
    global countOfEuc
    countOfEuc += 1
    d = len(p1)
    buffer = 0.0
    for i in range(d):
        buffer+=(p1[i]-p2[i])*(p1[i]-p2[i])
    return math.sqrt(buffer)

# Fungsi untuk menentukan jarak terdekat dari set of points
def findShortestDistance(ap, d):
    # Jumlah titik dengan menghitung panjang dari array of points
    n = len(ap)
    # Basis ketika jumlah titik adalah 2 atau 3
    if(n == 2):
        return [ap[0],ap[1], euclideanDistance(ap[0], ap[1])]
    elif (n==3):
        t1 = euclideanDistance(ap[0], ap[1])
        t2 = euclideanDistance(ap[0], ap[2])
        t3 = euclideanDistance(ap[1], ap[2])

        if(t1 < t2):
            if(t1 < t3):
                ret = [ap[0], ap[1], t1]
            else:
                ret = [ap[1], ap[2], t3]
            
        else:
            if(t2 < t3):
                ret = [ap[0], ap[2], t2]
            else:
                ret = [ap[1], ap[2], t3]
        
        return ret
    else:
        # Divide
        if(n % 2 == 0):
            carry = 0
        else:
            carry = 1
        
        # Bagi titik-titik menjadi partisi p1 dan p2
        p1 = [[] for i in range (n//2)]
        p2 = [[] for i in range ((n//2)+carry)]
        for i in range(n//2):
            p1[i] = ap[i]

        for i in range((n//2) + carry):
            p2[i] = ap[i + (n//2)]

        # Cari jarak minimum pada tiap partisi
        d1 = findShortestDistance(p1, d)
        d2 = findShortestDistance(p2, d)

        # Conquer
        # Bandingkan d1 dan d2 untuk mengambil minimumnya
        if(d1[2] < d2[2]):
            ret = [d1[0], d1[1], d1[2]]
        else:
            ret = [d2[0], d2[1], d2[2]]

        # Combine
        # Make a Slab

        # Hitung jumlah yang akan dimasukkan ke dalam slab
        nslab = 0
        for i in range(len(p1)):
            if(p1[i][0] >= ap[n//2][0]-ret[2]):
                nslab += 1
        
        for i in range(len(p2)):
            if(p2[i][0] <= ap[n//2][0]+ret[2]):
                nslab += 1

        slab = [[] for i in range(nslab)]

        nfill = 0
        for i in range(len(p1)):
            if(p1[i][0] >= ap[n//2][0]-ret[2]):
                slab[nfill] = p1[i]
                nfill += 1

        for i in range(len(p2)):
            if(p2[i][0] <= ap[n//2][0]+ret[2]):
                slab[nfill] = p2[i]
                nfill += 1
        
        for i in range(d-1, 0,-1):
            slab = pt.sortArray(slab, i)
            for j in range(len(slab)):
                for k in range(j+1, len(slab)):
                    if(abs(slab[j][0] - slab[k][0]) < ret[2] or abs(slab[j][i] - slab[k][i]) < ret[2]):
                        newret = [slab[j], slab[k], euclideanDistance(slab[j], slab[k])]
                        if(ret[2] > newret[2]):
                            ret = newret
        
        return ret

def findShortestDistanceBrute(ap):
    # Mencari Shortest Distance Menggunakan Algoritma Bruteforce
    d = euclideanDistance(ap[0], ap[1])
    p1 = ap[0]
    p2 = ap[1]
    for i in range(len(ap)):
        for j in range(i+1, len(ap)):
            temp = euclideanDistance(ap[i], ap[j])
            if(temp < d):
                d = temp
                p1 = ap[i]
                p2 = ap[j]

    ret = [p1,p2,d]

    return ret