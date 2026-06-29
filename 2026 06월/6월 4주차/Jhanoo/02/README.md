# [PGS - Lv2] 02_[3차] 파일명 정렬

## ⏰**time**

47분

## :pushpin: **Algorithm**

* 문자열 파싱
* 정렬
* Comparator
* 안정 정렬

## ⏲️**Time Complexity**

$O(N \times L + N \log N)$
`N`은 파일명의 개수, `L`은 파일명 길이이다.
먼저 각 파일명을 한 번씩 순회하며 `HEAD`와 `NUMBER`를 파싱하므로 $O(N \times L)$이 걸린다.
이후 `FileInfo` 배열을 정렬하는 데 $O(N \log N)$이 걸린다.

따라서 전체 시간 복잡도는 $O(N \times L + N \log N)$이다.

## :round_pushpin: **Logic**

1. 파일명은 문제 조건에 따라 `HEAD`, `NUMBER`, `TAIL` 세 부분으로 나눌 수 있다.

   이 중 정렬 기준에 사용되는 값은 `HEAD`와 `NUMBER`이다.

   ```text
   foo010bar020.zip
   HEAD   : foo
   NUMBER : 010
   TAIL   : bar020.zip
   ```

2. 파일명, 파싱된 `HEAD`, `NUMBER`, 그리고 원래 입력 순서를 저장하기 위해 `FileInfo` 클래스를 만든다.

   ```java
   class FileInfo {
       String file;
       String head;
       int number;
       int index;
   }
   ```

3. `FileInfo` 객체를 생성할 때 파일명을 파싱한다.

   처음 숫자가 등장하기 전까지를 `HEAD`로 분리한다.

   ```java
   int idx = 0;

   while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
       idx++;
   }

   this.head = file.substring(0, idx);
   ```

4. 숫자가 시작되는 위치를 `numStart`로 저장한 뒤, 숫자가 끝나는 지점까지 이동한다.

   해당 구간을 정수로 변환해 `NUMBER`로 저장한다.

   ```java
   int numStart = idx;

   while (idx < file.length() && Character.isDigit(file.charAt(idx))) {
       idx++;
   }

   this.number = Integer.parseInt(file.substring(numStart, idx));
   ```

5. 모든 파일명을 `FileInfo` 객체로 변환해 배열에 저장한다.

   이렇게 하면 정렬 비교 과정에서 같은 파일명을 반복해서 파싱하지 않아도 된다.

   ```java
   FileInfo[] infos = new FileInfo[files.length];

   for (int i = 0; i < files.length; i++) {
       infos[i] = new FileInfo(files[i], i);
   }
   ```

6. 첫 번째 정렬 기준은 `HEAD`이다.

   `HEAD`는 대소문자를 구분하지 않으므로 `compareToIgnoreCase()`를 사용한다.

   ```java
   int headCompare = a.head.compareToIgnoreCase(b.head);

   if (headCompare != 0) {
       return headCompare;
   }
   ```

7. `HEAD`가 같다면 두 번째 정렬 기준인 `NUMBER`를 비교한다.

   `NUMBER`는 문자열이 아니라 숫자값 기준으로 비교해야 한다.

   ```java
   int numberCompare = Integer.compare(a.number, b.number);

   if (numberCompare != 0) {
       return numberCompare;
   }
   ```

8. `HEAD`와 `NUMBER`가 모두 같다면 원래 입력 순서를 유지해야 한다.

   이를 명시적으로 보장하기 위해 원래 인덱스 `index`를 비교한다.

   ```java
   return Integer.compare(a.index, b.index);
   ```

9. 정렬이 끝난 뒤 `FileInfo` 배열에서 원래 파일명만 꺼내 정답 배열에 담는다.

   ```java
   String[] answer = new String[files.length];

   for (int i = 0; i < infos.length; i++) {
       answer[i] = infos[i].file;
   }

   return answer;
   ```

## :black_nib: **Review**

* 처음에는 Comparator 내부에서 매번 파일명을 파싱했지만, 정렬 중 같은 파일명이 여러 번 비교될 수 있어 비효율적이었다.
* `FileInfo` 객체를 미리 만들어 `HEAD`, `NUMBER`, 원래 인덱스를 저장해두니 파싱을 한 번만 수행할 수 있어 구조가 더 깔끔해졌다.
* `HEAD`는 대소문자를 구분하지 않고, `NUMBER`는 정수값으로 비교해야 하는 점이 핵심이었다.
* `HEAD`와 `NUMBER`가 모두 같은 경우에는 원래 입력 순서를 유지해야 하므로 `index`를 저장해 비교 기준에 포함했다.
* `a.number - b.number` 대신 `Integer.compare()`를 사용하면 오버플로우 가능성을 피할 수 있어 더 안전하다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/17686
