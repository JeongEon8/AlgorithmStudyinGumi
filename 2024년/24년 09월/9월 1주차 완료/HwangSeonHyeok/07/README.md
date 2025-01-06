# [백준 - g3] 2623. 음악프로그램

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그래프이론
- 위상 정렬
- 방향 비순환 그래프

## :round_pushpin: **Logic**

가수 클래스에 이 가수 다음 순서의 가수들 번호와 이 가수 선행할 가수들 갯수를 기록해둔다.
이후 선행가수 갯수가 0인 가수들을 큐에 넣고 큐에서 꺼내면서 그 뒤 가수들 다음 가수들의 backCnt를 빼주고 0일시 마찬가지로 큐에 넣어주는식으로 탐색한다.  
만약 최종적으로 공연한 가수의 수가 n이면 답이고 아니면 0을 출력

```java
    static class Singer{
		int num, backCnt;
		List<Integer> next;
		public Singer(int num) {
			this.num = num;
			this.backCnt = 0;
			this.next = new ArrayList<>();
		}
	}

    Queue<Integer> q= new ArrayDeque<>();
		for(int i =1; i<=n;i++) {
			if(singerArr[i].backCnt==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int current = q.poll();
			cnt++;
			sb.append(current+"\n");
			for(int next :singerArr[current].next) {
				singerArr[next].backCnt--;
				if(singerArr[next].backCnt==0) {
					q.add(next);
				}
			}
		}

```

## :black_nib: **Review**

이번주에 배운 위상정렬을 복습할겸 풀은 문제.

## 📡**Link**

https://www.acmicpc.net/problem/2623
