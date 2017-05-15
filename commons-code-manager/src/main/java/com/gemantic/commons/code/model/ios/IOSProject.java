package com.gemantic.commons.code.model.ios;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class IOSProject implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5343156137922045988L;


	public static final String Template_Controller_M = "template_controller_m";
	public static final String Template_Controller_H = "template_controller_h";
	
	public static final String Template_View_M = "template_view_m";
	public static final String Template_View_H = "template_view_h";
	
	public static final String Template_Model_M = "template_model_m";
	public static final String Template_Model_H = "template_model_h";


	public static final String Template_Service_H = "template_service_h";
	public static final String Template_Service_M = "template_service_m";
	public static final String Template_Interface_Config = "template_interface_config";
	
	
	
	
	
	
	private String name;
	
	private List<IOSView> views;
	
	private List<IOSController> controllers;
	
	private List<IOSModel> models;
	
	private Map<String,String> name_template;
	
	private List<IOSService> services;

	private TemplateConfig httpConfig;
	
	
	
	
	
	
	
	
	

	public IOSProject() {
		super();
        Map<String, String> name_template=new HashMap();
		
		name_template.put(IOSProject.Template_Controller_M, "velocity/ios/controller/m.vm");
		name_template.put(IOSProject.Template_Controller_H, "velocity/ios/controller/h.vm");
		
		name_template.put(IOSProject.Template_Model_H, "velocity/ios/model/h.vm");
		name_template.put(IOSProject.Template_Model_M, "velocity/ios/model/m.vm");
		
		name_template.put(IOSProject.Template_View_H, "velocity/ios/view/h.vm");
		name_template.put(IOSProject.Template_View_M, "velocity/ios/view/m.vm");
		
		
		
		this.name_template=name_template;
		
		
	}

	public List<IOSController> getControllers() {
		return controllers;
	}

	public void setControllers(List<IOSController> controllers) {
		this.controllers = controllers;
	}
	
	
	


	
	


	public List<IOSModel> getModels() {
		return models;
	}

	public void setModels(List<IOSModel> models) {
		this.models = models;
	}

	public Map<String, String> getName_template() {
		return name_template;
	}

	public void setName_template(Map<String, String> name_template) {
		this.name_template = name_template;
	}
	
	
	
	

	public List<IOSView> getViews() {
		return views;
	}

	public void setViews(List<IOSView> views) {
		this.views = views;
	}
	
	
	
	
	
	
	
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

	public TemplateConfig getHttpConfig() {
		return httpConfig;
	}

	public void setHttpConfig(TemplateConfig httpConfig) {
		this.httpConfig = httpConfig;
	}
	
	
	
	

	public List<IOSService> getServices() {
		return services;
	}

	public void setServices(List<IOSService> services) {
		this.services = services;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}
	
	
	
	
	
	

}
