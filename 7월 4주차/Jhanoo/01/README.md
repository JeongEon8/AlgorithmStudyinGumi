# [PGS - Lv2] 01_숫자 카드 나누기

## ⏰**time**

22분

## :pushpin: **Algorithm**

* 최대공약수
* 유클리드 호제법
* 배열 순회

## ⏲️**Time Complexity**

$O(N \log M)$

`N`은 두 배열의 전체 원소 수에 비례하는 값이고, `M`은 배열 원소의 최댓값이다.

각 배열의 최대공약수를 구할 때 유클리드 호제법을 사용한다.
두 수의 최대공약수를 구하는 데 $O(\log M)$이 걸리고, 배열의 모든 원소에 대해 이를 수행하므로 최대공약수 계산에는 $O(N \log M)$이 걸린다.

이후 상대 배열에서 나누어떨어지는 원소가 있는지 확인하기 위해 각 배열을 한 번씩 순회하므로 $O(N)$이 추가된다.

따라서 전체 시간 복잡도는 $O(N \log M)$이다.

## :round_pushpin: **Logic**

1. 조건을 만족하는 수는 한쪽 배열의 모든 원소를 나눌 수 있어야 한다.

   따라서 가능한 가장 큰 수는 해당 배열 전체의 최대공약수이다.

2. `arrayA`와 `arrayB` 각각의 최대공약수를 구한다.

   ```java
   int gcdA = getArrayGcd(arrayA);
   int gcdB = getArrayGcd(arrayB);
   ```

3. 두 수의 최대공약수는 유클리드 호제법으로 구한다.

   큰 수를 작은 수로 나눈 나머지를 반복해서 계산하고, 나머지가 `0`이 되었을 때의 값을 최대공약수로 반환한다.

   ```java
   public int gcd(int a, int b) {
       while (b != 0) {
           int remainder = a % b;
           a = b;
           b = remainder;
       }

       return a;
   }
   ```

4. 배열 전체의 최대공약수는 첫 번째 원소를 기준으로 나머지 원소와 순차적으로 최대공약수를 계산한다.

   ```java
   public int getArrayGcd(int[] arr) {
       int result = arr[0];

       for (int i = 1; i < arr.length; i++) {
           result = gcd(result, arr[i]);
       }

       return result;
   }
   ```

5. `arrayB`의 최대공약수 `gcdB`가 `arrayA`의 어떤 원소도 나누지 못하는지 확인한다.

   하나라도 나누어떨어지는 원소가 있다면 조건을 만족하지 못하므로 후보를 `0`으로 만든다.

   ```java
   int candidateA = canDivide(gcdB, arrayA) ? 0 : gcdB;
   ```

6. 반대로 `arrayA`의 최대공약수 `gcdA`가 `arrayB`의 어떤 원소도 나누지 못하는지도 확인한다.

   ```java
   int candidateB = canDivide(gcdA, arrayB) ? 0 : gcdA;
   ```

7. 상대 배열에서 주어진 수로 나누어떨어지는 원소가 하나라도 존재하는지 확인한다.

   ```java
   public boolean canDivide(int divisor, int[] arr) {
       for (int num : arr) {
           if (num % divisor == 0) {
               return true;
           }
       }

       return false;
   }
   ```

8. 두 방향에서 구한 유효 후보 중 더 큰 값을 반환한다.

   두 후보가 모두 조건을 만족하지 못하면 둘 다 `0`이므로 `0`이 반환된다.

   ```java
   return Math.max(candidateA, candidateB);
   ```

## :black_nib: **Review**

* 처음에는 한쪽 배열의 모든 원소를 나눌 수 있는 수를 직접 탐색해야 한다고 생각할 수 있지만, 가능한 가장 큰 값은 반드시 해당 배열의 최대공약수라는 점을 이용할 수 있었다.
* 각 배열의 최대공약수를 구한 뒤 상대 배열에서 나누어떨어지는 원소가 있는지만 확인하면 되어 풀이가 단순해졌다.
* 최대공약수는 유클리드 호제법을 사용해 효율적으로 계산했다.
* 상대 배열에서 하나라도 나누어떨어지는 원소가 발견되면 즉시 `true`를 반환해 불필요한 순회를 줄였다.
* 현재 코드의 `candidateA`는 `arrayB`의 최대공약수를 기준으로 하고, `candidateB`는 `arrayA`의 최대공약수를 기준으로 하므로 변수 이름을 `candidateFromB`, `candidateFromA`처럼 작성하면 의미가 더 명확해질 수 있다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/135807
