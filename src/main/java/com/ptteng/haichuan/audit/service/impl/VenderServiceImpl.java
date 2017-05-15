package com.ptteng.haichuan.audit.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Vender;
import com.ptteng.haichuan.audit.service.VenderService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;


public class VenderServiceImpl extends BaseDaoServiceImpl implements VenderService {

 

	private static final Log log = LogFactory.getLog(VenderServiceImpl.class);



		   
		@Override
		public Long insert(Vender vender)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + vender);

		if (vender == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		vender.setCreateAt(currentTimeMillis);
		vender.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(vender);
		} catch (DaoException e) {
			log.error(" insert wrong : " + vender);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Vender> insertList(List<Vender> venderList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (venderList == null ? "null" : venderList.size()));
      
		List<Vender> resultList = null;

		if (CollectionUtils.isEmpty(venderList)) {
			return new ArrayList<Vender>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Vender vender : venderList) {
			vender.setCreateAt(currentTimeMillis);
			vender.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Vender>) dao.batchSave(venderList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + venderList);
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
			result = dao.delete(Vender.class, id);
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
		public boolean update(Vender vender)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (vender == null ? "null" : vender.getId()));

		boolean result = false;

		if (vender == null) {
			return true;
		}

		vender.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(vender);
		} catch (DaoException e) {
			log.error(" update wrong : " + vender);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + vender);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Vender> venderList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (venderList == null ? "null" : venderList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(venderList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Vender vender : venderList) {
			vender.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(venderList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + venderList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + venderList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Vender getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Vender vender = null;

		if (id == null) {
			return vender;
		}

		try {
			vender = (Vender) dao.get(Vender.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return vender;		
		}	
		  
    	   
		@Override
		public List<Vender> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Vender> vender = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Vender>();
		}

		try {
			vender = (List<Vender>) dao.getList(Vender.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (vender == null ? "null" : vender.size()));
    
		return vender;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getVenderIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getVenderIdsAll",new Object[] {},start, limit, false);
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
	public Integer countVenderIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getVenderIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getVenderIds " ) ;
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

