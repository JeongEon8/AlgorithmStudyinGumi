# [백준 - G4] 1043. 거짓말

## ⏰ **time**

75분

## :pushpin: **Algorithm**
- 그래프

## ⏲️**Time Complexity**

$O(N²)$

## :round_pushpin: **Logic**
- 진실을 알고 있는 사람을 배열에 담는다
```java
   int K = Integer.parseInt(input[0]);
		for(int k = 0; k<K; k++) {
			arr[Integer.parseInt(input[k+1])]=true;
		}
```
- 파티에 참여하는 사람들끼리 연결리스트로 표시 해준다.
```java
   for(int m=0; m<M; m++) {
			
			party[m] = new ArrayList();
			
			input = in.readLine().split(" ");
			int num = Integer.parseInt(input[0]); // 파티에 참여하는 사람수
			
			int[] p = new int[num];
			for(int i = 0; i<num; i++) {
				p[i] = Integer.parseInt(input[i+1]);
				party[m].add(p[i]);
				}
			
			for(int i = 0; i<num; i++) {
				int a = p[i];
				for(int j = i+1; j<num; j++) {
					int b = p[j];
					map[a][b] = true;
					map[b][a] = true;
				}
			}
			
		}
```

- 진실을 아는 사람을 한명씩 뽑아서 bfs로 탐색하여 진실을 아는 사람으로 표시
```java
   for(int m=0; m<M; m++) {
			
			party[m] = new ArrayList();
			
			input = in.readLine().split(" ");
			int num = Integer.parseInt(input[0]); // 파티에 참여하는 사람수
			
			int[] p = new int[num];
			for(int i = 0; i<num; i++) {
				p[i] = Integer.parseInt(input[i+1]);
				party[m].add(p[i]);
				}
			
			for(int i = 0; i<num; i++) {
				int a = p[i];
				for(int j = i+1; j<num; j++) {
					int b = p[j];
					map[a][b] = true;
					map[b][a] = true;
				}
			}
			
		}
```

- 그러고 파티를 참여하는 정보를 다시 탐색하여 파티수를 체크하고 출력한다.
```java
   while(!que.isEmpty()) {
			int p = que.poll();
			check[p]= true;
			arr[p] = true;
			for(int i = 1; i<N+1; i++) {
				if(map[p][i] && !check[i]) {
					check[i] = true;
					arr[i] = true;
					que.add(i);
				}
			}
		
		}
		
		int count = 0;
		for(int m = 0; m<M; m++) {
			int ch = 0;
			for(int i = 0; i< party[m].size(); i++) {
				if(arr[(int)party[m].get(i)]) {
					ch =1;
					break;
				}
			}
			if(ch==0) {
				count++;
			}
			
		}
		
		
		System.out.print(count);
```


## :black_nib: **Review**  
- 이렇게 풀면 시간 초과 뜰줄 알았는데 통과했네요

## 📡**Link**
https://www.acmicpc.net/problem/1043
