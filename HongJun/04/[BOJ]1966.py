t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    import_list = list(map(int, input().split()))
    index_list = list(i for i in range(1, n+1))
    index_list[m] = 'target'
    idx = 0

    while 1:
        if import_list[0] == max(import_list):
            idx += 1

            if index_list[0] == 'target':
                print(idx)
                break
            else:
                index_list.pop(0)
                import_list.pop(0)

        else:
            import_list.append(import_list.pop(0))
            index_list.append(index_list.pop(0))