package Queue;

public class Queue {
    private int[] fila;
    private int head, tail, capacidade, size;

    public Queue(int capacidade){
        this.capacidade = capacidade;
        this.head = -1;
        this.tail = -1;
        this.size = 0;
        this.fila = new int[capacidade];
    }


    public boolean isEmpty(){
        return (this.head == -1 && this.tail == -1);
    }

    public boolean isFull(){
        return this.head == (this.tail + 1) % capacidade;
    }

    
    public void addLast(int element) {
        if(!isFull()) {
            if(isEmpty()) {
                this.head = 0;
                this.tail = 0;
                fila[this.tail] = element; 
                this.size++;
            } else {
                this.tail = (this.tail + 1) % capacidade;
                fila[tail] = element;
                this.size++;
            } 
        }
    }

    public int removeFirst() {
        int result = -1;

        if(!isEmpty()) {
        result = fila[this.head];
        if(this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
            this.size--;
        }  
        else {
            this.head = (this.head + 1) % capacidade;
            this.size--;
        }   
        }
            return result;
    }

    public Integer peek(){
        if(!isEmpty()){
            return fila[this.head];
        }
        return null;
    }


    public int size(){
        return this.size;
    }

public static void main(String[] args) {
    Queue filaQueue = new Queue(5);

    filaQueue.addLast(0);
    filaQueue.addLast(1);
    filaQueue.addLast(5);
    filaQueue.addLast(5);
    filaQueue.addLast(5);

    
    filaQueue.removeFirst();
    System.out.println(filaQueue.size);

}
}