public class stock {
    private int ID;
    private String name;
    private double price;
    private String expireDate;

    public stock(int ID, String name, double price, String expireDate) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.expireDate = expireDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return name;
    }
}
