package com.gemantic.commons.code.manager.ios;

import java.util.List;

import com.gemantic.commons.code.model.ios.IOSProject;

public interface IOSCodeGenerate {

	public List<String> generateControllerMFile(IOSProject project);

	public List<String> generateControllerHFile(IOSProject project);

	public List<String> generateViewMFile(IOSProject project);

	public List<String> generateViewHFile(IOSProject project);

	public List<String> generateModelMFile(IOSProject project);

	public List<String> generateModelHFile(IOSProject project);

	public List<String> generateServiceHFile(IOSProject project);

	public List<String> generateServiceMFile(IOSProject project);

	public List<String> generateInterfaceConfigFile(IOSProject project);

}
