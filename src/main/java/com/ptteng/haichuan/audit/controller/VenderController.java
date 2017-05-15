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

import com.ptteng.haichuan.audit.model.Vender;
import com.ptteng.haichuan.audit.service.VenderService;

/**
 * Vender  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class VenderController {
	private static final Log log = LogFactory.getLog(VenderController.class);

	@Autowired
	private VenderService venderService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/vender", method = RequestMethod.GET)
	public String getvenderList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/vender  to /vender/view/venderList");

		return "/haichuan-audit-service/vender/view/venderList";
	}
    
    

    
	
	@RequestMapping(value = "/c/vender/{id}", method = RequestMethod.GET)
	public String getVender(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/vender/" + id + "  to /vender/view/venderDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/haichuan-audit-service/vender/view/venderDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/vender/{id}", method = RequestMethod.GET)
	public String getVenderJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Vender vender = venderService.getObjectById(id);
			log.info("get vender data is " + vender);

			model.addAttribute("code", 0);

			model.addAttribute("vender", vender);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get vender error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/vender/json/venderDetailJson";
	}

	@RequestMapping(value = "/a/vender/{id}", method = RequestMethod.PUT)
	public String updateVenderJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Vender vender) throws Exception {
		
		log.info("update vender : vender= " + vender);
		
		try {
			
			venderService.update(vender);

			model.addAttribute("code", 0);

			model.addAttribute("vender", vender);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update vender error,id is  " + vender.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/vender", method = RequestMethod.POST)
	public String addVenderJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Vender vender) throws Exception {
		
		log.info("update vender : vender= " + vender);
		
		try { 
			vender.setId(null);

			venderService.insert(vender);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add vender error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/vender/{id}", method = RequestMethod.DELETE)
	public String deleteVenderJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete vender : id= " + id);
		try {
			venderService.delete(id);

			log.info("add vender success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete vender error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/vender", method = RequestMethod.GET)
	public String getMultiVenderJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Vender> venderList = venderService.getObjectsByIds(idList);
			log.info("get  vender data is " + venderList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",venderList.size());

			model.addAttribute("venderList", venderList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get vender error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/vender/json/venderListJson";
	}
	
	
	
	
	
}

