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

import com.ptteng.haichuan.audit.model.Team;
import com.ptteng.haichuan.audit.service.TeamService;

/**
 * Team  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class TeamController {
	private static final Log log = LogFactory.getLog(TeamController.class);

	@Autowired
	private TeamService teamService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/team", method = RequestMethod.GET)
	public String getteamList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/team  to /team/view/teamList");

		return "/haichuan-audit-service/team/view/teamList";
	}
    
    

    
	
	@RequestMapping(value = "/c/team/{id}", method = RequestMethod.GET)
	public String getTeam(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/team/" + id + "  to /team/view/teamDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/haichuan-audit-service/team/view/teamDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/team/{id}", method = RequestMethod.GET)
	public String getTeamJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Team team = teamService.getObjectById(id);
			log.info("get team data is " + team);

			model.addAttribute("code", 0);

			model.addAttribute("team", team);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get team error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/team/json/teamDetailJson";
	}

	@RequestMapping(value = "/a/team/{id}", method = RequestMethod.PUT)
	public String updateTeamJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Team team) throws Exception {
		
		log.info("update team : team= " + team);
		
		try {
			
			teamService.update(team);

			model.addAttribute("code", 0);

			model.addAttribute("team", team);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update team error,id is  " + team.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/team", method = RequestMethod.POST)
	public String addTeamJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Team team) throws Exception {
		
		log.info("update team : team= " + team);
		
		try { 
			team.setId(null);

			teamService.insert(team);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add team error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/team/{id}", method = RequestMethod.DELETE)
	public String deleteTeamJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete team : id= " + id);
		try {
			teamService.delete(id);

			log.info("add team success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete team error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/team", method = RequestMethod.GET)
	public String getMultiTeamJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Team> teamList = teamService.getObjectsByIds(idList);
			log.info("get  team data is " + teamList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",teamList.size());

			model.addAttribute("teamList", teamList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get team error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/haichuan-audit-service/team/json/teamListJson";
	}
	
	
	
	
	
}

