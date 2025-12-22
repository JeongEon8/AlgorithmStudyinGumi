# [백준 - S3] 9017. 크로스 컨트리

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
입력 받으면서 6인인 팀의 리스트 확인, 6인팀만 포함된 순서 작성
6인팀 순서 바탕으로 점수 계산

```java
st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            List<Integer> order = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int teamNum = Integer.parseInt(st.nextToken());
                list[teamNum]++;
                order.add(teamNum);
            }
            Map<Integer, ArrayList<Integer>> scores = new HashMap<>();
            List<Integer> good = new ArrayList<>();
            for (int i = 1; i < 201; i++) {
                if (list[i] == 6) {
                    scores.put(i, new ArrayList<>());
                    good.add(i);
                }
            }
            int score = 1;
            for (int now : order) {
                if (list[now] == 6) {
                    scores.get(now).add(score);
                    score++;
                }
            }
            int lowScore = Integer.MAX_VALUE;
            int answer = 0;
            for (int i : good) {
                ArrayList<Integer> arrayList = scores.get(i);
                int sum = 0;
                for (int j = 0; j < 4; j++) {
                    sum += arrayList.get(j);
                }
                if (sum < lowScore) {
                    lowScore = sum;
                    answer = i;
                } else if (sum == lowScore) {
                    if (arrayList.get(4) < scores.get(answer).get(4)) {
                        answer = i;
                    }
                }
            }
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/9017
