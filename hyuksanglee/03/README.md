# [PGS - Lv2] 03_카펫

## ⏰**time**

- 19분

## :pushpin: **Algorithm**
- 수학

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. brown은 사이드만 있으므로 곁치는 부분 모서리 4개를 제거한거랑 같음
 - brown+4 를 하면 가로 세로 두번 더한거랑 같이 같음
2. 1번에서 가로 세로 총합을 구하고 가로를 2에서 총합까지 탐색을 해준다.
 - 가로 길이를 설정하면 세로길이는 총합에서 뺴주면 된다.
3. 가로 세로 길이를 설정하면 넓이를 구하고 brown을 뺐을때 yellow가 나오면 종류시키고 정답을 출력한다.
   ```java
    while(y>1){
            int to = x * y;
            int result = to - brown;
            if(result == yellow){
                r = y;
                c = x;
                
                break;
            }
            x+=1;
            y = total - x;
        }
   ```

## :black_nib: **Review**

- 이게 완탐인건가?
- 투포인트로 풀면 더 시간복잡도가 더 작아질거 같기도함

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42842
