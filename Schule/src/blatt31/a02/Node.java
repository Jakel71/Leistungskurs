package blatt31.a02;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private int balance;

    public Node(int value) {
        this.value = value; this.balance = 0;
    }

    public Node[] findInOrderNeighbour(){
        Node[] neighbours = new Node[2];
        Node current = this.getLeft();
        while(current.getRight() != null){
            current = current.getRight();
        }
        neighbours[0] = current;
        current =  this.getRight();
        while(current.getLeft() != null){
            current = current.getLeft();
        }
        neighbours[1] = current;
        return neighbours;

    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getBalance() {
        return this.balance;
    }

    public void update(){
        this.balance = this.right.hoehe() - this.left.hoehe();
    }

    private int hoehe(){
        if(this.right == null && this.left == null){
            return 1;
        }
        return 1 + Math.max(this.right.hoehe(), this.left.hoehe());
    }
}
