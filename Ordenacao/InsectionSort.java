package Ordenacao;

import java.util.Arrays;

public class InsectionSort {
    
    public void insectionSort(int[] array) {
        
        for(int i = 1; i < array.length; i++) {
            int j = i;

            while(j > 0 && array[j] < array[j-1]) {
                swap(array, j, j - 1);
                j--;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public void swap(int[] array, int p1, int p2) {
        Integer aux = array[p1];
        array[p1] = array[p2];
        array[p2] = aux;
    }

    public void inserePrimeiro(int[] array){
        Integer j = 0;

        while(j < array.length && array[j] > array[j+1]) {
            swap(array, j, j+1);
            j++;
        }
    }

    public void InsereUltimo(int[] array){
        int j = array.length-1;
        while(j > 0 && array[j] < array[j-1]) {
            swap(array, j, j-1);
            j--;
        }
    }

    public void move_n(int[] array){
        int index = indexBreak(array);

        while(index < array.length) {
            insectionSortIndex(array,index);
            index++;
        }
    }
    
    public int indexBreak(int[] array) {
        int i = 0;
        while(i < array.length - 1) {
            if(array[i] > array[i + 1]) {
                i++;
            } else {
                i++;
                break;
            }
        }
            return i;
    }

    public void insectionSortIndex(int[] array, int index) {
        int j = index;

        while(j > 0 && array[j] < array[j - 1]) {
            swap(array, j, j-1);
            System.out.println(Arrays.toString(array));
            j--;
        }
    }
    public static void main(String[] args) {
        InsectionSort isInsectionSort = new InsectionSort();
        int[] array = new int[] {1, 2, 4, 90, 99, 101, 7, 14, 21};
        Integer[] array_2 = new Integer[] {5 ,2 ,6 ,9 ,11 ,13};
        Integer[] array_padrao = new Integer[] {8, 3, 12, 1, 9, 7, 2, 4, 11, 6, 5, 10};
        //isInsectionSort.inserePrimeiro(array_2);
        isInsectionSort.insectionSort(array);
        
    }
}
