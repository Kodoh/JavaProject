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

public void insert(int x) {
    Node c = new Node(x);
    Node current = this.items.get(0);  
    while ((current.getValue() > c.getValue() && current.getLeft() != null)  || (current.getValue() < c.getValue() && current.getRight() != null)) {
        if (current.getValue() < c.getValue()) {
            Node temp = current.getRight();
            current = temp;
        }
        else {
            Node temp = current.getLeft();
            current = temp;
        }
    }
    if (current.getValue() < c.getValue()) {
        current.setRight(c);
    }
    else {
        current.setLeft(c);
    }
}

public void inorder(Node node) {
    if (node == null) {
        return;
    }
    inorder(node.getLeft());
    System.out.println(node.getValue() + " ");
    inorder(node.getRight());
    
}

public void preorder(Node node) {
    if (node == null) {
        return;
    }
    System.out.println(node.getValue() + " ");
    preorder(node.getLeft());
    preorder(node.getRight());
}

public void postorder(Node node) {
    if (node == null) {
        return;
    }
    postorder(node.getLeft());
    postorder(node.getRight());
    System.out.println(node.getValue() + " ");
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
        

public int getMin(Node node) {
    if (node.getLeft() == null) {
        return node.getValue();
    } else {
        return getMin(node.getLeft());
    }
}

public int getMax(Node node) {
    if (node.getRight() == null) {
        return node.getValue();
    } else {
        return getMax(node.getRight());
    }
}

public Node deleteNode(Node root, int key) {
    if(root == null) return root;
    if(key > root.getValue()){ //move right
        root.setRight(deleteNode(root.getRight(), key));
    }else if(key < root.getValue()){ //move left
        root.setLeft(deleteNode(root.getLeft(), key));
    }else{ //oh yes, we finally found the target
        if(root.getLeft() == null && root.getRight() == null){ //hmm, its a leaf node; easy peasy
            root = null;
        }else if(root.getRight() != null){ // oh, it has a getRight() child, don't make it an orphan or is it old enough to become a parent ? lets find out
            root.setValue(successor(root)); // my worthy successor
            root.setRight(deleteNode(root.getRight(), root.getValue()));
        }else{ //oh it seems that I do not have a worthy successor, fallback, fallback ...
            root.setValue(predecessor(root));
            root.setLeft(deleteNode(root.getLeft(), root.getValue()));
        }
    }
    return root;
}
/**
 * Return node's successor getValue()ue
 * @param root
 * @return
 */
private int successor(Node root){
    root = root.getRight();
    while(root.getLeft() != null){
        root = root.getLeft();
    }
    return root.getValue();
}
/**
 * Return node's predecessor getValue()ue
 * @param root
 * @return
 */
private int predecessor(Node root){
    root = root.getLeft();
    while(root.getRight() != null){
        root = root.getRight();
    }
    return root.getValue();
}
}


