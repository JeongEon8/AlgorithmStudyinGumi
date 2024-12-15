package N32_물류허브;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

class Trie {
	int city;
	int cost;
	int visit;
	
	Map<Integer, Trie> chidren = new TreeMap<>();
	Trie(int city){
		this.city = city;
		this.cost = 0;
		this.visit = 0;
	}
	
	Trie(int city, int cost){
		this.city = city;
		this.cost = cost;
		this.visit = 0;
	}
	
	Trie(){
	}
}

class UserSolution {
	
	
	public static Set<Integer> set;
	public static Trie goHead;
	public static Trie backHead;
	public static int v;
	public int init(int N, int sCity[], int eCity[], int mCost[]) {
		set = new HashSet<Integer>();
		goHead = new Trie();
		backHead = new Trie();
		for(int n =0; n<N; n++) {
			if(!goHead.chidren.containsKey(sCity[n])) {
				Trie newTrie = new Trie(sCity[n]);
				goHead.chidren.put(sCity[n], newTrie);
			}
			Trie trie = goHead.chidren.get(sCity[n]);
			Trie newTrie = new Trie(eCity[n],mCost[n]);
			trie.chidren.put(eCity[n], newTrie);
			
			if(!backHead.chidren.containsKey(eCity[n])) {
				newTrie = new Trie(eCity[n]);
				backHead.chidren.put(eCity[n], newTrie);
			}
			trie = backHead.chidren.get(eCity[n]);
			newTrie = new Trie(sCity[n],mCost[n]);
			trie.chidren.put(sCity[n], newTrie);
			
			set.add(sCity[n]);
			set.add(eCity[n]);
		}
		
		return set.size();
	}

	public void add(int sCity, int eCity, int mCost) {
		
		if(!goHead.chidren.containsKey(sCity)) {
			Trie newTrie = new Trie(sCity);
			goHead.chidren.put(sCity, newTrie);
		}
		Trie trie = goHead.chidren.get(sCity);
		Trie newTrie = new Trie(eCity,mCost);
		trie.chidren.put(eCity, newTrie);
		
			trie.visit=v;
		
		
		if(!backHead.chidren.containsKey(eCity)) {
			newTrie = new Trie(eCity);
			backHead.chidren.put(eCity, newTrie);
		}
		trie = backHead.chidren.get(eCity);
		newTrie = new Trie(sCity,mCost);
		trie.chidren.put(sCity, newTrie);
		
			trie.visit=v;
		
		
		
		return;
	}

	public static int dijkstra(int start, Trie head) {
		PriorityQueue<Trie> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		q.add(head.chidren.get(start));
		Map<Integer, Integer> map = new TreeMap();
		for(int i : set) {
			if(i!=start) {
				map.put(i, Integer.MAX_VALUE);
			}else {
				map.put(i, 0);
			}
			
		}
		while(!q.isEmpty()) {
			Trie trie = q.poll();
//			System.out.println("도시: " + trie.city);
			trie.visit +=1;
			v= trie.visit;
			for(Map.Entry<Integer, Trie> entry : trie.chidren.entrySet()) {
				
				if(entry.getValue().visit!= trie.visit) {
					int c = map.get(entry.getValue().city);
					if(c>entry.getValue().cost+map.get(trie.city)) {
						map.put(entry.getValue().city, entry.getValue().cost+map.get(trie.city));
						q.add(head.chidren.get(entry.getValue().city));
//						System.out.println("도시: " + entry.getValue().city + ", 비용: " + entry.getValue().cost+ ", visit: " + entry.getValue().visit+ ", visit2: " + map.get(trie.city));
					}
				}
			}
			
		}
		
		int total = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println("도시: "+entry.getKey() + ", 비용: "+ entry.getValue());
            total+=entry.getValue();
        }
		return total;
		
	}

	public int cost(int mHub) {
		
		

		return dijkstra(mHub,goHead)+dijkstra(mHub,backHead);
	}
}
