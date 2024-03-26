import java.util.HashSet;
import java.util.Set;

public class TabelaHash {
        private Aluno[] tabela;
        private Set<Integer> chaves;
        private Set<Aluno> valores;
        private int size;
        private double fatorDeCarga;

        public static final int CAPACIDADE = 20;
        public static final double FATOR_DE_CARGA = 0.75;
        public static final Aluno APAGADO = new Aluno(Integer.MIN_VALUE, "APAGADO");


        //tabela padrao
        public TabelaHash() {
            this.tabela = new Aluno[CAPACIDADE];
            this.fatorDeCarga = FATOR_DE_CARGA;
        }

        //tabela personalizada
        public TabelaHash(int capacidade, double fatorDeCarga){
            this.tabela = new Aluno[capacidade];
            this.chaves = new HashSet<Integer>();
            this.valores = new HashSet<Aluno>();
            this.fatorDeCarga = fatorDeCarga;
        }


        //metodo da divisao por um inteiro.
        public int hash(int key){
            return key % tabela.length;
        }
    
        //metodo put 
        public void put(Integer chave, Aluno valor){
        //verificar se atingiu o limite, se sim resize
        if(this.size / this.tabela.length >= fatorDeCarga || this.tabela.length == this.size){
            //cria uma nova tabela
            Aluno[] novaTabela = new Aluno[tabela.length * 2];
            reinicializaTabela();

            for(Aluno aluno : tabela){
                if(aluno != null){
                    put(novaTabela, aluno.getMatricula(), aluno);
                }
            }
                put(novaTabela,valor.getMatricula(), valor);
                this.tabela = novaTabela;
                
            } else {
                put(this.tabela, chave, valor);
        }   
    }
    
    
    //outro metodo put 
        private void put(Aluno[] tabela, Integer chave, Aluno valor){
            int sondagem = 0;
            int hash;

            while(sondagem < tabela.length) {

                hash = (hash(chave) + sondagem) % tabela.length;
                Aluno alunoTemp = tabela[hash];
                
                if(alunoTemp == null || alunoTemp.getMatricula() == chave || alunoTemp == APAGADO) {
                    tabela[hash] = valor;
                    this.chaves.add(chave);
                    this.valores.add(valor);
                    this.size++;
                }
                    sondagem++;
            }
        }
    
        public Aluno remove(Integer chave) {
            int sondagem = 0;
            int hash;

            while (sondagem < tabela.length){

                hash = (hash(chave) + sondagem) % tabela.length;
                if(tabela[hash] != null && tabela[hash].getMatricula() == chave){
                    Aluno aluno = tabela[hash];
                    tabela[hash] = APAGADO;
                    this.chaves.remove(chave);
                    this.valores.remove(aluno);
                    this.size--;
                    return aluno;
                }
                    sondagem++;
            }
                return null;
        }

        private void reinicializaTabela() {
            this.size = 0;
            this.chaves = new HashSet<Integer>();
            this.valores = new HashSet<Aluno>();
        }

    public static class Aluno {
        private int matricula;
        private String nome;

        public Aluno(int matricula, String nome){
            this.matricula = matricula;
            this.nome = nome;
        }

        public int getMatricula(){
            return this.matricula;
        }
    
        public String getNome(){
            return this.nome;
        }
    
    }

    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();
        Aluno aluno = new Aluno(1231312, "Renato");
        System.out.println(1231312 % 20);
    }
}
