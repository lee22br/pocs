POCs to understand how jhm is used to benchmark


With small list (tam = 100)
Benchmark                      Mode                Cnt     Score       Error    Units
StreamConcept.normalStream    thrpt                 5     61153,954 ±  278,675  ops/ms
StreamConcept.parallelStream  thrpt                 5     55602,517 ±  554,808  ops/ms

With big list (tam = 100.000)
StreamConcept.normalStream     thrpt                5     61086,137 ±  622,158  ops/ms
StreamConcept.parallelStream   thrpt                5     55548,463 ±   93,042  ops/ms

Sigle shot invocation (100)
StreamConcept.normalStream      ss                       2,516          ms/op
StreamConcept.parallelStream    ss                       3,574          ms/op

Sigle shot invocation (100000)
StreamConcept.normalStream      ss                      2,792          ms/op
StreamConcept.parallelStream    ss                      3,714          ms/op