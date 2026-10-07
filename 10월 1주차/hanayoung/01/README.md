# [SWEA - D3] 01_안경이 없어!

## ⏰**time**

15분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 같은 문자로 판별되는 문자들 하나의 변수로 정의
   ```
   String noHole = "CEFGHIJKLMNSTUVWXYZ";
   String oneHole = "ADOPQR";
   ```
2. 길이가 다를 경우 answer를 "DIFF"로 업데이트 후 종료
   ```
   if(str1.length() != str2.length()) {
                   answer = "DIFF";
               } 
```
3. 길이가 같을 경우, 하나씩 비교하며 같은 문자인지 확인
```
for(int i = 0; i < str1.length(); i++) {
    if(str1.charAt(i) == 'B' && str2.charAt(i) == 'B') {
        continue;
    } else if(checkHole(str1.charAt(i), noHole) && checkHole(str2.charAt(i), noHole)) {
        continue;
    } else if(checkHole(str1.charAt(i), oneHole) && checkHole(str2.charAt(i), oneHole)) {
        continue;
    } else {
        answer = "DIFF";
        break;
    }
}
```
4. 같은 문자에 속하는지 String의 index로 확인. 0보다 크거나 같을 경우 존재한다는 것으로 확인
```
static boolean checkHole(char ch, String str) {
        return str.indexOf(ch) >= 0;
    }
```

## :black_nib: **Review**

- 구현 최고!

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
