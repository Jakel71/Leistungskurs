package blatt30.a02;

public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
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
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
