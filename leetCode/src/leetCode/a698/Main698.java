package leetCode.a698;

import java.util.Arrays;

//回溯
public class Main698 {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		if(sum%k != 0) {
			return false;
		}
		sum = sum/k;
		int bucket[] = new int[k];
		Arrays.fill(bucket, sum);
		Arrays.sort(nums);
		return backTrack(nums,nums.length-1,bucket,k);
    }
	private boolean backTrack(int[] nums,int cur,int[] bucket,int k) {
		if(cur < 0) {
			return true;
		}
		for(int i = 0;i<k;i++) {
			if(bucket[i] == nums[cur]||(cur>0 && bucket[i]-nums[cur] >= nums[0])) {
				bucket[i] -= nums[cur];
				if(backTrack(nums,cur-1,bucket,k)) {
					return true;
				}
				bucket[i] += nums[cur];
			}
		}
		return false;
	}
}
