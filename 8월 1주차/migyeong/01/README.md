# [백준] 2295. 세 수의 합


## ⏰ **time**
50분

## :pushpin: **Algorithm**
자료 구조, 이분 탐색

## ⏲️**Time Complexity**
O(n² log n)

## :round_pushpin: **Logic**
1. 입력받은 수를 오름차순으로 정렬하고
2. 두 수의 합을 구한 것에서 한 수를 뺐을 때
3. nums 배열에 값이 존재하는지 뒤에서 부터 확인

```java
for(int i = 0; i < n; i++)
        for(int j = i; j < n; j++)
        sumList.add(nums[i] + nums[j]); // 두 수의 합

Collections.sort(sumList);

for(int i = n - 1; i >= 0; i--) {
        for(int j = 0; j <= i; j++) {
        int target = nums[i] - nums[j]; // 큰 수에서 하나를 뺀 수가 
        if(Collections.binarySearch(sumList, target) >= 0) { // sumList 안에 있는가?
                System.out.println(nums[i]);
                return;
        }
        }
}
```

## :black_nib: **Review**
이런 풀이도 가능하구나.. 이마를 탁 침

## 📡**Link**
https://www.acmicpc.net/problem/2295
