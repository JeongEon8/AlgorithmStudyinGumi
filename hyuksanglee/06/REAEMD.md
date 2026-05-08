# [PGS - lv3] 06.입국심사

## ⏰**time**

30분

## :pushpin: \*\*Algorith

- 정렬
- 이분탐색

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. 상담시간을 정렬시켜준다.
2. 초기값 세팅
   - start는 1, end는 MAX_VALUE로 설정
3. 이분탐색 시켜줌
   - 상담인원이 많기때문에 이분탐색 사용
   - mid 시간을 상담 시간으로 나눠서 총합이 인원이랑 비교해서 다시 세팅해주낟.
   - 인원을 구하는 과정에서 넘어가면 시간을 줄이기 위해 다음단계로 넘어간다.

```java
       Arrays.sort(times);
        
        int len = times.length;
        long end = Long.MAX_VALUE;
        long start =1;
        while(start<=end){
            long mid = end/2 + start/2;
            long count = 0;
            
           for (int t : times) {
                count += mid / t;
                if (count >= n) break; 
            }
            if(count>=n){
                answer=mid;
                end = mid-1;
                
            }else {
                start = mid+1;
            }
        }
```



## :black_nib: **Review**

## 📡 Link
<https://school.programmers.co.kr/learn/courses/30/lessons/43238>
