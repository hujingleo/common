package com.ptteng.haichuan.audit.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Storage;
import com.ptteng.haichuan.audit.service.StorageService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;


public class StorageServiceImpl extends BaseDaoServiceImpl implements StorageService {

 

	private static final Log log = LogFactory.getLog(StorageServiceImpl.class);



		   
		@Override
		public Long insert(Storage storage)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + storage);

		if (storage == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		storage.setCreateAt(currentTimeMillis);
		storage.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(storage);
		} catch (DaoException e) {
			log.error(" insert wrong : " + storage);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Storage> insertList(List<Storage> storageList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (storageList == null ? "null" : storageList.size()));
      
		List<Storage> resultList = null;

		if (CollectionUtils.isEmpty(storageList)) {
			return new ArrayList<Storage>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Storage storage : storageList) {
			storage.setCreateAt(currentTimeMillis);
			storage.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Storage>) dao.batchSave(storageList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + storageList);
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
			result = dao.delete(Storage.class, id);
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
		public boolean update(Storage storage)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (storage == null ? "null" : storage.getId()));

		boolean result = false;

		if (storage == null) {
			return true;
		}

		storage.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(storage);
		} catch (DaoException e) {
			log.error(" update wrong : " + storage);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + storage);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Storage> storageList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (storageList == null ? "null" : storageList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(storageList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Storage storage : storageList) {
			storage.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(storageList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + storageList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + storageList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Storage getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Storage storage = null;

		if (id == null) {
			return storage;
		}

		try {
			storage = (Storage) dao.get(Storage.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return storage;		
		}	
		  
    	   
		@Override
		public List<Storage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Storage> storage = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Storage>();
		}

		try {
			storage = (List<Storage>) dao.getList(Storage.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (storage == null ? "null" : storage.size()));
    
		return storage;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getStorageIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getStorageIdsAll",new Object[] {},start, limit, false);
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
	public Integer countStorageIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getStorageIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getStorageIds " ) ;
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

