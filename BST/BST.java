package BST;

public class BST {
    Node root;

    public boolean isEmpty(){
        return this.root == null;
    }

    public void addInterative(int element){
        Node newNode = new Node(element);
        
        if(isEmpty()) this.root = newNode;
        
        Node aux = this.root;

        while(aux != null) {
            if(element < aux.value) {
                if(aux.left == null) {
                    aux.left = newNode;
                    newNode.parent = aux;
                    return;
                }

                aux = aux.left;

            } else {
                if(aux.right == null) {
                    aux.right = newNode;
                    newNode.parent = aux;
                    return;
                }

                aux = aux.right;
            }
         }
    }

    public void addRecursive(int element){
        if(isEmpty())
            this.root = new Node(element);
        else {
            addRecursive(this.root, element);
        }
    }
    
    private void addRecursive(Node node, int element) {
        if(element < node.value){
            if(node.left == null){
                Node newNode = new Node(element);
                node.left = newNode;
                newNode.parent = node;
                return;
            }

        addRecursive(node.left, element);

        } else {
            if(node.right == null){
                Node newNode = new Node(element);
                node.right = newNode;
                newNode.parent = node;
                return;
            }

            addRecursive(node.right, element);
            
        }
    }

    public Node interativeSearch(int element) {

        Node aux = this.root;

        while(aux != null) {
            if(aux.value == element) return aux;
            if(element < aux.value) aux = aux.left;
            if(element > aux.value) aux = aux.right;
        }

        return null;
    
    }

    public Node recursiveSearch(int element){
        return recursiveSeach(this.root, element);
    }

    private Node recursiveSeach(Node node, int element){
        if (node == null) return null;
        if (node.value == element) return node;
        if (element < node.value) return recursiveSeach(node.left, element);
        else return recursiveSeach(node.right, element);
    }

    
}
