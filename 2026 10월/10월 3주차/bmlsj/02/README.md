# [PGS - LV2] 02\_양궁대회

## ⏰**time**

30분

## :pushpin: **Algorithm**

백트래킹

## ⏲️**Time Complexity**

$O(2^N)$

## :round_pushpin: **Logic**

1. DFS 탐색

- 10점부터 0점까지의 과녁을 순회하며 라이언이 해당 점수를 획득하는 경우와 포기하는 경우를 완전탐색
- 탐색 중 남은 화살이 부족하면 해당 분기는 가지치기

1. 화살 처리 및 점수 계산

- 모든 과녁을 탐색했거나 남은 화살이 없다면, 남은 화살은 모두 가장 낮은 점수에 몰아줌
- 각 선수의 점수를 계산하여 라이언의 점수가 더 높고 점수 차이가 엄격하게 클 경우 최대 점수 차이와 정답 배열을 갱신

1. 가장 낮은 점수를 더 많이 맞힌 경우

- 최대 점수 차이가 동일할 경우, 0점부터 거꾸로 비교하여 라이언이 더 낮은 점수에 많은 화살을 맞힌 최적의 결과로 정답을 교체
- 만약 라이언이 우승할 수 없다면 초기값인 `[-1]`을 유지하여 반환

```java
public int[] solution(int n, int[] info) {
    int[] ryan = new int[11];
    dfs(0, n, info, ryan);
    return bestResult;
}

static void dfs(int idx, int leftArrows, int[] info, int[] ryan) {
    if (idx == 11 || leftArrows == 0) {
        ryan[10] += leftArrows;

        calculateScore(info, ryan);

        ryan[10] -= leftArrows;
        return;
    }

    if (leftArrows >= info[idx] + 1) {
        ryan[idx] = info[idx] + 1;
        dfs(idx + 1, leftArrows - ryan[idx], info, ryan);
        ryan[idx] = 0; // 백트래킹
    }

    ryan[idx] = 0;
    dfs(idx + 1, leftArrows, info, ryan);
}

static void calculateScore(int[] info, int[] ryan) {
    int apeachScore = 0;
    int ryanScore = 0;

    for (int i = 0; i < 11; i++) {

        if (info[i] == 0 && ryan[i] == 0) continue;

        if (info[i] >= ryan[i]) {
            apeachScore += (10 - i);
        } else {
            ryanScore += (10 - i);
        }
    }

    int diff = ryanScore - apeachScore;
    if (diff > 0) {
        if (diff > maxDiff) {
            maxDiff = diff;
            bestResult = ryan.clone();
        }
        else if (diff == maxDiff) {
            if (isBetter(ryan, bestResult)) {
                bestResult = ryan.clone();
            }
        }
    }
}

static boolean isBetter(int[] current, int[] best) {

    for (int i = 10; i >= 0; i--) {
        if (current[i] > best[i])
            return true;
        if (current[i] < best[i])
            return false;
    }

    return false;
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/92342>
