import java.util.ArrayList;

public class BinaryTree {
    private ArrayList<Node> items;
    public BinaryTree(ArrayList<Integer> item) {
        this.items = new ArrayList<Node>();
        for(int i = 0;i<item.size();i++) {
            Node f = new Node(item.get(i));
            this.items.add(f);
        }
        for(int j = 1;j<items.size();j++) {
            Node current = this.items.get(0);  
            while ((current.getValue() > this.items.get(j).getValue() && current.getLeft() != null)  || (current.getValue() < this.items.get(j).getValue() && current.getRight() != null)) {
                if (current.getValue() < this.items.get(j).getValue()) {
                    Node temp = current.getRight();
                    current = temp;
                }
                else {
                    Node temp = current.getLeft();
                    current = temp;
                }
            }
            if (current.getValue() < this.items.get(j).getValue()) {
                current.setRight(this.items.get(j));
            }
            else {
                current.setLeft(this.items.get(j));
            }
        }
        }
    public ArrayList<Node> getItems() {
        return this.items;
    }

public int getHeight(Node h) {
    if (h.getLeft() == null && h.getRight() == null) {
        return 1;
    } 
    if (h.getLeft() != null && h.getRight() == null) {
        return 1 + getHeight(h.getLeft());
    }
    if (h.getLeft() == null && h.getRight() != null) {
        return 1 + getHeight(h.getRight());
    }
    else {
        return 1 + max(getHeight(h.getLeft()),getHeight(h.getRight()));
    }

    }
    private int max(int height, int height2) {
        if (height > height2) {
            return height;
        }
        else {
            return height2;
        }
    }

public boolean isAVL() {
    boolean AVL = true;
    for(int i = 0;i<this.items.size();i++) {
        int left = 0;
        int right = 0;
        if (this.items.get((i)).getLeft() != null) {
            left = getHeight(this.items.get((i)).getLeft());
        }
        if (this.items.get((i)).getRight() != null) {
            right = getHeight(this.items.get((i)).getRight());
        }
        if (Math.abs(left - right) >= 2) {
            AVL = false;
            break;
        }
    }
    return AVL;
}

public void reBalanceSimple(Node n) {
        Node temp = new Node(n.getValue());
        temp.setLeft(n.getLeft().getRight());
        n = n.getLeft();
        

}


public void print(Node c) {
        print("", c, false);
    }

    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.getValue());
            print(prefix + (isLeft ? "|   " : "    "), n.getLeft(), true);
            print(prefix + (isLeft ? "|   " : "    "), n.getRight(), false);
        }
    }
        


}
