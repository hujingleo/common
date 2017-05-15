/**
 * 
 */
package com.ptteng.sca.haichuan.audit.client;

import java.util.List;
import java.util.Map;

import com.ptteng.haichuan.audit.model.Distributor;
import com.ptteng.haichuan.audit.service.DistributorService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class DistributorSCAClient implements DistributorService {

    private DistributorService distributorService;

	public DistributorService getDistributorService() {
		return distributorService;
	}
	
	
	public void setDistributorService(DistributorService distributorService) {
		this.distributorService =distributorService;
	}
	
	
			   
		@Override
		public Long insert(Distributor distributor)throws ServiceException, ServiceDaoException{
		
		return distributorService.insert(distributor);
		          
		
		}	
		  
    	   
		@Override
		public List<Distributor> insertList(List<Distributor> distributorList)throws ServiceException, ServiceDaoException{
		
		return distributorService.insertList(distributorList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return distributorService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Distributor distributor)throws ServiceException, ServiceDaoException{
		
		return distributorService.update(distributor);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Distributor> distributorList)throws ServiceException, ServiceDaoException{
		
		return distributorService.updateList(distributorList);
		          
		
		}	
		  
    	   
		@Override
		public Distributor getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return distributorService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Distributor> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return distributorService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getDistributorIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return distributorService.getDistributorIds(start, limit);
	}

	@Override
	public Integer countDistributorIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return distributorService.countDistributorIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return distributorService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return distributorService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   distributorService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.distributorService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

