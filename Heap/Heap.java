package Heap;

public class Heap {
    private int[] heap;
    private int tail;

    public Heap(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int left(int index){
        return 2 * index + 1;
    }

    public int right(int index) {
        return 2 * (index + 1);
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public void add(Integer element) {
       if(element == null) return;

       this.tail++;
       this.heap[tail] = element;

       int i = tail;
       while((i > 0) && (this.heap[i] > this.heap[parent(i)])) {
            int aux = this.heap[i];
            this.heap[i] = this.heap[parent(i)];
            this.heap[parent(i)] = aux;
            i = parent(i);        
        }
    }

    public int remove() {
        if(isEmpty()) throw new RuntimeException("Empty");

        int resultado = this.heap[0];
        this.heap[0] = this.heap[this.tail];
        this.tail--;

        this.heapify(0);
        return resultado;

    }

    public void heapify(int index) {
        if(!isValidIndex(index)) return;
        
        int max_index = maxIndex(index, right(index), left(index));

        if(max_index != index) {
            swap(index, max_index);
            heapify(max_index);
        }
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index <= this.tail;
    }

    public boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail;
    }

    public int maxIndex(int index, int right, int left) {
        if(this.heap[index] > this.heap[left]) {
            if(isValidIndex(right)) {
                if(this.heap[index] < this.heap[right]) 
                    return right;    
            }
             
            return index;

        } else {
            if(isValidIndex(right)) {
                if(this.heap[left] < this.heap[right])
                    return right; 
            }
                    return left;
        }
    }

    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }
}
