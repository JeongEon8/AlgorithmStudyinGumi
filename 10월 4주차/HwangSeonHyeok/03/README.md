# [백준 - G3] 16934. 게임 닉네임

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 자료 구조
- 문자열
- 트리
- 집합과 맵
- 해시를 사용한 집합과 맵
- 트라이

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
트라이, 노드에다가 각 닉네임과 중복된 갯수를 저장한다.
트라이에 새로운 노드가 추가되면 거기까지가 접두사고 아닌 경우 풀네임 또는 풀네임+중복수가 별칭이된다.
```java
static class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    String insert(String word) {
        TrieNode currentNode = root;
        StringBuilder prefix = new StringBuilder();
        boolean findPrefix = false;
        char[] charArr = word.toCharArray();
        for (char c : charArr) {
            if (currentNode.children.containsKey(c)) {
                currentNode = currentNode.children.get(c);
                if (!findPrefix) {
                    prefix.append(c);
                }
            } else {
                currentNode.children.put(c, new TrieNode());
                currentNode = currentNode.children.get(c);
                if (!findPrefix) {
                    prefix.append(c);
                    findPrefix = true;
                }
            }

        }
        currentNode.cnt++;
        if (!findPrefix && currentNode.cnt > 1) {
            prefix.append(currentNode.cnt);
        }
        return prefix.toString();
    }

}
```

## :black_nib: **Review**
트라이 복습
## 📡**Link**

https://www.acmicpc.net/problem/16934