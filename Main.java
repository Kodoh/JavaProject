import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Please enter your name - ");
        String name = read.nextLine();
        System.out.println("Please enter your age - ");
        int age = read.nextInt();
        read.close();
        Player p1 = new Player(name,age);
        System.out.println("Your name is " + p1.getName());
    }
}

