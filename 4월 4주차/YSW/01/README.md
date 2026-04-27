# [PGS - Lv2] 연속된 부분 수열의 합 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 투 포인터
- 슬라이딩 윈도우

## ⏲️**Time Complexity**

$O(N)$

N은 sequence 배열의 길이

## :round_pushpin: **Logic**

연속된 부분 수열의 합이 k 인 가장 짧은 부분수열을 찾는 문제였다.
right로 계속 확장하면서 sum을 키우고, sum이 k를 넘으면 left를 움직여서 sum 값을 줄인다. sum이 k일 때마다 길이를 비교해서 가장 짧은 구간을 저장한다.

```java
        for(int right = 0; right < sequence.length; right++){
            sum += sequence[right];

            while(sum > k){
                sum -= sequence[left];
                left++;
            }

            if(sum == k){
                if(minLength > right - left){
                    minLength = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
```

## :black_nib: **Review**

## 📡**Link**

https://school.programmers.co.kr/learn/courses/30/lessons/178870
