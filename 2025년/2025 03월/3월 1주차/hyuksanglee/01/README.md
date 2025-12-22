# [백준 - S5] 10610. 30

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 그리드

## ⏲️**Time Complexity**

$O(N²)$

## :round_pushpin: **Logic**
1. 배열 sort를 활용해서 정렬하기
2. 배열에 0이 포함되었는지 확인
3. 각자리의 수 합이 3의 배수인지 확인

```java
	Arrays.sort(N); 

      
        if (!N[0].equals("0") ) {
            System.out.println("-1");
            return;
        }

        
        String result ="";
        int sum = 0;
        for (String c : N) {
        	result = c+result;
            sum += Integer.parseInt(c); 
        }

        
        
        if (sum % 3 != 0) {
            System.out.println("-1");
            return;
        }
```

## :black_nib: **Review**
각자리에 수를 더해서 3의 배수이면 전체가 3의 배수가 되는거 이제 알았어

## 📡**Link**

https://www.acmicpc.net/problem/10610
