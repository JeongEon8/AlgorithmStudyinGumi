# [SWEA - D3] 01_알파벳 공부

## ⏰**time**

10분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 'a'부터 순서대로 시작해야하므로 비교할 첫 번째 문자 저장
   ```
   int before = (int)str.charAt(0);
   ```
2. 시작 문자가 'a'가 아닐 경우, before에 (int)'a' -1 할당
3. 'a'일 경우 다음 문자부터 문자열끝까지 비교하며 순차적인지(+1인지) 비교하며 순차적 증가라면 before값 업데이트 아니면 break
```
            if(str.charAt(0) == 'a') {
            	for(int i = 1; i < str.length(); i++) {
                    if(before + 1 == (int)str.charAt(i)) {
                        before += 1;
                        continue;
                    } else {
                        break;
                    }
                }
            } else {
                before = (int)'a' -1;
            }
```
4. before-'a'+1로 순차적 개수 확인.
```
System.out.println("#"+test_case+" "+(before-'a'+1));
```

## :black_nib: **Review**

- 가능하면 before 변수 하나로 하려고 하니 좀 안 예뻐진듯..?

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
