# [백준 - S2] 18258. 큐 2

## ⏰**time**

30분

## :pushpin: **Algorithm**

Queue

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

문제에 나온대로 구현하기

```java
ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
StringBuilder sb = new StringBuilder();

for (int i = 0; i < N; i++) {
    String[] split = br.readLine().split(" ");
    String comm = split[0];
    if (split.length == 1) {
       switch (comm) {
        case "back": {
            if (!queue.isEmpty()) {
                sb.append(queue.peekLast()).append('\n');
            } else {
                sb.append("-1").append('\n');
            }
        }
            break;
        case "size": {
            sb.append(queue.size()).append('\n');
            break;
        }
        case "empty": {
            if (!queue.isEmpty()) {
            sb.append("0").append('\n');
            } else {
            sb.append("1").append('\n');
            }
        }
            break;
        case "pop": {
            if (!queue.isEmpty()) {
                sb.append(queue.pop()).append('\n');
            } else {
                sb.append("-1").append('\n');
            }
            break;
        }
        case "front": {
            if (!queue.isEmpty()) {
                sb.append(queue.peekFirst()).append('\n');
            } else {
                sb.append("-1").append('\n');
            }
            break;
        }
        }
    } else {
       int X = Integer.parseInt(split[1]);
       queue.add(X);
    }
}
System.out.print(sb);

```

## :black_nib: **Review**

ㅎㅎ

## 📡 Link

<https://www.acmicpc.net/problem/18258>
