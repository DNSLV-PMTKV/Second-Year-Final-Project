public class OutOfStock extends Exception {
    private int cnt;
    private stock item;

    public OutOfStock(int cnt, stock item){
        this.cnt = cnt;
        this.item = item;
    }

    public int getCnt() {
        return cnt;
    }

    public stock getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Not enough " + item + ".Needed " + cnt + " more.";
    }
}
