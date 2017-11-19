package adaits.cursoJava.algoritmos.ordenacion;

public class SortSelection {
    public static void main(String[] args) {
        int array[] = {12,54,32,25,86,9,5,2,55,44,77,69,23,68,7,15};

        for (int i = 0;i < array.length; i++){
            int min = buscaMin(array,i);    // Buscamos el índice del elemento menor del subarray que comienza en i
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        for (int i:array){
            System.out.print(i + ", ");
        }
    }

    static int buscaMin(int array[], int i){
        int minIndex=i;
        for (int j = i;j < array.length;j++){
            if (array[j] < array[minIndex]){
                minIndex = j;
            }
        }
        return minIndex;
    }
}
