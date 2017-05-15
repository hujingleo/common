package com.gemantic.commons.code.model.android;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AndroidProject implements Serializable{
	
	
	



















	/**
	 * 
	 */
	private static final long serialVersionUID = 5343156137922045988L;


	public static final String Template_Controller = "template_controller";	
	public static final String Template_Model= "template_model";



	public static final String Template_Service = "template_service";
	public static final String Template_Presenter = "template_persenter";

	
	
	
	
	
	
	private String name;	
	private Map<String,String> name_template;
	private String packagePrefix;
	private List<AndroidService> services;
	private List<AndroidModel> models;
	private List<AndroidPresenter> persenters;
	
	
	
	
	

   
	  

	
	
	
	
	
	
	public AndroidProject() {
		super();
	       Map<String, String> name_template=new HashMap();
	
			
			name_template.put(AndroidProject.Template_Model, "velocity/android/model/model.vm");
		
			
			name_template.put(AndroidProject.Template_Presenter, "velocity/android/presenter/presenter.vm");
			
			
			
			name_template.put(AndroidProject.Template_Service, "velocity/android/service/service.vm");
			
			this.name_template=name_template;
	}
	
	

	

	public List<AndroidModel> getModels() {
		return models;
	}


















	public void setModels(List<AndroidModel> models) {
		this.models = models;
	}


















	public List<AndroidPresenter> getPersenters() {
		return persenters;
	}


















	public void setPersenters(List<AndroidPresenter> persenters) {
		this.persenters = persenters;
	}


















	public String getName() {
		return name;
	}


















	public void setName(String name) {
		this.name = name;
	}


















	public Map<String, String> getName_template() {
		return name_template;
	}


















	public void setName_template(Map<String, String> name_template) {
		this.name_template = name_template;
	}


















	public String getPackagePrefix() {
		return packagePrefix;
	}


















	public void setPackagePrefix(String packagePrefix) {
		this.packagePrefix = packagePrefix;
	}


















	public List<AndroidService> getServices() {
		return services;
	}


















	public void setServices(List<AndroidService> services) {
		this.services = services;
	}


















	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}
	
	
	
	
	
	

}
