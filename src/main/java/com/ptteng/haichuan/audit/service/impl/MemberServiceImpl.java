package com.ptteng.haichuan.audit.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Member;
import com.ptteng.haichuan.audit.service.MemberService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;


public class MemberServiceImpl extends BaseDaoServiceImpl implements MemberService {

 

	private static final Log log = LogFactory.getLog(MemberServiceImpl.class);



		   
		@Override
		public Long insert(Member member)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + member);

		if (member == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		member.setCreateAt(currentTimeMillis);
		member.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(member);
		} catch (DaoException e) {
			log.error(" insert wrong : " + member);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Member> insertList(List<Member> memberList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (memberList == null ? "null" : memberList.size()));
      
		List<Member> resultList = null;

		if (CollectionUtils.isEmpty(memberList)) {
			return new ArrayList<Member>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Member member : memberList) {
			member.setCreateAt(currentTimeMillis);
			member.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Member>) dao.batchSave(memberList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + memberList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(Member.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
 
		log.info(" delete data success : " + id);
   
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(Member member)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (member == null ? "null" : member.getId()));

		boolean result = false;

		if (member == null) {
			return true;
		}

		member.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(member);
		} catch (DaoException e) {
			log.error(" update wrong : " + member);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + member);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Member> memberList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (memberList == null ? "null" : memberList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(memberList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Member member : memberList) {
			member.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(memberList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + memberList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + memberList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Member getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Member member = null;

		if (id == null) {
			return member;
		}

		try {
			member = (Member) dao.get(Member.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return member;		
		}	
		  
    	   
		@Override
		public List<Member> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Member> member = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Member>();
		}

		try {
			member = (List<Member>) dao.getList(Member.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (member == null ? "null" : member.size()));
    
		return member;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getMemberIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getMemberIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countMemberIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getMemberIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getMemberIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}

