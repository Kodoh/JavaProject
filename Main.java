import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Please enter your name - ");
        String name = read.nextLine();
        System.out.println("Please enter your age - ");
        int age = Integer.parseInt(read.nextLine());
        System.out.println("ROLES include --> Mage // Khan // Tank // Ranger");
        System.out.println("Please enter your prefered role - ");
        String role = read.nextLine();
        read.close();
        Player p1 = new Player(name,age,role);
        String p1name = p1.getName();
        String p1age = Integer.toString(p1.getAge());
        System.out.println("Your name is " + p1name + " and age is " + p1age);

    }
}

