Expensive volatile
=============
Выявленные эффекты:
1. С увеличением числа потоков растет время выполнения каждой операции, так как
на потоки тратится много ресурсов, по сравнению с обычными операциями чтения и записи
2. На переменную, разделенную между потоками тратится значительно больше времени, чем
на обычную
3. Запись в volatile переменные дороже, чем в обычные, а чтение выполняется за такое же время

Более подробно - устно.

Hardware
========
Processor: Intel® Core™ i5 CPU @ 1.30GHz × 4

Memory: 4 GiB

Benchmark results
=================

Stats:
```
Test                                2       4       8        16
EV.justIntShared:reader          20,809  42,036   70,810  118,054
EV.justIntShared:writer           2,971   4,011    8,441   16,638
EV.justIntThread:reader           3,465   6,973   13,788   27,077
EV.justIntThread:writer           3,007   3,166    6,120   12,142
EV.volatileIntShared:reader      30,764  37,275   62,091  107,697
EV.volatileIntShared:writer      43,157  79,922  163,101  337,392
EV.volatileIntThread:reader       3,448   6,981   12,485   27,179
EV.volatileIntThread:writer       8,471  13,833   28,268   55,865

```