#include <iostream>
#include <vector>
#include <algorithm>

using namespace std; 

int parent[10001];

int find(int x) {
	if (parent[x] == x) {
        return x;
    }
	else {
        return parent[x] = find(parent[x]); 
    }
}

void uni(int x, int y) {
	x = find(x); 
	y = find(y); 
	parent[y] = x; 
}

bool sameparent(int x, int y) {
	x = find(x); 
	y = find(y); 
	if (x == y) {
        return true;
    }
	else {
        return false;    
    }
}

int main(void) {
	int vertex, e; 
	cin >> vertex >> e;
    
	int result = 0; 
	vector<pair<int, pair<int, int>>>v; 
	for (int i = 0; i < e; i++) {
		int from, to, cost; 
		cin >> from >> to >> cost; 
		v.push_back({ cost,{from,to} }); 
	}
    
	sort(v.begin(), v.end()); 
    
	for (int i = 1; i <= vertex; i++){
        parent[i] = i; 
    }
	for (int i = 0; i < v.size(); i++) {
		if (!sameparent(v[i].second.first, v[i].second.second)) {
			uni(v[i].second.first, v[i].second.second); 
			result += v[i].first; 
		}
	}
	cout << result; 
    
    return 0;
}
