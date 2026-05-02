# [PGS - Lv2] 과제 진행하기 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 스택
- 구현

## ⏲️**Time Complexity**

$O(N * log * N)$

## :round_pushpin: **Logic**

과제들을 시작 시간 기준으로 오름차순 정렬한 뒤, 순서대로 처리하면서 스택을 이용해 진행 중이던 과제를 관리한다. 새로운 과제를 시작하기 전에, 현재 시간과 다음 과제의 시작 시간 사이에 여유가 있다면 스택에 쌓여 있는 과제를 꺼내 처리한다. 이때 스택의 최상단 과제를 기준으로, 남은 시간을 모두 소진하여 끝낼 수 있으면 현재 시간을 갱신하고 해당 과제를 완료 처리한다. 반대로 주어진 시간 내에 끝낼 수 없다면 가능한 만큼만 수행한 뒤 남은 시간을 다시 계산하여 스택에 넣고 중단한다. 이후 현재 시간을 새로운 과제의 시작 시간으로 갱신하고, 해당 과제를 스택에 추가한다. 모든 과제를 순회한 뒤에는 스택에 남아 있는 과제들을 가장 최근에 멈춘 순서대로 꺼내어 차례로 완료 처리한다.

```java
        Arrays.sort(plans, (a, b) -> {
            return a[1].compareTo(b[1]);
        });

        int index = 0;
        int currentTime = 0;
        for(String[] sArr: plans){
            String name = sArr[0];
            int start = toMin(sArr[1]);
            int playTime = Integer.parseInt(sArr[2]);

            while(!stack.isEmpty()){
                Info cur = stack.pop();
                if(currentTime + cur.remain <= start){
                    currentTime += cur.remain;
                    answer[index++] = cur.name;
                }else {
                    cur.remain -= (start - currentTime);
                    stack.push(cur);
                    break;
                }
            }

            currentTime = start;
            stack.push(new Info(name, playTime));
        }

        while(!stack.isEmpty()){
            Info cur = stack.pop();
            answer[index++] = cur.name;
        }
```

## :black_nib: **Review**

## 📡**Link**

https://school.programmers.co.kr/learn/courses/30/lessons/176962
