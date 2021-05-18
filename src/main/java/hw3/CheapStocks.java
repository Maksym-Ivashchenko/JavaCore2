package hw3;

import java.util.*;

public class CheapStocks {
    public String getCheapStocks(String[] stocks) {
        int j = 0;
        String result = "";
        for (String stock: stocks) {
            String[] parts = stock.split(" ");
            String title = parts[0]; //gun
            int number = Integer.parseInt(parts[1]); //500
            if (number < 200) {
                result += title + " ";
            }
        } return result.strip();
    }
    public static void main(String[] args) {
        CheapStocks cheapStocks = new CheapStocks();
        System.out.println(cheapStocks.getCheapStocks(new String[] {"ak 602", "Six 530", "laoma 502", "hecaw 647", "le 170", "Itep 679", "wyu 883", "Te 538", "Siker 421", "Xijo 91", "Ycro 121", "My 282"}));
    }
}
