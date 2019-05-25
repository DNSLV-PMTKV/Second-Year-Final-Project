import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.io.FileOutputStream;


public class receipt implements Revenue{
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private static int count = 1;
    private int ID;
    private cashier cashier;
    private Date date;
    private ArrayList<stock> items;


    public receipt(cashier cashierName, ArrayList<stock> items) {
        this.cashier = cashierName;
        this.items = items;
        this.date = new Date();
        this.ID = count;
        count ++;
    }


    public int getID() {
        return ID;
    }

    public String getCashierName() {
        return cashier.getName();
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<stock> getItems() {
        return items;
    }

    @Override
    public String toString() {
        float total = 0;
        String output = "Receipt "+ID+"\nDate: "+sdf.format(date)+"\nCashier: "+cashier.getName()+"\nItems:\n";
        for(stock f: items){
            output += f.getName() + "\t\t\t" + f.getPrice() + "BGN\n";
            total += f.getPrice();
        }
        output += "\t\t\t\t-----\n\t\t\t\t" + String.format("%.2f", total) + "BGN";

        return output;
    }

    public double totalProfit() {
        double sum=0;
        for(stock g: items)
        {
            sum+=g.getPrice();
        }
        return sum;
    }

    public void WriteToFile() {
        try {
            FileOutputStream f = new FileOutputStream(ID+".txt");
            byte[] str = this.toString().getBytes();
            f.write(str);
            f.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
