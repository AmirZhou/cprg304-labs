package utilities;

/**
* DictionaryADT.java
*
* @author Yue (Amir) Zhou
* @version 0.1
* 
* Class Definition: This interface represents the public contract for the
* implementation of Dictionary for the DictionaryADT Lab. 
*/
public interface DictionaryADT<K,V>
{
	/**
	 * Returns {@code true} if this dictionary contains a mapping for the specific key.
	 * @param key key whose presence in this map is to be tested
	 * @return {@code true} if this map contains a mapping for the specified key
	 * @throws ClassCastException if the key is of an inappropriate type for this map
	 */
	boolean containsKey(K key);
	
	/**
	 * Returns the value for the specific key-value pair if it exists.
	 * @param key the specific key to look up in this dictionary
	 * @return the corresponding value of the specific key, or {@code null} if the mapping didn't exist.
	 * @throws ClassCastException if the key is of an inappropriate type for this map
	 */
	V get(K key);
	
	/**
	 * Mapping the provided key with the provided value in the dictionary.
	 * @param key key with which the specified value is to be associated
	 * @param v value to be associated with the specified key
	 * @return The previous value associated with the provided key, or null if there's no association with the key.
	 * @throws ClassCastException if the key or value is of an inappropriate type for this map
	 */
	V put(K key, V value);
	
	/**
	 * Remove an entry in the dictionary
	 * @param key key whose mapping is to be removed from the map
	 * @return the previous value associated with {@code key}, or {@code null} if there was no mapping for {@code key}.
	 * @throws ClassCastException if the key is of an inappropriate type for this map
	 */
	V remove(K key);
}
