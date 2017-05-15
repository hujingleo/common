package com.ptteng.common.compare;

import java.util.Comparator;

public class GeneralCompare<T> implements Comparator<T> {
	public static String TYPE_OBJECT ="type_object";
	public static String TYPE_BASE ="type_base";
	public String objType;
	public String sortType;
	public GeneralCompare(String objType,String sortType){
		this.objType = objType;
		this.sortType = sortType;
	}
	
	
	@Override
	public int compare(T fir, T sec) {
		if(objType.equals(TYPE_BASE)){
			
		}
		else if(TYPE_BASE.equals(TYPE_OBJECT)){
			
		}
		
		
		return 0;
	}

}
