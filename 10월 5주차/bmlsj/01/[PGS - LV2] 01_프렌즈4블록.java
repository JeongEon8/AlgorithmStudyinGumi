

import java.util.*;
class Solution {
    
    static class Node {
        int x, y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
        
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    static public int solution(int m, int n, String[] board) {
		int ans = 0;

		String[][] boards = new String[m][n];
		HashMap<String, ArrayList<Node>> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			int j = 0;
			for (String b : board[i].split("")) {
				boards[i][j] = b;
				map.putIfAbsent(b, new ArrayList<Node>());
				map.get(b).add(new Node(i, j++));
			}
		}

		// 2x2 블럭 제거
		while (true) {
            HashSet<Node> toRemove = new HashSet<>();
			map.forEach((key, nodes) -> {
				for (Node node : nodes) {
					if (node.x + 1 < m && node.y + 1 < n) {
						if (boards[node.x + 1][node.y].equals(key) && 
                            boards[node.x][node.y + 1].equals(key) &&
                            boards[node.x + 1][node.y + 1].equals(key)) {

							toRemove.add(new Node(node.x, node.y));
							toRemove.add(new Node(node.x + 1, node.y));
							toRemove.add(new Node(node.x, node.y + 1));
							toRemove.add(new Node(node.x + 1, node.y + 1));
						}
					}
				}
			});

			if (toRemove.size() == 0)
				break;

			map.forEach((key, nodes) -> {
				nodes.removeAll(toRemove);
			});

			for (Node node : toRemove) { // 제거한 노드들 초기화
				boards[node.x][node.y] = "";
			}

			ans += toRemove.size();
			map = fallNodes(map, m);
			updateBoards(boards, map, m, n);

		}

		return ans;
    }
    
    static HashMap<String, ArrayList<Node>> fallNodes(HashMap<String, ArrayList<Node>> map, int m) {

		List<Node> allNodes = new ArrayList<>();
		for (ArrayList<Node> nodes : map.values()) {
			allNodes.addAll(nodes);
		}

		allNodes.sort((a, b) -> b.x - a.x);
		
		for (Node node : allNodes) {
			while (node.x + 1 < m && !hasNode(map, node.x + 1, node.y)) { // 노드가 범위안이고, 해당 노드가 map에 없을 때
				node.x++;
			}
		}
	
		return map;
	}
    
    static boolean hasNode(HashMap<String, ArrayList<Node>> map, int x, int y) {

		for (ArrayList<Node> nodes : map.values()) {
			for (Node node : nodes) {
				if (node.x == x && node.y == y) {
					return true;
				}
			}
		}
		return false;
	}
    
    private static void updateBoards(String[][] boards, HashMap<String, ArrayList<Node>> map, int m, int n) {

		for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boards[i][j] = "";
            }
        }
        
		for (Map.Entry<String, ArrayList<Node>> entry : map.entrySet()) {
			String key = entry.getKey();
			ArrayList<Node> nodes = entry.getValue();

			for (Node node : nodes) {
				boards[node.x][node.y] = key;
			}
		}
	}
}