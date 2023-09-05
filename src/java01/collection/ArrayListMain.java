package java01.collection;

import java01.collection.list.ArrayList;

import java.util.*;

/**
 * Collection Framework : 자바의 자료구조
 * - List
 * - Set
 * - Map
 */
public class ArrayListMain {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        for(int i=1; i<=10; i++){
            list.add(i);
        }

        print(list);

        list.add(1, 11);

        print(list);

        list.remove(1);

        print(list);

    }

    public static void print(ArrayList<Integer> list){
        StringJoiner sj = new StringJoiner(",");
        for(int i=0; i< list.size(); i++){
            sj.add(""+list.get(i));
        }
        System.out.println(sj.toString());
        System.out.println(list.size());
    }

}
