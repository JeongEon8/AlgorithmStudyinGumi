package b5_병사관리;

import java.util.ArrayList;

import b5_병사관리.UserSolution.LinkList.Node;

class UserSolution
{
	
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
	public void mergeLists(LinkList list1, LinkList list2) {
	    // list1이 비어 있으면, list2를 그대로 list1에 넣음
	    if (list1.head == null) {
	        list1.head = list2.head;
	        list1.tail = list2.tail;
	        list1.size = list2.size;
	    } else if (list2.head != null) { // list1이 비어있지 않고, list2가 비어있지 않을 때만 연결
	        // list1의 tail을 list2의 head에 연결
	        list1.tail.next = list2.head;
	        
	        // list1의 tail을 list2의 tail로 업데이트
	        list1.tail = list2.tail;
	        
	        // size 업데이트
	        list1.size += list2.size;
	    }
	    
	    // list2 초기화
	    list2.head = null;
	    list2.tail = null;
	    list2.size = 0;
	}
	
	public static Soldier[] soldiers;
	public static ArrayList[] teams;
	public static LinkList[][] scores;
	
	public class Soldier{
		Boolean isFire;
		int version;
		int team;
		int mID;
		
	}
	
	
	public void init()
	{
		soldiers = new Soldier[100001];
		scores = new LinkList[6][6];
		  for (int i = 1; i <= 5; i++) {
		        for (int j = 1; j <= 5; j++) {
		            scores[i][j] = new LinkList();
		        }
		    }
		
		
	}
	
	

	public void hire(int mID, int mTeam, int mScore)
	{
		Soldier soldier = new Soldier();
		
		
		soldier.isFire = false;
		soldier.version = 1;
		soldier.team  = mTeam;
		soldier.mID = mID;
		soldiers[mID] = soldier;
		soldier = new Soldier();
		soldier.isFire = false;
		soldier.version = 1;
		soldier.team  = mTeam;
		soldier.mID = mID;
		
		scores[mTeam][mScore].addNode(soldier);
		
		
	}
	
	public void fire(int mID)
	{
		soldiers[mID].isFire=true;
	}

	public void updateSoldier(int mID, int mScore)
	{
		
		Soldier soldier = new Soldier();
		Soldier soldierP = soldiers[mID];
		
		
		soldier.isFire = false;
		soldier.version = soldierP.version+1;
		soldier.team  = soldierP.team;
		soldier.mID = mID;
		scores[soldierP.team][mScore].addNode(soldier);
		soldiers[mID].version = soldier.version;
		
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		if (mChangeScore > 0) {
	        for (int i = 4; i > 0; i--) {
	            int num = Math.min(i + mChangeScore, 5); // 최대 5로 제한
	            mergeLists(scores[mTeam][num], scores[mTeam][i]);
	        }
	    } else if (mChangeScore < 0) {
	        for (int i = 2; i < 6; i++) {
	            int num = Math.max(i + mChangeScore, 1); // 최소 1로 제한
	            
	            mergeLists(scores[mTeam][num], scores[mTeam][i]);
	        }
	    }
		
	}
	
	public int bestSoldier(int mTeam)
	{
		 int result = 0;
		    for (int i = 5; i > 0; i--) {
		        Node data = scores[mTeam][i].head;

		        // Null 체크 추가
		        while (data != null) {
		            int id = data.data.mID;
		            if (soldiers[id].isFire == false && data.data.version == soldiers[id].version && id > result) {
		                result = id;
//		  
//				        System.out.println( data.data.version);
//					    System.out.println(soldiers[id].version);
		            }
		            data = data.next;
		        }

		        if (result != 0) {
//		        	System.out.println(i);
		            break;
		        }
		        
		    }
		 
		   
//		   System.out.println(result);
		    return result;
		
	}
}
