#include <iostream>
#include <deque>

using namespace std;

int main() {
  deque<int> dq;
  int idx;
  int res = 0;

  int n, m, x;
  cin >> n >> m;

  for(int i = 1; i <= n; i++) {
    dq.push_back(i);
  }

  while(m--) {
    cin >> x;

    for(int i = 0; i < dq.size(); i++) {
      if(dq[i] == x) {
        idx = i;
        break;
      }
    }

    if(idx <= dq.size() / 2) {
      while(1) {
        if(dq.front() == x) {
          dq.pop_front();
          break;
        }
        ++res;
        dq.push_back(dq.front());
        dq.pop_front();
      }
    } else {
      while(1) {
        if(dq.front() == x) {
          dq.pop_front();
          break;
        }
        ++res;
        dq.push_front(dq.back());
        dq.pop_back();
      }
    }
  }

  cout << res;

  return 0;
}
