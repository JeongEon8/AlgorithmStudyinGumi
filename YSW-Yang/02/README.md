# [PGS - Lv2] 02_스킬트리

## ⏰**time**

- 20분

## :pushpin: **Algorithm**

- HashMap

## ⏲️**Time Complexity**

// M은 skill_trees의 개수, K는 skill_trees안의 문자열 길이
$O(M * K)$

## :round_pushpin: **Logic**

1. 선행 스킬 문자열(skill)을 순회하며 각 스킬의 배울 수 있는 순서(우선순위)를 HashMap에 기록합니다.
   ```java
        int index = 1;
        for(int i = 0; i < skill.length(); i++){
            hashmap.put(skill.charAt(i) ,index++);
        }
   ```

2. 각 유저가 제출한 스킬트리(skill_trees)를 하나씩 순회하며, 선행 스킬 규칙을 잘 지켰는지 검사합니다.
- 새로운 스킬트리를 검사할 때마다 요구되는 스킬 순서(index)를 다시 1로 초기화합니다.
- 유저 스킬트리의 문자가 HashMap에 등록된 선행 스킬일 경우에만 순서를 확인합니다. 현재 요구되는 index와 일치하면 스킬을 정상적으로 배운 것이므로, 다음 스킬을 위해 index++를 해줍니다. 잘못된 순서인 경우: 요구되는 순서와 다르다면 canSkillTree = false 처리 후 탐색을 종료합니다.
- 모든 문자를 검사하는 동안 위반 사항이 없었다면 올바른 스킬트리로 판단하여 answer를 1 증가시킵니다.
   ```java
        for(String s : skill_trees){
            index = 1;
            boolean canSkillTree = true;
            for(int i = 0; i < s.length(); i++){
                if(hashmap.containsKey(s.charAt(i))){
                    if(hashmap.get(s.charAt(i)) == index){
                        index++;
                    }else{
                        canSkillTree = false;
                        break;
                    }
                }
            }
            
            if(canSkillTree){
                answer++;
            }
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/49993
