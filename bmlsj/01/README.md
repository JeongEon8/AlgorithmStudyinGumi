# [SQL - lv5] 01\_상품을 구매한 회원 비율 구하기

## ⏰**time**

10분

## :pushpin: **Algorithm**

join

## ⏲️**Time Complexity**

## :round_pushpin: **Logic**

```sql
-- 2021년에 가입한 전체 회원 수
WITH COUNT_ALL AS (
    SELECT *
    FROM USER_INFO
    WHERE JOINED LIKE '2021%'
)
```

```sql
SELECT YEAR(O.SALES_DATE) AS YEAR, MONTH(O.SALES_DATE) AS MONTH
        , COUNT(DISTINCT O.USER_ID) AS PURCHASED_USER,
        ROUND(COUNT(DISTINCT O.USER_ID) / (SELECT COUNT(*) FROM COUNT_ALL), 1) AS PUCHASED_RATIO
FROM ONLINE_SALE O
JOIN USER_INFO U
ON U.USER_ID = O.USER_ID
WHERE U.JOINED LIKE '2021%'
GROUP BY YEAR(O.SALES_DATE), MONTH(O.SALES_DATE)
ORDER BY YEAR(O.SALES_DATE), MONTH(O.SALES_DATE)
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/131534>
