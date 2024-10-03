# [백준 - S1] 25758. 유전자 조합

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 자료 구조
- 브루트포스 알고리즘
- 해시를 사용한 집합과 맵
- 비둘기집 원리

## ⏲️**Time Complexity**

$O(1)$  
입력N은 100000까지지만 최대 반복 횟수는 $(26^2)^2$인 상수시간이다.

## :round_pushpin: **Logic**

입력에 중복이 가능한 최대 100000개가 들어오므로 map을 사용하여 자료구조에 들어갈 수를 압축해준다.
이중for문으로 모든 경우를 돌면서 표현형을 set에 중복없이 저장한다.
일반 set은 기본적으로 정렬상태를 유지하므로 추가적인 정렬 없이 알파벳 순으로 출력 가능.

```cpp
    //입력은 100000개가 들어오지만 중복이 가능하므로 unordered_map으로 중복, 중복 체크
    //최대 종류 수가 26*26=676개라 unordered_map이 아니라 일반 map이어도 비슷했을듯
    unordered_map<string, int> g1;

     for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        g1[str]++;

    }
    //출력이 알파벳 순이고 최대 26종류만 들어갈 수 있으므로 ordered set을 사용하였다.
    set<char> g2;

    for (auto dna1 : g1) {

        for (auto dna2 : g1) {
            if (dna1 == dna2 && dna1.second == 1) {
                continue;//같은 유전자에서 중복이 없으면 continue
            }
            //표현형 phenotype
            char phenotype = dna1.first[0] > dna2.first[1] ? dna1.first[0] : dna2.first[1];
            g2.insert(phenotype);
        }

    }
```

## :black_nib: **Review**

- 입력에서 같은 유전자가 중복으로 들어간 경우를 생각해주는게 중요한 문제같다.

- 첫 줄에 표현형 알파벳 수를 출력하지 않고 유전자 표현형만 출력해서 틀렸었다.. 문제 좀 잘 읽자

## 📡**Link**

- https://www.acmicpc.net/problem/25758
