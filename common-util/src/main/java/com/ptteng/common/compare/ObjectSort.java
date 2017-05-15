/**
 * 
 */
package com.ptteng.common.compare;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author yhye
 * @2012-9-4下午03:14:31
 */
public class ObjectSort  {

	
	/**
	 * 排序属性
	 */
	private Field sortField;
	/**
	 * 排序方向：desc-倒序,asc-正序
	 */
	private String direct;
	
	/**
	 * 排序类型
	 */
	private String sortType;
	
	
	/**
	 * 排序值的指定顺序：
	 * 例如，要求sortField对应值的顺序为2,1,3
	 * valueSortIndex={2,0},{1,1},{3,2}
	 * direct = asc
	 * sortField值为2的排前面，值1的排中间，值3的排后面
	 * valueSortIndex传null则根据sortField的value值进行排序
	 */
	private Map<Comparable,Integer> sortIndexMap;


	public ObjectSort(Field sortField, String direct) {
		super();
		this.sortField = sortField;
		this.direct = direct;
	}
	
	public ObjectSort(Field sortField, String direct, String sortType) {
		super();
		this.sortField = sortField;
		this.direct = direct;
		this.sortType = sortType;
	}
	
	
	public ObjectSort(Field sortField, String direct, String sortType,
			Map<Comparable, Integer> sortIndexMap) {
		super();
		this.sortField = sortField;
		this.direct = direct;
		this.sortType = sortType;
		this.sortIndexMap = sortIndexMap;
	}

	

	/**
	 * @return the sortField
	 */
	public Field getSortField() {
		return sortField;
	}


	/**
	 * @param sortField the sortField to set
	 */
	public void setSortField(Field sortField) {
		this.sortField = sortField;
	}


	/**
	 * @return the direct
	 */
	public String getDirect() {
		return direct;
	}


	/**
	 * @param direct the direct to set
	 */
	public void setDirect(String direct) {
		this.direct = direct;
	}


	/**
	 * @return the sortType
	 */
	public String getSortType() {
		return sortType;
	}


	/**
	 * @param sortType the sortType to set
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}


	/**
	 * @return the sortIndexMap
	 */
	public Map<Comparable, Integer> getSortIndexMap() {
		return sortIndexMap;
	}


	/**
	 * @param sortIndexMap the sortIndexMap to set
	 */
	public void setSortIndexMap(Map<Comparable, Integer> sortIndexMap) {
		this.sortIndexMap = sortIndexMap;
	} 
	
	
	
	
	
}
