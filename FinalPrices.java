import java.util.*;

public class FinalPrices {
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int j = stack.pop();
                prices[j] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter prices (space-separated):");
        int[] prices = Arrays.stream(sc.nextLine().split(" "))
                             .mapToInt(Integer::parseInt).toArray();
        int[] result = finalPrices(prices);
        System.out.println("Final prices: " + Arrays.toString(result));
    }
}

