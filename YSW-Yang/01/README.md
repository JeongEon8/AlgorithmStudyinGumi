# [PGS - Lv2] 01_두 큐 합 같게 만들기

## ⏰**time**

- 50분

## :pushpin: **Algorithm**

- 그리디
- 투포인터

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 두 큐의 합을 구한다.
   ```java
        for(int i = 0; i < n; i++){
            total += queue1[i];
            arr[i] = queue1[i];
        }
        current = total;
        
        for(int i = 0; i < n; i++){
            total += queue2[i];
            arr[n + i] = queue2[i];
        }
   ```

2. 전체 합이 홀수면 절대 같아질 수 없으므로 -1 반환.
   ```java
        if(total % 2 != 0){
            return -1;
        }
   ```

3. 목표 합 = 전체 합 / 2, 현재 queue1의 구간을 [left, right]로 생각한다.
   ```java
        long target = total / 2;
        int left = 0;
        int right = n - 1;
   ```
4. 현재 합이 목표보다 작으면 right++ 목표보다 크면 left++
   ```java
        while(right < n * 2){
            if(current == target){
                return answer;
            }
            
            if(current > target){
                current -= arr[left++];
            }else{
                right++;
                if(right >= n * 2){
                   break; 
                }
                current += arr[right];
            }
            answer++;
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/118667
