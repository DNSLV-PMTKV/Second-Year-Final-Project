import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class payDesk implements Runnable {
    private Shop shop;
    private cashier worker;
    private ArrayList<stock> sold;
    private receipt r;

    public payDesk(Shop shop, cashier worker) {
        this.shop = shop;
        this.worker = worker;
        this.sold = new ArrayList<>();
    }
    public void addToList(stock s, int count){
        for (int i = 0; i < count ; i++){
            sold.add(s);
        }
    }
    public void sell(stock s, int count) throws OutOfStock{
        int productCount = shop.countStock(s);
        if(productCount < count){
            throw new OutOfStock(count-productCount, s);
        }
        else{
            shop.RemoveFromGoods(s, count);
            addToList(s, count);
        }
    }
    public synchronized receipt makeReceipt(){
        receipt r = new receipt(this.worker,this.sold);
        r.WriteToFile();
        return r;
    }

    @Override
    public void run(){
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));
        System.out.println(shop.getName()+":Cashier's name is " + worker.getName() + ". \nTotal sum:  " + makeReceipt().totalProfit());
        sold.removeAll(sold);
    }

}
