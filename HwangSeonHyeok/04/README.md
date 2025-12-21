# [백준 - S5] 1817. 짐 챙기는 숌

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 그리디 알고리즘
- 시뮬레이션

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
기본 박스를 1개부터 시작해서 순서대로 책을 담는다.  
박스의 최대 적재량을 초과하면 새 박스에 새로 담기 시작한다.
책이 0일 수 있는 경우는 예외처리한다.
```java
if (n == 0) {
    System.out.println(0);

} else {
    int ans = 1;
    int sum = 0;
    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < n; i++) {
        int nextBook = Integer.parseInt(st.nextToken());
        sum += nextBook;
        if (sum > m) {
            ans++;
            sum = nextBook;
        }
    }
    System.out.println(ans);
}
```  
## :black_nib: **Review** 
## 📡**Link**
https://www.acmicpc.net/problem/1817