# [백준 - S3] 5635. 생일 

## ⏰ **time**

기억이안남.. 

## :pushpin: **Algorithm**

구현, 문자열, 정렬 

## ⏲️**Time Complexity**

O(N log N)

## :round_pushpin: **Logic**
Person 객체로 이루어진 리스트를 만들고, 년도순 정렬 or 태어난 달 순 정렬을 한다. <br/>
그리고 순서에 맞춰서 출력해주면 끝...
```java
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();

            people.add(new Person(name, day, month, year));
        }

        //늦게 태어난 사람이 앞으로 오게
        people.sort((a, b) -> {
            if (a.year != b.year) return b.year - a.year;
            if (a.month != b.month) return b.month - a.month;
            return b.day - a.day;
        });
```


## :black_nib: **Review**  
왜 이렇게 오랜만인 기분이지? 그야 실제로 오랜만이니까 

## 📡**Link**
https://www.acmicpc.net/problem/5635
