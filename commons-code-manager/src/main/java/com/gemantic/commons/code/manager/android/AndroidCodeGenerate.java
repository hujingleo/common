package com.gemantic.commons.code.manager.android;

import java.util.List;

import com.gemantic.commons.code.model.android.AndroidProject;

public interface AndroidCodeGenerate {

	public List<String>  generateModelFile(AndroidProject project);

	public List<String>  generatePresenterFile(AndroidProject project);

	public List<String>  generateServiceFile(AndroidProject project);

}
