import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static class Group{
		int candy, population;

		public Group(int candy, int population) {
			this.candy = candy;
			this.population = population;
		}
	}
	
	static class Kid{
		int candy, parent;

		public Kid(int candy, int parent) {
			this.candy = candy;
			this.parent = parent;
		}
	}
	static Kid[] kArr;
	
	static int findParent(int idx) {
		if(kArr[idx].parent == idx) {
			return idx;
		}
		return kArr[idx].parent = findParent(kArr[idx].parent);
	}
	static boolean setGroup(Kid a, Kid b) {
		int aRoot = findParent(a.parent);
		int bRoot = findParent(b.parent); 
		if(aRoot==bRoot) {
			return false;
		}else {
			kArr[bRoot].parent = aRoot;
			return true;
		}
	}
	

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int k = Integer.parseInt(split[2]);
		kArr = new Kid[n+1];
		split = in.readLine().split(" ");
		for(int i = 1; i<=n; i++) {
			int c = Integer.parseInt(split[i-1]);
			kArr[i] = new Kid(c,i);
		}
		for(int i = 0; i<m;i++) {
			split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			setGroup(kArr[a],kArr[b]);
		}
		Map<Integer,Group> groupMap = new HashMap<>();
		List<Integer> kList = new ArrayList<>();
		kList.add(0);
		for(int i = 1; i<=n;i++) {
			int parent = findParent(i);
			int candy = kArr[i].candy;
			int population = 1;
			if(groupMap.containsKey(parent)) {
				Group group = groupMap.get(parent);
				candy += group.candy;
				population += group.population;
			}else {
				kList.add(parent);
			}
			groupMap.put(parent, new Group(candy,population));
		}      
		int[][] dp = new int[kList.size()][k];
		for(int i = 1; i<kList.size();i++) {
			Group g = groupMap.get(kList.get(i));
			for(int j = 1;j<k;j++) {
				if(g.population<=j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-g.population]+g.candy);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[kList.size()-1][k-1]);
		

	}

}