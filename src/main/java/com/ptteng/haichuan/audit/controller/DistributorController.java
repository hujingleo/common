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

import com.ptteng.haichuan.audit.model.Distributor;
import com.ptteng.haichuan.audit.service.DistributorService;

/**
 * Distributor  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class DistributorController {
	private static final Log log = LogFactory.getLog(DistributorController.class);

	@Autowired
	private DistributorService distributorService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/distributor", method = RequestMethod.GET)
	public String getdistributorList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/distributor  to /distributor/view/distributorList");

		return "/haichuan-audit-service/distributor/view/distributorList";
	}
    
    

    
	
	@RequestMapping(value = "/c/distributor/{id}", method = RequestMethod.GET)
	public String getDistributor(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/distributor/" + id + "  to /distributor/view/distributorDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/haichuan-audit-service/distributor/view/distributorDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/distributor/{id}", method = RequestMethod.GET)
	public String getDistributorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Distributor distributor = distributorService.getObjectById(id);
			log.info("get distributor data is " + distributor);

			model.addAttribute("code", 0);

			model.addAttribute("distributor", distributor);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get distributor error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/distributor/json/distributorDetailJson";
	}

	@RequestMapping(value = "/a/distributor/{id}", method = RequestMethod.PUT)
	public String updateDistributorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Distributor distributor) throws Exception {
		
		log.info("update distributor : distributor= " + distributor);
		
		try {
			
			distributorService.update(distributor);

			model.addAttribute("code", 0);

			model.addAttribute("distributor", distributor);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update distributor error,id is  " + distributor.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/distributor", method = RequestMethod.POST)
	public String addDistributorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Distributor distributor) throws Exception {
		
		log.info("update distributor : distributor= " + distributor);
		
		try { 
			distributor.setId(null);

			distributorService.insert(distributor);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add distributor error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/distributor/{id}", method = RequestMethod.DELETE)
	public String deleteDistributorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete distributor : id= " + id);
		try {
			distributorService.delete(id);

			log.info("add distributor success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete distributor error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/distributor", method = RequestMethod.GET)
	public String getMultiDistributorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Distributor> distributorList = distributorService.getObjectsByIds(idList);
			log.info("get  distributor data is " + distributorList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",distributorList.size());

			model.addAttribute("distributorList", distributorList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get distributor error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/distributor/json/distributorListJson";
	}
	
	
	
	
	
}

