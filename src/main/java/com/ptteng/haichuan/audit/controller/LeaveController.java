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

import com.ptteng.haichuan.audit.model.Leave;
import com.ptteng.haichuan.audit.service.LeaveService;

/**
 * Leave  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class LeaveController {
	private static final Log log = LogFactory.getLog(LeaveController.class);

	@Autowired
	private LeaveService leaveService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/leave", method = RequestMethod.GET)
	public String getleaveList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/leave  to /leave/view/leaveList");

		return "/haichuan-audit-service/leave/view/leaveList";
	}
    
    

    
	
	@RequestMapping(value = "/c/leave/{id}", method = RequestMethod.GET)
	public String getLeave(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/leave/" + id + "  to /leave/view/leaveDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/haichuan-audit-service/leave/view/leaveDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/leave/{id}", method = RequestMethod.GET)
	public String getLeaveJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Leave leave = leaveService.getObjectById(id);
			log.info("get leave data is " + leave);

			model.addAttribute("code", 0);

			model.addAttribute("leave", leave);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get leave error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/leave/json/leaveDetailJson";
	}

	@RequestMapping(value = "/a/leave/{id}", method = RequestMethod.PUT)
	public String updateLeaveJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Leave leave) throws Exception {
		
		log.info("update leave : leave= " + leave);
		
		try {
			
			leaveService.update(leave);

			model.addAttribute("code", 0);

			model.addAttribute("leave", leave);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update leave error,id is  " + leave.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/leave", method = RequestMethod.POST)
	public String addLeaveJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Leave leave) throws Exception {
		
		log.info("update leave : leave= " + leave);
		
		try { 
			leave.setId(null);

			leaveService.insert(leave);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add leave error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/leave/{id}", method = RequestMethod.DELETE)
	public String deleteLeaveJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete leave : id= " + id);
		try {
			leaveService.delete(id);

			log.info("add leave success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete leave error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/leave", method = RequestMethod.GET)
	public String getMultiLeaveJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Leave> leaveList = leaveService.getObjectsByIds(idList);
			log.info("get  leave data is " + leaveList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",leaveList.size());

			model.addAttribute("leaveList", leaveList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get leave error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/leave/json/leaveListJson";
	}
	
	
	
	
	
}

