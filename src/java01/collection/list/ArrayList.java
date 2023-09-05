package java01.collection.list;

import java.util.List;

public class ArrayList<E> {
    // TODO
    final int DEFAULT_CAPACITY = 10;
    final int DEFAULT_SIZE = 0;
    final Object[] DEFAULT_CAPACITY_EMPTY_DATA = {};

    int capacity;
    Object[] data;
    int size = 0;

    public ArrayList(){
        this.capacity = DEFAULT_CAPACITY;
//        this.data = DEFAULT_CAPACITY_EMPTY_DATA;
        this.data = new Object[this.capacity];
        this.size = DEFAULT_SIZE;
    }


    public void add(Object obj){
        if(capacitySizeCheck()){
            expand();
        }
        data[size++] = obj;
    }

    public void add(int index, Object obj){
        if(capacitySizeCheck()){
            expand();
        }

        for(int i = size; index <= i; i--){
            data[i] = data[i-1];
        }

        data[index] = obj;
        size++;
    }

    public void addFirst(Object obj){
        add(0, obj);
    }

    public void remove(int index){
        for(int i = index; i < size; i++){
            data[i] = data[i+1];
        }
        data[--size] = null;
    }

    public boolean capacitySizeCheck(){
        if(capacity == size){
            return true;
        }
        return false;
    }

    public void expand(){
        capacity *= 2;
        Object[] temp = new Object[capacity];
        copy(data, temp);
        data = new Object[capacity];
        copy(temp, data);
    }

    public void copy(Object[] src, Object[] dest){
        for(int i = 0; i < src.length; i++){
            dest[i] = src[i];
        }
    }

    public void clear(){
        this.capacity = DEFAULT_CAPACITY;
        this.data = DEFAULT_CAPACITY_EMPTY_DATA;
        this.size = DEFAULT_SIZE;
    }

    public E get(int index) {
        return (E) data[index];
    }

    public int size() {
        return size;
    }
}
