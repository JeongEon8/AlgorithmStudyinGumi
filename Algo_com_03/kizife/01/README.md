# [백준] 2564. 경비원
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
구현
많은 조건 분기

## ⏲️**Time Complexity**
220ms

## :round_pushpin: **Logic**
1. 어차피 동근이는 네모의 모서리로만 움직인다. 따라서 모서리를 일직선으로 편 형태로 상상한다.
2. 가로길이 hor, 세로길이 ver, 좌표 입력값 loc 설정
3. 방향(dir)이 1인 경우의 재설정 좌표값은 loc
4. 2인 경우 hor+ver+(hor-loc)
5. 3인 경우 hor+ver+hor+(ver-loc)
6. 4인 경우 hor+loc
```java
        int[] storeArr = new int[storeNum]; //상점 좌표 저장할 배열 

        for (int i = 0; i < storeNum; i++) { // 상점 좌표별 위치 재지정
            int dir = sc.nextInt();
            int loc = sc.nextInt();

            switch (dir) { // 일직선으로 폈을 때의 상점 위치값
            case 1:
                reLoc = loc;
                break;
            case 2:
                reLoc = hor + ver + hor - loc;
                break;
            case 3:
                reLoc = hor + ver + hor + ver - loc;
                break;
            case 4:
                reLoc = hor + loc;
                break;
            }

            storeArr[i] = reLoc;

        }
```

7. 상점의 위치, 동근이의 위치 모두 위의 식으로 처리

8. (상점의 위치-동근이의 위치값)을 절대값 처리
9. 여기서 일직선의 반대 방향으로 가는 것이 더 짧을 수 있으므로, 일직선의 전체 길이(2hor+2ver)에서 위의 절대값 뺀 경우도 추출
10. 둘 중 최소값 도출
```java
        for (int i = 0; i < storeNum; i++) {
            int length1 = Math.abs(storeArr[i] - reDgLoc);
            int length2 = Math.abs((hor * 2 + ver * 2) - Math.abs(storeArr[i] - reDgLoc));
            int length = Math.min(length1, length2); // 최단거리 추출
```

11. 최소값들의 합을 구함
```java
            result += length;

        }
        System.out.println(result);
```

## :black_nib: **Review**
- 일직선으로 편다는 아이디어를 떠올리지 못했다면 어렵게 풀었을 듯...
- 길이 재조정하는 코드가 자잘자잘해서(?) 그렇지 막 어려운 문제는 아니었다.

## 📡**Link**
- https://www.acmicpc.net/problem/2564
