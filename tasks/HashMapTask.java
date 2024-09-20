package tasks;

import java.util.HashMap;
import java.util.Map;

import exception.CustomException;
import helper.util.Helper;

public class HashMapTask  {
	
	public <K, V> Map<K, V> getHashMap() {
		return new HashMap<K, V>();
	}
	
	public <K, V> boolean containsKey(Map<K, V> map, K key) throws CustomException {
		Helper.checkNullValues(map);
		Helper.checkNullValues(key);
		return map.containsKey(key);
	}
	
	public <K, V> int getMapLength(Map<K, V> map) throws CustomException {
		Helper.checkNullValues(map);
		return map.size();
	}
	
	public <K, V> V get(Map<K, V> map, K key) throws CustomException {
		Helper.checkNullValues(map);
		Helper.checkNullValues(key);
		return map.get(key);
	}
	
	public <K, V> Map<K, V> add(Map<K, V> map, K key, V value) throws CustomException {
		Helper.checkNullValues(map);
		Helper.checkNullValues(key);
		Helper.checkNullValues(value);
		map.put(key, value);
		return map;
	}
	
	
}
