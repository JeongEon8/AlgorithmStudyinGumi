# [백준 - S5] 32403. 전구 주기 맞추기

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 수학
- 브루트포스 알고리즘
- 정수론

## ⏲️**Time Complexity**

$O(nlogn)$

## :round_pushpin: **Logic**
전구 주기를 오름차순으로 정렬하고 모든 전구가 켜지길 원하는 시간의 약수를 구해서 그 약수를 작은 수부터 전구와 비교해나가면서 전구의 주기와 약수의 수의 차가 가장 작은 수들을 찾아서 더한다.
```java
Arrays.sort(lights);
List<Integer> divisor = new ArrayList();
for(int i = 1;i<=t/2;i++){
    if(t%i==0) {
        divisor.add(i);
    }
}
divisor.add(t);
int dIdx = 0;
int lIdx = 0;
int ans = 0;
while(lIdx<n){
    if(dIdx>=divisor.size()-1){
        ans += Math.abs(divisor.get(divisor.size()-1)-lights[lIdx]);
    }else{
        int min = Math.min(Math.abs(divisor.get(dIdx)-lights[lIdx]),10000);
        while(dIdx<divisor.size()-1&&min>Math.abs(divisor.get(dIdx+1)-lights[lIdx])){
            dIdx++;
            min = Math.abs(divisor.get(dIdx)-lights[lIdx]);
        }
        ans+= Math.min(min,Math.abs(divisor.get(divisor.size()-1)-lights[lIdx]));
    }
    lIdx++;
}
```  
## :black_nib: **Review**
굉장히 지저분하게 풀었다. 나중에 생각할 시간이 있으면 코드는 다듬어야할듯

## 📡**Link**

https://www.acmicpc.net/problem/32403
