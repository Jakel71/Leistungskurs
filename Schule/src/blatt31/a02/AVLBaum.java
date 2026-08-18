package blatt31.a02;

public class AVLBaum {
    private Node root;

    public AVLBaum() {}

    public AVLBaum(Node root) {
        this.root = root;
    }

    public Node search(int value){
        Node current = this.root;
        while(current != null){
            if(current.getValue() == value){
                return current;
            }
            if(current.getValue()<value){
                current = current.getRight();
            } else{
                current = current.getLeft();
            }
        }
        return null;
    }

    public void add(int value){
        Node current = this.root;
        while(current != null){
            if(current.getValue()<value){
                if(current.getRight() == null){
                    current.setRight(new Node(value));
                    break;
                }
                current = current.getRight();
            }else{
                if(current.getLeft() == null){
                    current.setLeft(new Node(value));
                    break;
                }
                current = current.getLeft();
            }
        }
        while(current!=this.root){
            current.update();
            current = this.getParent(current);
        }
    }

    private Node getParent(Node target){
        Node current = this.root;
        while(current != null){
            if(current.getRight() == target || current.getLeft() == target){
                return current;
            }
            if(current.getValue()<target.getValue()){
                current = current.getRight();
            } else{
                current = current.getLeft();
            }
        }
        return null;
    }

    public Node remove(int value){
        Node toDelete = this.search(value);
        if(toDelete == null){
            return null;
        }
        Node parent = this.getParent(toDelete);
        if(toDelete==this.root) { // Sonderfall: wir wollen Root überschreiben:
            Node[] neighbours = toDelete.findInOrderNeighbour();
            if(neighbours[1] != null){
                this.remove(neighbours[1].getValue());
                neighbours[1].setRight(toDelete.getRight());
                neighbours[1].setLeft(toDelete.getLeft());
                this.root = neighbours[1];
            }else{
                this.remove(neighbours[0].getValue());
                neighbours[0].setRight(toDelete.getRight());
                neighbours[0].setLeft(toDelete.getLeft());
                this.root = neighbours[0];
            }
            return toDelete;
        }else if(toDelete.getRight() == null && toDelete.getLeft() == null){
            if(parent.getLeft()==toDelete){
                parent.setLeft(null);
            } else{
                parent.setRight(null);
            }
        } else if(toDelete.getLeft() == null &&  toDelete.getRight() != null){
            if(parent.getRight()==toDelete){
                parent.setRight(toDelete.getRight());
            } else{
                parent.setLeft(toDelete.getRight());
            }
        } else if(toDelete.getLeft() != null && toDelete.getRight() == null){
            if(parent.getRight()==toDelete){
                parent.setRight(toDelete.getLeft());
            }  else{
                parent.setLeft(toDelete.getLeft());
            }
        } else{ //Hat zwei Kinder:
                Node[] neighbours = toDelete.findInOrderNeighbour();
                if(neighbours[1] != null){
                    this.remove(neighbours[1].getValue());
                    neighbours[1].setRight(toDelete.getRight());
                    neighbours[1].setLeft(toDelete.getLeft());
                    if(parent.getRight()==toDelete){
                        parent.setRight(neighbours[1]);
                    } else{
                        parent.setLeft(neighbours[1]);
                    }
                }else{
                    this.remove(neighbours[0].getValue());
                    neighbours[0].setRight(toDelete.getRight());
                    neighbours[0].setLeft(toDelete.getLeft());

                    if(parent.getRight()==toDelete){
                        parent.setRight(neighbours[0]);
                    } else{
                        parent.setLeft(neighbours[0]);
                    }
                }
            }

        Node current = parent;
        while(current!=this.root){
            current.update();
            current = this.getParent(current);
        }
        return toDelete;
    }

    public int depht(){
        return dephtDFS(this.root);
    }
    private int dephtDFS(Node current){
        if(current==null){
            return 0;
        }else{
            return (1 + Math.max(dephtDFS(current.getLeft()), dephtDFS(current.getRight())));
        }
    }

    public int count(){
        return countAlgo(this.root);
    }

    private int countAlgo(Node current){
        if(current==null){
            return 0;
        }
        return 1 + countAlgo(current.getLeft()) + countAlgo(current.getRight());
    }

    public void preOrder(){
        System.out.println("Pre Order:");
        preOrderSout(this.root);
    }

    private void rotateLeft(Node current){
    	Node newRoot = current.getRight();
    	current.setRight(newRoot.getLeft());
    	newRoot.setLeft(current);
    	Node parent = this.getParent(current);
    	if(parent == null){
    		this.root = newRoot;
    	} else if(parent.getLeft() == current){
    		parent.setLeft(newRoot);
    	} else{
    		parent.setRight(newRoot);
    	}
    }

    private void rotateRight(Node current){
        Node newRoot = current.getLeft();
        current.setLeft(newRoot.getRight());
        newRoot.setRight(current);
        Node parent = this.getParent(current);
        if(parent == null){
            this.root = newRoot;
        } else if(parent.getLeft() == current){
            parent.setLeft(newRoot);
        } else{
            parent.setRight(newRoot);
        }
    }

    private void preOrderSout(Node current){
        String left = "null";
        if(current.getLeft()!=null){
            left =  current.getLeft().getValue()+"";
        }
        String right = "null";
        if(current.getRight()!=null){
            right =  current.getRight().getValue()+"";
        }
        System.out.println(current.getValue() + ", " + left + ", " + right + "; ");
        if(current.getLeft() != null){
            preOrderSout(current.getLeft());
        }
        if(current.getRight() != null){
            preOrderSout(current.getRight());
        }
    }

    public void inOrder(){
        System.out.println("In Order:");
        inOrderSout(this.root);
    }

    private void inOrderSout(Node current){
        String left = "null";
        if(current.getLeft()!=null){
            left =  current.getLeft().getValue()+"";
        }
        String right = "null";
        if(current.getRight()!=null){
            right =  current.getRight().getValue()+"";
        }
        System.out.println(left + ", " + current.getValue() + ", " + right + "; ");
        if(current.getLeft() != null){
            inOrderSout(current.getLeft());
        }
        if(current.getRight() != null){
            inOrderSout(current.getRight());
        }
    }

    public void postOrder(){
        System.out.println("Post Order:");
        postOrderSout(this.root);
    }

    private void postOrderSout(Node current){
        String left = "null";
        if(current.getLeft()!=null){
            left =  current.getLeft().getValue()+"";
        }
        String right = "null";
        if(current.getRight()!=null){
            right =  current.getRight().getValue()+"";
        }
        System.out.println(left + ", " + right + ", " + current.getValue() + "; ");
        if(current.getLeft() != null){
            postOrderSout(current.getLeft());
        }
        if(current.getRight() != null){
            postOrderSout(current.getRight());
        }
    }

    public int[] toArray(){
        Node[] arr = new Node[(int) Math.pow(2, this.depht()) - 1];
        arr[0]=this.root;
        int i =0;
        Node current;
        while(i < arr.length - 1 && 2 * i + 2 < arr.length && arr[i] != null) {
            current = arr[i];
            arr[2*i+1]=current.getLeft();
            arr[2*i+2]= current.getRight();
            i++;
        }
        int[] result = new int[arr.length];
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=null) {
                result[j] = arr[j].getValue();
            }
        }
        return result;
    }
}
