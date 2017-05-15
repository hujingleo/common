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

import com.ptteng.haichuan.audit.model.Late;
import com.ptteng.haichuan.audit.service.LateService;

/**
 * Late  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class LateController {
	private static final Log log = LogFactory.getLog(LateController.class);

	@Autowired
	private LateService lateService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/late", method = RequestMethod.GET)
	public String getlateList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/late  to /late/view/lateList");

		return "/haichuan-audit-service/late/view/lateList";
	}
    
    

    
	
	@RequestMapping(value = "/c/late/{id}", method = RequestMethod.GET)
	public String getLate(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/late/" + id + "  to /late/view/lateDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/haichuan-audit-service/late/view/lateDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/late/{id}", method = RequestMethod.GET)
	public String getLateJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Late late = lateService.getObjectById(id);
			log.info("get late data is " + late);

			model.addAttribute("code", 0);

			model.addAttribute("late", late);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get late error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/late/json/lateDetailJson";
	}

	@RequestMapping(value = "/a/late/{id}", method = RequestMethod.PUT)
	public String updateLateJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Late late) throws Exception {
		
		log.info("update late : late= " + late);
		
		try {
			
			lateService.update(late);

			model.addAttribute("code", 0);

			model.addAttribute("late", late);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update late error,id is  " + late.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/late", method = RequestMethod.POST)
	public String addLateJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Late late) throws Exception {
		
		log.info("update late : late= " + late);
		
		try { 
			late.setId(null);

			lateService.insert(late);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add late error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/late/{id}", method = RequestMethod.DELETE)
	public String deleteLateJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete late : id= " + id);
		try {
			lateService.delete(id);

			log.info("add late success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete late error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/late", method = RequestMethod.GET)
	public String getMultiLateJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Late> lateList = lateService.getObjectsByIds(idList);
			log.info("get  late data is " + lateList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",lateList.size());

			model.addAttribute("lateList", lateList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get late error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/late/json/lateListJson";
	}
	
	
	
	
	
}

