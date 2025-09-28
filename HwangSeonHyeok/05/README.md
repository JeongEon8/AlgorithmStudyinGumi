# [백준 - S1] 124335. 한강 (Small)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 브루트포스 알고리즘
- 정수론
- 소수 판정
- 에라토스테네스의 체

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
familyInfo[집 번호][0]엔 남동생의 수, 1번 인덱스엔 막내의 번호를 기록한다.  
에라토네스의 체로 모든 집들의 남동생의 수를 구한다. 만약 처음으로 찾은 남동생이면 막내이므로 1번인덱스에 기록한다.
```java
for (int i = 2; i <= 1000000; i++) {
    for (int j = 2 * i; j <= 1000000; j += i) {
        familyInfo[j][0]++;
        if (familyInfo[j][1] == 0) {
            familyInfo[j][1] = i;
        }
    }

}
```  
이후 각각의 케이스마다 자신보다 작고 남동생의 같은 여동생인 집 중에서 막내가 m이상인 집들을 센다.
```java
for (int i = 1; i <= t; i++) {
    StringTokenizer st = new StringTokenizer(in.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int myBrothers = familyInfo[n][0];
    int ans = 0;
    for (int j = 2; j < n; j++) {
        if (familyInfo[j][0] == myBrothers && familyInfo[j][1] >= m) {
            ans++;
        }
    }
    sb.append("Case #").append(i).append(": ").append(ans).append('\n');
}
```  
## :black_nib: **Review** 
설명도 쓸데없이 복잡하고 이상한 문제
## 📡**Link**
https://www.acmicpc.net/problem/12435