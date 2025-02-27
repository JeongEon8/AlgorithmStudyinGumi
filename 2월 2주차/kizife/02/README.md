# [백준] 10867. 중복 빼고 정렬하기


## ⏰ **time**
5분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
중복을 알아서 제거해 주는 HashSet에다가 수를 저장한다.  <br/>
그것을 list에 담아 정렬하고 출력한다...
```java
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            set.add(num);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i : list) {
            System.out.print(i + " ");
        }
```


## :black_nib: **Review**
해시셋아 고마워요 

## 📡**Link**
https://www.acmicpc.net/problem/10867
