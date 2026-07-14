# [PGS - Lv2] 02\_소수 찾기

## ⏰**time**

30분

## :pushpin: **Algorithm**

DFS

## ⏲️**Time Complexity**

$O(N!)$

## :round_pushpin: **Logic**

1. dfs 순열로 숫자 생성
   - `visited` 배열을 활용해 이미 사용한 자릿수를 제외하면서, 주어진 숫자로 만들 수 있는 모든 가능한 자리수의 숫자 조합을 생성
2. 중복 제거
   - 011과 11처럼 다른 순서로 만들어졌지만 숫자로 바꿨을 때 같은 값(11)이 되는 경우를 HashSet 통해 자동으로 걸러낸다.
3. 소수 판별
   - 생성된 모든 숫자를 순회하며 $2$부터 해당 숫자의 제곱근(`Math.sqrt(num)`)까지 나누어떨어지는지 확인하여 소수의 개수를 세어 반환

```java
    static HashSet<Integer> set;
    public int solution(String numbers) {

        set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, "", visited);

        int cnt = 0;
        for(int num: set) {
            if (isPrime(num)) {
                cnt++;
            }
        }


        return cnt;
    }

    static void dfs(String numbers, String curr, boolean[] visited) {
        if (!curr.isEmpty()) {
            set.add(Integer.parseInt(curr));
        }

        for(int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, curr + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/42839>
