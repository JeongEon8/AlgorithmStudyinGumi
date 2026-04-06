# [백준 - G4] 31091. 거짓말

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 누접합

## ⏲️**Time Complexity** 

$O(M*N)$

## :round_pushpin: **Logic**

1. 2개의 배열 생성
	- x개 이상을 저장하는 배열(크기:N)
 	- x개 이하를 저장하는 배열(크기:N) 	
2. 양수(이상)이면 이상벼열 음수이면 이하배열에 개수를 증가시켜준다
3. 양수일경우 N ->0 까지 누접합을 구하고 음수일경우 0->N 까지 구한다.
4. 우선순위 큐를 생성하고 이상배열에 작은 숫자부터 비교
   - 말했던 개수랑 이하의 -1 개수를 큐에 담아준다.

```kotlin
		val arrayP = IntArray(N + 2)
    val arrayM = IntArray(N + 2)

    for (n in 1..N) {
        val k = st.nextToken().toInt()
        if (k > 0) {
            arrayP[k]++
        } else {
            arrayM[-k]++
        }
    }

    for (n in N downTo 1) {
        arrayP[n] += arrayP[n + 1]
    }
    for (n in 1..N) {
        arrayM[n] += arrayM[n - 1]
    }

    val answers = mutableListOf<Int>()
    for (i in 0..N) {
        val pLiar = arrayP[i + 1]
        val mLiar = if (i > 0) arrayM[i - 1] else 0

        val actualLiar = pLiar + mLiar

        if (actualLiar == i) {
            answers.add(i)
        }
    }
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/31091
