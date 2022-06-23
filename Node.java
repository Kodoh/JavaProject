public class Node {
    private Node left;
    private Node right;
    private int value;
    public Node (int value) {
        this.left = this.right = null;
        this.value = value;
    }
    public Node getLeft() {
        return this.left;
    }
    public Node getRight() {
        return this.right;
    }
    public int getValue() {
        return this.value;
    }
    public void setLeft(Node newLeft) {
        this.left = newLeft;
    }
    public void setRight(Node newRight) {
        this.right = newRight;
    }

}
