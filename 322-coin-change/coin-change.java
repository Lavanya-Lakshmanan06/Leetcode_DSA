class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        if(amount<1){
            return 0;
        }
        for(int i=1;i<=amount;i++){
            for(int coin : coins){
                if(coin<=i){
                    dp[i]=Math.min(dp[i],1+dp[i-coin]);
                }
            }
        }
         return dp[amount] > amount ? -1 : dp[amount];
    }
}