# [백준 - G5] 18869. 멀티버스 Ⅱ

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 정렬
- 값 / 좌표 압축

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
각 행성들의 크기를 중복이 없게 set에 넣고 정렬한다.  
각 크기마다 해당 우주에서 몇 번째로 큰 행성인지 알 수 있으므로 해당 크기를 등수로 치환한다. 이 등수의 index순 리스트가 같으면 균등한 우주이므로 각각 Map<List\<Integer>,Integer>에 넣고 같은 패턴의 우주의 갯수를 구한다. 각 우주의 쌍의 갯수는 $n(n-1)/2$로 구할 수 있다.
```java
Map<List<Integer>, Integer> patterns = new HashMap<>();
for (int i = 0; i < m; i++) {
    int[] space = new int[n];
    Set<Integer> set = new HashSet<>();
    st = new StringTokenizer(in.readLine());
    for (int j = 0; j < n; j++) {
        int pSize = Integer.parseInt(st.nextToken());
        space[j] = pSize;
        set.add(pSize);
    }
    List<Integer> orderedSize = new ArrayList<>(set);
    Collections.sort(orderedSize);
    Map<Integer, Integer> sizeToPattern = new HashMap();
    for (int j = 0; j < orderedSize.size(); j++) {
        sizeToPattern.put(orderedSize.get(j), j);
    }
    List<Integer> pattern = new ArrayList<>();
    for (int size : space) {
        pattern.add(sizeToPattern.get(size));
    }
    patterns.put(pattern, patterns.getOrDefault(pattern, 0) + 1);
}
int ans = 0;
for (int p : patterns.values()) {
    ans += p * (p - 1) / 2;
}
```  
## :black_nib: **Review** 
좌표 압축은 번거로워요
## 📡**Link**
https://www.acmicpc.net/problem/18869