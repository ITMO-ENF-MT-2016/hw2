False sharing
=============
One of the unusual thing that can bite you back is false sharing.
If two threads access (and possibly modify) the adjacent values
in memory, chances are, they are modifying the values on the same.

Hardware
========
Processor: Intel® Core™ i5-2410M CPU @ 2.30GHz × 4 
Memory: 7.7 GiB

Benchmark results
=================

Base line of the false sharing:
```
Benchmark                     Mode  Cnt  Score   Error  Units
FalseSharing.baseline         avgt   25  6.143 ± 1.323  ns/op
FalseSharing.baseline:reader  avgt   25  9.736 ± 2.675  ns/op
FalseSharing.baseline:writer  avgt   25  2.551 ± 0.042  ns/op
```

Approach via paddings:
```
Benchmark                     Mode  Cnt  Score   Error  Units
FalseSharing.padded           avgt   25  3.733 ± 0.573  ns/op
FalseSharing.padded:reader    avgt   25  4.908 ± 1.160  ns/op
FalseSharing.padded:writer    avgt   25  2.557 ± 0.062  ns/op
```