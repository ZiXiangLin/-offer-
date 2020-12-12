```java
// 1 Math packages:
int temp = (int)Math.pow(a,3);
Math.max(1,2);
Math.sqrt(8);
int ans = (int)Math.exp(0.5*Math.log(x));

// 2 covert types:
// 1) convert char to int:
Character.getNumericValue(numChar);
// 2) convert str to char/ int/ long:
String str = "babababa bababala";
char c = str.charAt(0);
char[] arr = str.toCharArray();
int i = Integer.parseInt([String]);
String sub = str.substring(p,i);
Long numl = Long.parseLong(sub);
// 3) convert to str:
String s = String.valueOf('c');
String s = String.valueOf(integer);
String str2 = String.valueOf(9);
String str3 = 9 + ":" + 5;
String[] AB = (A + " " + B).split(" ");


  

// 3 sort:
int[] a = {2,3,51,24,56,3,4,2};
Arrays.sort(a);
List<Integer> list = new ArrayList<>();
Collections.sort(list);
// sort by x_end
Arrays.sort(points, (a, b) -> (a[1] - b[1]));
Arrays.sort(points, new Comparator<int[]>() {
   @Override
   public int compare(int[] o1, int[] o2) {
   		return o1[1] - o2[1];
   }
}

List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        //list.sort()
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o2.getValue() != o1.getValue()) return o2.getValue().compareTo(o1.getValue());
                else return o2.getKey().compareTo(o1.getKey());
            }
        });
        int ans = list.get(1).getKey();
            

// 4 data structure methods:
// 1) str methods:
int length = str.length();
for(char c: str.toCharArray()) {}
str.replace(" ","%20");      
// 2) sb method:            
StringBuilder sb = new StringBuilder();
int l = sb.length();
sb.append("sbsbsb");
String str = sb.toString();      
// 3) list methods:
List<Integer> list = new ArrayList<>();
List<Integer> list = new ArrayList<Integer>();
List<List<Integer>> ans = new ArrayList<>();
List<List<Integer>> solution = new LinkedList<List<Integer>>();
Object[] ob = list.get(i);
public void add(int index, E element)
ans.add(new ArrayList<>(list));
list.remove(index);
list.remove((Integer)25); 
list.clear();
Collections.sort(list);
Object[] o = list.toArray(res);
String[]  arr = new String[list.size];  list.toArray(arr);//此时arr就有了list中的值了
String[] arr = (String[])list.toArray(new String[0]);
Iterator iter = even.iterator();
while(iter.hasNext()){
   ans[i++] = (int)iter.next();
}
// 4) stack methods:
Stack<Integer> stack = new Stack<Integer>();
int length = stack.size();
stack.push(object);
Object object = stack.pop();
Object object = stack.peek();
boolean stack.isEmpty();
// 5) queue methods:
Queue<Integer> queue = new LinkedList<Integer>();
int length = queue.size();
queue.offer(object);
Object object = queue.poll();
Object object = queue.peek();
boolean queue.isEmpty();
// 6) hashmap methods:
HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
HashMap<Integer, String> fizzBizzDict =
        new HashMap<Integer, String>() {
          {
            put(3, "Fizz");
            put(5, "Buzz");
          }
        };   
int value = map.get(key);
int score = map.getOrDefault("score", 80);
int length = map.size();
map.put(key,val);
map.containsKey();
map.containsValue();
map.remove(key);
for (Integer i : map.keySet()) {
   Integer count = map.get(i);
}
for(String key : map.keySet()) {        
Iterator iter = map.entrySet().iterator();
while(iter.hasNext()){
	Map.Entry e = (Map.Entry)iter.next();
  int a = (int)e.getKey();
  int b = (int)e.getValue();
}
  
// iteraotr while remove elem：
// https://www.baeldung.com/java-concurrentmodificationexception
iter.remove();
import java.util.*;
public class HashMapSort {
    public static void main(String[] args) {
        Map phone = new HashMap();
        phone.put("Apple", 7299);
        phone.put("SAMSUNG", 6000);
        phone.put("Meizu", 2698);
        phone.put("Xiaomi", 2400);
        //key-sort
        Set set = phone.keySet();
        Object[] arr = set.toArray();
        Arrays.sort(arr);
        for (Object key : arr) {
            System.out.println(key + ": " + phone.get(key));
        }
        System.out.println();
        //value-sort
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(phone.entrySet());
        //list.sort()
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //collections.sort()
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
        }
        System.out.println();
        //for-each
        for (Map.Entry<String, Integer> mapping : list) {
            System.out.println(mapping.getKey() + ": " + mapping.getValue());
        }
    }
```

栈、队列、树、图时从逻辑结构去抽象的，映射到内存中，也是顺序存储结构和链式存储结构。

| 数据结构 | 查找                                       | 插入删除 |
| -------- | :----------------------------------------- | -------- |
| 数组     | O(1) (指定下标)  O(n) -> O(logn)（指定值） | O(n)     |
| 线性链表 | O(n)                                       | O(1)     |
| 二叉树   | O(logn)                                    | O(logn)  |
| 哈希表   | O(1)                                       | O(1)     |



哈希表的主干是数组

要新增或查找某个元素，通过把当前元素的关键字，通过某个函数映射到数组中的某个位置

存储位置=f（关键字） f：哈希函数

哈希冲突/哈希碰撞： 两个不同的元素，通过哈希函数的出的实际存储地址相同

hashmap的主干是一个entry数组

```java
static class Entry<K,V> implements Map.Entry<K,V> {
        final K key;
        V value;
        Entry<K,V> next;//存储指向下一个Entry的引用，单链表结构
        int hash;//对key的hashcode值进行hash运算后得到的值，存储在Entry，避免重复计算

        /**
         * Creates new entry.
         */
        Entry(int h, K k, V v, Entry<K,V> n) {
            value = v;
            next = n;
            key = k;
            hash = h;
        } 
```

![hashmap是由数组➕链表组成的](https://img-blog.csdnimg.cn/20181102221702492.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dvc2hpbWF4aWFvMQ==,size_16,color_FFFFFF,t_70)

Hashmap : 数组（主体） + 链表（解决哈希冲突）

链表出现越少，性能才会越好

![HashMap如何确定元素位置](https://img-blog.csdnimg.cn/20181102214046362.png)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181105181728652.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dvc2hpbWF4aWFvMQ==,size_16,color_FFFFFF,t_70)



HashMap : unsynchronized 不允许重复的键，允许键和值为null

HashTable: synchronized 多个线程可以共享一个hashtable

HashSet：不允许集合中有重复的值，将对象存储在hashset前需要确保对象重写equals（） hashcode()方法，才能比较对象的值是否相等







