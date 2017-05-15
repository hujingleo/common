package com.gemantic.commons.code.manager.android.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.gemantic.common.util.FileUtil;
import com.gemantic.commons.code.manager.android.AndroidCodeGenerate;
import com.gemantic.commons.code.model.android.AndroidModel;
import com.gemantic.commons.code.model.android.AndroidPresenter;
import com.gemantic.commons.code.model.android.AndroidProject;
import com.gemantic.commons.code.model.android.AndroidService;
import com.gemantic.commons.code.model.ios.TemplateConfig;
@Component("androidCodeGenerate")
public class AndroidProjectImpl implements AndroidCodeGenerate {
	
private static final Log log = LogFactory.getLog(AndroidProjectImpl.class);
	
	@Autowired
	private VelocityEngine velocityEngine;

	@Override
	public List<String> generateModelFile(AndroidProject project) {

		List<AndroidModel> models = project.getModels();
		Map model = new HashMap();
		model.put("project", project);
		List<String> contents = new ArrayList();
		Map<String, String> template_path = project.getName_template();

		String hpath = template_path.get(AndroidProject.Template_Model);

		for (AndroidModel m : models) {
			try {

				model.put("model", m);
				log.info("generate model h is " + m);
				TemplateConfig templateConfig = m.getTemplateConfig();

				String content = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, hpath, model);
				log.info(m.getName() + " write content is " + content);
				FileUtil.writeFile(templateConfig.getTargetPath()
						+ templateConfig.getTargetName(), false, content);
				log.info(templateConfig.getTargetPath()
						+ " =========create============== "
						+ templateConfig.getTargetName());
				contents.add(content);
			} catch (VelocityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return contents;
	
	}

	@Override
	public List<String> generatePresenterFile(AndroidProject project) {

		List<AndroidPresenter> presenters = project.getPersenters();
		Map model = new HashMap();
		model.put("project", project);
		List<String> contents = new ArrayList();
		Map<String, String> template_path = project.getName_template();

		String hpath = template_path.get(AndroidProject.Template_Presenter);

		for (AndroidPresenter presenter : presenters) {
			try {

				model.put("presenter", presenter);
				log.info("generate model h is " + presenter);
				TemplateConfig templateConfig = presenter.getTemplateConfig();

				String content = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, hpath, model);
				log.info(presenter.getName() + " write content is " + content);
				FileUtil.writeFile(templateConfig.getTargetPath()
						+ templateConfig.getTargetName(), false, content);
				log.info(templateConfig.getTargetPath()
						+ " =========create============== "
						+ templateConfig.getTargetName());
				contents.add(content);
			} catch (VelocityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return contents;
	
	}

	@Override
	public List<String> generateServiceFile(AndroidProject project) {

		List<AndroidService> services = project.getServices();
		Map model = new HashMap();
		model.put("project", project);
		List<String> contents = new ArrayList();
		Map<String, String> template_path = project.getName_template();

		String hpath = template_path.get(AndroidProject.Template_Service);

		for (AndroidService service : services) {
			try {

				model.put("service", service);
				log.info("generate model h is " + service);
				TemplateConfig templateConfig = service.getTemplateConfig();

				String content = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, hpath, model);
				log.info(service.getName() + " write content is " + content);
				FileUtil.writeFile(templateConfig.getTargetPath()
						+ templateConfig.getTargetName(), false, content);
				log.info(templateConfig.getTargetPath()
						+ " =========create============== "
						+ templateConfig.getTargetName());
				contents.add(content);
			} catch (VelocityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return contents;
	
	}

}
