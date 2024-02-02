package Ordenacao;

import java.util.Arrays;

/**
 * MergeSort
 */
public class MergeSort {

    public void merge(int[] array, int left , int middle, int right) {

        int[] arrayAux = new int[array.length];
        
        for(int i = 0; i < array.length; i++) {
            arrayAux[i] = array[i];
        }
        
        
        int i = left;
        int j = middle + 1;
        int k = left;

        //while comparando
        while(i <= middle && j <= right) {
            if(arrayAux[i] > arrayAux[j]) {
                array[k] = arrayAux[j];
                j++;
            } 
            else {
                array[k] = arrayAux[i];
                i++;
            }
                k++;
        }
     
        //while append
        while(i <= middle) {
            array[k] = arrayAux[i];
            i++;
            k++;
        }

        //while append
        while(j <= right) {
            array[k] = arrayAux[j];
            j++;
            k++;
        }

    }

   public void mergeSort(int[] array, int left,int right) {
        if(left >= right){
            return;
        } else {
            int middle = (left + right)/2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right); 
            System.out.println(Arrays.toString(array));

        }
    }

    public void mergeEntreArrays(int[] array_1, int[] array_2, int left) {

        int[] aux = new int[array_1.length + array_2.length];
        int i = left;
        int j = left;
        int k = left;

        while((i < array_1.length) && (j < array_2.length)){
            if(array_1[i] < array_2[j]) {
                aux[k] = array_1[i];
                i++;
            } else {
                aux[k] = array_2[j];
                j++;
            }
                k++;
        }

        while(i < array_1.length) {
            aux[k] = array_1[i];
            i++;
            k++;
        }

        while(j < array_2.length) {
            aux[k] = array_2[j];
            j++;
            k++;
        }
        
        System.out.println(Arrays.toString(aux));
    
    }

    public void mergeEntreArraysProva(int[] array_1, int[] array_2, int left) {

        int[] aux = new int[array_1.length + array_2.length];
        int i = left;
        int j = array_2.length-1;
        int k = left;

        while((i < array_1.length) && (j >= 0)){
            if(array_1[i] < array_2[j]) {
                aux[k] = array_1[i];
                i++;
            } else {
                aux[k] = array_2[j];
                j--;
            }
                k++;
        }

        while(i < array_1.length) {
            aux[k] = array_1[i];
            i++;
            k++;
        }

        while(j >= 0) {
            aux[k] = array_2[j];
            j--;
            k++;
        }
        
        System.out.println(Arrays.toString(aux));
    
    }
     
public static void main(String[] args) {
    MergeSort mSort = new MergeSort();
    int[] array_padrao = new int[] {8, 3, 12, 1, 9, 7, 2, 4, 11, 6, 5, 10};

    int[] array_1 = new int[]{1, 3, 5, 7, 9};
    int[] array_2 = new int[]{ 9, 7, 5, 3, 1};
    mSort.mergeSort(array_padrao, 0, array_padrao.length-1);
    
}

}