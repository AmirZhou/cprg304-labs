package implementations;

import java.util.ArrayList;

import exceptions.DuplicateKeyException;
import utilities.DictionaryADT;

public class Dictionary<K,V> implements DictionaryADT<K,V>
{
	// constant
	private static final int DEFAULT_SIZE = 10;
	
	// index indicates pairing, e.g. keys[1] is stored at values[1]
	private ArrayList<K> keys;
	private ArrayList<V> values;
	
	
	// Constructor with specified capacity
    public Dictionary(int capacity) {
        keys = new ArrayList<>(capacity);
        values = new ArrayList<>(capacity);
    }
    
    public Dictionary() {
        this(DEFAULT_SIZE);
    }
    
    @Override
    public void create(int size) {
        keys = new ArrayList<>(size);
        values = new ArrayList<>(size);
    }
	
	
    @Override
    public boolean insert(K key, V value) throws DuplicateKeyException {
        // Check for null key
        if (key == null) return false;
        
        // Check if key already exists
        if (keys.contains(key)) {
            throw new DuplicateKeyException();
        }
        
        // Add the key-value pair
        keys.add(key);
        values.add(value);
        return true;
    }
	
    @Override
    public V remove(K key) {
        // Check for null key
        if (key == null) return null;
        
        // Find the index of the key
        int index = keys.indexOf(key);
        
        // If key not found, return null
        if (index == -1) return null;
        
        // Remove key and value at that index and return the value
        keys.remove(index);
        return values.remove(index);
    }
	
    @Override
    public boolean update(K key, V value) {
        // Check for null key
        if (key == null) return false;
        
        // Find the index of the key
        int index = keys.indexOf(key);
        
        // If key not found, return false
        if (index == -1) return false;
        
        // Update the value at that index
        values.set(index, value);
        return true;
    }
	
    @Override
    public V lookup(K key) {
        // Check for null key
        if (key == null) return null;
        
        // Find the index of the key
        int index = keys.indexOf(key);
        
        // If key not found, return null
        if (index == -1) return null;
        
        // Return the value at that index
        return values.get(index);
    }
	
    public int size() {
        return keys.size();
    }
	
    public boolean isEmpty() {
        return keys.isEmpty();
    }
	
	
}
