/**
 * 
 */
package com.ptteng.sca.haichuan.audit.client;

import java.util.List;
import java.util.Map;

import com.ptteng.haichuan.audit.model.Storage;
import com.ptteng.haichuan.audit.service.StorageService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class StorageSCAClient implements StorageService {

    private StorageService storageService;

	public StorageService getStorageService() {
		return storageService;
	}
	
	
	public void setStorageService(StorageService storageService) {
		this.storageService =storageService;
	}
	
	
			   
		@Override
		public Long insert(Storage storage)throws ServiceException, ServiceDaoException{
		
		return storageService.insert(storage);
		          
		
		}	
		  
    	   
		@Override
		public List<Storage> insertList(List<Storage> storageList)throws ServiceException, ServiceDaoException{
		
		return storageService.insertList(storageList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return storageService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Storage storage)throws ServiceException, ServiceDaoException{
		
		return storageService.update(storage);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Storage> storageList)throws ServiceException, ServiceDaoException{
		
		return storageService.updateList(storageList);
		          
		
		}	
		  
    	   
		@Override
		public Storage getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return storageService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Storage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return storageService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getStorageIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return storageService.getStorageIds(start, limit);
	}

	@Override
	public Integer countStorageIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return storageService.countStorageIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return storageService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return storageService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   storageService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.storageService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

