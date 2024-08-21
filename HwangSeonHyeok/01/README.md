# [백준 - g1] 11256. 사탕

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## :round_pushpin: **Logic**

상자들을 넓이 순으로 정렬하고 가장 큰 상자부터 그리디하게 사용해서 사탕을 다담으면 사용한 상자 개수를 출력한다.

```cpp
    static class Box implements Comparable<Box> {
        int x, y;

        public Box(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Box o) {
            return (o.x * o.y) - (this.x * this.y);
        }

        public int getSize() {
            return x * y;
        }

    }
    //소트 후 그리디
    Arrays.sort(boxList);
    int ans = 0;
    for (Box b : boxList) {
        j -= b.getSize();
        ans++;
        if (j <= 0)
            break;
    }

```

## :black_nib: **Review**

- 코테를 Java로 갈아타는 것도 고려중이라 sort 연습겸 풀어보았다.

## 📡**Link**

- https://www.acmicpc.net/problem/11256
