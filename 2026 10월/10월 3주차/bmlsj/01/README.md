# [PGS - LV3] 01\_교점에 별 만들기

## ⏰**time**

30분

## :pushpin: **Algorithm**

수학

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 모든 직선들 중 2개를 고르는 조합을 구합니다.
2. 교점 공식 적용
   - 두 직선 $Ax + By + E = 0$과 $Cx + Dy + F = 0$의 교점 공식을 사용하여 교점의 좌표를 계산
3. 교점의 $x, y$ 좌표가 소수점이 아닌 정수(% 분모 == 0)인 경우에만 유효한 교점으로 인정하고 리스트에 저장
4. 격자판 크기 산출 및 별 찍기
   - 저장된 모든 정수 교점들의 최소/최대 $X, Y$ 좌표를 구해 2차원 격자판(map)의 크기를 결정합니다.
   - $Y$축의 방향을 고려하여 올바른 인덱스로 변환한 뒤, 빈 곳은 `.`으로 채우고 교점 위치에는 \*를 표시

```java
for(int i = 0; i < n; i++) {

    long a1 = line[i][0];
    long b1 = line[i][1];
    long c1 = line[i][2];

    for(int j = i + 1; j < n; j++) {

        long a2 = line[j][0];
        long b2 = line[j][1];
        long c2 = line[j][2];

        long denominator = a1 * b2 - a2 * b1;

        if (denominator == 0) continue;

        long xN = b1 * c2 - b2 * c1;
        long yN = c1 * a2 - c2 * a1;

        if (xN % denominator != 0 || yN % denominator != 0) continue;

        long x = xN / denominator;
        long y = yN / denominator;

        points.add(new Point(x, y));

        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
    }
}

int width = (int) (maxX - minX + 1);
int height = (int) (maxY - minY + 1);

char[][] map = new char[height][width];

for(char[] row: map) {
    Arrays.fill(row, '.');
}

// 별 찍기
for(Point p: points) {
    int nx = (int) (p.x - minX);
    int ny = (int) (maxY - p.y);
    map[ny][nx] = '*';
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/87377>
