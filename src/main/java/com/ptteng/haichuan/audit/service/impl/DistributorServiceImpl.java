package com.ptteng.haichuan.audit.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Distributor;
import com.ptteng.haichuan.audit.service.DistributorService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;


public class DistributorServiceImpl extends BaseDaoServiceImpl implements DistributorService {

 

	private static final Log log = LogFactory.getLog(DistributorServiceImpl.class);



		   
		@Override
		public Long insert(Distributor distributor)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + distributor);

		if (distributor == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		distributor.setCreateAt(currentTimeMillis);
		distributor.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(distributor);
		} catch (DaoException e) {
			log.error(" insert wrong : " + distributor);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Distributor> insertList(List<Distributor> distributorList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (distributorList == null ? "null" : distributorList.size()));
      
		List<Distributor> resultList = null;

		if (CollectionUtils.isEmpty(distributorList)) {
			return new ArrayList<Distributor>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Distributor distributor : distributorList) {
			distributor.setCreateAt(currentTimeMillis);
			distributor.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Distributor>) dao.batchSave(distributorList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + distributorList);
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
			result = dao.delete(Distributor.class, id);
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
		public boolean update(Distributor distributor)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (distributor == null ? "null" : distributor.getId()));

		boolean result = false;

		if (distributor == null) {
			return true;
		}

		distributor.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(distributor);
		} catch (DaoException e) {
			log.error(" update wrong : " + distributor);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + distributor);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Distributor> distributorList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (distributorList == null ? "null" : distributorList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(distributorList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Distributor distributor : distributorList) {
			distributor.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(distributorList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + distributorList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + distributorList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Distributor getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Distributor distributor = null;

		if (id == null) {
			return distributor;
		}

		try {
			distributor = (Distributor) dao.get(Distributor.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return distributor;		
		}	
		  
    	   
		@Override
		public List<Distributor> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Distributor> distributor = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Distributor>();
		}

		try {
			distributor = (List<Distributor>) dao.getList(Distributor.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (distributor == null ? "null" : distributor.size()));
    
		return distributor;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getDistributorIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getDistributorIdsAll",new Object[] {},start, limit, false);
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
	public Integer countDistributorIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getDistributorIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getDistributorIds " ) ;
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

