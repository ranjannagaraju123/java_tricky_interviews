import java.io.*;
import java.util.*;

class A {
    A() {
        print();
    }

    void print() {
        System.out.println("A Constructor");
    }
}

public class Solution extends A {

    int index = 4;

    void print() {
        System.out.println(index);
    }

    public static void main(String[] args) throws Exception {

        /** Question 1 */
        System.out.println("Question 1\n***********\n");
        A a = new Solution();
        a.print();

        /** Question 1 Answer */
        //A Constructor
        // 4


        /** Question 2 */
        System.out.println("\nQuestion 2\n***********\n");
        findBooleanOutput();

        /** Question 2 Answer */

        /** Question 3 */
        System.out.println("\nQuestion 3\n***********\n");
        findOutput();

        /** Question 3 Answer */


        /** Question 4 */
        System.out.println("\nQuestion 4\n***********\n");
        //findExOutput();

        /** Question 4 Answer */

        /** Question 5 */
        System.out.println("\nQuestion 5\n***********\n");
        countWords();

        /** Question 6 */
        System.out.println("\nQuestion 6\n***********\n");
        findFirstNonRepeatingChar();

    }

    /** Question 2 */
    public static void findBooleanOutput() {
        boolean b1 = false;
        boolean b2  = true;
        if (b2 = b1 != b2){
            System.out.println("true");
            System.out.println("b2" + b2 +"b1"+ b1);

        } else{
            System.out.println("false");

        }
    }

    // compilation Error on 67

    /** Question 3 */
    public static void findOutput() {
        Integer num1 = 100;
        Integer num2 = 100;
        Integer num3 = 500;
        Integer num4 = 500;

        if (num1 == num2) {
            System.out.println("num1 == num2");
        } else {
            System.out.println("num1 != num2");
        }
        if (num3 == num4) {
            System.out.println("num3 == num4");
        } else {
            System.out.println("num3 != num4");
        }
    }
    // num1 == num2
    // num3 == num4

    /** Question 4 */
    public static void m1() throws Exception {
        throw new Exception();
    }

    public static void findExOutput() throws Exception {
        try {
            m1();
            System.out.println("Try");
        } finally {
            System.out.println("Finally");
        }
        System.out.println("End");
    }

    // Finally

    /** Question 5 */
    public static void countWords() {
        String str = "This this is is done by me me only";
        str=str.toLowerCase();
        String[] split = str.split(" ");
       // Map<String,Integer> map = new LinkedHashMap<String,Integer>(); insertion order
         Map<String,Integer> map = new HashMap<String,Integer>();

        for (String newMapkey: split){
            if(map.keySet().contains(newMapkey))
            {
                map.put(newMapkey, map.get(newMapkey) + 1);
            }
            else{
                map.put(newMapkey, 1);
            }

        }
        System.out.println("word" + "\t\t" + "Count");
        Map<String,Integer> linkmap=sortBycount(map);
for ( Map.Entry<String,Integer> es  :linkmap.entrySet()){


    System.out.println(es.getKey() + "\t\t"+ es.getValue());

}
        /** Code Here */
        System.out.println(map);
    }

    private static  Map<String,Integer> sortBycount(Map<String, Integer> map) {

      Set<Map.Entry<String,Integer>> entrySets=  map.entrySet();

     List<Map.Entry<String,Integer>> list= new ArrayList<Map.Entry<String,Integer>>(entrySets);
     Collections.sort(list,
             new Comparator<Map.Entry<String,Integer>>() {
                 @Override
                 public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());

                 }
             });
     Map<String,Integer> linkedhmp= new LinkedHashMap<String,Integer>();
     for(Map.Entry<String,Integer> ls:list)
     {
         linkedhmp.put(ls.getKey(),ls.getValue());

     }
     return linkedhmp;
    }

    /** Question 6 */
    public static void findFirstNonRepeatingChar() {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java 8.");
        strings.add("NAAMNM");
        strings.add("ranjankeragodunagaraju");
for (String s:strings) {

    char index = firstNonRepeating(s.replaceAll("[^a-zA-Z]","").toLowerCase());

    System.out.println(index);
}
    }

    static char firstNonRepeating(String s) {
        /** Code Here */
        int[] charcount=new int[26];
        for (char c:s.toCharArray()
             ) {
            charcount[c-'a']++;

        }

        for (char c:s.toCharArray()
        ) {
            if(charcount[c-'a'] ==1) return c;

        }
        return '_';
    }

}