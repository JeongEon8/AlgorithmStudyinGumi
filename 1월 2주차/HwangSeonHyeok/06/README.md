# [백준 - G4] 17453. 두 개의 문

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 브루트포스 알고리즘
- 비트마스킹
- 비트 집합

## ⏲️**Time Complexity**

$O(Nm)$

## :round_pushpin: **Logic**
해당 스위치를 작동하는 경우 xor연산을 하고 스위치를 끌경우 다시 xor연산하면 다시 원래 형태로 돌아온다.  
이를 이용해 완전 탐색을 해 -n~n까지 중 만들어진 경우를 기록한다.
```java
	static void bitwise(int idx){
        for(int i = 0; i<n;i++){
            doors[i] = doors[i]^switches[idx][i];
        }
    }
    static int bitCount(){
        int cnt = 0;
        for(int bit:doors){
            if(bit==0){
                cnt--;
            }else{
                cnt++;
            }
        }
        return cnt;
    }

    static void solve(int idx){
        int ansIdx = bitCount()+n;
        if(ans[ansIdx]==null){
            ans[ansIdx] = new ArrayList<>();
            for(int i = 1;i<=m;i++){
                if(click[i]){
                    ans[ansIdx].add(i);
                }
            }
        }
        if(idx>m){
            return;
        }
        for(int i = idx; i<=m;i++){
            click[i] = true;
            bitwise(i);
            solve(i+1);
            bitwise(i);
            click[i] = false;
        }
    }
```

## :black_nib: **Review**
백트래킹 분기를 만들 방법이 없었을까?

## 📡**Link**

https://www.acmicpc.net/problem/17453
