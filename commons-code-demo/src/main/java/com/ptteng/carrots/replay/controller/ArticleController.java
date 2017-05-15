package com.ptteng.carrots.replay.controller;
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

import com.ptteng.carrots.replay.model.Article;
import com.ptteng.carrots.replay.service.ArticleService;

/**
 * Article  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class ArticleController {
	private static final Log log = LogFactory.getLog(ArticleController.class);

	@Autowired
	private ArticleService articleService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/article", method = RequestMethod.GET)
	public String getarticleList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/article  to /article/view/articleList");

		return "/carrots-replay-home-service/article/view/articleList";
	}
    
    

    
	
	@RequestMapping(value = "/c/article/{id}", method = RequestMethod.GET)
	public String getArticle(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/article/" + id + "  to /article/view/articleDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/carrots-replay-home-service/article/view/articleDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/article/{id}", method = RequestMethod.GET)
	public String getArticleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Article article = articleService.getObjectById(id);
			log.info("get article data is " + article);

			model.addAttribute("code", 0);

			model.addAttribute("article", article);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get article error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/carrots-replay-home-service/article/json/articleDetailJson";
	}

	@RequestMapping(value = "/a/article/{id}", method = RequestMethod.PUT)
	public String updateArticleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Article article) throws Exception {
		
		log.info("update article : article= " + article);
		
		try {
			
			articleService.update(article);

			model.addAttribute("code", 0);

			model.addAttribute("article", article);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update article error,id is  " + article.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/article", method = RequestMethod.POST)
	public String addArticleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Article article) throws Exception {
		
		log.info("update article : article= " + article);
		
		try { 
			article.setId(null);

			articleService.insert(article);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add article error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/article/{id}", method = RequestMethod.DELETE)
	public String deleteArticleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete article : id= " + id);
		try {
			articleService.delete(id);

			log.info("add article success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete article error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/article", method = RequestMethod.GET)
	public String getMultiArticleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Article> articleList = articleService.getObjectsByIds(idList);
			log.info("get  article data is " + articleList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",articleList.size());

			model.addAttribute("articleList", articleList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get article error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/carrots-replay-home-service/article/json/articleListJson";
	}
	
	
	
	
	
}

