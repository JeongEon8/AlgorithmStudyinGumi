# [백준 - S5] 2535. 아시아 정보올림피아드

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 구현
- 정렬

## ⏲️**Time Complexity**

$O(nlogn)$

## :round_pushpin: **Logic**
점수의 내림차순으로 정렬하고 그 나라가 받은 메달 수가 2미만이면 메달 수상자로 기록하고 그 나라의 메달 수상 수를 증가시킨다.
```java
static class Player implements Comparable<Player>{
    int country, studentNum, score;
    Player(int country, int studentNum, int score){
        this.country = country;
        this.studentNum = studentNum;
        this.score = score;
    }

    @Override
    public int compareTo(Player o) {
        return o.score-this.score;
    }
}

Arrays.sort(players);
int cnt = 0;
for(Player p:players){
    if(countryWinnerCnt[p.country]<2){
        countryWinnerCnt[p.country]++;
        cnt++;
        sb.append(p.country+" "+p.studentNum).append("\n");
    }
    if(cnt>=3)break;
}
```  

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2535
