# [SWEA - D4] 5432. 쇠막대기 자르기

## ⏰  **time**
1시간

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 학생들의 이동 정보 저장, -1하고 2로 나눠서 0부터 시작하며 공유하는 복도를 나타내도록 저장
2. 학생 수인 N만큼 반복하며 학생들이 지나가는 복도의 인덱스값 1씩 증가시키고, max보다 해당 복도 값이 클 경우 max 변경
3. 위의 과정을 작은 수 -> 큰 수, 큰 수 -> 작은 수 두 번 해줌


## :black_nib: **Review**
처음에는 지나가는 방이 있으면 해당 방(index)들을 다 1씩 증가시켜줬는데.. 이랬더니 틀려버리기
아래 이미지에서 힌트 얻었당.... 공유하는 건 복도니까 복도 기준으로 생각해주기
![image](https://github.com/user-attachments/assets/f12435a1-2c71-4afc-a26c-bbf95f69f3df)

그래도 와장창 틀렸는데 ? 이유는.. 두둥 작은 방에서 큰 방으로 가는 것만 생각하고, 큰 방에서 작은 방으로 가는 건 생각못하기...

## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWNcJ2sapZMDFAV8
