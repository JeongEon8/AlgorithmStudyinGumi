# [PGS - Lv2] 02_시소 짝꿍

## ⏰**time**

- 50분

## :pushpin: **Algorithm**

- 이분탐색

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. 몸무게 배열을 오름차순으로 정렬한다.
2. 현재 몸무게(W)를 기준으로, 나보다 오른쪽 범위(i + 1 ~ 끝)에서 짝꿍을 찾는다.
3. 시소 매칭이 가능한 4가지 몸무게 비율을 타깃으로 지정한다.
    - W * 1
    - W * 1.5 (3/2 배)
    - W * 2   (4/2 배)
    - W * 1.333... (4/3 배)
4. 중복 값이 존재할 수 있으므로 이분 탐색(Lower / Upper Bound)을 수행한다.
    - 해당 타깃이 위치한 경계 범위를 구해 (rightIndex - leftIndex)로 개수를 세어 더해준다.
5. 이 과정을 모든 사람(weights.length)에 대해 반복한다.
   ```java
        for(int i = 0; i < weights.length; i++){
            double w = weights[i]; 
            answer += countTarget(weights, i + 1, weights.length, w);
            answer += countTarget(weights, i + 1, weights.length, w * 3 / 2);
            answer += countTarget(weights, i + 1, weights.length, w * 2);
            answer += countTarget(weights, i + 1, weights.length, w * 4 / 3);
        }

    private int countTarget(int[] weights, int start, int end, double target) {
        int leftIndex = lowerBound(weights, start, end, target);
        int rightIndex = upperBound(weights, start, end, target);
        return rightIndex - leftIndex;
    }
    
    public int lowerBound(int[] weights, int start, int end, double target){
        int left = start;
        int right = end;
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if(weights[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public int upperBound(int[] weights, int start, int end, double target){
                int left = start;
        int right = end;
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if(weights[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/152996
