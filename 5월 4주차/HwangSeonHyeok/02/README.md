# [PGS - LV2] 172927. 광물 캐기

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 그리디

## ⏲️**Time Complexity**

$O(nlogn)$

## :round_pushpin: **Logic**
한 곡괭이로 순서대로 5개를 연속으로 캐야하므로 5개씩의 그룹으로 정해진 곳까지만 캘 수 있다.  
안 좋은 곡괭이일수록 기하급수적으로 피로도가 많이 드므로 피로도가 많이 드는 그룹일수록 좋은 곡괭이를 먼저사용하면된다.
```java
class Stones implements Comparable<Stones>{
    int dia;
    int iron;
    int stone;
    int total;
    public Stones(int dia, int iron, int stone){
        this.dia = dia;
        this.iron = iron;
        this.stone = stone;
        this.total = (dia*25)+(iron*5)+stone;
    }

    @Override
    public int compareTo(Stones o){
        return Integer.compare(o.total,this.total);
    }
}
```
위처럼 그룹별 가중치를 돌곡괭이 기준으로 계산하여 정렬할 수 있게한다.
```java
List<Stones> list = new ArrayList<>();
int picksCnt = picks[0]+picks[1]+picks[2];
for(int i = 0; i<minerals.length && i<5*picksCnt; i+=5){
    int dia=0;
    int iron=0;
    int stone=0;
    for(int j = i; j<i+5;j++){
        if(j==minerals.length)break;
        if(minerals[j].equals("diamond"))dia++;
        else if(minerals[j].equals("iron"))iron++;
        else stone++;
    }
    list.add(new Stones(dia,iron,stone));
}
Collections.sort(list);
for(Stones s:list){
    if(picks[0]>0){
        answer+= s.dia + s.iron + s.stone;
        picks[0]--;
    }else if(picks[1]>0){
        answer+= (s.dia*5) + s.iron + s.stone;
        picks[1]--;
    }else{
        answer+= s.total;
        picks[2]--;
    }
}
```
각 그룹의 가중치를 내림차순으로 정렬하고 좋은 곡괭이를 우선적으로 사용한다.
## :black_nib: **Review**

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/172927