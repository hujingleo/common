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

import com.ptteng.haichuan.audit.model.Member;
import com.ptteng.haichuan.audit.service.MemberService;

/**
 * Member  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class MemberController {
	private static final Log log = LogFactory.getLog(MemberController.class);

	@Autowired
	private MemberService memberService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/member", method = RequestMethod.GET)
	public String getmemberList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/member  to /member/view/memberList");

		return "/haichuan-audit-service/member/view/memberList";
	}
    
    

    
	
	@RequestMapping(value = "/c/member/{id}", method = RequestMethod.GET)
	public String getMember(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/member/" + id + "  to /member/view/memberDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/haichuan-audit-service/member/view/memberDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/member/{id}", method = RequestMethod.GET)
	public String getMemberJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Member member = memberService.getObjectById(id);
			log.info("get member data is " + member);

			model.addAttribute("code", 0);

			model.addAttribute("member", member);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get member error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/member/json/memberDetailJson";
	}

	@RequestMapping(value = "/a/member/{id}", method = RequestMethod.PUT)
	public String updateMemberJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Member member) throws Exception {
		
		log.info("update member : member= " + member);
		
		try {
			
			memberService.update(member);

			model.addAttribute("code", 0);

			model.addAttribute("member", member);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update member error,id is  " + member.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/member", method = RequestMethod.POST)
	public String addMemberJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Member member) throws Exception {
		
		log.info("update member : member= " + member);
		
		try { 
			member.setId(null);

			memberService.insert(member);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add member error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/member/{id}", method = RequestMethod.DELETE)
	public String deleteMemberJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete member : id= " + id);
		try {
			memberService.delete(id);

			log.info("add member success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete member error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/member", method = RequestMethod.GET)
	public String getMultiMemberJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Member> memberList = memberService.getObjectsByIds(idList);
			log.info("get  member data is " + memberList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",memberList.size());

			model.addAttribute("memberList", memberList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get member error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/member/json/memberListJson";
	}
	
	
	
	
	
}

