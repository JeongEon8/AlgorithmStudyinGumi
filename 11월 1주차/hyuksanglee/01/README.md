# [백준 - 골드 3] 1238. 파티
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
다익스트라

## ⏲️**Time Complexity**
$O(N²+M)$

## :round_pushpin: **Logic**
1. 다익스트라 2개 이용한다.
	- 하나는 모든 지점에서 특정 지점까지 도착하는 최단 시간이고 나머지 하나는 특정 지점에서 모든 지점까지 최단시간 이다

2. 출발과 도착 배열을 for문을 돌면서 왕복 시간을 구하고 최대 시간과 비교하여 갱신 하고 마지막에는 출력해준다.
   ```java
	public static void dijkstra(int n,  int sum) {
		Queue<Student> que = new ArrayDeque();
		Student student = new Student();
		student.current = n;
		student.total = sum;
		que.add(student);
		while(!que.isEmpty()) {
			Student cStudent = que.poll();
			int cn = cStudent.current;
			int ct = cStudent.total;
			
			for(int i =0; i<N; i++) {
				int total = sum+map[cn][i]+ct;
			
				if(map[cn][i]!=0 && start[i]>total) {
					student = new Student();
					student.current = i;
					student.total = total;
					que.add(student);
					start[i]=total;
				}
			}
		}
		
	}
	
	public static void rDijkstra(int n,  int sum) {
		Queue<Student> que = new ArrayDeque();
		Student student = new Student();
		student.current = n;
		student.total = sum;
		que.add(student);
		while(!que.isEmpty()) {
			Student cStudent = que.poll();
			int cn = cStudent.current;
			int ct = cStudent.total;
			
			for(int i =0; i<N; i++) {
				int total = sum+map[i][cn]+ct;
			
				if(map[i][cn]!=0 && end[i]>total) {
					student = new Student();
					student.current = i;
					student.total = total;
					que.add(student);
					end[i]=total;
				}
			}
		}
		
	}
   ```

## :black_nib: **Review**
- 다익스트라 문제를 오랜만에 풀려고 하니깐 어떻게 풀어야할지 처음에 헤맷어요

## 📡 Link
https://www.acmicpc.net/problem/1238
