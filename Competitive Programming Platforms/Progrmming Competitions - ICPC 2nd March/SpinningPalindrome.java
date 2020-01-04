import java.util.*;
class Solution {
	static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		String s=in.nextLine();
		int[] num=new int[s.length()];
		for(int i=0;i<s.length();i++)num[i]=Integer.parseInt(s.substring(s.length()-i-1, s.length()-i));
		int[][] dp=new int[s.length()/2][4];
		for(int[] i:dp)Arrays.fill(i, Integer.MAX_VALUE);
		System.out.println(Math.min(recurse(num, dp, 0, 0), recurse(num,dp,0,2)));
	}
	private static int recurse(int[] num, int[][] dp, int index, int end) {
		int low=num[index],high=num[num.length-index-1], min=Integer.MAX_VALUE/100;
		if(index==num.length-index-1) {
			if(end==0)return 0;
			if(end==1)return low==9?Integer.MAX_VALUE/100:0;
			if(end==2)return 10-low;
			if(end==3)return 10-(low+1);
		}
		if(index+1==num.length-index-1) {
			if(end==0) {
				min=Math.min(min, Math.abs(low-high));
				if(high<9)min=Math.min(min, (10-low)+(high+1));
				return min;
			}
			if(end==1) {
				if(low==9&&high==9)return Integer.MAX_VALUE/100;
				if(low==9) return high+1;
				min=Math.min(min, Math.abs(high-(low+1)));
				if(high<9)min=Math.min(min, (10-(low+1))+(high+1));
				return min;
			}
			if(end==2) return Math.min((10-high)+low, (10-(high+1))+(10-low));
			if(end==3) {
				if(low==9)return 10-(high+1);
				else return Math.min((10-high)+low+1, (10-high+1)+(10-(low+1)));
			}
		}
		if(dp[index][end]<Integer.MAX_VALUE)return dp[index][end];
		if (end==0) {//lower number didn't end into us, upper number doesn't have end
			min=Math.min(min, Math.abs(high-low)+recurse(num,dp,index+1,0));
			min=Math.min(min, high+(10-low)+recurse(num,dp,index+1,1));
			if(high<9) {
				min=Math.min(min, Math.abs(low-(high+1))+recurse(num,dp,index+1,2));
				min=Math.min(min, (high+1)+(10-low)+recurse(num,dp,index+1,3));
			}
		} else if(end==1) {
			if(low<9)min=Math.min(min, Math.abs((low+1)-high)+recurse(num,dp,index+1,0));
			min=Math.min(min, high+(10-(low+1))+recurse(num,dp,index+1,1));
			if(high<9) {
				if(low<9)min=Math.min(min, Math.abs((low+1)-(high+1))+recurse(num,dp,index+1,2));
				min=Math.min(min, (high+1)+(10-(low+1))+recurse(num,dp,index+1,3));
			}
		} else if(end==2) {
			min=Math.min(min, (10-high)+low+recurse(num,dp,index+1,0));
			min=Math.min(min, (10-high)+(10-low)+recurse(num,dp,index+1,1));
			min=Math.min(min, (10-(high+1))+low+recurse(num,dp,index+1,2));
			min=Math.min(min, (10-(high+1))+(10-low)+recurse(num,dp,index+1,3));
		} else {
			if(low<9)min=Math.min(min, (10-high)+(low+1)+recurse(num,dp,index+1,0));
			min=Math.min(min, (10-high)+(10-(low+1))+recurse(num,dp,index+1,1));
			if(low<9) min=Math.min(min, (10-(high+1))+(low+1)+recurse(num,dp,index+1,2));
			min=Math.min(min, (10-(high+1))+(10-(low+1))+recurse(num,dp,index+1,3));
		}
		dp[index][end]=min;
		return dp[index][end];
	}
 
}