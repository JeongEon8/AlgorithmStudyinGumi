# [백준 - S4] 1940. 주몽

## ⏰  **time**
30분

## :pushpin: **Algorithm**
투 포인터

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 무기의 값들 list에 담기
```java
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
```
2. 투 포인터 위해서 정렬하기
```java
Collections.sort(list);
```
3. left, right 값을 두고 합이 M보다 작을 경우 left++, 합이 M보다 클 경우 right--, 같을 경우 answer++, left++, right-- 해서 이동하며 탐색하기
```java
        int left = 0;
        int right = N-1;

        while(left < right) {
            int sum = list.get(left)+list.get(right);

            if(sum < M) left++;
            else if(sum > M) right--;
            else {
                answer++;
                left++;
                right--;
            }

        }
```


## :black_nib: **Review**
- 냅다 arr나 list로 탐색하려고 했는데 아니었다..!

## 📡 Link
https://www.acmicpc.net/problem/1940
