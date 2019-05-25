public class cashier {
    private static int count = 1;
    private int ID;
    private String name;

    public cashier(String name) {
        this.ID = count;
        this.name = name;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }
}
