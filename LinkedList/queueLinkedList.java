package LinkedList;

public class queueLinkedList {
        Node head;
        Node tail;
        int size;
        
        public queueLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
  

        public void enqueue(int element) {
            if(isEmpty()) {
                Node newNode = new Node(element);
                this.head = newNode;
                this.tail = newNode;
            } else {

                Node newNode = new Node(element);

                Node aux = this.head;
                while(aux.next != null) {
                    aux = aux.next;
                }

                aux.next = newNode;
                newNode.prev = aux;
                this.tail = newNode;
            }
                this.size++;
        }

        public int deQueue() {
            Integer retorno = null;
            if(isEmpty()) {
                retorno =  -1;
            }
            if(this.head.next == null) {
                retorno = this.head.data;
                this.head = null;
                this.tail = null;
                this.size--;
            } else {
                Node nextHead = this.head.next;
                retorno = this.head.data;

                nextHead.prev = null;
                this.head = nextHead;
                this.size--;
            }
            return retorno;
        }

        public boolean isEmpty() {
            return this.head == null;
        }

        public int peek(){
            return this.head.data;
        }

        public int size(){
            return this.size;
        }
    
        public void linkedToString() {
            Node aux = this.head;

            while(aux != null) {
                System.out.print(aux.data + " ");
                aux = aux.next;
            }
        }

    public static void main(String[] args) {
        queueLinkedList q = new queueLinkedList();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        
        System.out.println(q.deQueue());
        System.out.println(q.size);
    }
}
