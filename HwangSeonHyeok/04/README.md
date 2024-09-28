# [백준 - g5] 13140. Hello World!

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 수학
- 브루트포스 알고리즘

## :round_pushpin: **Logic**

백트래킹으로 모든 경우를 돌았다.

```java
  private static void solve(int depth, int hello, int world) {
		if(hello+world>n)return;
		if(depth==7) {
			if(hello+world==n) {
				sb.append(String.format("%7s",Integer.toString(hello))+'\n');
				sb.append("+"+String.format("%6s",Integer.toString(world))+'\n');
				sb.append("-------\n");
				sb.append(String.format("%7s",Integer.toString(hello+world)));
				solved = true;
			}
			return;
		}
		for(int i = 9;i>=0;i--) {
			if(depth<=1&&i==0)continue;
			if(!visited[i]) {
				visited[i] = true;
				solve(depth+1, hello+helloArr[depth]*i, world+worldArr[depth]*i);
				if(solved) return;
				visited[i] = false;
			}
		}

	}

```

## :black_nib: **Review**

sb의 마지막에 '\n'을 넣고 println으로 출력해서 틀렸다.  
8%까지 진행되길래 이 부분이 틀린줄은 상상도 못했는데 8퍼까진 답이 없는 경우였는듯.

## 📡**Link**

https://www.acmicpc.net/problem/13140
