# [PGS - Lv2] 02_최솟값 만들기

## ⏰**time**

30분

## :pushpin: **Algorithm**

오름차순/내림차순

## ⏲️**Time Complexity**

$O(N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 오름차순
   ```
   int[]arr;
   Arrays.sort();
   ```
2. 내림차순
   ```
   int[]arr;

   for(int i = 0; i < arr.length; i++){
   int temp = arr[i];
   arr[i] = arr[arr.length-i-1];
   arr[arr.length-i-1] = temp;
}
   ```

3. a 배열의 작은수* b배열의 큰 수를 누적해서 더하면 최솟값

## :black_nib: **Review**

- (소감을 작성해주세요.)

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12941
