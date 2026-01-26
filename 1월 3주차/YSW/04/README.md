# [백준 - S5] 32185. 꿈 열정 나눔 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

재원이가 팀원을 자신을 포함해서 M명 뽑는데 스텟의 합이 자신보다 크지 않은 팀원을 뽑는데, 팀의 스텟의 합이가 가장 큰 경우의 자신과 팀원을 인덱스를 출력하는 문제였다.
Node 클래스를 담는 배열을 만들어서 스텟의 합과 인덱스를 기록한다. 그리고 Node배열을 스텟의합으로 내림차순으로 정렬한 뒤, 스텟의 합이 높은 순으로 검사해서 자신보다 높지 않은 팀원을 M명 뽑아서 만들어진 팀의 인덱스를 출력한다.

```java
		int myStats = V + P + S;
		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			V = Integer.parseInt(inputs[0]);
			P = Integer.parseInt(inputs[1]);
			S = Integer.parseInt(inputs[2]);
			nodes[i] = new Node(V + P + S, i);
		}

		Arrays.sort(nodes, Comparator.comparingInt((Node node) -> node.value).reversed());

		int count = 1;
		for (int i = 0; i < N; i++) {
			if (count == M) {
				break;
			}

			if (myStats >= nodes[i].value) {
				sb.append(nodes[i].index + 1).append(" ");
				count++;
			}
		}

		System.out.println(sb.toString().trim());
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/32185
