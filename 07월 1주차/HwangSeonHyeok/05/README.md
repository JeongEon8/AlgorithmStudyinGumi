# [백준 - S1] 33040. 마작 거신병 1

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 해 구성하기

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
w가 정해져있으므로 각 행마다 1과 9의 갯수가 각각 달라야하고 위에서 부터 1의 갯수기준으로 감소 순열을 만들면 된다. 비둘기집 정리에 의해 h>w+1이면 답이 없다. 또한 1만과 9만이 각각 최소0~h-1의 합만큼이 있어야 해가 있을 수 있다.  
해가 있을 수 있는 경우 1만을 아래에서부터 각각 0~h-1개로 놓고 각각 고르게 분배하면 안정적인 아름다운 마작 거신병을 만들 수 있다.
```java
int minimum = h * (h - 1) / 2;
if (h > w + 1 || nine < minimum || one < minimum) {
    System.out.println(-1);
} else {
    StringBuffer sb = new StringBuffer();
    int[] oneInLine = new int[h];
    int remainOne = one - minimum;
    int divide = remainOne / h;
    int remain = remainOne % h;
    for (int i = 0; i < h; i++) {
        oneInLine[i] = h - 1 - i + divide;
        if (i < remain)
            oneInLine[i]++;
    }

    for (int i = 0; i < h; i++) {
        for (int j = 0; j < oneInLine[i]; j++) {
            sb.append("1 ");
        }
        for (int j = 0; j < w - oneInLine[i]; j++) {
            sb.append("9 ");
        }
        sb.append("\n");
    }
    System.out.println(sb);
}
```  
## :black_nib: **Review**
마작 거신병!
## 📡**Link**
https://www.acmicpc.net/problem/33040
