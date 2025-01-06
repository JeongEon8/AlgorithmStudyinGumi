# [SWEA] 물류허브
 
## ⏰  **time**
5시간

## :pushpin: **Algorithm**
트라이, 다익스트라

## ⏲️**Time Complexity**
$O(Nlog(N))$

## :round_pushpin: **Logic**
1. 입력 받은 도시에 정보를 출발 지점을 부모로 하고 도착 지점을 자식으로 하여 트라이 클래스에 담기
2. 돌아오는 최소 비용도 계산 해야하므로 도착지점과 출발지점이 반대로 하여 한개 더 만들기
3. init 단계에서는 도착 지점과 출발지점 도시를 set함수에 넣고 set size 를 리턴 해준다.
4. cost는 해당 허브에서 다익스트라 이용해서 최소 비용 구하기
   ```java
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

			trie.visit +=1;
			v= trie.visit;
			for(Map.Entry<Integer, Trie> entry : trie.chidren.entrySet()) {
				
				if(entry.getValue().visit!= trie.visit) {
					int c = map.get(entry.getValue().city);
					if(c>entry.getValue().cost+map.get(trie.city)) {
						map.put(entry.getValue().city, entry.getValue().cost+map.get(trie.city));
						q.add(head.chidren.get(entry.getValue().city));

					}
				}
			}
			
		}
		
		int total = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            total+=entry.getValue();
        }
		return total;
		
	}
   ```

## :black_nib: **Review**
- 이거 풀다가 머리 터질뻔했어요

## 📡 Link
https://swexpertacademy.com/main/code/codeBattle/problemDetail.do?contestProbId=AYYj7xj6TVsDFARc&categoryId=AY1INdsqPvADFAWX&categoryType=BATTLE&battleMainPageIndex=1
