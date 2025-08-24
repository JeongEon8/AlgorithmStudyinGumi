# [백준 - S2] 2784. 가로 세로 퍼즐

## ⏰ **time**

30분

## :pushpin: **Algorithm**
- 구현
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
3개의 단어를 가로줄로 정하고 남은 3개의 단어가 세로줄에 모두 있는지 체크한다.
```java
static void solve(int depth) {
    if (depth == 3) {
        String w0 = "" + selectedWord[0].charAt(0) + selectedWord[1].charAt(0) + selectedWord[2].charAt(0);
        String w1 = "" + selectedWord[0].charAt(1) + selectedWord[1].charAt(1) + selectedWord[2].charAt(1);
        String w2 = "" + selectedWord[0].charAt(2) + selectedWord[1].charAt(2) + selectedWord[2].charAt(2);
        List<String> list = new ArrayList<>();
        list.add(selectedWord[0]);
        list.add(selectedWord[1]);
        list.add(selectedWord[2]);
        list.add(w0);
        list.add(w1);
        list.add(w2);

        Collections.sort(list);
        if (Arrays.equals(list.toArray(), words)) {
            findAns = true;
            String selectedString = selectedWord[0] + selectedWord[1] + selectedWord[2];
            String ansString = ans[0] + ans[1] + ans[2];
            if (ans[0] == null || ansString.compareTo(selectedString) > 0) {
                ans[0] = selectedWord[0];
                ans[1] = selectedWord[1];
                ans[2] = selectedWord[2];
            }
        }
        return;
    }
    for (int i = 0; i < 6; i++) {
        if (!selected[i]) {
            selected[i] = true;
            selectedWord[depth] = words[i];
            solve(depth + 1);
            selected[i] = false;
        }
    }
}
```

## :black_nib: **Review**  

## 📡**Link**
https://www.acmicpc.net/problem/2784