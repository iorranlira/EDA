package Pilha;

/**
 * Pilha
 */
public class Pilha {
    int topo;
    private int[] pilha;
    int capacidade;
   
    public Pilha(int capacidade){
        this.capacidade = capacidade;
        pilha = new int[capacidade];   
        this.topo = -1; 
    }


    //adiciona um item na pilha, se ela nao estiver cheia.
    public void push(int element){
       if(isFull()) {
            return;
       } else {
            topo++;
            pilha[topo] = element;
       }
    }

    //remove um item da pilha se ela nao estiver vazia, retorna o item do topo antes da exclusao.
    public int pop() {
      Integer retorno = null;

        if(isEmpty()) {
            retorno = -1;
      } else {
        retorno = pilha[topo];
        topo--;
      }
        return retorno;
    }
    
    //retorna o elemento do topo da lista, se nao estiver vazia, sem remove-lo.
    public int peek(){
      Integer retorno = null;
        if(isEmpty()) {
            retorno = -1;
        } else {
            retorno = pilha[topo];
      }
        return retorno;
    }


    //retorna a quantidade de elementos de uma pilha
    public int size(){
        return this.topo + 1;
    }


    public boolean isEmpty(){
      return this.topo == -1;
    }

    public boolean isFull(){
      return this.topo == capacidade - 1;
    }

    public void invertePilha(Pilha pilha){
        Pilha pilha_2 = new Pilha(pilha.capacidade);

        while(!pilha.isEmpty()) {
            pilha_2.push(pilha.pop());
        }

        while(!pilha_2.isEmpty()) {
            System.out.println(pilha_2.pop());
        }
    }


    public void invertePilhaIndex(Pilha pilha, int index){
        Pilha pilha_2 = new Pilha(pilha.capacidade);
        Pilha pilha_3 = new Pilha(pilha.capacidade);

        while(!pilha.isEmpty()) {
            pilha_2.push(pilha.pop());
        }

        for(int i = 0; i < index; i++) {
            pilha.push(pilha_2.pop());
        }

        while(!pilha_2.isEmpty()) {
            pilha_3.push(pilha_2.pop());
        }

        while(!pilha_3.isEmpty()) {
            pilha.push(pilha_3.pop());
        }

        System.out.println("-");
        while(!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }   



public static void main(String[] args) {
    Pilha pilha = new Pilha(5);

    pilha.push(1);
    pilha.push(2);
    pilha.push(4);
    pilha.push(8);
    pilha.push(24);

    Pilha pilha_2 = new Pilha(10);

    pilha_2.push(8);
    pilha_2.push(2);
    pilha_2.push(1);
    pilha_2.push(3);
    pilha_2.push(0);
    pilha_2.push(7);
    pilha_2.push(2);
    pilha_2.push(90);
    pilha_2.push(12);
    pilha_2.push(74);
    
    pilha_2.invertePilhaIndex(pilha_2, 3);

}

}