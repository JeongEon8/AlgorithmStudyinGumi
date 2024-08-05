# [백준] 10951. A+B - 4
 
## ⏰  **time**
5분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
- while문에 hasNextInt()를 사용함으로써, 입력값이 존재할 때까지만 반복한다.
    while(sc.hasNextInt()) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(A+B);
        }

## :black_nib: **Review**
- 처음에는 hasNextInt()를 사용하지 않아서 '출력 초과'가 떴다.
