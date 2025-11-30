# [프로그래머스 - Lv2] 순위 검색

## ⏰  **time**
3시간

## :pushpin: **Algorithm**
해시, 이분탐색

## ⏲️**Time Complexity**
$O((N+M)logN)$

## :round_pushpin: **Logic**
1. 입력받으면서 map에 각 요소들의 앞글자를 따서 key를 만들고 코딩테스트 점수를 value로 삽입
```java
        for(String str: info) {
            String[] arr = str.split(" ");
            String key = "";
            for(int i = 0; i < arr.length-1; i++) {
                key += arr[i].charAt(0);
            }
            
            map.computeIfAbsent(key, k -> new ArrayList<Integer>()).add(Integer.valueOf(arr[arr.length-1]));
        }
```
2. value들을 탐색하며 정렬
```java
        for(List<Integer> list: map.values()) {
            Collections.sort(list);
        }
```
3. 쿼리에서 각 요소들을 분리
```java
String[] arr = q.split(" and | (?=\\d+$)");
```
4. 분리한 arr의 마지막 인덱스 전까지 탐색.
5. "-" 인 경우, 아직 keys가 비어있다면, 해당 인덱스에서 가능한 첫 글자들 모두 삽입
6. keys 크기가 0 보다 크다면, 하나씩 꺼내서 해당 값에 가능한 첫 글자들 붙여서 삽입
7. "-"가 아닌 경우, 아직 keys가 비어있다면 해당하는 arr[i]의 첫 글자를 tmp에 삽입, keys가 차있다면 동일하게 꺼내서 해당 글자 붙여서 삽입
8. tmp에 넣어둔 값들 keys에 삽입
```java
            for(int i = 0; i < arr.length-1; i++) {
                if("-".equals(arr[i])) {
                    if(keys.size() == 0) {
                        for(String first: name[i]) {
                            tmp.add(first);
                        }
                    } else {
                        while(keys.size() > 0) {
                            String key = keys.poll();
                            for(String first: name[i]) {
                                tmp.add(key+first);
                            }
                        }
                    }
                } else {
                    if(keys.size() == 0) {
                        tmp.add(Character.toString(arr[i].charAt(0)));
                    } else {
                        while(keys.size() > 0) {
                            String key = keys.poll();
                            tmp.add(key+arr[i].charAt(0));
                        }
                    }
                }
                keys.addAll(tmp);
                tmp.clear();
            }
```
7. keys에서 하나씩 꺼내서, values에서 해당 키에 해당하는 점수를 찾고, 있으면 이분탐색 진행해서 인덱스 찾기. sum에 전체 크기 - 인덱스 값을 더함
8. answer[k]에 sum 업데이트
```java
            int sum = 0;
            while(keys.size() > 0) {
                String key = keys.poll();
                int score = Integer.valueOf(arr[arr.length-1]);
                List<Integer> values = map.get(key);
                if(values != null) {
                    int left = 0;
                    int right = values.size();
                    int index = values.size();
                    while(left < right) {
                        int mid = (left+right)/2;
                        if(values.get(mid) < score) {
                            left = mid + 1;
                        } else {
                            right = mid;
                            index = mid;
                        }
                    }
                    if(values.size() > index) sum += values.size() - index;
                }
            }
```


## :black_nib: **Review**
- 시간초과 이슈로 별의별짓을 다해봤던 문제.. 시간 줄인다고 한 게 오히려 늘리는 일이었음.. 했던 일: 페이징이나 인덱스처럼 버킷을 나눠서 관리하려고 했음

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/72412
