package com.ptteng.haichuan.audit.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptteng.haichuan.audit.model.Storage;
import com.ptteng.haichuan.audit.service.StorageService;

/**
 * Storage  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class StorageController {
	private static final Log log = LogFactory.getLog(StorageController.class);

	@Autowired
	private StorageService storageService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/storage", method = RequestMethod.GET)
	public String getstorageList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/storage  to /storage/view/storageList");

		return "/haichuan-audit-service/storage/view/storageList";
	}
    
    

    
	
	@RequestMapping(value = "/c/storage/{id}", method = RequestMethod.GET)
	public String getStorage(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/storage/" + id + "  to /storage/view/storageDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/haichuan-audit-service/storage/view/storageDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/storage/{id}", method = RequestMethod.GET)
	public String getStorageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Storage storage = storageService.getObjectById(id);
			log.info("get storage data is " + storage);

			model.addAttribute("code", 0);

			model.addAttribute("storage", storage);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get storage error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/storage/json/storageDetailJson";
	}

	@RequestMapping(value = "/a/storage/{id}", method = RequestMethod.PUT)
	public String updateStorageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Storage storage) throws Exception {
		
		log.info("update storage : storage= " + storage);
		
		try {
			
			storageService.update(storage);

			model.addAttribute("code", 0);

			model.addAttribute("storage", storage);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update storage error,id is  " + storage.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/storage", method = RequestMethod.POST)
	public String addStorageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Storage storage) throws Exception {
		
		log.info("update storage : storage= " + storage);
		
		try { 
			storage.setId(null);

			storageService.insert(storage);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add storage error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/storage/{id}", method = RequestMethod.DELETE)
	public String deleteStorageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete storage : id= " + id);
		try {
			storageService.delete(id);

			log.info("add storage success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete storage error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/storage", method = RequestMethod.GET)
	public String getMultiStorageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Storage> storageList = storageService.getObjectsByIds(idList);
			log.info("get  storage data is " + storageList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",storageList.size());

			model.addAttribute("storageList", storageList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get storage error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/storage/json/storageListJson";
	}
	
	
	
	
	
}

