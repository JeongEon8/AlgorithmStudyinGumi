  # [백준 - 실버4] 2003. 수들의 합 2
  
  ## ⏰**time**
  30분
  
  ## :pushpin: **Algorithm**
  투 포인터
  
  ## ⏲️**Time Complexity**
  $O(N)$ 
  
  ## :round_pushpin: **Logic**
  1. 투 포인터로 목표보다 크면 빼주고
  2. 작으면 더해주기
  ```
    for (int b = 0; b < n; b++) {
            sum += array[b];
            if (sum == goal) answer++;
            while (sum >= goal) {
                sum -= array[a];
                a++;
                if (sum == goal) {
                    answer++;
                }
            }
        }
  ```
  
  ## :black_nib: **Review**
  - 
  
  ## 📡 Link
  https://www.acmicpc.net/problem/2003
