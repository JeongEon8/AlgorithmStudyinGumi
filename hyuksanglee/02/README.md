# [백준 - 실버 3] 1021. 회전하는 큐

## ⏰**time**
30분

## :pushpin: **Algorithm**
큐

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 데큐에 1~N까지 넣어준다.
2. 데큐에서 찾는 숫자의 인덱스를 알아낸다
3. 절반 이상이면 왼쪽으로 이동해서 찾아주고
4. 이하면 오르쪽으로 이동해서 찾아준다.
5. 이동한 수를 저장해서 마지막에 출력해준다.
```
for(int m = 0; m< M; m++) {
			int n = Integer.parseInt(input[m]);
			int index = 0;
			for(int num : que) {
				if(num == n) {
					break;
				}
				index++;
			}
			if(index > que.size()/2) {
				while(que.peek()!=n) {
					int q = que.pollLast();
					que.addFirst(q);
					total++;
				}
				que.poll();
			}else {
				while(que.peek()!=n) {
					int q = que.pollFirst();
					que.add(q);
					total++;
				}
				que.poll();
			}
		}
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/1021](https://www.acmicpc.net/problem/1021)
