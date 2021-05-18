package hw3;

class MyTraining {
    public int[] removePrice(int[] prices, int toRemove) {
        if (prices.length == 0) {
            return new int[0];
        }

        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] != toRemove) {
                result++;
            }}
        int[] priceRemote = new int[result];
        for (int i = 0, j=0; i < prices.length; i++, j++) {
            if (prices[i] != toRemove) {
                priceRemote[j] = prices[i];
            } else j--;
        }
        return priceRemote;
    }
    public int getMinPriceCount(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
        }return min;
    }
    public String drawPattern(char[] pattern, int repeatCount) {
        String word = new String();
        for (; repeatCount > 0; repeatCount--) {
            for (int i = 0; i < pattern.length; i++) {
                word += String.valueOf(pattern[i]);
            }
        }
        return word;
    }
    public int countBanknotes(int sum) {
        int result = 1;
        int[] nominal = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int ost = sum % 500;
        int ost1 = 9%5;
        return ost1;
    }
    public static void main(String[] args) {
        MyTraining myTraining = new MyTraining();
        //1
        //System.out.println(atm.countBanknotes(500));
        //6
        System.out.println(myTraining.countBanknotes(578));
    }
}
