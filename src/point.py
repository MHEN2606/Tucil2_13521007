import random

# Konstruktor point
# Point adalah array of float
def makePoint(d):
    point = [random.uniform(0,101) for i in range(d)]
    return point

# Konstruktor set of point
# Set adalah array of array of float
def makeArrayPoint(n,d):
    arrayPoint = [makePoint(d) for i in range(n)]
    return arrayPoint

# Fungsi sorting array menggunakan selection sort
def sortArray(arr, order):
    # Lakukan sorting berdasarkan order (0,1,2,3,...,derajat) (0=x,1=y,2=z,...)
    # Sorting dengan Selection Sort
    for i in range(len(arr)-1):
        min = i
        for j in range(i+1, len(arr)):
            if(arr[j][order] < arr[min][order]):
                min = j;
    
        temp_point = arr[min]; 
        arr[min] = arr[i];
        arr[i] = temp_point;

    return arr

# Fungsi untuk return string terformat
def printPoint(buffer,d):
    ret = ""
    ret+=("(")
    for i in range(d):
        if(i != d-1):
            ret+=str(round(buffer[i],2))+(",")
        else:
            ret+=str(round(buffer[i],2))
    ret+=(")")
    return ret