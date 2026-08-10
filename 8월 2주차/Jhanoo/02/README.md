# [PGS - Lv2] 02_[3차] 방금그곡

## ⏰**time**

45분

## :pushpin: **Algorithm**

* 문자열
* 문자열 치환
* 시뮬레이션
* 문자열 탐색

## ⏲️**Time Complexity**

$O(\sum T)$

각 곡마다 실제 재생 시간만큼 멜로디 문자열을 생성한다.

```java
for (int i = 0; i < playTime; i++) {
    played.append(melody.charAt(i % melody.length()));
}
```

따라서 모든 곡의 재생 시간을 합한 값을 $\sum T$라고 하면, 재생 멜로디를 만드는 데 $O(\sum T)$이 걸린다.

이후 `contains()`를 이용해 기억한 멜로디가 포함되어 있는지 확인하므로 문자열 길이에 비례하는 탐색 비용이 추가된다.

문제의 입력 범위에서는 재생 시간이 제한되어 있으므로 충분히 처리할 수 있다.

## :round_pushpin: **Logic**

1. `C#`, `D#`처럼 `#`이 붙은 음은 문자열 길이가 2이기 때문에 그대로 비교하면 음 하나를 문자 두 개로 처리하게 된다.

   예를 들어:

   ```text
   ABC
   ABC#
   ```

   를 단순 문자열로 비교하면 `ABC#` 안에 `ABC`가 포함되어 있다고 판단할 수 있다.

   하지만 음악적으로 `C`와 `C#`은 서로 다른 음이므로 이를 구분해야 한다.

2. `#`이 붙은 음을 사용하지 않는 문자 하나로 치환한다.

   ```java
   public String convertMelody(String melody) {
       return melody
           .replace("C#", "H")
           .replace("D#", "I")
           .replace("F#", "J")
           .replace("G#", "K")
           .replace("A#", "L");
   }
   ```

   이렇게 하면 모든 음을 문자 하나로 표현할 수 있어 문자열 비교가 간단해진다.

3. 기억하고 있는 멜로디 `m`도 동일한 규칙으로 변환한다.

   ```java
   m = convertMelody(m);
   ```

4. 각 음악 정보를 `,` 기준으로 분리한다.

   ```java
   String[] info = music.split(",");
   ```

   각 정보는 다음과 같이 구성되어 있다.

   ```text
   시작 시각
   종료 시각
   음악 제목
   악보
   ```

5. 시작 시각과 종료 시각을 분 단위로 변환하여 실제 재생 시간을 구한다.

   ```java
   public int getPlayingTime(String start, String end) {
       int s = Integer.parseInt(start.substring(0, 2)) * 60
             + Integer.parseInt(start.substring(3, 5));

       int e = Integer.parseInt(end.substring(0, 2)) * 60
             + Integer.parseInt(end.substring(3, 5));

       return e - s;
   }
   ```

6. 음악의 원본 멜로디 역시 `#` 음표를 한 글자로 변환한다.

   ```java
   String melody = convertMelody(info[3]);
   ```

7. 실제 재생 시간만큼 멜로디를 반복해서 재생된 전체 멜로디를 만든다.

   원본 멜로디의 길이를 넘어가면 처음부터 다시 반복되므로 `%` 연산을 사용한다.

   ```java
   StringBuilder played = new StringBuilder();

   for (int i = 0; i < playTime; i++) {
       played.append(melody.charAt(i % melody.length()));
   }
   ```

   예를 들어:

   ```text
   melody = "ABC"
   playTime = 8
   ```

   이라면 실제 재생된 멜로디는 다음과 같다.

   ```text
   ABCABCAB
   ```

8. 실제 재생된 멜로디에 기억한 멜로디 `m`이 포함되어 있는지 확인한다.

   ```java
   played.toString().contains(m)
   ```

9. 조건을 만족하는 음악 중 가장 재생 시간이 긴 음악을 정답으로 선택한다.

   ```java
   if (played.toString().contains(m) && playTime > time) {
       answer = title;
       time = playTime;
   }
   ```

   재생 시간이 같은 경우에는 먼저 입력된 음악을 반환해야 하므로 `>=`가 아니라 `>`만 사용한다.

   따라서 같은 길이의 음악이 나중에 등장해도 기존 정답이 유지된다.

10. 조건을 만족하는 음악이 하나도 없다면 초기값인 `(None)`을 반환한다.

```java
String answer = "(None)";
```

## :black_nib: **Review**

* 처음에는 문자열을 그대로 비교하려 했지만 `C`와 `C#`처럼 `#`이 붙은 음을 정확하게 구분해야 했다.
* `#`이 붙은 음을 사용하지 않는 문자 하나로 치환하면 각 음을 한 글자로 표현할 수 있어 비교가 간단해졌다.
* 실제 음악은 원본 악보보다 재생 시간이 길면 반복되고, 짧으면 중간에서 끊기므로 재생 시간만큼 직접 멜로디를 만들어 비교했다.
* `% melody.length()`를 사용하면 별도의 반복 횟수 계산 없이 악보를 순환시킬 수 있었다.
* 여러 음악이 조건을 만족하면 재생 시간이 가장 긴 음악을 선택하고, 재생 시간이 같은 경우 먼저 입력된 음악을 유지해야 하므로 `playTime > time`으로 비교했다.
* 조건에 맞는 음악이 없는 경우 반환해야 하는 문자열이 `(None)`이라는 점도 정확히 맞춰야 했다. 처음에 잘못봐서 전부 대문자인줄 알고 `(NONE)` 로 했다가 테스트케이스 몇개가 틀렸다... 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/17683
