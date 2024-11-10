# [백준 - S1] 1105. 팔

## ⏰ **time**

3시간

## :pushpin: **Algorithm**

- LinkedList
- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 각팀에 점수별로 LinkList에 병사에 대한 정보를 담는다.
- 병사가 해고 여부와 version을 담는 배열을 생성하고 병사에 대한 정보를 담는다.
  	- version : 병사의 점수를 업데이트 할때 시간을 단축하기 위해 기존에 있던 병사정보를 지우지 않고 버전정보만 바꿔서 해당 점수에 새로 추가 해준다.

```
public static class LinkList{
		Node head;
		Node tail;
		int size;
		
		public class Node{
			public Soldier data;
			public Node next;
			public Node(Soldier input) {
				this.data = input;
				this.next = null;
			}
		}
		
		public void addNode(Soldier data) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
			size++;
			if(head.next == null) {
				tail = head;
			}
		}
		
		
	}
```

## :black_nib: **Review**
- 링크드 리스트를 구현하는게 너무 어려웠다
- 처음에는 링크드리스트 없이 구현을 해보려고 했지만 점수가 1~5점까지 한정되어있어 병사점수를 업데이트 하는 과정을 구현하기가 어려워 링크드 리스트로 구현할수밖에 없었다.

## 📡**Link**

X
