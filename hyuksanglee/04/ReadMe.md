# [프로그래머스 - Lv2] 요격 시스템
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 정렬

## ⏲️**Time Complexity**
$O(N \log N)$

## :round_pushpin: **Logic**
1. 이차원 배열 정렬
   - End 작은순, Start 작은순으로 정렬
2. 정렬된 배열에서 하나씩 꺼내서 Start와 End를 비교해서 계산
   - 이전의 End보다 현제 Start가 크면 개수+1 해주고 Start와 End 값 업데이트
```java
		Arrays.sort(targets, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });
        int start = -1;
        int end = -1;
        for(int i = 0; i<targets.length; i++){
            int[] target = targets[i];
            if(end<=target[0]){
                answer++;
                start=target[0];
                end = target[1];
            }
        }
```

## :black_nib: **Review**
- 어디간거니? 내 코딩테스트 싸이트..

  ## 📡**Link**

- https://school.programmers.co.kr/learn/courses/30/lessons/181188

  

