/**
 * 
 */
package com.ptteng.sca.haichuan.audit.client;

import java.util.List;
import java.util.Map;

import com.ptteng.haichuan.audit.model.Member;
import com.ptteng.haichuan.audit.service.MemberService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class MemberSCAClient implements MemberService {

    private MemberService memberService;

	public MemberService getMemberService() {
		return memberService;
	}
	
	
	public void setMemberService(MemberService memberService) {
		this.memberService =memberService;
	}
	
	
			   
		@Override
		public Long insert(Member member)throws ServiceException, ServiceDaoException{
		
		return memberService.insert(member);
		          
		
		}	
		  
    	   
		@Override
		public List<Member> insertList(List<Member> memberList)throws ServiceException, ServiceDaoException{
		
		return memberService.insertList(memberList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return memberService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Member member)throws ServiceException, ServiceDaoException{
		
		return memberService.update(member);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Member> memberList)throws ServiceException, ServiceDaoException{
		
		return memberService.updateList(memberList);
		          
		
		}	
		  
    	   
		@Override
		public Member getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return memberService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Member> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return memberService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getMemberIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return memberService.getMemberIds(start, limit);
	}

	@Override
	public Integer countMemberIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return memberService.countMemberIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return memberService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return memberService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   memberService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.memberService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

