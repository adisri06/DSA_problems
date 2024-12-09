package DSA;

import java.util.LinkedList;

class HashNode{
    public String key;
    public String value;

    public HashNode(String key,String value){
        this.key = key;
        this.value = value;
    }   
}
public class HashTable {
public LinkedList<HashNode>[] table;
public int size;

public HashTable(int size){
    this.size = size;
    this.table = new LinkedList[size];
    for (int i = 0; i < size; i++) {
        table[i] = new LinkedList<>();
    }
}
public int hashFunction(String key){
    int asciiSum = 0;
    for (char c : key.toCharArray()) {
        asciiSum += (int) c;
    }
    return asciiSum % size; 

}
public void add(String key, String value){
    int position = hashFunction(key);
    LinkedList<HashNode> existing =  table[position];

    // Check if the key already exists in the bucket, update if found
    for (HashNode hashNode : existing) {
        if(hashNode.key.equals(key)){
            hashNode.value = value;
            return;
        }
    }
    existing.add(new HashNode(key, value));

}
public String find(String key){
    int position = hashFunction(key);
    LinkedList<HashNode> existing =  table[position];

    for (HashNode hashNode : existing) {
        if(hashNode.key.equals(key)){
            return hashNode.value;
        }
        
    }
    return null;

}
public void update(String key, String value){
    int postion = hashFunction(key);
    LinkedList<HashNode> existing = table[postion];
    for (HashNode hashNode : existing) {
        if(hashNode.key.equals(key)){
           hashNode.value = value;
        }
       
        
    }
    add(key,value);
}
public void delete(String key) {
    int index = hashFunction(key);
    LinkedList<HashNode> bucket = table[index];

    // Iterate through the bucket and remove the entry if found
    for (HashNode entry : bucket) {
        if (entry.key.equals(key)) {
            bucket.remove(entry);
            return;
        }
    }
}
public void print(){
    for (int i =0; i< 10;i++){
        System.out.println("Element for "+ i + " index are " );
        LinkedList<HashNode> bucket = table[i];
        if (bucket == null || bucket.isEmpty()) {
            System.out.println("Empty");
        } else {
        for (HashNode hashNode : bucket) {
            System.out.print("{" + hashNode.key + "=" + hashNode.value + "} -> ");

        }
    }

    }
}

public static void main(String[] args) {
    HashTable hashTable = new HashTable(10);
    hashTable.add("Shubham", "Srivastava");
    hashTable.add("Shu", "Srivastava");
    hashTable.add("Shub", "Srivastava");
    hashTable.add("Shu", "Srivas");
    hashTable.add("ADI", "noob");

    hashTable.print();
    System.out.println("Value for key is "+ hashTable.find("ADI"));
    
    hashTable.update("ADI", "Srivas");
    System.out.println("Updated ADI's value: " + hashTable.find("ADI"));

    hashTable.print();  
    hashTable.delete("ADI");
    System.out.println("Finding ADI's value after deletion : " + hashTable.find("ADI"));



    

}
}
