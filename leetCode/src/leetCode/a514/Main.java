package leetCode.a514;

import java.util.Arrays;
/**
 *    动态规划 dp[i][j] 代表从ring的第j位开始搜索出key的前i个字符需要的次数，j表示搜索到后12点钟方向所指的位置
 *    状态转移方程为
 *    dp[i][j] = Math.min(dp[i][j],dp[i][k] + Math.min(Math.abs(n-j),n-Math.abs(n-j)))
 *    n表示ring的长度
 *    (从k位置转到j位置，顺时针转动的次数 + 逆时针转动的次数 = ring.length. 因此只需要计算一个方向上的转动次数，
  就可以得到另一个方向上的转动次数)
  
 *    边界条件（初始状态）： dp[0][j] = min(j, ring.length - j)
 * @author LSIR
 *
 */
public class Main {
	public int findRotateSteps(String ring, String key) {
        char[] sring = ring.toCharArray();
        char[] skey = key.toCharArray();
        int n = sring.length;
        int[][] dp = new int[skey.length][n];
        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int count = Integer.MAX_VALUE;
        for(int i=0;i<skey.length;i++){
            for(int j=0;j<n;j++){
                if(skey[i] == sring[j]){
                    if(i == 0){
                        dp[i][j] = Math.min(j,n-j);
                    }else{
                        for(int k=0;k<n;k++){
                            if(dp[i - 1][k] != Integer.MAX_VALUE){
                                dp[i][j] = Math.min(dp[i][j],dp[i-1][k] + Math.min(Math.abs(j-k),n - Math.abs(j-k)));
                            }
                        }
                    }
                }
                if(i == skey.length -1){
                    count = Math.min(count,dp[i][j]);
                }
            }
        }
        return count+skey.length;
    }
}
