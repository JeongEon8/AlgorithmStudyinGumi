# [SWEA - 모의 SW 역량테스트] 4013. 특이한 자석
 
## ⏰  **time**
약 3시간 30분..?

## :pushpin: **Algorithm**
구현

## :round_pushpin: **Logic**
- 회전하는 자석의 정보 얻기 (자석 번호, 회전 방향)
- 회전하는 자석과 연결된 자석 살펴보기
  - 맞닿은 자석의 자성이 다르면 해당 자석도 살펴보기
- 회전해야 하는 자석들을 회전시키기
```java
// 자석 회전하기
for (int i = 0; i < K; i++) {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int target = Integer.parseInt(st.nextToken()); // 회전할 자석
    int direction = Integer.parseInt(st.nextToken()); // 회전 방향

    rotateQueue.clear(); // 회전할 자석들을 저장하기 위한 큐 초기화
    Arrays.fill(checked, false); // 자석 탐색 여부를 위한 배열 초기화

    Queue<Magnetic> queue = new LinkedList<>(); // 회전하는 자석들을 찾기 위한 큐
    queue.offer(new Magnetic(target, magnetics[target].get(2), magnetics[target].get(6), direction));
    checked[target] = true;
    while (!queue.isEmpty()) {
        Magnetic now = queue.poll();
        rotateQueue.offer(new int[]{now.idx, now.direction});

        // 현재 자석의 오른쪽 자석 탐색
        int next = now.idx + 1;
        int rotateD = now.direction == 1? -1 : 1;
        if (next <= N && !checked[next] && now.point1 != magnetics[next].get(6)) {
            queue.offer(new Magnetic(next, magnetics[next].get(2), magnetics[next].get(6), rotateD));
            checked[next] = true;
        }

        // 현재 자석의 왼쪽 자석 탐색
        next = now.idx - 1;
        if (next >= 1 && !checked[next] && now.point2 != magnetics[next].get(2)) {
            queue.offer(new Magnetic(next, magnetics[next].get(2), magnetics[next].get(6), rotateD));
            checked[next] = true;
        }
    }

    // 회전 가능한 자석들 회전시키기
    while (!rotateQueue.isEmpty()) {
        int[] now = rotateQueue.poll(); // 0: 타겟, 1: 이동 방향
        int moveTarget = now[0];
        if (now[1] == 1) { // 시계 방향으로 회전하는 경우
            // 제일 뒤에 것을 제일 앞으로 이동
            magnetics[moveTarget].add(0, magnetics[moveTarget].remove(M - 1));
        }
        else { // 반시계 방향으로 회전하는 경우
            // 앞에 것을 제일 뒤로 이동
            magnetics[moveTarget].add(magnetics[moveTarget].remove(0));
        }
    }
}
```

## :black_nib: **Review**
문제 이해를 제대로 못해서 거의 2시간 이상 삽질했다. 좀 쉬다가 다시 문제를 읽으니 이해가 됐고..ㅎ 
그래서 풀던 것을 뒤엎고 다시 작성했다.. 하 복잡해 보여도 하나씩 정리하고 구현하면 되니까 쓸데없이 겁먹지 말자..!

## 📡**Link**
- [SWEA 4013_특이한 자석](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH&categoryId=AWIeV9sKkcoDFAVH&categoryType=CODE&problemTitle=sw&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
