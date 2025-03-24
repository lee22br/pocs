# POCs to understand how jhm is used to benchmark Stream and ParallelStream 
## Problem to Solve:
###  Give a List with Name and Age, Filter by Name "Ana", Filter by Age > 22 and order by Age

Benchmark (single Shot)

| Benchmark       | Size      | Score    | Units   |
|-----------------|-----------|----------|---------| 
| parallelStream  | 100       | 11,851   | ms/op   |
| stream          | 100       | 05,879   | ms/op   |
| parallelStream  | 1000000   | 293,634  | ms/op   |
| stream          | 1000000   | 126,254  | ms/op   |
| parallelStream  | 10000000  | 789,586  | ms/op   |
| stream          | 10000000  | 543,037  | ms/op   |
| parallelStream  | 50000000  | 1584,264 | ms/op  |
| stream          | 50000000  | 2427,566 | ms/op  |
| parallelStream  | 100000000 | 2963,190 | ms/op  |
| stream          | 100000000 | 4532,455 | ms/op  |


## Problem to Solve:
###  Give a List integer numbers calc o sin and return the list 
Benchmark (single Shot)

| Benchmark      | Size  |Score| Units |
|----------------|-------|-----|-------|
| parallelStream | 100   |25,703|  ms/op|
| stream         | 100   |20,655|  ms/op|
| parallelStream | 1000000 |24,663|  ms/op|
| stream         | 1000000 |21,161|  ms/op|
