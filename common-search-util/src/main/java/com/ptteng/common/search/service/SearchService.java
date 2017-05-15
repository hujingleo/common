package com.ptteng.common.search.service;


import java.util.HashMap;
import java.util.List;

public interface SearchService {


	/**
	 * 根据ID搜索索引
	 * @param index
	 * @return
	 */

	public String getDocumentById(String index, String type, Long id);

	/**
	 * 将文档插入索引
	 * @param index
	 * @return
	 */

	public String addDocument(String index, String type ,Long id, String json);

	/**
	 * 修改文档
	 * @param index
	 * @return
	 */

	public String updateDocument(String index, String type ,Long id, String json);

	/**
	 * 修改文档
	 * @param index
	 * @return
	 */

	public String deleteDocument(String index, String type ,Long id);


	/**
	 * 单个字段搜索索引
	 * @param index
	 * @return
	 */

	public String simpleSearch(String index, String type, String query);

	/**
	 * 单个字段搜索索引
	 * @param index
	 * @return
	 */

	public String indexSearch(String index, String query);

	/**
	 * 单个字段搜索索引
	 * @param index
	 * @return
	 */

	public String addIndex(String index);

//	/**
//	 * 通过es搜索
//	 * @Param url
//	 * @return
//	 */
//
//	public String searchByParams(String url, HashMap<String,String> params, Integer start, Integer limit);
//


}
