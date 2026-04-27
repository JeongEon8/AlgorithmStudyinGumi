# [백준 - S1] 1160. 구간 합 구하기 5

## ⏰**time**

40분

## :pushpin: **Algorithm**

누접합

## :round_pushpin: **Logic**

좌표 x1,y1에서 x2,y2 를 합을 구하는 식이고 하나씩 더해주면 1024*1024*100000이므로 시간 초과 될가능성이 있음
- 누접합을 구해서 전체에서 아닌 부분을 빼주는 방식으로 구했음
- 누접합을 구할때는 현재값 + x축과 y축의 이전값들을 더해주고 중복값인 x-1,y-1을 뺴준다.

```kotlin
for (i in 1..N) {
        val st = StringTokenizer(readLine())
        for (j in 1..N) {
            val num = st.nextToken().toInt()
            array[i][j] = num + array[i - 1][j] + array[i][j - 1] - array[i - 1][j - 1]
        }
    }
```

- x1, y1 ~ x2, y2 까지 구할때는 전체에서 x축과 y축의 이전값들을 빼주고 중복값은 더해준다.
```kotlin
 for(m in 1..M){
        val (x1, y1, x2, y2) = readLine().split(" ").map{it.toInt()}
        val result = array[x2][y2] - array[x1 - 1][y2] - array[x2][y1 - 1] + array[x1 - 1][y1 - 1]
        println(result)
    }
```

## 📡 Link

<https://www.acmicpc.net/problem/11660>
