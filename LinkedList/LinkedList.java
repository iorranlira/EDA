package LinkedList;

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

    //metodos de insercao addLast, addFirst, Add.
    //adicionar um elemento no final da lista, se nao for vazia, adiciona a frente de tail, elemento inserido aponta pra tail;
    public void addLast(Integer element){
        Node newNode = new Node(element); 
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        } 
            this.size++;
    }

    //adiciona um elemento no inicio da lista, se nao for vazia, adicionar a frente de head, elemento inserido aponta pra head.
    public void addFirst(Integer element){  
        Node newNode = new Node(element);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }   
            this.size++;
    }

    //adiciona um elemento a uma posicao especificada.
    public void add(Integer element, int index) {
        Node newNode = new Node(element);

        if(index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        
        if(index == 0) {
            addFirst(element);
        }
            
        else if(index == this.size - 1) {
            addLast(element);
        }
        
        else {
            Node aux = this.head;

            for(int i = 0; i < index - 1; i++) {
                aux = aux.next;
            }
            
            newNode.next = aux.next;
            aux.next = newNode;
            newNode.next.prev = newNode;
            newNode.prev = aux;
        }   
            this.size++;
    }
    
    //Metodos de busca
    //pega o objeto de um index especifico.
    public int get(int index){
        if(index < 0 || index > this.size){
            throw new NullPointerException("Indice Invalido");
        }

        Node aux = this.head;
        for(int i = 0; i < index; i++){
            aux = aux.next;
        }
            return aux.data;
    }

    //retorna o indice onde o objeto esta, se nao ouver, -1.
    public int indexOf(Integer element){
        Node aux = this.head;
        int index = 0;
        while(aux != null){
            if(aux.data == element){
                return index;
            }
                aux = aux.next;
                index++;
        }   
                return -1;
        }       

        //verifica se o objeto esta contido na linked list.
        public boolean Countains(Integer element){
            if(indexOf(element) == -1){
                return false;
            }
                return true;
        }

        //pega o primeiro objeto, se ele existir e se a lista nao estiver vazia.
        public Integer getFirst(){
            if(!isEmpty()){
                return this.head.data;
            }
                return null;
        }
        
        //pega o ultimo objeto, se ele existe e se a lista nao estiver vazia.
        public Integer getLast(){
            if(!isEmpty()){
                return this.tail.data;
            }
                return null;
        }
 

        //metodos de remocao
        //remover o primeiro elemento da lista, head aponto pro proximo, e o anterior de head pra null.
        public Integer removeFirst(){
            Integer saida = this.head.data;
            if(isEmpty()){
                throw new NullPointerException();
        }   if (this.head.next == null)    {
                this.head = null;
                this.tail = null;
        }   else {
                this.head = this.head.next;
                this.head.prev = null;
        }   
                size--;
                return saida;
    }

    //remover o ultimo elemento da lista, tail aponta para o anterior e o proximo de tail aponta pra null.
    public Integer removeLast(){
        Integer saida = this.head.data;
        if(isEmpty()){
            throw new NullPointerException();
        }   if(this.head.next == null){
                this.head = null;
                this.tail = null;
        }   else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
            size--;
            return saida;
    }   

    //remove um elemento de uma posicao espeficica, verifica o index 3 vezes, no else, intera ate o index
    public Integer remove(int index){
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            return this.removeFirst();
        }

        if(index == this.size - 1){
            return this.removeLast();
        }
        else {
            Node aux = this.head;
            for(int i = 0; i < index; i++){
                aux = aux.next;
            }

            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
            size--;
            return aux.data;
        }
    }


    public class queueLinkedList {
        LinkedList linkedList;
        Node head = linkedList.head;
        Node tail = linkedList.tail;
        int size = 0;;
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
    }
 public static void main(String[] args) {
   
}

}


