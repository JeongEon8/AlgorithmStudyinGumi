# [백준 - G5] 13884. 삭삽 정렬

## ⏰ **time**

25분

## :pushpin: **Algorithm**
- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
만약 떨어져 있더라도 오름차순으로 있는 숫자들은 뒤로 갈 필요가 없고 오름차순 이외의 사이에 껴져 있는 수는 결국 뒤로 보내진다.  
오름차순 정렬후의 순서와 입력한 순서를 비교하여 떨어져 있더라도 오름차순인 순열의 수를 센다. 이외의 수를 전부 뒤로 보내면 된다.
```java
int[] sortedNumbers = Arrays.copyOf(numbers, n);
Arrays.sort(sortedNumbers);
int matchingIdx = 0;
for (int i = 0; i < n; i++) {
    if (numbers[i] == sortedNumbers[matchingIdx]) {
        matchingIdx++;
    }
}
sb.append(k).append(" ").append(n - matchingIdx).append("\n");
```

## :black_nib: **Review** 


## 📡**Link**
https://www.acmicpc.net/problem/13884