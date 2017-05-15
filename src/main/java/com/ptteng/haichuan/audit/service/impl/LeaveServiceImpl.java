package com.ptteng.haichuan.audit.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Leave;
import com.ptteng.haichuan.audit.service.LeaveService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;


public class LeaveServiceImpl extends BaseDaoServiceImpl implements LeaveService {

 

	private static final Log log = LogFactory.getLog(LeaveServiceImpl.class);



		   
		@Override
		public Long insert(Leave leave)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + leave);

		if (leave == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		leave.setCreateAt(currentTimeMillis);
		leave.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(leave);
		} catch (DaoException e) {
			log.error(" insert wrong : " + leave);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Leave> insertList(List<Leave> leaveList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (leaveList == null ? "null" : leaveList.size()));
      
		List<Leave> resultList = null;

		if (CollectionUtils.isEmpty(leaveList)) {
			return new ArrayList<Leave>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Leave leave : leaveList) {
			leave.setCreateAt(currentTimeMillis);
			leave.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Leave>) dao.batchSave(leaveList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + leaveList);
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
			result = dao.delete(Leave.class, id);
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
		public boolean update(Leave leave)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (leave == null ? "null" : leave.getId()));

		boolean result = false;

		if (leave == null) {
			return true;
		}

		leave.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(leave);
		} catch (DaoException e) {
			log.error(" update wrong : " + leave);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + leave);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Leave> leaveList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (leaveList == null ? "null" : leaveList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(leaveList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Leave leave : leaveList) {
			leave.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(leaveList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + leaveList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + leaveList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Leave getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Leave leave = null;

		if (id == null) {
			return leave;
		}

		try {
			leave = (Leave) dao.get(Leave.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return leave;		
		}	
		  
    	   
		@Override
		public List<Leave> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Leave> leave = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Leave>();
		}

		try {
			leave = (List<Leave>) dao.getList(Leave.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (leave == null ? "null" : leave.size()));
    
		return leave;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getLeaveIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getLeaveIdsAll",new Object[] {},start, limit, false);
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
	public Integer countLeaveIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getLeaveIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getLeaveIds " ) ;
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

