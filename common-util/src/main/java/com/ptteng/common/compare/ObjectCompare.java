/**
 * 
 */
package com.ptteng.common.compare;

import java.lang.reflect.Field;
import java.util.Comparator;

import org.apache.commons.lang.math.NumberUtils;



/**
 * @author yhye
 * @2012-1-9下午04:11:20
 */
public class ObjectCompare<E> implements Comparator<E> {
    
	/**
	 * 时间-毫秒：正序空的排后面，倒序空的排前面
	 */
	public static final String SORT_TYPE_TIME_MILLISECOND = "time_millisecond";

	/**
	 * 指标值：无论正序倒序，空值排后面,比较值转换 bigdecimal进行排序
	 */
	public static final String SORT_TYPE_INDICATOR_VALUE = "indicator_value";
	
	/**
	 * 指标值：无论正序倒序，空值排后面,对于实现 comparable 接口的实体进行排序
	 */
	public static final String SORT_TYPE_COMPARABLE_VALUE = "comparable_value";
	
	/**
	 * 升序排列
	 */
	public static final String DIRECT_ASC = "asc";
	/**
	 * 降序排列
	 */
	public static final String DIRECT_DESC = "desc";
	

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
	 * 初始化，必须传入参数，否则无法排序
	 * @param sortField
	 * @param direct
	 * @param sortType
	 */
	public ObjectCompare(Field sortField, String direct, String sortType) {
		super();
		this.sortField = sortField;
		this.sortField.setAccessible(true);
		this.direct = direct;
		this.sortType = sortType;
	}


	@Override
	public int compare(E o1, E o2) {
		if(null == o1 || null == o2){
			return 0;
		}
		
	 try {
		 Comparable value1 = (Comparable) sortField.get(o1);
	
		 Comparable value2 = (Comparable) sortField.get(o2);
	
	    
	    if(SORT_TYPE_TIME_MILLISECOND.equals(sortType)){
			
			return compareTimeMillisecond(value1, value2);
			
			
		}else if(SORT_TYPE_INDICATOR_VALUE.equals(sortType)){
			
			return compareIndicatorValue(value1, value2);
			
		}else if(SORT_TYPE_COMPARABLE_VALUE.equals(sortType)){
			return compareComparableValue(value1, value2);
		}
	    
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * time_millisecond排序
	 * @param value1
	 * @param value2
	 * @return
	 */
	private int compareTimeMillisecond(Comparable value1, Comparable value2) {
		if (null == value1 && null == value2) {
			return 0;
		}

		if (DIRECT_DESC.equalsIgnoreCase(direct)) {
			if (null != value1 && null != value2) {
				return value2.compareTo(value1);
			} else if (null == value1) {
				return -1;
			} 
			return 1;
			
		}
		
		if (null != value1 && null != value2) {
			return value1.compareTo(value2);
		}else if (null == value1) {
			return 1;
		}
		return -1;
	}
	
	/**
	 * comparable_value 排序
	 * @param value1
	 * @param value2
	 * @return
	 */
	private int compareComparableValue(Comparable value1, Comparable value2){
		if (null == value1 && null == value2) {
			return 0;
		}

		if (DIRECT_DESC.equalsIgnoreCase(direct)) {
			if (null != value1 && null != value2) {
				return value2.compareTo(value1);
			} else if (null == value1) {
				return 1;
			} else {
				return -1;
			}
		}
		if (null != value1 && null != value2) {
			return value1.compareTo(value2);
		}else if (null == value1) {
			return 1;
		}else {
			return -1;
		}
	}

	/**
	 * indicator_value 排序
	 * @param value1
	 * @param value2
	 * @return
	 */
	private int compareIndicatorValue(Comparable value1, Comparable value2) {

		if (null == value1 && null == value2) {
			return 0;
		}

		if (DIRECT_DESC.equalsIgnoreCase(direct)) {
			if (null != value1 && null != value2) {
				return NumberUtils.createBigDecimal(value2.toString()).compareTo(NumberUtils.createBigDecimal(value1.toString()));
			} else if (null == value1) {
				return 1;
			} else {
				return -1;
			}
		}
		if (null != value1 && null != value2) {
			return NumberUtils.createBigDecimal(value1.toString()).compareTo(NumberUtils.createBigDecimal(value2.toString()));
		}else if (null == value1) {
			return 1;
		}else {
			return -1;
		}
    }


	/**
	 * @return the sortField
	 */
	public Field getSortField() {
		return sortField;
	}


	/**
	 * @return the direct
	 */
	public String getDirect() {
		return direct;
	}


	/**
	 * @return the sortType
	 */
	public String getSortType() {
		return sortType;
	}
	
	
}
