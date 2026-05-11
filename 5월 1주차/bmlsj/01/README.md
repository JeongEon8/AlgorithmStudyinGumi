# [PGS - lv3] 01. 디스크 컨트롤러

## ⏰**time**

30분

## :pushpin: \*\*Algorith

정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. 먼저 모든 작업을 `요청 시간(reqTime)` 기준으로 정렬한다. 들어오는 순으로 확인하기 위해
2. 현재 시간(time)까지 요청된 작업들만 PriorityQueue에 넣는다. 이 PriorityQueue는 작업 시간이 짧은 순, 요청 시간이 빠른 순, 작업 번호가 작은 순으로 우선순위를 가진다.
3. 작업의 반환 시간은 `작업 종료 시간 - 요청 시간` 이를 total에 더한다.
4. 만약 현재 시점에 실행 가능한 작업이 없다면, 다음 작업의 요청 시간으로 현재 시간을 이동시킨다.

```java
Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

PriorityQueue<Job> pq = new PriorityQueue<>();

int time = 0;
int idx = 0;
int total = 0;
int count = 0;

while (count < jobs.length) {

    // 현재 시간까지 요청된 작업들을 큐에 넣기
    while (idx < jobs.length && jobs[idx][0] <= time) {
        pq.offer(new Job(idx, jobs[idx][0], jobs[idx][1]));
        idx++;
    }

    // 실행 가능한 작업이 있는 경우
    if (!pq.isEmpty()) {

        Job cur = pq.poll();
        time += cur.workTime;
        total += (time - cur.reqTime);
        count++;
    }
    // 실행 가능한 작업이 없는 경우
    else {
        time = jobs[idx][0];
    }
}

return total / jobs.length;
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/42627>
