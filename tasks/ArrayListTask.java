package tasks;

import java.util.ArrayList;
import java.util.List;
import exception.CustomException;
import helper.util.Helper;

public class ArrayListTask  {
	
	public <T> List<T> getArrayList() {
		return new ArrayList<T>();
	}
	
	public <T> int getLength(List<T> list) throws CustomException {
		Helper.checkNullValues(list);
		return list.size();
	}
	
	public <T> List<T> add(List<T> list, T obj) throws CustomException {//SOLID Principles -- O- Open Closed principle or Coding to the interface
		Helper.checkNullValues(list);
		Helper.checkNullValues(obj);
		list.add(obj);
		return list;
	}
	
	public <T> List<T> deleteAll(List<T> firstList, List<T> secondList) throws CustomException {
		Helper.checkNullValues(firstList);
		Helper.checkNullValues(secondList);
		firstList.removeAll(secondList);
		return firstList;
	}
	
	public <T> List<T> deleteIf(List<T> firstList, List<T> secondList) throws CustomException {
		Helper.checkNullValues(firstList);
		firstList.retainAll(secondList);
		return firstList;
	}
	
	public <T> boolean contains(List<T> list, T obj) throws CustomException {
		Helper.checkNullValues(list);
		Helper.checkNullValues(obj);
		return list.contains(obj);
	}
	
	public <T> T remove(List<T> list, int index) throws CustomException {
		int length = getLength(list);
		Helper.checkIndexBounds(index, length);
		return list.remove(index);
	}
	
	public <T> List<T> addAll(List<T> firstList, List<T> secondList) throws CustomException {
		Helper.checkNullValues(firstList);
		Helper.checkNullValues(secondList);
		firstList.addAll(secondList);
		return firstList;
	}
	
	public <T> List<T> sublist(List<T> list, int startIndex, int endIndex) throws CustomException {
		int length = getLength(list);
		Helper.checkTwoIndexBounds(startIndex, endIndex, length);
		return list.subList(startIndex, endIndex);
	}
	
	public <T> int findFirstIndex(List<T> list, T obj) throws CustomException {
		Helper.checkNullValues(list);
		Helper.checkNullValues(obj);
		return list.indexOf(obj);
	}
	
	public <T> void deleteAll(List<T> list) throws CustomException {
		Helper.checkNullValues(list);
		list.clear();
	}
	
	public <T> int findLastIndex(List<T> list, T obj) throws CustomException {
		Helper.checkNullValues(list);
		Helper.checkNullValues(obj);
		return list.lastIndexOf(obj);
	}
	
	public <T> T find(List<T> list, int index) throws CustomException {
		int length = getLength(list);
		Helper.checkIndexBounds(index, length);
		return list.get(index);
	}
	
	public <T> List<T> insert(List<T> list, T obj, int index) throws CustomException {
		Helper.checkNullValues(obj);
		int length = getLength(list);
		Helper.checkIndexBounds(index, length);
		list.add(index, obj);
		return list;
	}
}
