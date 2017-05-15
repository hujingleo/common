package com.gemantic.commons.code.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  
@Retention(RetentionPolicy.RUNTIME)
public @interface FileTemplate {
	
	public String templatePath();
	public String filePath();
	public String fileName();	
	/**
	 * 是否追加原文件，默认为false
	 * @return
	 */
	public boolean append() default false;
	
	

}
