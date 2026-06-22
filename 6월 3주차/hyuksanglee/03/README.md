# [PGS - Lv2] 03_가장 큰 수

## ⏰**time**

- 40분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(N log N * K)$ 

## :round_pushpin: **Logic**

1. 배열을 사전의 숫자 순으로 정렬
   ```
   Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
   ```
2. 정렬된 배열에서 하나씩 꺼내서 합쳐준다

## :black_nib: **Review**


## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42746
