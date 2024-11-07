#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;

int n, m;
int parent[500000];
int ans;

int find(int u)
{
    if (parent[u] == u) return u;
    else return parent[u] = find(parent[u]);
}

bool union_node(int u, int v)
{
    u = find(u);
    v = find(v);

    // 부모노드가 같으면 사이클이 생기므로 true 반환
    if (u == v) return true;
    else // 노드 결합
    {
        parent[u] = v;
        return false;
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int u, v;
    cin >> n >> m;

    // 자기 자신을 부모로 지정
    for (int i = 0; i < n; i++)
        parent[i] = i;

    // Union Find
    for (int i = 1; i <= m; i++)
    {
        cin >> u >> v;
        if (union_node(u, v))
        {
            ans = i;
            break;
        }
    }

    if (ans == 0) cout << 0;
    else cout << ans;

}
