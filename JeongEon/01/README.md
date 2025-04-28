# [백준 - 실버 4] 1244. 스위치 켜고 끄기

## ⏰  **time**
20분 

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 스위치를 켜고 끕니다. 켜져있으면 끄고, 꺼져있으면 킵니다.
```cpp
    if(g==1) {  //남학생일 때
      for(i=1; i<=n; i++) {
        if(i%y==0){  //배수일 때
          arr[i]=!arr[i];  //스위치의 상태를 바꾼다.
        }
      }
    }
    else { //여학생일 때
      arr[y]=!arr[y];  //우선 자기자신(중심)의 상태를 바꾼다.
      for(i=1; arr[y+i] == arr[y-i]; i++) { // <x o x> || <x가 같다면 실행> 
        if(y+i>n || y-i<1) { //인덱스가 벗어나면 멈춘다.
          break;
        }
        arr[y+i]=!arr[y+i];   //뒤집
        arr[y-i]=!arr[y-i];   //뒤집
      }
    }
```

## :black_nib: **Review**
- 후하하

## 📡 Link
https://www.acmicpc.net/problem/1244
