package learning.array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    /**
     * 思路：求两数的差的和
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length < 3) {
            return 0;
        }
        int sum = 0;
        int begin = prices[0];
        int temp = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < temp) {
                sum += (temp - begin);
                begin = prices[i];
            }
            temp = prices[i];

            if (i == (prices.length - 1)) {
                sum += (temp - begin);
            }
        }
        return sum;
    }
}
