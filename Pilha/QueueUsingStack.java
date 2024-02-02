package Pilha;

/**
 * QueueUsingStack
 */
public class QueueUsingStack {

    private Pilha pilha_1;
    private Pilha pilha_2;

    public QueueUsingStack(int capacidade) {
        pilha_1 = new Pilha(capacidade);
        pilha_2 = new Pilha(capacidade);
    }

    public void push(Integer element) {
        if(isFull()) {
            return;
        } 
        
        while(!pilha_1.isEmpty()) {
            pilha_2.push(pilha_1.pop());
        }

        pilha_1.push(element);

        while(!pilha_2.isEmpty()) {
            pilha_1.push(pilha_2.pop());
        }

    }
    
    public int pop() {
        Integer element = null;
        
        if(!isEmpty()) {

        element = pilha_1.peek();
        pilha_1.pop();
    
    }
        return element;
    }

    public int peek() {
        Integer retorno = null;
        if(isEmpty()) {
            return retorno;
        } else {
            retorno = pilha_1.peek();
        }
        
        return retorno;
    }

    public int size() {
        return pilha_1.topo + 1;
    }

    public boolean isEmpty() {
        return pilha_1.topo == -1 && pilha_2.topo == -1; 
    }


    public boolean isFull() {
        return pilha_1.topo == pilha_1.capacidade -1;
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack(5);

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        System.out.println(queue.pop());
        System.out.println(queue.peek());
       System.out.println(queue.size());
        
    }
}