#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int t,n;
int ret;
vector<pair<int,int>> v;

int main(void){
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> t;
	while(t--){
		cin >> n;
		v.clear();
		for(int i=0; i<n; i++){
			int a,b;
			cin >> a >> b;
			v.push_back({a,b});
		}
		sort(v.begin(), v.end());
		
		int tmp = 0;
		ret = 1;
		for(int i=1; i<n; i++){
			if(v[tmp].second > v[i].second){
				ret++;
				tmp = i;
			}
		}
		cout << ret << '\n';
	}
	return 0;
}
