package tasks;

import java.util.ArrayList;
import java.util.List;

import exception.CustomException;
import helper.util.Helper;

public class ArrayListTask {
	
	public <T> List<T> getArrayList() {
		return new ArrayList<T>();
	}
	
	public <T> int getLength(List<T> list) throws CustomException {
		Helper.checkNullValues(list);
		return list.size();
	}
	
	public <T> List<T> add(List<T> list, T obj) throws CustomException {
		Helper.checkNullValues(list);
		Helper.checkNullValues(obj);
		list.add(obj);
		return list;
	}
	
	public <T> int findIndex(List<T> list, T obj) throws CustomException {
		Helper.checkNullValues(list);
		Helper.checkNullValues(obj);
		return list.indexOf(obj);
	}
	
	public <T> T find(List<T> list, int index) throws CustomException {
		int length = getLength(list);
		Helper.checkIndexBounds(index, length);
		return list.get(index);
	}
}
