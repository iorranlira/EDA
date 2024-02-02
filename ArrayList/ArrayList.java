package ArrayList;

import java.util.Arrays;

public class ArrayList {
    Integer[] array;

    public ArrayList(Integer[] array) {
        this.array = array;
    }
    public void remove(int index) {
        if(index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException();
        }
        if(isEmpty()) {
            return;
        } else {
            shiftLeft(index);
            System.out.println(Arrays.toString(array));
        }
    }

    public boolean isEmpty() {
        return this.array[0] == null;
    }
    
    public void shiftLeft(int index) {
        if(index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException();
        } if(isEmpty()) {
            return;
        } else {
            for(int i = index; i < array.length -1; i++) {
                array[i] = array[i+1];
            }
        }
    }
    public static void main(String[] args) {
        Integer[] array = new Integer[] {4,1,3};
        ArrayList aList = new ArrayList(array);

        aList.remove(0);
        
    }
}
