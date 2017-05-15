/**
 * 
 */
package com.ptteng.sca.haichuan.audit.client;

import java.util.List;
import java.util.Map;

import com.ptteng.haichuan.audit.model.Late;
import com.ptteng.haichuan.audit.service.LateService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class LateSCAClient implements LateService {

    private LateService lateService;

	public LateService getLateService() {
		return lateService;
	}
	
	
	public void setLateService(LateService lateService) {
		this.lateService =lateService;
	}
	
	
			   
		@Override
		public Long insert(Late late)throws ServiceException, ServiceDaoException{
		
		return lateService.insert(late);
		          
		
		}	
		  
    	   
		@Override
		public List<Late> insertList(List<Late> lateList)throws ServiceException, ServiceDaoException{
		
		return lateService.insertList(lateList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return lateService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Late late)throws ServiceException, ServiceDaoException{
		
		return lateService.update(late);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Late> lateList)throws ServiceException, ServiceDaoException{
		
		return lateService.updateList(lateList);
		          
		
		}	
		  
    	   
		@Override
		public Late getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return lateService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Late> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return lateService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getLateIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return lateService.getLateIds(start, limit);
	}

	@Override
	public Integer countLateIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return lateService.countLateIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return lateService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return lateService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   lateService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.lateService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

