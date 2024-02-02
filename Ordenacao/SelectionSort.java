package Ordenacao;

import java.util.Arrays;

public class SelectionSort {

    //encontrar o menor e colocar na primeira posicao, fazer isso n vezes.
    public void selectionSort(Integer[] array) {
    for(int i = 0; i < array.length; i++) {
        Integer menorIndex = i;

        for(int j = i + 1; j < array.length; j++) {
            if(array[j] < array[menorIndex]) {
                menorIndex = j;
            }
        }
        swap(array,menorIndex, i);
    } 
    System.out.println(Arrays.toString(array));   
}   


public void selectionSortQuestao(Integer[] array) {
    
    for(int i = 0; i < array.length; i++) {
        int menorIndex = i;
        for(int j = i + 1; j < array.length; j++) {
            if(array[menorIndex] > array[j]) {
                menorIndex = j;
                swap(array, i, j);
            }
        }
        System.out.println(Arrays.toString(array));   
    }
}



public void swap(Integer[] array, Integer posicao1, Integer posicao2) {
        //troca a posicao v1 por v2
        Integer aux = array[posicao1];
        array[posicao1] = array[posicao2];
        array[posicao2] = aux;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {10,14,7,9,6,2,1}; 
        Integer[] array_teste = new Integer[] {5, 0, 6, 2};
        Integer[] array_teste2 = new Integer[] {4 ,3, 2, 1};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(array_teste2);
    }
}

