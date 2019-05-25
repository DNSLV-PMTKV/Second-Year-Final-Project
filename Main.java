public class Main {

    public static void main(String[] args) {
        cashier c1 = new cashier("Ivan");
        cashier c2 = new cashier("Mitko");

        stock s1 = new stock(1, "Kartof", 1.20, "12-12-12");
        stock s2 = new stock(2, "Domat", 2.05, "13-13-13");

        Shop shop = new Shop("Avanti");
        shop.addCashier(c1);
        shop.addCashier(c2);

        shop.addStock(s1, 10);
        shop.addStock(s2, 15);

        payDesk firstDesk = new payDesk(shop, c1);
        payDesk secondDesk = new payDesk(shop, c2);

        Thread one = new Thread(firstDesk, "First");
        Thread two = new Thread(secondDesk, "Second");

        System.out.println(shop.getStocks());

        try {
            firstDesk.sell(s1, 2);
            firstDesk.sell(s2, 2);
            one.start();
            secondDesk.sell(s1,14);
            secondDesk.sell(s2,2);
            two.start();
        }catch(OutOfStock e){
            System.err.println(e);
        }

        try {
            one.join();
            two.join();

        }catch (InterruptedException e){

        }

        shop.readReceipt("1.txt");

        System.out.println(shop.getStocks());

    }
}