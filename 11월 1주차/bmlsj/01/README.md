# [PGS - LV1] 01\_동영상 재생기

## ⏰ **time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 시간 계산의 편의성을 위해 `video_len`, `pos`, `op_start`, `op_end`를 모두 초 단위의 정수로 변환
2. `commands`를 순회하며 각 명령어에 따라 현재 재생 위치를 10초씩 이동
   - `next`: 현재 위치에 10초를 더하고, 동영상 길이를 초과하면 동영상 끝으로 이동
   - `prev`: 현재 위치에서 10초를 빼고, 0초 미만이면 처음으로 이동
3. 명령어 실행 전 현재 위치가 광고 구간(`op_start ~ op_end`)에 포함되는지 확인하고, 포함된다면 광고 종료 시점으로 이동
4. 명령어 실행 후에도 광고 구간에 진입했는지 확인하고, 진입했다면 광고 종료 시점으로 이동
5. 모든 명령어 실행이 끝나면 초 단위의 현재 위치를 다시 `MM:SS` 형식으로 변환하여 반환

```java
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int video = toSec(video_len);
        int curr = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);

        for (String cmd : commands) {

            // 광고 구간 진입 시 즉시 점프
            if (curr >= opStart && curr <= opEnd) curr = opEnd;

            if (cmd.equals("next")) {
                curr += 10;
                if (curr > video) curr = video;
            } else {
                curr -= 10;
                if (curr < 0) curr = 0;
            }

            // 이동 후 광고 구간이면 다시 점프
            if (curr >= opStart && curr <= opEnd) curr = opEnd;
        }

        return toMMSS(curr);
    }

    private int toSec(String t) {
        String[] arr = t.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }

    private String toMMSS(int t) {
        int m = t / 60;
        int s = t % 60;
        return String.format("%02d:%02d", m, s);
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/340213>
