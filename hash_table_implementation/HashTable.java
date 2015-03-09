import java.io.*;
import java.util.*;

class HashTable<K,V>{

    static final int MAX_SIZE=10;
    LinkedList<Item<K,V>>[] items;
    
    public HashTable(){
	//items=new ArrayList<LinkedList<Item<K,V>>>(10);
	//allocate array of ArrayList and then cast it into required type
	items=(LinkedList<Item<K,V>>[]) new LinkedList[MAX_SIZE];
	for(int i=0;i<MAX_SIZE;i++)
	    items[i]=null;//safety
    }

    public int  hash(K k){
	return k.toString().length()%MAX_SIZE;
    }
    
    void put(K k,V v){
	int x=hash(k);
	if(items[x]==null){
	    items[x]=new LinkedList<Item<K,V>>();
	}
	for(Item<K,V> i:items[x]){
	    if(i.equals_key(k)){
		items[x].remove(i);
		break;
	    }
	}
	Item<K,V> c=new Item<K,V>(k,v);
	items[x].add(c);
    }

    V get(K k){
	int x=hash(k);
	if(items[x]!=null){
	    for(Item<K,V> c:items[x]){
		if(c.equals_key(k)){
		    return c.getValue();
		}
	    }
	}
	return null;
    }

    public static void main(String[] args){
	HashTable<Integer,Integer> ht =new HashTable<Integer,Integer>();
//	ht.put(1,1);
	ht.put(11,11);
	System.out.println(ht.get(1));
	System.out.println(ht.get(11));
    }

}

class Item<K,V>{

    private K key;
    private V value;
    
    Item(K k,V v){
	key=k;
	value=v;
    }

    public boolean equals_key(K c){
	return c.equals(key);
    }

    public K getKey(){
	return key;
    }

    public V getValue(){
	return value;
    }
}
