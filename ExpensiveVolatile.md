Expensive volatile
=============
Verbal explanation

Hardware
========
Processor: Intel® Core™ i5 CPU @ 1.30GHz × 2

Memory: 4 GiB

Benchmark results
=================

Non volatile, 1 thread, Scope.Thread:
```
Benchmark                             Mode  Cnt  Score   Error  Units
ExpensiveVolatile.nonVolatile         avgt   25  3,413 ± 0,117  ns/op
ExpensiveVolatile.nonVolatile:reader  avgt   25  3,764 ± 0,199  ns/op
ExpensiveVolatile.nonVolatile:writer  avgt   25  3,063 ± 0,051  ns/op

```

Volatile, 1 thread, Scope.Thread:
```
Benchmark                     Mode  Cnt  Score   Error  Units
ExpensiveVolatile.volatile            avgt   25  6,239 ± 0,247  ns/op
ExpensiveVolatile.volatile:reader     avgt   25  3,692 ± 0,211  ns/op
ExpensiveVolatile.volatile:writer     avgt   25  8,787 ± 0,288  ns/op

```

Non volatile, 1 thread, Scope.Benchmark:
```
Benchmark                             Mode  Cnt  Score   Error  Units
ExpensiveVolatile.nonVolatile         avgt   25  11,633 ± 0,254  ns/op
ExpensiveVolatile.nonVolatile:reader  avgt   25  20,257 ± 0,492  ns/op
ExpensiveVolatile.nonVolatile:writer  avgt   25   3,010 ± 0,055  ns/op

```

Volatile, 1 thread, Scope.Benchmark:
```
Benchmark                     Mode  Cnt  Score   Error  Units
ExpensiveVolatile.volatile            avgt   25  29,311 ± 4,174  ns/op
ExpensiveVolatile.volatile:reader     avgt   25  26,502 ± 2,652  ns/op
ExpensiveVolatile.volatile:writer     avgt   25  32,120 ± 5,798  ns/op

```

---


Non volatile, 2 threads, Scope.Thread:
```
Benchmark                             Mode  Cnt  Score   Error  Units
ExpensiveVolatile.nonVolatile         avgt   25  3,424 ± 0,082  ns/op
ExpensiveVolatile.nonVolatile:reader  avgt   25  3,785 ± 0,137  ns/op
ExpensiveVolatile.nonVolatile:writer  avgt   25  3,062 ± 0,048  ns/op

```

Volatile, 2 threads, Scope.Thread:
```
Benchmark                     Mode  Cnt  Score   Error  Units
ExpensiveVolatile.volatile            avgt   25  6,176 ± 0,231  ns/op
ExpensiveVolatile.volatile:reader     avgt   25  3,639 ± 0,201  ns/op
ExpensiveVolatile.volatile:writer     avgt   25  8,713 ± 0,265  ns/op

```

Non volatile, 2 threads, Scope.Benchmark:
```
Benchmark                             Mode  Cnt  Score   Error  Units
ExpensiveVolatile.nonVolatile         avgt   25  11,635 ± 0,233  ns/op
ExpensiveVolatile.nonVolatile:reader  avgt   25  20,293 ± 0,459  ns/op
ExpensiveVolatile.nonVolatile:writer  avgt   25   2,978 ± 0,024  ns/op

```

Volatile, 2 threads, Scope.Benchmark:
```
Benchmark                             Mode  Cnt  Score   Error  Units
ExpensiveVolatile.volatile            avgt   25  34,619 ± 3,914  ns/op
ExpensiveVolatile.volatile:reader     avgt   25  31,003 ± 6,399  ns/op
ExpensiveVolatile.volatile:writer     avgt   25  38,235 ± 3,452  ns/op

```

---


Non volatile, 4 threads, Scope.Thread:
```
Benchmark                             Mode  Cnt  Score   Error  Units
ExpensiveVolatile.nonVolatile         avgt   25   5,416 ± 0,316  ns/op
ExpensiveVolatile.nonVolatile:reader  avgt   25   7,456 ± 0,448  ns/op
ExpensiveVolatile.nonVolatile:writer  avgt   25   3,375 ± 0,199  ns/op

```

Volatile, 4 threads, Scope.Thread:
```
Benchmark                     Mode  Cnt  Score   Error  Units
ExpensiveVolatile.volatile            avgt   25  10,338 ± 0,519  ns/op
ExpensiveVolatile.volatile:reader     avgt   25   6,196 ± 0,903  ns/op
ExpensiveVolatile.volatile:writer     avgt   25  14,481 ± 0,455  ns/op

```

Non volatile, 4 threads, Scope.Benchmark:
```
Benchmark                             Mode  Cnt  Score   Error  Units
ExpensiveVolatile.nonVolatile         avgt   25  22,980 ± 1,009  ns/op
ExpensiveVolatile.nonVolatile:reader  avgt   25  41,762 ± 2,415  ns/op
ExpensiveVolatile.nonVolatile:writer  avgt   25   4,199 ± 0,563  ns/op

```

Volatile, 4 threads, Scope.Benchmark:
```
Benchmark                             Mode  Cnt  Score   Error  Units
ExpensiveVolatile.volatile            avgt   25  55,051 ± 1,591  ns/op
ExpensiveVolatile.volatile:reader     avgt   25  33,471 ± 2,156  ns/op
ExpensiveVolatile.volatile:writer     avgt   25  76,631 ± 1,853  ns/op

```