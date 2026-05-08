# [PGS - lv2] 02.K번째수

## ⏰**time**

30분

## :pushpin: \*\*Algorith

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. 해당 범위만큼 리스트를 자르고 정렬 시켜서 원하는 인덱스의 값을 뽑아낸다.

```java
for(int i =0; i<len; i++){
            // answer[i] = commands[i][1];
            int start = commands[i][0];
            int end = commands[i][1];
            int type = commands[i][2];
            
            int[] arr= new int [end-start+1];
            int indexA = 0;
            for(int j = start-1; j<end; j++){
                arr[indexA++] = array[j];
            }
            
            Arrays.sort(arr);
            
            answer[index++] = arr[type-1];
        }
```

## :black_nib: **Review**

## 📡 Link
<https://school.programmers.co.kr/learn/courses/30/lessons/42748>
