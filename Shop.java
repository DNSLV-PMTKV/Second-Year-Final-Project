import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop{
    private String Name;
    private ArrayList<stock> stocks = new ArrayList<>();
    private ArrayList<cashier> cashiers = new ArrayList<>();
    private ArrayList<stock> cart = new ArrayList<>();
    private static float income;
    private static int receiptCount;

    public Shop(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<stock> getStocks() {
        return stocks;
    }

    public ArrayList<cashier> getCashiers() {
        return cashiers;
    }

    public ArrayList<stock> getCart() {
        return cart;
    }

    public void addStock(stock s, int count) {
        for (int i = 0 ; i < count ; i ++) {
            stocks.add(s);
        }
    }

    public void addCashier(cashier c) {
        cashiers.add(c);
    }

    public void checkIncome() {
        System.out.println("Income: " + income);
    }



    public int countStock(stock s) {
        int cnt = 0;
        for (stock f : stocks) {
            if (f.getName().equals(s.getName())) {
                cnt++;
            }
        }
        return cnt;
    }

    public void RemoveFromGoods(stock g,int n){
        for(int i = 0;i<n;i++) {
            stocks.remove(g);
        }
    }

    public void readReceipt(String name) {
        try {
            File input = new File(name);
            Scanner smth= new Scanner(input);
            while(smth.hasNextLine()) {
                String asd = smth.nextLine();
                System.out.println(asd);
            }
        }
        catch(FileNotFoundException e) {
            System.err.println("Eror");
        }

    }



}


