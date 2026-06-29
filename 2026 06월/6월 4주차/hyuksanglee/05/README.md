# [PGS - Lv2] 05_비밀 코드 해독

## ⏰**time**

- 40분

## :pushpin: **Algorithm**

- 완전탐색

## ⏲️**Time Complexity**

$O({}_{n}C_{5} \times m)$

## :round_pushpin: **Logic**

1. 1~n까지 5자리에 숫자를 조합하고 그 숫자들이 q 에있는 수랑 비교해서 ans의 값이 같으면 계수를 새준다
   ```java
           for (int i = 1; i <= n - 4; i++) {
            for (int j = i + 1; j <= n - 3; j++) {
                for (int k = j + 1; k <= n - 2; k++) {
                    for (int l = k + 1; l <= n - 1; l++) {
                        for (int m = l + 1; m <= n; m++) {
                            
                            int[] numbers = {i, j, k, l, m};
                            boolean check = true;
                            
                            for (int index = 0; index < q.length; index++) {
                                int[] current = q[index];
                                int target = ans[index];
                                
                               
                                int count = 0;
                                for (int number : numbers) {
                                    for (int c : current) {
                                        if (number == c) {
                                            count++;
                                            break; 
                                        }
                                    }
                                }
                                
                                if (count != target) {
                                    check = false;
                                    break;
                                }
                            }
                            
                            if (check) {
                                answer++;
                            }
                            
                        }
                    }
                }
            }
        }
   ```

## :black_nib: **Review**

- 범위가 작아서 일단은 완전탐색으로 했는데 더 좋은 방법이 있을거 같은데 생각이 안나네요

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/388352
