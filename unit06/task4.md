|   |  Основная функциональность |  Примеры типичного использования |   
|---|---|---|
|  Set |  В реализации интерфейса Set не содержится дублирующих элементов. Множества часто используются для проверки принадлежности объекта заданному множеству.  | К интерфейсу Set относятся HashSet, TreeSet и LinkedHashSet. HashSet хранит элементы в хеш-таблице, обеспечивая высокую производительность, но не гарантируя порядок элементов. В TreeSet объекты хранятся отсортированными по возрастанию. LinkedHashSet хранит элементы в порядке добавления.|  
| List  |List представляет собой упорядоченный набор элементов и может содержать повторяющиеся элементы. Можно получить доступ к любому элементу по индексу. Список представляет собой динамический массив. |  ArrayList — реализация интерфейса List в виде массива переменной длины. Но работать с ArrayList проще и удобнее, чем с массивами. Можно без проблем добавлять новые элементы, в том числе и в середину листа. LinkedList — реализация интерфейсов List и Deque в виде двусвязного списка. Он оптимизирован для быстрой вставки/удаления в начало/конец списка|   
| Queue  | Queue - коллекция, предназначенная для хранения элементов в порядке, нужном для их обработки. Очереди обычно, но не обязательно, упорядочивают элементы в FIFO (first-in-first-out, "первым вошел - первым вышел") порядке.  |  PriorityQueue - единственная прямая реализация интерфейса Queue. Эта очередь упорядочивает элементы либо по их натуральному порядку (используя интерфейс Comparable), либо с помощью интерфейса Comparator, полученному в конструкторе. Интерфейс Dequeue расширяет Queue и поддерживает вставку и удаление элемента как в начало, так и в конец коллекции.|  
| Map  | Map — это структурированные данные, состоящие из набора пар ключ-значение. Ключи могут быть уникальными, а значения могут дублироваться. Map позволяет искать объекты по ключу.  | Есть три реализации Map: HashMap, TreeMap и LinkedHashMap. Класс HashMap использует хеш-таблицу для хранения элементов, обеспечивая высокую производительность. Данная реализация не гарантирует порядка элементов. LinkedHashMap — это упорядоченная реализация хэш-таблицы (хранит элементы в порядке добавления), в которой имеются двунаправленные связи между элементами подобно LinkedList. TreeMap сортируется по ключам с использованием принципа "natural ordering". Но это поведение может быть настроено под конкретную задачу при помощи интерфейсов Comparable или Comparator.   |  