package java01.collection;

import java.util.*;

public class Collection2Main {

    public static void main(String[] args) {
//        setBox();

    }

    public static void map(){
        Map<String, String> map = new HashMap<>();
        Iterator it = map.keySet().iterator();
        Iterator it2 = map.entrySet().iterator();
    }
    public static void mapCompute(){
        // compute() 메서드는 람다식을 통해서 기존의 값에 어떻게 연산을 할지 지정할 수 있습니다.
        Map<String, Integer> map1 = new HashMap<>();

        map1.compute("coding", (key, oldValue) -> oldValue == null ? 0 : oldValue + 1);
        System.out.println(map1.get("coding"));
        // 실행결과 0

        // key의 값이 있는게 확실 한 경우에는 아래처럼도 가능
        map1.compute("coding", (key, oldValue) -> oldValue + 1);
        System.out.println(map1.get("coding"));
        // 실행결과 1



        Map<String, String> map2 = new HashMap<>();

        // 값이 없으면 람다식의 결과 값을 put하고 값 리턴
        String value = map2.computeIfAbsent("nojam", key -> "Key : " + key );
        System.out.println(value);
        // 실행결과 : Codingnojam

        // 값이 존재하면 해당 key의 값 리턴
        value = map2.computeIfAbsent("nojam2", key -> "Key : " + key );
        System.out.println(value);
        // 실행결과 : Codingnojam
    }

    public static void list(){
        List<String> list = new ArrayList<>();
        Iterator it = list.listIterator();
    }

    public static void set(){
        Set<String> set = new HashSet<>();
        Iterator it = set.iterator();
    }

    public static void binarySearch(){
        int[] arr = {1,2,3,4,5};
        Arrays.binarySearch(arr, 2);
    }

    public static void arrayToCollection(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    }

    public static void sort(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Collections.sort(list);
    }

    // 집합
    public static void setBox(){
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();
        HashSet<Integer> kyoziphap = new HashSet<>();
        HashSet<Integer> habziphap = new HashSet<>();
        HashSet<Integer> chaziphap = new HashSet<>();

        A.add(1);A.add(2);A.add(3);A.add(4);A.add(5);
        B.add(4);B.add(5);B.add(6);B.add(7);B.add(8);

        System.out.println("A = " + A);
        System.out.println("B = " + B);

        Iterator it = B.iterator();
        while (it.hasNext()){
            Object temp = it.next();
            if(A.contains(temp)){
                kyoziphap.add((Integer) temp);
            }
        }

        it = A.iterator();
        while (it.hasNext()){
            Object temp = it.next();
            if(!B.contains(temp)){
                chaziphap.add((Integer) temp);
            }
        }

        it = A.iterator();
        while (it.hasNext()){
            habziphap.add((Integer) it.next());
        }

        it = B.iterator();
        while (it.hasNext()){
            habziphap.add((Integer) it.next());
        }


        System.out.println("A 교집합 B = " + kyoziphap);
        System.out.println("A 합집합 B = " + habziphap);
        System.out.println("A 차집합 B = " + chaziphap);


    }

}
