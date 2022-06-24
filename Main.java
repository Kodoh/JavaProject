import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(4);
        test.add(2);
        test.add(1);
        test.add(3);
        BinaryTree first = new BinaryTree(test);
        ArrayList<Node> items = first.getItems();
        first.insert(5);
        first.postorder(items.get(0));
    }
}

