Various synchronizations
=============
Выявленные эффекты:
1. С увеличением числа потоков растет время выполнения каждой операции
2. На переменную, разделенную между потоками тратится значительно больше времени, чем
на обычную
3. На двух потоках synchronized быстрее, а на 4, 8 и 16 быстрее - lock

Более подробно - устно.

Hardware
========
Processor: Intel® Core™ i5 CPU @ 1.30GHz × 4

Memory: 4 GiB

Benchmark results
=================

Stats:
```
Test                                 2        4        8         16
VS.justLock                       515,895  231,322  490,036   944,800
VS.justSynchro                    163,671  312,710  583,833  1253,275
VS.lockShared:reader              578,908  222,548  422,186   873,000
VS.lockShared:writer              436,760  155,766  316,951   634,116
VS.lockThread:reader               33,606   44,713   87,940   175,505
VS.lockThread:writer               28,321   38,674   74,453   147,363
VS.synchronizedShared:reader      144,314  261,751  526,429  1015,044
VS.synchronizedShared:writer      117,017  233,002  452,237  1013,286
VS.synchronizedThread:reader       30,980   41,261   77,850   155,746
VS.synchronizedThread:writer       33,624   40,337   76,405   148,976
VS.volatileShared:reader           32,430   32,428   61,162   109,482
VS.volatileShared:writer           48,041   80,743  161,682   333,455
VS.volatileThread:reader            3,608    6,153   12,902    25,437
VS.volatileThread:writer            8,725   14,141   27,811    56,897

``