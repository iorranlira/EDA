package BinarySearch;

import Ordenacao.CountingSort;

/**
 * BinarySearch
 */
public class BinarySearch {
    
    public boolean binarySearch(int[] array, int element, int left, int right) {
        boolean result = false;
        int middle = (left+right) / 2;

        if((left >= 0 && left < array.length) && (right >= 0 && right < array.length) && (left <= right)) {
            if(array[middle] == element) {
                result = true;
            } else {
                if(array[middle] < element) {
                    result = binarySearch(array, element, middle + 1, right);
                }
            if(array[middle] > element) {
                    result = binarySearch(array, element, left, middle - 1);
                } 
            }
        }      return result;
    }

    public static void main(String[] args) {
        BinarySearch bSearch = new BinarySearch();
        int[] array = new int[] {3, 5, 8, 10, 12, 18, 20};
        int[] array_2 = new int[] {3, 5, 8, 10, 12, 18};
        System.out.println(bSearch.binarySearch(array_2, 0, 0, array_2.length-1));
        
    }

 
}