# [백준] 1244. 스위치 켜고 끄기
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
252ms

## :round_pushpin: **Logic**
1. for문으로 스위치 상태 입력
2. 학생 수를 변수에 입력

3. 경우1: 남자인 경우
1-1. 스위치 번호 == 다음 값의 배수인 경우
1-1-1. 0인 경우 1로,
1-1-2. 1인 경우 0으로 변환 
1-2. 배수가 아닌 경우 아무것도 하지 않음.

4. 경우2: 여자인 경우
2-1: 받은 번호의 좌우 상태가 같다면
2-1-1: 0을 1로,
2-1-2: 1을 0으로 변환
2-2: 좌우 상태가 같지 않다면 끝

5. 3~4의 과정을 학생 수만큼 반복


```java
if (gender == 1) { // 남학생이라면

                for (int k = 0; k < switchNum; k++) { // 스위치 수만큼 반복
                    if ((k + 1) % (gotNum+1) == 0) { // 받은 숫자의 배수인 스위치라면
                        if (arr[k] == 0) { // 0인 스위치를 1로 바꾸고
                            arr[k] = 1;
                        } else { // 1인 스위치를 0으로 바꿈
                            arr[k] = 0;
                        }
                    }
                }
            }

            else if (gender == 2) { // 여학생이라면
                int left = gotNum - 1; // 왼쪽 인덱스
                int right = gotNum +1; // 오른쪽 인덱스

                if (arr[gotNum] == 0) {
                    arr[gotNum] = 1;
                } else {
                    arr[gotNum] = 0;
                }

                
                while (left >= 0 && right < switchNum) { // 대칭 이루는 스위치 페어까지
                    if( arr[left] != arr[right] ) break;
                    
                    if (arr[left] == 0) { // 페어의 값이 0이라면 1로 바꿈
                        arr[left] = 1;
                        arr[right] = 1;

                    } else { // 페어의 값이 1이라면 0으로 바꿈
                        arr[left] = 0;
                        arr[right] = 0;
                    }
```

6. 출력의 경우, 한 줄에 20개 숫자만 들어가도록 줄바꿈 설정

```java
for (int i = 0; i < switchNum; i++) {
            if(i%20 == 0 && i!=0) {
                System.out.println();
            }
            
            System.out.print(arr[i] + " ");
            
            
        }
```

## :black_nib: **Review**
- 로직 자체는 어렵지 않았으나, '학생 수만큼의 반복문' 내에 '스위치 수만큼 반복문'을 넣어야 할 것을 순서 바꾸어서 넣었다.
- 출력 조건을 제대로 읽지 않고 제출하여 자꾸 틀렸다. 테스트 케이스 잘 돌아간다고 방심하지 말자!

## 📡**Link**
- https://www.acmicpc.net/problem/1244
