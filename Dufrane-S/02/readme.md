# [백준 - S3] 19941. 햄버거 분배
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(N)$


## :round_pushpin: **Logic**
- 배열을 순회하며 사람일 경우에 햄버거 먹기 시도


```java
for (int i = 0; i < length; i++) {
            if (arr[i] == 'P') {
                for (int j = i - k; j <= i + k && j < length; j++) {
                    if (j < 0) {
                        continue;
                    }
                    if (done[j] == false) {
                        done[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }
```

## :black_nib: **Review**
- 

## 📡**Link**
- https://www.acmicpc.net/problem/19941
