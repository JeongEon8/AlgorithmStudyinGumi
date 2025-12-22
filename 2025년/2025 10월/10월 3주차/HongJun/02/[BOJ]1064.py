xa, ya, xb, yb, xc, yc = map(int, input().split())

if ((xa - xb) * (ya - yc) == (ya - yb) * (xa - xc)):
    print(-1.0)
else:
    xd2 = (xa + xc) - xb
    yd2 = (ya + yc) - yb

    cir_1 = (abs(xa - xb) ** 2 + abs(ya - yb) ** 2) ** 0.5 + (abs(xa - xc) ** 2 + abs(ya - yc) ** 2) ** 0.5
    cir_2 = (abs(xa - xb) ** 2 + abs(ya - yb) ** 2) ** 0.5 + (abs(xa - xd2) ** 2 + abs(ya - yd2) ** 2) ** 0.5
    cir_3 = (abs(xa - xc) ** 2 + abs(ya - yc) ** 2) ** 0.5 + (abs(xa - xd2) ** 2 + abs(ya - yd2) ** 2) ** 0.5

    ans = max(cir_1, cir_2, cir_3) - min(cir_1, cir_2, cir_3)

    print(ans*2)