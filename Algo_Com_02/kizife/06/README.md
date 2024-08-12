# [백준] 2309. 일곱 난쟁이
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
브루트포스 알고리즘
정렬

## ⏲️**Time Complexity**
168ms

## :round_pushpin: **Logic**
1. 난쟁이 키 배열을 만들고, 이어 오름차순 정렬 / 배열의 총합을 구한다.
```java
        for (int i = 0; i < 9; i++) { // 9명 난쟁이 키 입력
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            Arrays.sort(arr);
            sum += arr[i];
        
```

2. 배열의 총합에서 2개 요소 합을 뺐을 때 100이 되는 경우를 찾는다.
```java
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (arr[i] + arr[j]) == 100) { //인덱스 i, j 요소를 뺐을 때 100이 됨
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) { //인덱스 i, j를 제외하고 출력
                            System.out.println(arr[k]);
                        }
                    }
                    return;
                }
            }
        }
```

## :black_nib: **Review**
-  로직이 어려운 것은 아니었는데 자꾸 구현에서 걸려 시간이 많이 소요됐다.
-  처음에는 9개 값 중 랜덤으로 7개 값을 골라 계산하려고 했었다.
-  합==100을 찾았어야 했는데, '100이 넘지 않는 것'으로 잘못 읽고 한참 <=로 표기하고 있었다. 제발 문제 좀 잘 읽자고~
-  return;을 쓰지 않아서 가능한 케이스가 전부 출력되는 문제가 있었다. 

## 📡**Link**
- https://www.acmicpc.net/problem/2309
