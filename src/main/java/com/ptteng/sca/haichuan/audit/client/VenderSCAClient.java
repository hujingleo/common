/**
 * 
 */
package com.ptteng.sca.haichuan.audit.client;

import java.util.List;
import java.util.Map;

import com.ptteng.haichuan.audit.model.Vender;
import com.ptteng.haichuan.audit.service.VenderService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class VenderSCAClient implements VenderService {

    private VenderService venderService;

	public VenderService getVenderService() {
		return venderService;
	}
	
	
	public void setVenderService(VenderService venderService) {
		this.venderService =venderService;
	}
	
	
			   
		@Override
		public Long insert(Vender vender)throws ServiceException, ServiceDaoException{
		
		return venderService.insert(vender);
		          
		
		}	
		  
    	   
		@Override
		public List<Vender> insertList(List<Vender> venderList)throws ServiceException, ServiceDaoException{
		
		return venderService.insertList(venderList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return venderService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Vender vender)throws ServiceException, ServiceDaoException{
		
		return venderService.update(vender);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Vender> venderList)throws ServiceException, ServiceDaoException{
		
		return venderService.updateList(venderList);
		          
		
		}	
		  
    	   
		@Override
		public Vender getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return venderService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Vender> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return venderService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getVenderIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return venderService.getVenderIds(start, limit);
	}

	@Override
	public Integer countVenderIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return venderService.countVenderIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return venderService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return venderService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   venderService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.venderService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

