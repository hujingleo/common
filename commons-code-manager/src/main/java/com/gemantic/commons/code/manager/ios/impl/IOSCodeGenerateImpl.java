package com.gemantic.commons.code.manager.ios.impl;

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
import com.gemantic.commons.code.manager.ios.IOSCodeGenerate;
import com.gemantic.commons.code.model.ios.IOSController;
import com.gemantic.commons.code.model.ios.IOSInterface;
import com.gemantic.commons.code.model.ios.IOSModel;
import com.gemantic.commons.code.model.ios.IOSProject;
import com.gemantic.commons.code.model.ios.IOSService;
import com.gemantic.commons.code.model.ios.IOSView;
import com.gemantic.commons.code.model.ios.TemplateConfig;

@Component("iOSCodeGenerate")
public class IOSCodeGenerateImpl implements IOSCodeGenerate {

	private static final Log log = LogFactory.getLog(IOSCodeGenerateImpl.class);

	@Autowired
	private VelocityEngine velocityEngine;

	@Override
	public List<String> generateControllerMFile(IOSProject project) {

		List<IOSController> controllers = project.getControllers();
		Map model = new HashMap();
		model.put("project", project);
		List<String> contents = new ArrayList();
		Map<String, String> template_path = project.getName_template();
		String mpath = template_path.get(IOSProject.Template_Controller_M);

		for (IOSController controller : controllers) {
			try {

				model.put("controller", controller);
				log.info("generate controller is " + controllers);
				TemplateConfig templateConfig = controller.getMTemplateConfig();

				String content = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, mpath, model);
				log.info(controller.getName() + " write content is " + content);
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
	public List<String> generateControllerHFile(IOSProject project) {
		List<IOSController> controllers = project.getControllers();
		Map model = new HashMap();
		model.put("project", project);
		List<String> contents = new ArrayList();
		Map<String, String> template_path = project.getName_template();

		String hpath = template_path.get(IOSProject.Template_Controller_H);

		for (IOSController controller : controllers) {
			try {

				model.put("controller", controller);
				log.info("generate controller is " + controllers);
				TemplateConfig templateConfig = controller.gethTemplateConfig();

				String content = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, hpath, model);
				log.info(controller.getName() + " write content is " + content);
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
	public List<String> generateViewMFile(IOSProject project) {
		List<IOSView> views = project.getViews();
		Map model = new HashMap();
		model.put("project", project);
		List<String> contents = new ArrayList();
		Map<String, String> template_path = project.getName_template();

		String mpath = template_path.get(IOSProject.Template_View_M);

		for (IOSView view : views) {
			try {

				model.put("view", view);
				log.info("generate view is " + views);
				TemplateConfig templateConfig = view.getmTemplateConfig();

				String content = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, mpath, model);
				log.info(view.getName() + " write content is " + content);

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
	public List<String> generateViewHFile(IOSProject project) {
		List<IOSView> views = project.getViews();
		Map model = new HashMap();
		model.put("project", project);
		List<String> contents = new ArrayList();
		Map<String, String> template_path = project.getName_template();

		String hpath = template_path.get(IOSProject.Template_View_H);

		for (IOSView view : views) {
			try {

				model.put("view", view);
				log.info("generate controller is " + views);
				TemplateConfig templateConfig = view.gethTemplateConfig();

				String content = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, hpath, model);
				log.info(view.getName() + " write content is " + content);
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
	public List<String> generateModelMFile(IOSProject project) {
		List<IOSModel> models = project.getModels();
		Map model = new HashMap();
		model.put("project", project);
		List<String> contents = new ArrayList();
		Map<String, String> template_path = project.getName_template();

		String mpath = template_path.get(IOSProject.Template_Model_M);

		for (IOSModel m : models) {
			try {

				model.put("model", m);

				log.info("generate is " + m);
				TemplateConfig templateConfig = m.getmTemplateConfig();

				String content = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, mpath, model);
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
	public List<String> generateModelHFile(IOSProject project) {
		List<IOSModel> models = project.getModels();
		Map model = new HashMap();
		model.put("project", project);
		List<String> contents = new ArrayList();
		Map<String, String> template_path = project.getName_template();

		String hpath = template_path.get(IOSProject.Template_Model_H);

		for (IOSModel m : models) {
			try {

				model.put("model", m);
				log.info("generate controller is " + m);
				TemplateConfig templateConfig = m.gethTemplateConfig();

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
	public List<String> generateServiceHFile(IOSProject project) {

		List<IOSService> services = project.getServices();
		Map model = new HashMap();
		model.put("project", project);
		List<String> contents = new ArrayList();
		Map<String, String> template_path = project.getName_template();

		String hpath = template_path.get(IOSProject.Template_Service_H);

		for (IOSService service : services) {
			try {

				model.put("service", service);
				log.info("generate interface h is " + service);
				TemplateConfig templateConfig = service.gethTemplateConfig();

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

	@Override
	public List<String> generateServiceMFile(IOSProject project) {
		List<IOSService> services = project.getServices();
		Map model = new HashMap();
		model.put("project", project);
		List<String> contents = new ArrayList();
		Map<String, String> template_path = project.getName_template();

		String hpath = template_path.get(IOSProject.Template_Service_M);

		for (IOSService service : services) {
			try {

				model.put("service", service);
				log.info("generate interface h is " + service);
				TemplateConfig templateConfig = service.getmTemplateConfig();

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

	@Override
	public List<String> generateInterfaceConfigFile(IOSProject project) {

		List<IOSService> services = project.getServices();
		List<IOSInterface> interfaces = new ArrayList();
		for (IOSService service : services) {
			interfaces.addAll(service.getInterfaces());
		}

		Map model = new HashMap();
		model.put("project", project);
		model.put("interfaces", interfaces);
		List<String> contents = new ArrayList();
		Map<String, String> template_path = project.getName_template();

		String path = template_path.get(IOSProject.Template_Interface_Config);

		try {

			log.info("generate config is ");
			TemplateConfig templateConfig = project.getHttpConfig();

			String content = VelocityEngineUtils.mergeTemplateIntoString(
					velocityEngine, path, model);
			log.info(templateConfig.getTargetName() + " write content is "
					+ content);
			FileUtil.writeFile(
					templateConfig.getTargetPath()
							+ templateConfig.getTargetName(), false, content);
			log.info(templateConfig.getTargetPath()
					+ " =========create============== "
					+ templateConfig.getTargetName());
			contents.add(content);
		} catch (VelocityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contents;

	}

}
