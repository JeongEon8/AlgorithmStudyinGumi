# [백준 - S4] 20125. 쿠키의 신체 측정

## ⏰  **time**
15분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 각 부위 담을 리스트와 포인트 변수 생성, head와 heart를 제외한 변수들은 일정한 x값 or y값을 갖고 y값 or x값만 변하므로 Integer타입으로 선언
```java
        Point head = null, heart = null;
        ArrayList<Integer> waist = new ArrayList<>();
        ArrayList<Integer> lArms = new ArrayList<>();
        ArrayList<Integer> rArms = new ArrayList<>();
        ArrayList<Integer> lLegs = new ArrayList<>();
        ArrayList<Integer> rLegs = new ArrayList<>();
```
2. 입력받을 때 쿠키의 일부분일 경우만 판단, 머리가 가장 먼저 나오므로, head에 값 할당, heart는 x+1값이므로 할당
3. i가 heart.x와 동일할 경우는 팔이고, heart.y보다 작은 j이면 왼팔, 크면 오른팔
4. i가 heart.x보다 크고, heart.y와 j가 동일하면 허리
5. heart.x보다 i가 크면 다리이고, heart.y-1과 동일하면 왼다리, heart.y+1과 동일하면 오른다리
```java
               if(str.charAt(j-1) == '*') { // 쿠키 일부분
                    if(head == null) {
                        head = new Point(i, j);
                        heart = new Point(i+1, j);
                    } else {
                        if(i == heart.x) {
                            if(j < heart.y) lArms.add(j);
                            else if(j > heart.y) rArms.add(j);
                        } 
                        else if(i > heart.x && j == heart.y) waist.add(i);
                        else if(i > heart.x) {
                            if(j == heart.y - 1) lLegs.add(i);
                            else if(j == heart.y + 1) rLegs.add(i);
                        }
                    }
                }
```


## :black_nib: **Review**
- 코드가 더럽지만,, 아무튼 풀었다,, 어떻게 해야 알아보기 쉬운 코드일까요 

## 📡**Link**
- https://www.acmicpc.net/problem/20125
