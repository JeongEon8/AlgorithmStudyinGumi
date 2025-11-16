# [백준 - S3] 4375. 1

## ⏰ **time**

25분

## :pushpin: **Algorithm**
- 수학
- 브루트포스 알고리즘
- 정수론

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1, 11, 111...등 1로만 수를 만들어서 입력된 수로 나누어 떨어지는지 확인한다. 범위가 클 수 있으므로 mod연산도 적용하였다.
```java
while ((str = in.readLine()) != null) {
    int num = Integer.parseInt(str);
    int cnt = 1;
    int tmp = 1;
    while (tmp % num != 0) {
        cnt++;
        tmp = (tmp * 10 + 1)%num;
    }
    sb.append(cnt).append('\n');
}
```

## :black_nib: **Review** 
처음엔 modular연산 없이 tmp를 long범위로 했는데 long 범위를 초과했습니다ㅜㅜ 

## 📡**Link**
https://www.acmicpc.net/problem/4375