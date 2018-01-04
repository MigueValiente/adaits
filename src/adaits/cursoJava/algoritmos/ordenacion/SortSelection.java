package adaits.cursoJava.algoritmos.ordenacion;

class SortSelection {
    public static void main(String[] args) {
        //int array[] = {12,54,32,25,86,9,5,2,55,44,77,69,23,68,7,15};
        int array[] = populate(10000);
        for (int i = 0;i < array.length; i++){
            int min = buscaMin(array,i);    // Buscamos el índice del elemento menor del subarray que comienza en i
            if (i != min) {
                swap(array,i,min);
            }
        }
        for (int i:array){
            System.out.print(i + ", ");
        }


    }

    private static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }
    private static int buscaMin(int array[], int i){
        int minIndex=i;
        for (int j = i;j < array.length;j++){
            if (array[j] < array[minIndex]){
                minIndex = j;
            }
        }
        return minIndex;
    }

    private static int[] populate(int n){
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random()*n + 1);
        }
        return a;
    }
}
