# [프로그래머스 - LV.4] 보호소에서 중성화한 동물
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
Join

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
1. animal_id로 join 후 각 테이블의 중성화 여부로 조건
```sql
select i.animal_id, o.animal_type, o.name from animal_ins as i join animal_outs as o on i.animal_id = o.animal_id
where (i.sex_upon_intake not like 'Spayed%' and i.sex_upon_intake not like '%Neutered%')
and (o.sex_upon_outcome like 'spayed%' or o.sex_upon_outcome like 'neutered%') order by i.animal_id;
```


## :black_nib: **Review**
- 우선순위큐 조

## 📡 Link
https://school.programmers.co.kr/learn/courses/30/lessons/59045
