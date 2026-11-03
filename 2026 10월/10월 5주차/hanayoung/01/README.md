# [SWEA - D3] 01_영준이의 카드 카운팅

## ⏰**time**

15분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 각 카드무늬별로 등장한 번호 담을 배열
   ```
   boolean[] sArr = new boolean[14];
   boolean[] dArr = new boolean[14];
   boolean[] hArr = new boolean[14];
   boolean[] cArr = new boolean[14];
   ```
2. isError 값으로 중복여부 확인
3. index 3개 단위로 돌며, 카드무늬를 의미하는 char과 숫자 분리하여 확인
4. true인지 확인하여 중복확인 후, 아닐 경우 true 처리
```
boolean isError = false;
for(int i = 0; i < str.length()-1; i+=3) {
    int num = Integer.parseInt(str.substring(i+1,i+3));
    switch(str.charAt(i)) {
        case 'S':
            if(sArr[num] == true) {
                isError = true;
                break;
            } else {
                sArr[num] = true;
            }
            break;
        case 'D':
            if(dArr[num] == true) {
                isError = true;
                break;
            } else {
                dArr[num] = true;
            }
            break;
        case 'H':
            if(hArr[num] == true) {
                isError = true;
                break;
            } else {
                hArr[num] = true;
            }
            break;
        case 'C':
            if(cArr[num] == true) {
                isError = true;
                break;
            } else {
                cArr[num] = true;
            }
            break;
    }
}
```
5. isError가 true일 경우, 중복이므로 "ERROR"
6. 아닐 경우, 카운트 세서 출력
```
if(isError == true) sb.append("#").append(tc).append(" ERROR\n");
            else {
                int sCnt = 0;
                int dCnt = 0;
                int hCnt = 0;
                int cCnt = 0;
                for(int i = 1; i <=13; i++) {
                    if(sArr[i] == true) sCnt++;
                    if(dArr[i] == true) dCnt++;
                    if(hArr[i] == true) hCnt++;
                    if(cArr[i] == true) cCnt++;
                }
                sb.append("#").append(tc).append(" ").append(13-sCnt).append(" ").append(13-dCnt).append(" ").append(13-hCnt).append(" ").append(13-cCnt).append("\n");
            }
```
## :black_nib: **Review**

- 너무 더럽게 풀어버렸지만 아무튼 풀렸다... 다음엔 더 예쁘게 풀어야지..

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
