# [SWEA - D3] 01_규영이와 인영이의 카드게임

## ⏰**time**

80분

## :pushpin: **Algorithm**

순열

## ⏲️**Time Complexity**

$O(9!)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 순서를 구하기 위한 함수 생성
2. 가지치기를 위해서 점수가 가능한 가장 큰 점수의 절반보다 크면 반환, 각 answer에 가지치기된 값들 더하기
   ```
    static void perm(int gy, int iy, int[] iyCard, boolean[] visited, int r, int[] gyCard) {
        if (gy > MAXSCORE / 2) {
            answer[0] += factorial[CARDCNT - r];
            return;
        } else if (iy > MAXSCORE / 2) {
            answer[1] += factorial[CARDCNT - r];
            return;
        }

        if (r == CARDCNT) {
            if (gy > iy) answer[0]++;
            else if (gy < iy) answer[1]++;
            return;
        }

        for (int i = 0; i < CARDCNT; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (gyCard[r] > iyCard[i]) {
                    perm(gy + gyCard[r] + iyCard[i], iy, iyCard, visited, r + 1, gyCard);
                } else {
                    perm(gy, iy + gyCard[r] + iyCard[i], iyCard, visited, r + 1, gyCard);
                }
                visited[i] = false;
            }
        }
    }
}

   ```
3. iyCard는 인영이가 가지는 카드로 card에서 이미 값이 true가 된 것들을 빼고 넣기
```
            int[] iyCard = new int[CARDCNT];
            int idx = 0;
            for (int i = 1; i <= CARDCNT * 2; i++) {
                if (!card[i]) {
                    iyCard[idx++] = i;
                }
            }

```


## :black_nib: **Review**

- c++로 동일한 로직으로 풀어도 안됐는데 java는 된다 왜지..!

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
