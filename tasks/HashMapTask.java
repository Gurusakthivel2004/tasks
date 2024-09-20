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
	
	public <K, V> V remove(Map<K, V> map, K key) throws CustomException {
		Helper.checkNullValues(map);
		Helper.checkNullValues(key);
		return map.remove(key);
	}
	
	public <K, V> boolean remove(Map<K, V> map, K key, V value) throws CustomException {
		Helper.checkNullValues(map);
		Helper.checkNullValues(key);
		return map.remove(key, value);
	}
	
	public <K, V> boolean containsValue(Map<K, V> map, V value) throws CustomException {
		Helper.checkNullValues(map);
		Helper.checkNullValues(value);
		return map.containsValue(value);
	}
	
	public <K, V> Map<K, V> replace(Map<K, V> map, K key, V value) throws CustomException {
		Helper.checkNullValues(map);
		Helper.checkNullValues(key);
		Helper.checkNullValues(value);
		map.replace(key, value);
		return map;
	}
	
	public <K, V> void putAll(Map<K, V> firstMap, Map<K, V> secondMap) throws CustomException {
		Helper.checkNullValues(firstMap);
		Helper.checkNullValues(secondMap);
		firstMap.putAll(secondMap);
	}
	
	public <K, V> Map<K, V> replace (Map<K, V> map, K key, V oldValue, V newValue) throws CustomException {
		Helper.checkNullValues(map);
		Helper.checkNullValues(key);
		Helper.checkNullValues(oldValue);
		Helper.checkNullValues(newValue);
		map.replace(key, oldValue, newValue);
		return map;
	}
	
	public <K, V> int getMapLength(Map<K, V> map) throws CustomException {
		Helper.checkNullValues(map);
		return map.size();
	}
	
	public <K, V> V getOrDefault(Map<K, V> map, K key, V defaultValue) throws CustomException {
		Helper.checkNullValues(map);
		Helper.checkNullValues(key);
		return map.getOrDefault(key, defaultValue);
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
