package beakjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Sw1248 {
	
	static int V, E, a, b, count;
	static int[]arr;
	static int[] check;
	
	// 부모 찾기
	static void dfs(int n) {
		if(arr[n] == n) { // 부모가 자기 자신일때
			return;
		}
		
		check[arr[n]] +=1;	// 공통 조상을 찾기 위해 방문 여부 체크
		
		if(check[arr[n]] == 2) {	// 2이면 공통 조상이므로 리턴
			return;
		}
		
		dfs(arr[n]);	// 
	}
	
	// 자식 찾는 함수
	static void rdfs(int n ) {
		Queue<Integer> que = new LinkedList<>(); 
		que.offer(n);
		
		
		while(!que.isEmpty()) {
			int num = que.poll();
			for(int v = 1; v<=V; v++) {
				if(v==num) {	// 자기자신을 제외하기 위해
					continue;
				}
				if(arr[v] == num) {	// 부모가 num인 정수 찾기
					count++;
					que.offer(v);	// num자식인 정수 큐에 담기
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1248.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine()); // 케이스 개수 받기

		for (int t = 1; t <= T; t++) {	
			String [] input = in.readLine().split(" ");
			
			V = Integer.parseInt(input[0]);	// 정점개수 받기
			E = Integer.parseInt(input[1]);	// 간선 개수 받기
			
			// 두 정점 받기
			a = Integer.parseInt(input[2]);	
			b = Integer.parseInt(input[3]);
			
			arr = new int[V+1];	// 정점의 부모 정점 담는 배열
			check = new int[V+1];	// 공통 조상 찾을때 사용되는 배열
			
			// 정점 자기 자신으로 초기화
			for(int v= 0 ; v<=V; v++) {
				arr[v]=v;
			}
			
			input = in.readLine().split(" ");
			for(int e = 0; e<E*2; e = e+2) { // 연결된 두 정점을 자식정점에 부모정점 번호 입력 (정점에 바로 상위 정점이 누구 인지 확인가능하게)
				arr[Integer.parseInt(input[e+1])]=Integer.parseInt(input[e]);
			}
			
			dfs(a); // 하나의 정점의 조상이 누가 있는지 찾아서 check에 그 조상 정점번호에 1을 더해준다.
			
			dfs(b);	// 나머지 하나의 점정도 조상이 누가인지 찾아서 check에 1을 더해준다.
			
			int parent = 0;
			for(int i =1; i <=V; i++) {
				if(check[i] == 2) { // 2가 된부분이 두개의 정점의 공통조상이다.
					parent= i;
				}
			}
			
			count =0;
			rdfs(parent);	// 위에 조상 찾는 함수를 반대로 이제 해당정점에 자식이 누구인지 찾는 함수
			
			count +=1;	// 자기 자신도 포함해야해서 +1을 해준다.
			

			
			System.out.println("#"+t+" "+parent+" "+count);
		

			
		}

	}

}
