# [프로그래머스 - Lv2] 두 큐 합 같게 만들기

## ⏰  **time**
50분

## :pushpin: **Algorithm**
- 큐, 투포인터

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 큐 2개를 하나로 합친다
- 첫 번째 큐의 시작과 두 번째 큐의 시작을 각각 st, en으로 잡는다.
- 두 큐의 합에서 절반 값을 찾아야한다.
- while (st < en) 으로 투포인터 반복한다.
- 합이 절반보다 작으면 en 인덱스의 값을 더하고 en+1 한다.
- 절반보다 크면 st 인덱스의 값을 빼고 st+1 한다.

```
    while (st < en) {
        // en이 끝까지 갔는데 합이 안맞는 경우는 불가능
        if (en == 2 * N - 1 && total < half) {
            return -1;
        }

        // 합이 절반과 같은 경우
        if (total == half) {
            break;
        } 
        else if (total < half) {
            total += dq.get(en); // dq에서 en 인덱스 값 가져오기
            en++;
        }
        // 크면 start 포인터 한 칸 이동
        else {
            total -= dq.get(st); // dq에서 첫 번째 값 빼기
            st++;
        }

        // 이동 횟수 +1
        cnt++;
    }
```

## :black_nib: **Review**


## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/118667
