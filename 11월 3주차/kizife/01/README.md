# [백준] 14891. 톱니바퀴 


## ⏰ **time**
90분 

## :pushpin: **Algorithm**
구현, 시뮬레이션

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
```java
list.add(new int[]{num, dir});
```
list에 톱니바퀴 번호, 방향을 저장한다.

맞붙은 극이 상극이냐에 따라 회전 여부가 달라진다. 이를 양쪽 끝에서부터 검토한다.
```java
// 왼쪽으로 전파 검사
        for (int i = gear - 1; i > 0; i--) {
            if (getGear(i)[6] != getGear(i - 1)[2]) {
                dirs[i - 1] = -dirs[i];
            } else {
                break;
            }
        }

        //왼쪽에서 오른쪽으로 검토 
        for (int i = gear - 1; i < 3; i++) {
        	//맞붙은 극이 상이한지 검토 
            if (getGear(i)[2] != getGear(i + 1)[6]) { //getGear(i)란..어떤 arr인지 
                dirs[i + 1] = -dirs[i];
            } else {
                break;
            }
        }
```

시계방향 회전
```java
    private static void spinRight(int[] arr) {
        int temp = arr[7];
        for (int i = 7; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }
```

반시계방향 회전
```java
    private static void spinLeft(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < 7; i++) {
            arr[i] = arr[i + 1];
        }
        arr[7] = temp;
    }
```

## :black_nib: **Review**
구현된 코드 자체는 쉬운데 귀찮은 문제였당

## 📡**Link**
https://www.acmicpc.net/problem/14891 
