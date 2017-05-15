package com.ptteng.haichuan.audit.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Late;
import com.ptteng.haichuan.audit.service.LateService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;


public class LateServiceImpl extends BaseDaoServiceImpl implements LateService {

 

	private static final Log log = LogFactory.getLog(LateServiceImpl.class);



		   
		@Override
		public Long insert(Late late)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + late);

		if (late == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		late.setCreateAt(currentTimeMillis);
		late.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(late);
		} catch (DaoException e) {
			log.error(" insert wrong : " + late);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Late> insertList(List<Late> lateList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (lateList == null ? "null" : lateList.size()));
      
		List<Late> resultList = null;

		if (CollectionUtils.isEmpty(lateList)) {
			return new ArrayList<Late>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Late late : lateList) {
			late.setCreateAt(currentTimeMillis);
			late.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Late>) dao.batchSave(lateList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + lateList);
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
			result = dao.delete(Late.class, id);
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
		public boolean update(Late late)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (late == null ? "null" : late.getId()));

		boolean result = false;

		if (late == null) {
			return true;
		}

		late.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(late);
		} catch (DaoException e) {
			log.error(" update wrong : " + late);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + late);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Late> lateList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (lateList == null ? "null" : lateList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(lateList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Late late : lateList) {
			late.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(lateList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + lateList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + lateList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Late getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Late late = null;

		if (id == null) {
			return late;
		}

		try {
			late = (Late) dao.get(Late.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return late;		
		}	
		  
    	   
		@Override
		public List<Late> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Late> late = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Late>();
		}

		try {
			late = (List<Late>) dao.getList(Late.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (late == null ? "null" : late.size()));
    
		return late;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getLateIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getLateIdsAll",new Object[] {},start, limit, false);
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
	public Integer countLateIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getLateIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getLateIds " ) ;
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

