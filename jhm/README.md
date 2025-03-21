POCs to understand how jhm is used to benchmark


With small list (tam = 11)
Benchmark                      Mode  Cnt        Score       Error  Units
StreamConcept.normalStream             thrpt        5  1767775,944 � 97711,426  ops/s
StreamConcept.parallelStream           thrpt        5   294381,034 � 40136,846  ops/s
StreamConcept.normalStream              avgt        5       ? 10??               s/op
StreamConcept.parallelStream            avgt        5       ? 10??               s/op
StreamConcept.normalStream                ss                 0,002               s/op
StreamConcept.parallelStream              ss                 0,003               s/op

With big list (tam = 100.000)
StreamConcept.normalStream              thrpt    5  35487,854 � 9686,039  ops/ms
StreamConcept.parallelStream            thrpt    5  33370,214 � 7289,573  ops/ms