package leetCode.a514;

import java.util.Arrays;
/**
 *    ��̬�滮 dp[i][j] �����ring�ĵ�jλ��ʼ������key��ǰi���ַ���Ҫ�Ĵ�����j��ʾ��������12���ӷ�����ָ��λ��
 *    ״̬ת�Ʒ���Ϊ
 *    dp[i][j] = Math.min(dp[i][j],dp[i][k] + Math.min(Math.abs(n-j),n-Math.abs(n-j)))
 *    n��ʾring�ĳ���
 *    (��kλ��ת��jλ�ã�˳ʱ��ת���Ĵ��� + ��ʱ��ת���Ĵ��� = ring.length. ���ֻ��Ҫ����һ�������ϵ�ת��������
  �Ϳ��Եõ���һ�������ϵ�ת������)
  
 *    �߽���������ʼ״̬���� dp[0][j] = min(j, ring.length - j)
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
