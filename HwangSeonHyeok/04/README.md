# [백준 - S4] 9693. 시파르

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 정수론

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
팩토리얼에서 가장 뒷자리에 0이 몇개 연속으로  나오는지를 찾는 문제.  
짝수는 충분히 많으므로 5가 곱해질때마다 0이하나씩 늘어난다. 입력이 여러번 들어오므로 미리 답을 구해두고 출력한다.
```java
for (int i = 1; i <= 1000000; i++) {
    arr[i] = arr[i - 1];
    int tmp = i;
    while (tmp % 5 == 0) {
        arr[i]++;
        tmp /= 5;
    }
}
int caseNum = 1;
while (true) {
    int n = Integer.parseInt(in.readLine());
    if (n == 0)
        break;
    sb.append("Case #").append(caseNum++).append(": ").append(arr[n]).append("\n");
}
```  
## :black_nib: **Review**
처음에 팩토리얼의 자릿수 길이를 구하는 문제로 잘못 이해했다.

## 📡**Link**
https://www.acmicpc.net/problem/9693
