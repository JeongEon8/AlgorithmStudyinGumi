#include<iostream>
#include<stack>
#include<string.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    
	stack<int> s;
	string str;
	
	int cnt = 0;
	cin >> str;
    
	for (int i = 0; i < str.size(); i++) {
		if (str[i] == '(' && str[i+1] == ')') {
			cnt += s.size();
			i++;
		}
		else if (str[i] == '(') {
			s.push(i);
		}
		else if (str[i] == ')') {
			cnt++;
			s.pop();
		}
	}
    
	cout << cnt;
    
    return 0;
}
