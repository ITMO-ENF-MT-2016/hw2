Various synchronizations
=============
Verbal explanation

Hardware
========
Processor: Intel® Core™ i5 CPU @ 1.30GHz × 4

Memory: 4 GiB

Benchmark results
=================

Volatile, 1 thread, Scope.Thread:
```
Benchmark                        Mode  Cnt   Score   Error  Units
VariousSynchro.volatile          avgt   25   6,190 ± 0,411  ns/op
VariousSynchro.volatile:reader   avgt   25   3,516 ± 0,152  ns/op
VariousSynchro.volatile:writer   avgt   25   8,864 ± 0,781  ns/op

```

Synchronized, 1 thread, Scope.Thread:
```
Benchmark                           Mode  Cnt   Score   Error  Units
VariousSynchro.synchronized         avgt   25  33,828 ± 2,260  ns/op
VariousSynchro.synchronized:reader  avgt   25  32,402 ± 2,137  ns/op
VariousSynchro.synchronized:writer  avgt   25  35,253 ± 2,392  ns/op

```

Lock, 1 thread, Scope.Thread:
```
Benchmark                           Mode  Cnt   Score   Error  Units
VariousSynchro.lock                 avgt   25  30,897 ± 0,193  ns/op
VariousSynchro.lock:reader          avgt   25  33,539 ± 0,166  ns/op
VariousSynchro.lock:writer          avgt   25  28,255 ± 0,237  ns/op

```


Volatile, 1 thread, Scope.Benchmark:
```
Benchmark                        Mode  Cnt   Score   Error  Units
VariousSynchro.volatile          avgt   25   6,219 ± 0,522  ns/op
VariousSynchro.volatile:reader   avgt   25   3,662 ± 0,413  ns/op
VariousSynchro.volatile:writer   avgt   25   8,775 ± 0,632  ns/op

```

Synchronized, 1 thread, Scope.Benchmark:
```
Benchmark                           Mode  Cnt   Score   Error  Units
VariousSynchro.synchronized         avgt   25  33,315 ± 1,312  ns/op
VariousSynchro.synchronized:reader  avgt   25  31,969 ± 1,399  ns/op
VariousSynchro.synchronized:writer  avgt   25  34,661 ± 1,293  ns/op

```

Lock, 1 thread, Scope.Benchmark:
```
Benchmark                           Mode  Cnt   Score   Error  Units
VariousSynchro.lock                 avgt   25  33,003 ± 2,543  ns/op
VariousSynchro.lock:reader          avgt   25  35,820 ± 2,719  ns/op
VariousSynchro.lock:writer          avgt   25  30,187 ± 2,392  ns/op

```


---


Volatile, 2 threads, Scope.Thread:
```
Benchmark                           Mode  Cnt   Score   Error  Units
VariousSynchro.volatile             avgt   25   5,965 ± 0,086  ns/op
VariousSynchro.volatile:reader      avgt   25   3,522 ± 0,168  ns/op
VariousSynchro.volatile:writer      avgt   25   8,408 ± 0,046  ns/op

```

Synchronized, 2 threads, Scope.Thread:
```
Benchmark                           Mode  Cnt   Score   Error  Units
VariousSynchro.synchronized         avgt   25  32,268 ± 0,158  ns/op
VariousSynchro.synchronized:reader  avgt   25  30,948 ± 0,145  ns/op
VariousSynchro.synchronized:writer  avgt   25  33,588 ± 0,290  ns/op

```

Lock, 2 threads, Scope.Thread:
```
Benchmark                           Mode  Cnt   Score   Error  Units
VariousSynchro.lock                 avgt   25  30,992 ± 0,210  ns/op
VariousSynchro.lock:reader          avgt   25  33,580 ± 0,216  ns/op
VariousSynchro.lock:writer          avgt   25  28,405 ± 0,217  ns/op

```


Volatile, 2 threads, Scope.Benchmark:
```
Benchmark                           Mode  Cnt   Score     Error  Units
VariousSynchro.volatile             avgt   25   37,944 ±  1,669  ns/op
VariousSynchro.volatile:reader      avgt   25   31,798 ±  1,139  ns/op
VariousSynchro.volatile:writer      avgt   25   44,090 ±  2,624  ns/op

```

Synchronized, 2 threads, Scope.Benchmark:
```
Benchmark                           Mode  Cnt   Score     Error  Units
VariousSynchro.synchronized         avgt   25  120,289 ± 13,050  ns/op
VariousSynchro.synchronized:reader  avgt   25  134,697 ± 18,877  ns/op
VariousSynchro.synchronized:writer  avgt   25  105,880 ± 17,151  ns/op

```

Lock, 2 threads, Scope.Benchmark:
```
Benchmark                           Mode  Cnt   Score     Error  Units
VariousSynchro.lock                 avgt   25  527,247 ± 31,963  ns/op
VariousSynchro.lock:reader          avgt   25  582,367 ± 48,864  ns/op
VariousSynchro.lock:writer          avgt   25  472,127 ± 32,652  ns/op

```

---


Volatile, 4 threads, Scope.Thread:
```
Benchmark                           Mode  Cnt   Score   Error  Units
VariousSynchro.volatile             avgt   25  10,095 ± 0,249  ns/op
VariousSynchro.volatile:reader      avgt   25   6,238 ± 0,593  ns/op
VariousSynchro.volatile:writer      avgt   25  13,953 ± 0,344  ns/op

```

Synchronized, 4 threads, Scope.Thread:
```
Benchmark                           Mode  Cnt   Score   Error  Units
VariousSynchro.synchronized         avgt   25  38,645 ± 4,849  ns/op
VariousSynchro.synchronized:reader  avgt   25  38,649 ± 5,140  ns/op
VariousSynchro.synchronized:writer  avgt   25  38,640 ± 5,424  ns/op

```

Lock, 4 threads, Scope.Thread:
```
Benchmark                           Mode  Cnt   Score   Error  Units
VariousSynchro.lock                 avgt   25  42,444 ± 0,701  ns/op
VariousSynchro.lock:reader          avgt   25  46,612 ± 1,606  ns/op
VariousSynchro.lock:writer          avgt   25  38,276 ± 0,865  ns/op

```


Volatile, 4 threads, Scope.Benchmark:
```
Benchmark                           Mode  Cnt   Score     Error  Units
VariousSynchro.volatile             avgt   25   56,325 ±  1,607  ns/op
VariousSynchro.volatile:reader      avgt   25   34,258 ±  2,067  ns/op
VariousSynchro.volatile:writer      avgt   25   78,392 ±  2,409  ns/op

```

Synchronized, 4 threads, Scope.Benchmark:
```
Benchmark                           Mode  Cnt     Score   Error  Units
VariousSynchro.synchronized         avgt   25  246,813 ±  4,132  ns/op
VariousSynchro.synchronized:reader  avgt   25  263,279 ±  7,820  ns/op
VariousSynchro.synchronized:writer  avgt   25  230,347 ±  8,137  ns/op

```

Lock, 4 threads, Scope.Benchmark:
```
Benchmark                           Mode  Cnt    Score    Error  Units
VariousSynchro.lock                 avgt   25  178,696 ±  6,218  ns/op
VariousSynchro.lock:reader          avgt   25  204,005 ± 15,887  ns/op
VariousSynchro.lock:writer          avgt   25  153,387 ±  6,178  ns/op

```