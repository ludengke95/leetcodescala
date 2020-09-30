/**
 * 描述:
 *
 * @author ludengke
 * @create 2020-09-29 11:42
 */
public class LeetCodeLCP19 {
    public int minimumOperations(String leaves) {
        int[][] dp = new int[3][leaves.length()];
        for (int i = 0; i < leaves.length(); i++) {
            dp[0][i] = i == 0 ? 0 : dp[0][i - 1];
            if (leaves.charAt(i) == 'y') {
                dp[0][i] += 1;
            }
            if(i>0){
                dp[1][i] = i == 1? dp[0][i-1] :Math.min(dp[1][i-1],dp[0][i-1]);
                if (leaves.charAt(i) == 'r') {
                    dp[1][i] += 1;
                }
            }
            if(i>1){
                dp[2][i] = i <= 2? dp[1][i-1] :Math.min(dp[2][i-1],dp[1][i-1]);
                if (leaves.charAt(i) == 'y') {
                    dp[2][i] += 1;
                }
            }
        }
        return dp[2][leaves.length() - 1];
    }

    public static void main(String[] args) {
        LeetCodeLCP19 l = new LeetCodeLCP19();
        System.out.println(l.minimumOperations("rrryyyrryyyrr"));
        System.out.println(l.minimumOperations("ryr"));
    }
}
