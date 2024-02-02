package LinkedList_2;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }


    //insercao
    public void addFirst(int element) {
        Node newNode = new Node(element);

        if(this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
            this.size++;
        }
    }

    public void addLast (int element) {
        Node newNode = new Node(element);

        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
            this.size++;
        }
    }

    public void addIndex(int element, int index) {
        
        Node newNode = new Node(element);

        if(index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if(this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;
        } if (index == 0) {
            addFirst(element);
            this.size++;
        } if (index == this.size - 1) {
            addLast(element);
            this.size++;
        }

         else {

            Node aux = this.head;

            for(int i = 0; i < index - 1; i++) {
                aux = aux.next;
            }
        
            newNode.prev = aux;
            newNode.next = aux.next;
            aux.next.prev = newNode;
            aux.next = newNode;
            this.size++;
        }
    }

    public int removeFirst() {
        int retorno;
        
        if(this.isEmpty()) {
            throw new IllegalStateException();
        } if (this.head.next == null) {
            retorno = this.head.data;
            this.head = null;
            this.tail = null;
            this.size--;
        } else {
            retorno = this.head.data;
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;   
        }
            return retorno;
    }

    public int removeLast() {
        int retorno;
        if(this.isEmpty()) {
            throw new IllegalStateException();
        } if (this.tail.prev == this.head) {
                retorno = this.tail.data;
                this.head.next = null;
                this.tail = this.head;
        } else {
            retorno = this.tail.data;
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.size--;
        }
        return retorno;
    }

    public int removeIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } if(this.isEmpty()) {
            throw new IllegalStateException();
        } if (index == 0) {
            return removeFirst();
        } if (index == this.size - 1) {
            return removeLast();
        } else {

            Node aux = this.head;

            for(int i = 0; i < index; i++) {
                aux = aux.next;
            }

            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
            this.size--;
            return aux.data;
        }
    }

    public void trimLinkedList(int quantidade) {
        for(int i = 0; i < quantidade; i++) {
            if(!this.isEmpty()) {
                removeLast();
            }
            if(!this.isEmpty()) {
                removeFirst();
            } 
            if(this.isEmpty()) {
                System.out.println("vazio porra");
            }
        }
    }

    public void filtraLinkedList(int k) {
        Node auxHead = this.head;
        int index = -1;

        while(auxHead != null) {
            index++;
            if(auxHead.data == k) { 
                removeIndex(index);
                index--;
            }
                auxHead = auxHead.next;
        }
                toStringLinkedList();
    }

    public int soma() {
        if(this.isEmpty()) return 0;
        else return soma(this.head,this.tail);
    }

    private int soma(Node head, Node tail) {
        int soma = 0;
        
        if(head.next == tail && tail.prev == head) {
            soma += head.data;
            soma += tail.data;
            return soma;
        }
        if(head != tail) {
            soma += head.data;
            soma += tail.data;
            soma += soma(head.next,tail.prev);
        }
        if(head == tail) {
            soma += head.data;
        }
            return soma;
    }


    public void trocaVizinho(int index) {
        Node aux = this.head;

        for(int i = 0; i < index; i++) {
            aux = aux.next;
        }
        
        Node proxAux = aux.next;

        aux.prev.next = proxAux;
        proxAux.prev = aux.prev;
        proxAux.next.prev = aux;
        aux.next = proxAux.next;
        aux.prev = proxAux;
        proxAux.next = aux;
        toStringLinkedList();
    }

    public void toStringLinkedList() {
        if(this.isEmpty()) {
            System.out.println("vazio");
            return;
        } else {
            Node aux = this.head;

            while(aux!= null) {
                System.out.println(aux.data);
                aux = aux.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList linked = new LinkedList();
        LinkedList linked_2 = new LinkedList();
        LinkedList linked_3 = new LinkedList();
        
        linked.addLast(1);
        linked.addLast(13);
        linked.addLast(3);
        linked.addLast(4);
        linked.addLast(5);

        linked_2.addLast(9);
        linked_2.addLast(7);
        linked_2.addLast(3);
        linked_2.addLast(5);
        linked_2.addLast(4);
        linked_2.addLast(3);

        linked_2.trocaVizinho(3);
    }
}


