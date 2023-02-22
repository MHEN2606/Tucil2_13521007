public class ArrayPoint{
    public int n;
    public point[] array;

    ArrayPoint(int n, int d){
        this.n = n;
        array = new point[n];
        for(int i = 0; i < n; i++){
            array[i] = new point(d);
        }
    }

    ArrayPoint(int n, point[] array){
        this.n = n;
        this.array = array;
    }

    ArrayPoint(int n){
        this.n = n;
    }

    public void sortArray(point[] arr, int order){
    // Lakukan sorting berdasarkan order (0,1,2,3,...,derajat) (0=x,1=y,2=z,...)
    // Sorting dengan Selection Sort
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(arr[j].buffer[order] < arr[min].buffer[order]){
                    min = j;
                }
            }
            //swap
            point temp_point = arr[min]; 
            arr[min] = arr[i];
            arr[i] = temp_point;
        }
        this.array = arr;
    }
}
