package Ordenacao;
import java.util.Arrays;

public class QuickSort {
    public int particionamentoLomuto(int[] array, int left, int right) {
      int pivot = array[left];
      int i = left;

      for(int j = left + 1; j <= right; j++) {
        if(array[j] < pivot) {
            i++;
            swap(array, i, j);
        }
      }     swap(array,i, left);
            return i;
    }

    public void quickSort(int[] array, int left, int right) {
        if(left < right) {
            int pivot = particionamentoLomuto(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }


    public boolean arrayDuplicado(int[] array) {
        boolean result = false;
       
        for(int i = 0; i < array.length; i++) {
            int elementIndex = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[elementIndex] == array[j]) {
                    result = true;
                }
            }
        }
            return result;
    }

    public void swap(int[] array, int p1, int p2) {
        int aux = array[p1];
        array[p1] = array[p2];
        array[p2] = aux;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] array = new int[] {4, 9, 2, 10, 5, 8, 7,-1};
        int[] arrayQuestao = new int[] {9, 5, 1, 8, 2, 6};
       
        q.quickSort(array, 0, array.length-1);
       System.out.println(Arrays.toString(array));
    }

}
