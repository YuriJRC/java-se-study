|  |  Ordering  |  RandomAccess |  Key-ValuePairs | AllowsDuplicates  |  AllowsNullValues |  ThreadSafe |   BlockingOperations|
|---|---|---|---|---|---|---|---|
|  ArrayList |  Yes |  Yes | No  |  Yes | Yes   |  No |  No  | 
|  LinkedList | Yes  | No  | No  |  Yes | Yes  |  No |  No | 
|  HashSet |  No |  No |  No |  No |  Yes |  No |  No  | 
| TreeSet  | Yes  | No  |  No |  No |  No |   No | No | 
|  LinkedHasSet |  Yes |  No |  No |  No |  Yes | No  |No  | 
| HashMap  | No  |  Yes (by key)|  Yes |  No (by key)|  Yes | No  |   No | 
|  TreeMap |  Yes | Yes (by key)  |  Yes |  No (by key) |  No |  No | No  | 
|  LinkedHashMap |  Yes |Yes (by key)    | Yes  |  No (by key) | Yes  |  No |   No |
| Vector  | Yes  |  Yes | No  | Yes  |Yes   | Yes  |  Yes  | 
|PriorityQueue   | 	Yes  | No  | No  | Yes  |  No | No  |  No  | 
| ArrayDequeue  | 	Yes  | No  |  No | Yes  |  No |  No |  No  | 
| CopyOnWriteArrayList  |  Yes |  Yes | No  |  Yes | Yes  | Yes  | No  |  
| ConcurrentHashMap  | No  |Yes (by key)  |  Yes |  No (by key) | Yes |Yes |No | 
|  CopyOnWriteArraySet | No  | No  |  No | No  |  Yes |  Yes |   No | 
|  Properties | No  |Yes (by key) |Yes  |  No (by key) |  No  | Yes  | Yes   | 