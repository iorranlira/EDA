package Ordenacao;

import java.util.Arrays;

public class CountingSort {
    public int[] countingSort (int[] A, int k) {
        int[] C = new int[k];
        int[] B = new int[A.length];


        //calcular as frequencias dos elementos de A e guardar em C
        for(int i = 0; i < A.length; i++) {
            C[A[i] -1] += 1;
        }
        
        //contagem
        for(int i = 1; i < k; i++) {
            C[i] += C[i - 1];
        }
        
        //ordanando A ao contrario
        for(int i = A.length - 1; i > 0; i--) {
            B[C[A[i] -1] -1] =  A[i];
            C[A[i]-1]--;        
        }
            return B;

    }

    public void down_n(int[] array, int k){
        array = countingSort(array , getMaior(array));

        for(int i = 0; i < k; i++) {
            System.out.println(array[i]);
        }
    }

    public int getMaior(int[] array) {
        int maior = array[0];

        for(int i = 1; i < array.length; i++){
            if(array[i] > maior) {
                maior = array[i];
            }
        }
            return maior;   
    }

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] arrayQuestao = new int[] {9, 3, 1, 7, 34, 22, 101, 7, 300, 1, 45};
        int[] outroArray = new int[] {3, 2, 4, 7,4 ,7,1,2,3};
        System.out.println(Arrays.toString(countingSort.countingSort(arrayQuestao, 300)));
    }
}
