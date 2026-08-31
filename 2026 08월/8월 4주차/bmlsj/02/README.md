# [PGS - Lv4] 02\_취소되지 않은 진료 예약 조회하기

## ⏰**time**

- 30분

## :round_pushpin: **Logic**

3중 조인을 활용해 각 조건에 맞는 데이터 출력

```sql
SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM APPOINTMENT A
JOIN DOCTOR D
ON A.MDDR_ID = D.DR_ID
JOIN PATIENT P
ON A.PT_NO = P.PT_NO
WHERE A.APNT_CNCL_YN = 'N' AND A.APNT_YMD LIKE '2022-04-13%' AND A.MCDP_CD = 'CS'
ORDER BY APNT_YMD
```

## :black_nib: **Review**

-

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/132204>
