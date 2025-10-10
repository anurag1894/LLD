/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.Query;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
    Map<Integer, Integer> map = new HashMap<>();
    strings.sort(Comparator.comparingInt(String::length));

    /*
    1. Stack
    2. Queue
    3. Priority Queue
    4. Deque
    5. List
    6. Map 
    7. Set 
    8. Sort 
         A. Array
         B. List 
    9. Collections, Comparision  
     */


     Stack<Integer> st = new Stack<>();
     st.push(1);
     st.push(2);
     System.out.println(st.peek());
     st.pop();
     System.out.println();

     Queue<Integer> q1 = new LinkedList<>();
     PriorityQueue<Integer> pq = new PriorityQueue<>();
     Deque<Integer> dq = new ArrayDeque<>();
     q1.add(1);
     q1.add(2);
     System.out.println(q1.peek());
     q1.poll();
     System.out.println(q1.poll());
     System.out.println();

     pq.add(29);
     pq.add(30);
     pq.add(16);
     System.out.println(pq.peek());
     pq.poll();
     System.out.println(pq.poll());


     System.out.println();
     dq.add(9);
     dq.addFirst(10);
     dq.addLast(18);
     System.out.println(dq.peek());
     System.out.println(dq.getFirst());
     System.out.println(dq.getLast());
     System.out.println(dq.poll());
     System.out.println(dq.removeLast());

     System.out.println();
     List<Integer> list = new ArrayList<>();
     list.add(12);
     list.add(29);
     list.add(39);
     // Testing Stream 
     list.stream().forEach(x -> System.out.print(x +" "));
     System.out.println();
     list = list.stream().map(x -> x+1).peek(x-> System.out.println(x)).collect(Collectors.toList());


     Map<Integer, Integer> hashMap = new HashMap<>();
     Map<Integer,Integer> sortedMap = new TreeMap<>();
     Map<Integer,Integer> sequeMap = new LinkedHashMap<>();

     hashMap.put(2,  2);
     hashMap.put(9,  2);
     hashMap.put(1,  2);
     hashMap.put(3,  2);
     
     sortedMap.put(2,  2);
     sortedMap.put(1,  2);
     sortedMap.put(3,  2);

     sequeMap.put(2,  2);
     sequeMap.put(1,  2);
     sequeMap.put(3,  2);
     System.out.println();
     for(Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
         System.out.println(entry.getKey() +" "+ entry.getValue());
     }
     System.out.println();
     for(Map.Entry<Integer,Integer> entry : sortedMap.entrySet()){
         System.out.println(entry.getKey() +" "+ entry.getValue());
     }
     System.out.println();
     for(Map.Entry<Integer,Integer> entry : sequeMap.entrySet()){
        System.out.println(entry.getKey() +" "+ entry.getValue());
     }
      System.out.println();

     if(hashMap.containsKey(1)){
         System.out.println(hashMap.get(1));
     }

     /*
      same will be for sort as well
      */
     int[] arr = new int[]{4,3,2,6,5};
     String str = "hell";
      System.out.println();
     System.out.println(str.length()); // str.length
     System.out.println(strings.size()); // List -> size()
     System.out.println(arr.length);  // arr -> length


    Arrays.sort(arr); // This is the only we can sort array int
    // If Integer[] arr , then we can use 
    // Arrays.sort(arr, Collections.reverseOrder());
    System.out.println();
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+ " "); 
    }
    arr = Arrays.stream(arr) // this is for reverse 
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
    
    System.out.println();
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+ " "); 
    }


    Integer[] derivedArr = new Integer[]{4,5,6,3,1};
    Arrays.sort(derivedArr, Collections.reverseOrder());
     System.out.println();
    for(int i=0;i<derivedArr.length;i++){
        System.out.print(derivedArr[i]+ " "); 
    }

    // This above is for array , now let's check List 
    // we already have list, strings. let's do both base on value and 
    // length

     System.out.println();

    list.sort(Comparator.naturalOrder());
    list.stream()
        .forEach(x -> System.out.print(x+" "));
     System.out.println();
    list.sort(Comparator.reverseOrder());
    list.stream()
        .forEach(x -> System.out.print(x+" "));
    List<String> listString = new ArrayList<>();
    listString.add("First");
    listString.add("second");
    listString.add("third");    
    listString.sort(Comparator.comparingInt(String::length));

    strings.sort(Comparator.comparingInt(String::length));

    System.out.println();
    strings.stream()
        .forEach(x -> System.out.print(x+" "));
    System.out.println();
    listString.stream()
        .forEach(x -> System.out.print(x+" "));

    // For any other object if we have List<A> listOfA = new ...
    // To sort base on some value of A we can have
    // listOfA.sort((a, b) -> b.id - a.id);
    // listOfA.sort(Comparator.comparingInt(A::getId))
    list.add(100);
     list.sort((a,b) -> b-a); // This will sort above one as reverse , So either we can use Compartor OR FI
    System.out.println();
     list.stream()
        .forEach(x -> System.out.print(x+" "));
    
    /*
    Q1. Differnce b/w Comparable and  Comparator 
        Method. compareTo(T o). compare(T o1, T o2)
    Q2. Differnce between ArrayList and List 
      List -> Interface where as ArrayList is Class implements over List 
    Q3. Difference between HashMap and Hashtable?
            HashMap: Not synchronized, allows one null key, faster.
            Hashtable: Synchronized, doesn’t allow nulls, slower.

    Q4. Convert List<Integer> to int[] and vice-versa
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();

        List<Integer> list2 = Arrays.stream(array).boxed().collect(Collectors.toList());
     */
  }
}
