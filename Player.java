public class Player {
    private String name;
    private int age;
    private String role;
    public Player(String name,int age,String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getRole() {
        return this.role;
    }
}