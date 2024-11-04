# [백준 - 실버 5] 15702. 중간고사 채점
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(N*M)$

## :round_pushpin: **Logic**
1. 점수를 배열에 저장해두고, 해당 O가 입력으로 들어올 때 점수를 더한다.
2. 점수와 번호를 pair를 통해 저장해두고, 정렬한다.
   ```cpp
    bool compare(pair<int, int> a, pair<int, int> b) {
    	if (a.second == b.second) {
    		return a.first < b.first;
    	}
    
    	return a.second > b.second;
    }
   
  	vector<pair<int, int>> student;
  	for (int i = 0; i < M; i++) {
  		int num;
  		cin >> num;
  		
  		int result = 0;
  		for (int j = 0; j < N; j++) {
  			char input;
  			cin >> input;
  			if (input == 'O') {
  				result += score[j];
  			}
  		}
  		student.push_back({ num, result });
  	}
   ```

## :black_nib: **Review**
- 백터를 이용해서 정렬

## 📡 Link
https://www.acmicpc.net/problem/15702
