# [PGS - Lv2] 03\_택배상자

## ⏰**time**

30분

## :pushpin: **Algorithm**

스택

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 보조 컨테이너에 들어갈 순서와 기사님이 원하는 순서를 하나씩 꺼내서 확인
2. `보조 컨테이너 순서 <= order[i]`의 경우, 같아질 때까지 상자를 스택에 넣는다.
3. 스택의 가장 위의 값이 `order[i]`값과 같다면, 스택에서 제거하고 `answer + 1`
4. 더이상 이어나갈 수 없는 경우면 break
   - 보조 컨테이너에서 꺼낼 수 없는 경우
   - 스택이 빈 경우

```java
class Solution {

    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> st = new Stack<>();
        int idx = 0;
        int currBox = 1;

        for (int i = 0; i < order.length; i++) {
            int target = order[i];

            while (currBox <= target) {
                st.push(currBox++);
            }

            if (!st.isEmpty() && st.peek() == target) {
                // 만약 같다면
                st.pop();
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}

```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/131704#>
