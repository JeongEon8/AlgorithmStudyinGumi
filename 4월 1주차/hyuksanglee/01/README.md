# [백준 - B1] 1952. 달팽이2

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity** 

$O(M*N)$

## :round_pushpin: **Logic**

1. 한방향으로 길이 있을때까지 이동
2. 더이상 갈수 없을경우 시계방향으로 변경해준다
3. 변경했는데도 갈일이 없으면 중단
4. 방향 변경 횟수 세어서 출력
   - 변경을 했는데도 길이 없을 경우 제외

```kotlin
		while (count > 0){
        val cn = n + dn[d]
        val cm = m + dm[d]
        if(cn<0 || cm <0 || cn>=N || cm>=M){
            if(check){
                cross--
                break
            }

            d = (d+1)%4
            check = true
            cross++
            continue
        }else if(map[cm][cn]==1){
            if(check){
                cross--
                break
            }
            d = (d+1)%4
            check= true
            cross++
            continue
        }


        if(map[cm][cn] ==0){
            map[cm][cn]=1
            n = cn
            m = cm
            check = false
            continue
        }


    }
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1952
