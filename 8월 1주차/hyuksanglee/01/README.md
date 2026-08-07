# [PGS - Lv2] 01_테이블 해시 함수

## ⏰**time**

- 38분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$ 

## :round_pushpin: **Logic**

1. 정렬이 가장 중요하다고 생각이 들었습니다. 
- 1000000 개를 정렬 하는게 시간 문제가 생길수 있다고 생각이 들었고 n^2이면 1억이 넘어서 시간 초과이고 nlogn 으로 해서 시간안에 가능
2. Arrays.sort()를 이용해서 정렬시켜줌

   ```
   int targetCol = col - 1;
        Arrays.sort(data, (a, b) -> {
            if(a[targetCol] != b[targetCol]){
               return Integer.compare(a[targetCol], b[targetCol]);
            }
        return Integer.compare(b[0], a[0]);
        });
   ```
3. 정렬된 배열에서 지정된 시작 컬럼과 끝 컬럼을 나머지를 구한 총 합 값에서 xor 해서 더해준다.
  ```
   for(int i = row_begin-1; i<row_end; i++){
            int[] arr = data[i];
            int total = 0;
            for(int j = 0; j<arr.length; j++){
                total+= arr[j] % (i+1);
            }
            answer ^= total;
        }
   ```
## :black_nib: **Review**
 

- 정렬하는 함수를 직접 구현하려고 했는데 굳이 그럴필요가 없을거 같다고 생각이 들었고 sort() 함수를 사용해서 쉽게 구현

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/147354
