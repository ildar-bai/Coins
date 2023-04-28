import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ChangeMoney {

    public static void main(String[] args) {
        System.out.println("Введите номинал монет, после каждого значения ставьте пробел и в конце поставьте точку");
        System.out.println("Пример: x1 x2 x3 .");
        Scanner inputCoins = new Scanner(System.in);
        ArrayList<Integer> coins = new ArrayList();
        int n = 0;
        do {
            coins.add(inputCoins.nextInt());
            n++;
        }
        while(inputCoins.hasNextInt());

        System.out.println("Введите сумму которую необходимо разменять");
        Scanner inputSum = new Scanner(System.in);
        int sum = inputSum.nextInt();

        Collections.sort(coins);

        System.out.println(calculate(sum, n, coins));

    }

    public static int calculate(int sum, int coinsQuantity, ArrayList<Integer> coins) {
        if (sum == 0)
            return 1;
        if ((sum < 0) | (coinsQuantity == 0))
            return 0;
        else return calculate(sum, coinsQuantity-1, coins) +
                calculate(sum - maxCoin(coinsQuantity, coins), coinsQuantity, coins);
    }
    public static int maxCoin(int coinsQuantity, ArrayList<Integer> list){
        return list.get(coinsQuantity - 1);
    }
}
