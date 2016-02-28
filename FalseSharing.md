False sharing
=============
One of the unusual thing that can bite you back is false sharing.
If two threads access (and possibly modify) the adjacent values
in memory, chances are, they are modifying the values on the same.

Hardware
========
Processor: Intel® Core™ i5 CPU @ 1.30GHz × 4

Memory: 4 GiB

Benchmark results
=================

Base line of the false sharing:
```
Benchmark                     Mode  Cnt  Score   Error  Units
FalseSharing.baseline         avgt   25  11,826 ± 0,297  ns/op
FalseSharing.baseline:reader  avgt   25  20,595 ± 0,600  ns/op
FalseSharing.baseline:writer  avgt   25   3,057 ± 0,130  ns/op
```

Approach via paddings:
```
Benchmark                     Mode  Cnt  Score   Error  Units
FalseSharing.padded           avgt   25  3,258 ± 0,020  ns/op
FalseSharing.padded:reader    avgt   25  3,494 ± 0,031  ns/op
FalseSharing.padded:writer    avgt   25  3,021 ± 0,019  ns/op
```
