package hw3;

public class ATM {
    public int countBanknotes(int sum) {
        int[] nominal = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int result =0;
        int i = 0;
        while (sum != 0) {
            while (sum < nominal[i]) {
                i++;
            }
                sum -= nominal[i];
            result++;

        } return result;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        //11
        System.out.println(atm.countBanknotes(3462));
        //19
        System.out.println(atm.countBanknotes(55));
    }
}
