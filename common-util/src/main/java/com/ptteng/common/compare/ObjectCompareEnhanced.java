/**
 * 
 */
package com.ptteng.common.compare;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;


/**
 * @author yhye
 * @2012-9-4下午03:26:23
 */
public class ObjectCompareEnhanced<E> implements Comparator<E> {

	
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
	 * 根据指定的值所在的顺序排序，使用sortIndexMap做排序
	 */
	public static final String SORT_TYPE_VALUE_INDEX = "comparable_value_index";
	
	
	/**
	 * 升序排列
	 */
	public static final String DIRECT_ASC = "asc";
	/**
	 * 降序排列
	 */
	public static final String DIRECT_DESC = "desc";
	
	/**
	 * 多重排序,以迭代顺序为先后
	 */
	private List<ObjectSort> multiSortField;
	
	
	

	
	public ObjectCompareEnhanced(List<ObjectSort> multiSortField) {
		super();
		this.multiSortField = multiSortField;
		if (null != multiSortField) {
			for (ObjectSort os : this.multiSortField) {
				os.getSortField().setAccessible(true);
			}
		}
	}


	@Override
	public int compare(E o1, E o2) {
		if(null == o1 || null == o2){
			return 0;
		}
		int compResult = 0;
		
		try {
			
			for(ObjectSort os : multiSortField){
				
				Comparable value1 = (Comparable) os.getSortField().get(o1);

				Comparable value2 = (Comparable) os.getSortField().get(o2);
				
				compResult = 0;
				
                if (SORT_TYPE_TIME_MILLISECOND.equals(os.getSortType())) {

					compResult = compareTimeMillisecond(value1, value2, os.getDirect());

				} else if (SORT_TYPE_INDICATOR_VALUE.equals(os.getSortType())) {

					compResult = compareIndicatorValue(value1, value2, os.getDirect());

				} else if(SORT_TYPE_VALUE_INDEX.equals(os.getSortType())){
					
					compResult = compareValueIndex(value1, value2,os.getSortIndexMap(),os.getDirect());
					
				}else {
					
					compResult = compareComparableValue(value1, value2, os.getDirect());
				}

				if (compResult != 0) {
					
					return compResult;
				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return compResult;
	}
	
	/**
	 * time_millisecond排序
	 * @param value1
	 * @param value2
	 * @return
	 */
	private int compareTimeMillisecond(Comparable value1, Comparable value2,String direct) {
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
	private int compareComparableValue(Comparable value1, Comparable value2,String direct){
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
		}
			return -1;
		
	}

	/**
	 * indicator_value 排序
	 * @param value1
	 * @param value2
	 * @return
	 */
	private int compareIndicatorValue(Comparable value1, Comparable value2,String direct) {

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
		}
			return -1;
		
    }
	
	
	/**
	 * comparable_value_index 排序
	 * @param value1
	 * @param value2
	 * @return
	 */
	private int compareValueIndex(Comparable value1, Comparable value2,Map<Comparable,Integer> sortIndexMap,String direct){
		
		Integer index1 = sortIndexMap.get(value1);
		Integer index2 = sortIndexMap.get(value2);
		
		if (null == index1 && null == index2) {
			return 0;
		}
		
		if (DIRECT_DESC.equalsIgnoreCase(direct)) {
			if (null != index1 && null != index2) {
				return index2.compareTo(index1);
			} else if (null == index1) {
				return 1;
			} else {
				return -1;
			}
		}
		if (null != index1 && null != index2) {
			return index1.compareTo(index2);
		}else if (null == index1) {
			return 1;
		}
		return -1;
		
	}
	
	
	
}
