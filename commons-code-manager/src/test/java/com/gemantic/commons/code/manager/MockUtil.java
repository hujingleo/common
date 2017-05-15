package com.gemantic.commons.code.manager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemantic.common.util.FileUtil;
import com.gemantic.common.util.json.GsonUtil;
import com.gemantic.commons.code.annotation.FileTemplate;
import com.gemantic.commons.code.cmodel.CConstant;
import com.gemantic.commons.code.cmodel.CField;
import com.gemantic.commons.code.cmodel.CMold;
import com.gemantic.commons.code.cmodel.CProject;
import com.gemantic.commons.code.cmodel.CSql;
import com.gemantic.commons.code.model.android.AndroidModel;
import com.gemantic.commons.code.model.android.AndroidPresenter;
import com.gemantic.commons.code.model.android.AndroidProject;
import com.gemantic.commons.code.model.android.AndroidService;
import com.gemantic.commons.code.model.ios.IOSController;
import com.gemantic.commons.code.model.ios.IOSField;
import com.gemantic.commons.code.model.ios.IOSInterface;
import com.gemantic.commons.code.model.ios.IOSModel;
import com.gemantic.commons.code.model.ios.IOSPosition;
import com.gemantic.commons.code.model.ios.IOSProject;
import com.gemantic.commons.code.model.ios.IOSService;
import com.gemantic.commons.code.model.ios.IOSView;
import com.gemantic.commons.code.model.ios.TemplateConfig;
import com.gemantic.commons.code.util.CProjectUtil;
import com.gemantic.commons.code.util.GenerateFileUtil;

public class MockUtil {
	private static final Log log = LogFactory.getLog(MockUtil.class);

	public static CProject mockGetProject() throws Exception {

		CProject project = new CProject();
		// =========创建Project============
		project.setArtifactID("analyse-convert-service");

		// =========创建Model============forexample~~~~~
		List<CMold> cms = new ArrayList();

		// 创建多个,可以使用CreateMold2();
		CMold cm = MockUtil.createMold1();

		cms.add(cm);
		project.setMolds(cms);
		CProjectUtil.init(project);

		return project;

	}

	private static CMold createMold1() {
		List<CField> cfs = new ArrayList();
		CField id_cf = new CField("id", "Long", "id", "int");
		cfs.add(id_cf);
		CField create_cf = new CField("createAt", "Long", "create_at", "int");
		cfs.add(create_cf);
		CField update_cf = new CField("updateAt", "Long", "update_at", "int");
		cfs.add(update_cf);
		CField group_cf = new CField("groupID", "Long", "group_id", "int");
		cfs.add(group_cf);
		CField user_cf = new CField("userID", "Long", "user_id", "int");
		cfs.add(user_cf);

		List<String> sqls = new ArrayList<String>();
		Map<String, String> maps = new HashMap();
		String sql = "select id from relations where group_id = ? and user_id = ? ";
		maps.put(sql, CSql.Sql_Type_List);
		sqls.add(sql);
		String sql2 = "select group_id from relations where  user_id = ? ";
		maps.put(sql2, CSql.Sql_Type_Map);
		sqls.add(sql2);

		List<CConstant> constants = new ArrayList();
		CConstant c = new CConstant("int", "Type_Flex", "1", "Flex类型");
		constants.add(c);

		CMold cm = MockUtil.createMold("Relation", "10000", cfs, constants,
				sqls, maps);
		return cm;
	}

	/**
	 * 
	 * @param model
	 *            生成的类名
	 * @param port
	 *            生成Service的端口号
	 * @param cfs
	 *            字段列表
	 * @param constants
	 *            常量列表
	 * @param sqls
	 *            Sql语句
	 * @param maps
	 *            Sql和对应的类型
	 * @return
	 */

	public static CMold createMold(String model, String port, List<CField> cfs,
			List<CConstant> constants, List<String> sqls,
			Map<String, String> maps) {
		CMold cm = new CMold();
		cm.setModelClass(model);
		cm.setPort(port);
		cm.setFields(cfs);
		cm.setSqls(sqls);
		cm.setSql_typ(maps);
		cm.setConstants(constants);

		return cm;
	}

	public static IOSProject mockIOSProject() {
		IOSProject project = new IOSProject();
		project.setName("hello~");

		List<IOSController> controllers = mockIOSController();
		project.setControllers(controllers);

		List<IOSView> views = mockIOSView();

		project.setViews(views);
		List<IOSModel> models = mockIOSModel();
		project.setModels(models);

		List<IOSService> services = mockIOSService();
		project.setServices(services);

		TemplateConfig httpConfig = new TemplateConfig("D:\\data\\code\\",
				"ios\\constant.m");
		project.setHttpConfig(httpConfig);

		Map<String, String> name_template = new HashMap();

		name_template.put(IOSProject.Template_Controller_M,
				"velocity/ios/controller/m.vm");
		name_template.put(IOSProject.Template_Controller_H,
				"velocity/ios/controller/h.vm");

		name_template.put(IOSProject.Template_Model_H,
				"velocity/ios/model/h.vm");
		name_template.put(IOSProject.Template_Model_M,
				"velocity/ios/model/m.vm");

		name_template.put(IOSProject.Template_View_H, "velocity/ios/view/h.vm");
		name_template.put(IOSProject.Template_View_M, "velocity/ios/view/m.vm");

		name_template.put(IOSProject.Template_Interface_Config,
				"velocity/ios/service/config.vm");
		name_template.put(IOSProject.Template_Service_M,
				"velocity/ios/service/m.vm");
		name_template.put(IOSProject.Template_Service_H,
				"velocity/ios/service/h.vm");

		project.setName_template(name_template);

		log.info("project is " + project);
		FileUtil.writeFile("d:\\data\\code\\ios", "data.json", false,
				GsonUtil.toJson(project));

		return project;
	}

	private static List<IOSService> mockIOSService() {
		List<IOSService> services = new ArrayList();
		IOSService service = new IOSService();
		service.setName("login");

		TemplateConfig hconfig = new TemplateConfig("D:\\data\\code\\", "ios\\"
				+ service.getName() + "Service.h");
		service.sethTemplateConfig(hconfig);

		TemplateConfig mconfig = new TemplateConfig("D:\\data\\code\\", "ios\\"
				+ service.getName() + "Service.m");
		service.setmTemplateConfig(mconfig);

		List<IOSInterface> interfaces = mockIOSInterface();
		service.setInterfaces(interfaces);

		services.add(service);

		return services;

	}

	private static List<IOSInterface> mockIOSInterface() {
		List<IOSInterface> interfaces = new ArrayList();
		IOSInterface iface = new IOSInterface();
		iface.setName("MyInterface");
		iface.setHttpMethod("post");
		iface.setServiceMethod("login");
		iface.setUrl("/member/reg.do");

		iface.setModelName("myModel");
		iface.setModelType("MyModel");

		IOSField f1 = new IOSField("name1", "1");
		IOSField f2 = new IOSField("name2", "2");
		IOSField f3 = new IOSField("name3", "3");
		IOSField f4 = new IOSField("name4", "4");

		List<IOSField> fields = new ArrayList();
		fields.add(f1);
		fields.add(f2);
		fields.add(f3);
		fields.add(f4);

		iface.setParams(fields);

		interfaces.add(iface);
		return interfaces;
	}

	private static List<IOSModel> mockIOSModel() {
		List<IOSModel> models = new ArrayList();
		IOSModel model = new IOSModel();
		model.setName("myModel");
		model.setType("MyModel");
		List<IOSField> fields = mockIOSFields();
		model.setFields(fields);

		TemplateConfig hconfig = new TemplateConfig("D:\\data\\code\\", "ios/"
				+ model.getName() + ".h");
		model.sethTemplateConfig(hconfig);

		TemplateConfig mconfig = new TemplateConfig("D:\\data\\code\\", "ios/"
				+ model.getName() + ".m");
		model.setmTemplateConfig(mconfig);

		models.add(model);
		return models;
	}

	private static List<IOSView> mockIOSView() {

		List<IOSView> views = new ArrayList();
		IOSView view = new IOSView();
		view.setName("ProlTable");
		view.setViewType("ViewCell");
		List<IOSField> fields = mockIOSFields();
		view.setFields(fields);

		TemplateConfig hconfig = new TemplateConfig("D:\\data\\code\\", "ios/"
				+ view.getName() + "View.h");
		view.sethTemplateConfig(hconfig);

		TemplateConfig mconfig = new TemplateConfig("D:\\data\\code\\", "ios/"
				+ view.getName() + "View.m");
		view.setmTemplateConfig(mconfig);

		views.add(view);
		return views;
	}

	private static List<IOSController> mockIOSController() {
		List<IOSController> controllers = new ArrayList();
		IOSController controller = new IOSController();
		List<IOSField> fields = mockIOSFields();

		controller.setFields(fields);

		controller.setName("HomeViewController");
		TemplateConfig mconfig = new TemplateConfig("D:\\data\\code\\", "ios/"
				+ controller.getName() + "Controller.m");
		controller.setMTemplateConfig(mconfig);
		TemplateConfig hconfig = new TemplateConfig("D:\\data\\code\\", "ios/"
				+ controller.getName() + "Controller.h");
		controller.sethTemplateConfig(hconfig);

		controllers.add(controller);
		return controllers;
	}

	private static List<IOSField> mockIOSFields() {
		List<IOSField> fields = new ArrayList();

		IOSField field = new IOSField();
		field.setCname("personalView");

		field.setComment("昵称");
		field.setCtype("UIView");
		field.setPublicField(true);
		IOSPosition position = new IOSPosition(
				"self.frame.size.width - 10 -70", "_TitleLabel.y"
						+ "_TitleLabel.height", "70", "30");
		field.setPosition(position);
		fields.add(field);

		IOSField field2 = new IOSField();
		field2.setCname("personalView2");
		field2.setColor("whiteColor");
		field2.setComment("昵称2");
		field2.setCtype("UIView");
		field2.setPublicField(true);

		fields.add(field2);
		return fields;
	}

	@Test
	public void testGetInputStream() {

		MockUtil.class.getClassLoader().getResourceAsStream("a.txt");
	}

	public static AndroidProject mockAndroidProject(IOSProject project) {
		AndroidProject androidProject = new AndroidProject();
		List<AndroidModel> models = new ArrayList();
		for (IOSModel imodel : project.getModels()) {
			AndroidModel androidModel = new AndroidModel();

			androidModel.setFields(imodel.getFields());
			androidModel.setName(imodel.getName());
			TemplateConfig templateConfig = new TemplateConfig(
					"D:\\data\\code\\", "android/"
							+ StringUtils.capitalize(androidModel.getName())
							+ ".java");
			androidModel.setTemplateConfig(templateConfig);

			models.add(androidModel);

		}
		androidProject.setModels(models);
		androidProject.setModels(models);
		androidProject.setName(project.getName());

		List<AndroidPresenter> persenters = new ArrayList();
		androidProject.setPersenters(persenters);
		List<AndroidService> services = new ArrayList();
		androidProject.setServices(services);
		return androidProject;
	}

	@FileTemplate(templatePath = "velocity/excel/excel.vm",filePath="d:/data/excel2/",fileName="2.txt")
	@Test
	public void testExcel() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/commons-code-mananger/applicationContext.xml");
		GenerateFileUtil generate = (GenerateFileUtil) context
				.getBean("velocityGenerateFileUtil");

		Map model = new HashMap();

	
		List<IOSProject> projects=new ArrayList();
		projects.add(MockUtil.mockIOSProject());
		projects.add(MockUtil.mockIOSProject());
		projects.add(MockUtil.mockIOSProject());
		projects.add(MockUtil.mockIOSProject());
		projects.add(MockUtil.mockIOSProject());
		projects.add(MockUtil.mockIOSProject());
		model.put("projects", projects);

		
	
		String path = "d:/data/excel/";
		String fileName = "xxx.txt";

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		log.info("method name is "+methodName);
		Method m=this.getClass().getMethod(methodName, null);
		log.info("m is "+m.getName());
	
	
		Map<String,String> config=new HashMap();
		config.put("name","名字");
		config.put("views","视图");
		config.put("controllers","控制器");
		

		model.put("config", config);
		if (m.isAnnotationPresent(FileTemplate.class)) {
			FileTemplate p = m.getAnnotation(FileTemplate.class);
			
			String content = generate.generateFile(model, p.templatePath(), p.filePath(),
					p.fileName(), false);
			log.info("test result is " + content);
			
		}else{
			
		}
		
	

	}

}
