package coinchange;

/**
 * Created by MMA on 4/14/2016.
 */
public class CoinChange {

    public static void main(String[] args) {

        double money = 200.00;


        System.out.println("####### Greedy #######");
        int[] coins = changeGreedy(money);
        print(coins);

        /////////////////////////////////////////

        System.out.println("####### Dynamic Programming #######");
        int [] denominations = {1,5,10,25};
        int totalCoins = minChange(denominations, 200);
        System.out.println("Total coins by DP: " + totalCoins);




    }

    public static int[] changeGreedy(double money) {

        int[] denominations = new int[4];

        //        int dollars = (int) Math.floor(money/1);
//        money -= dollars * 1;


//        int quarters = (int) Math.floor(money / 0.25);
//        money -= quarters * 0.25;

        int quarters = (int) Math.floor(money / 25);
        money -= quarters * 25;

        int dimes = (int) Math.floor(money / 10);
        money -= dimes * 10;

        int nickels = (int) Math.floor(money / 5);
        money -= nickels * 5;

        int pennies = (int) Math.round(money * 1);

        denominations[0] = quarters;
        denominations[1] = dimes;
        denominations[2] = nickels;
        denominations[3] = pennies;

        return denominations;

    }

    public static int dynamic(int[] v, int amount) {
        int[][] solution = new int[v.length + 1][amount + 1];

        // if amount=0 then just return empty set to make the change
        for (int i = 0; i <= v.length; i++) {
            solution[i][0] = 1;
        }

        // if no coins given, 0 ways to change the amount
        for (int i = 1; i <= amount; i++) {
            solution[0][i] = 0;
        }

        // now fill rest of the matrix.

        for (int i = 1; i <= v.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // check if the coin value is less than the amount needed
                if (v[i - 1] <= j) {
                    // reduce the amount by coin value and
                    // use the subproblem solution (amount-v[i]) and
                    // add the solution from the top to it
                    solution[i][j] = solution[i - 1][j]
                            + solution[i][j - v[i - 1]];
                } else {
                    // just copy the value from the top
                    solution[i][j] = solution[i - 1][j];
                }
            }
        }
        return solution[v.length][amount];
    }

//    public static int minChange(double[] denom, int targetAmount) {
//
//        int actualAmount;
//        int m = denom.length+1;
//        int n = targetAmount + 1;
//        int inf = Integer.MAX_VALUE-1;
//
//        int[][] table = new int[m][n];
//        for (int j = 1; j < n; j++)
//            table[0][j] = inf;
//
//        for (int denomPosition = 1; denomPosition < m; denomPosition++) {
//            for (double currentAmount = 1; currentAmount < n; currentAmount++) {
//                if (currentAmount - denom[denomPosition-1] >= 0)
//                    actualAmount = table[denomPosition][currentAmount - denom[denomPosition-1]];
//                else
//                    actualAmount = inf;
//                table[denomPosition][currentAmount] = Math.min(table[denomPosition-1][currentAmount], 1 + actualAmount);
//            }
//        }
//
//        return table[m-1][n-1];
//
//    }

    public static int minChange(int[] denom, int targetAmount) {

        int actualAmount;
        int m = denom.length+1;
        int n = targetAmount + 1;
        int inf = Integer.MAX_VALUE-1;

        int[][] table = new int[m][n];
        for (int j = 1; j < n; j++)
            table[0][j] = inf;

        for (int denomPosition = 1; denomPosition < m; denomPosition++) {
            for (int currentAmount = 1; currentAmount < n; currentAmount++) {
                if (currentAmount - denom[denomPosition-1] >= 0)
                    actualAmount = table[denomPosition][currentAmount - denom[denomPosition-1]];
                else
                    actualAmount = inf;
                table[denomPosition][currentAmount] = Math.min(table[denomPosition-1][currentAmount], 1 + actualAmount);
            }
        }

        return table[m-1][n-1];

    }

//    public static int [] minChange(int[] denom, int targetAmount) {
//
//        int [] coins = new int[denom.length];
//
//        int actualAmount;
//        int m = denom.length+1;
//        int n = targetAmount + 1;
//        int inf = Integer.MAX_VALUE-1;
//
//        int[][] table = new int[m][n];
//        for (int j = 1; j < n; j++)
//            table[0][j] = inf;
//
//        for (int denomPosition = 1; denomPosition < m; denomPosition++) {
//            for (int currentAmount = 1; currentAmount < n; currentAmount++) {
//                if (currentAmount - denom[denomPosition-1] >= 0) {
//                    actualAmount = table[denomPosition][currentAmount - denom[denomPosition - 1]];
//                    coins[denomPosition-1]++;
//                }
//
//                else
//                    actualAmount = inf;
//                table[denomPosition][currentAmount] = Math.min(table[denomPosition-1][currentAmount], 1 + actualAmount);
//            }
//        }
//
//        return coins;
//
//    }

    public static void print(int[] denominations) {

        System.out.println("(25) coins: " + denominations[0]);
        System.out.println("(10) coins: " + denominations[1]);
        System.out.println("(5) coins: " + denominations[2]);
        System.out.println("(1) coins: " + denominations[3]);

    }


}
