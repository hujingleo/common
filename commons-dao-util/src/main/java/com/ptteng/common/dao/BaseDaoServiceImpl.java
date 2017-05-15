package com.ptteng.common.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.util.SQLUtil;


public class BaseDaoServiceImpl implements BaseDaoService {

    protected Dao dao;

    private static final Log log = LogFactory.getLog(BaseDaoServiceImpl.class);

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        log.info("set dao " + dao);
        this.dao = dao;
    }

    @Override
    public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        // log.info(clz + " want run dynamic  " + conditions + " start " + start
        // + " size " + limit);

        String table = null;
        String sql = "";
        Method method;
        try {
            Annotation annotation = clz.getAnnotation(Table.class);
            Class<Annotation> type = (Class<Annotation>) annotation.annotationType();

            method = type.getDeclaredMethod("name", null);
            table = (String) method.invoke(annotation, null);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(clz + "  run dynamic  wrong " + conditions + " start " + start + " size " + limit);
        }

        try {

           
            sql = SQLUtil.convert2Sql(conditions, start, limit);
            // log.info("sql:" + sql);

            Object o = dao.excuteSimpleSql(sql, clz);

            if (o instanceof List) {
                log.info(sql + " result is list " + o);
                List<Long> ids = new ArrayList();

                for (Object oo : (List) o) {
                    BigInteger id = (BigInteger) oo;
                    ids.add(id.longValue());
                }
                return ids;
            } else {
                log.info(sql + " result is not list " + o + " instance " + o.getClass());

                List<Long> ids = new ArrayList();
                BigInteger id = (BigInteger) o;
                ids.add(id.longValue());
                return ids;
            }

        } catch (DaoException e) {
            log.error(" count by getPuserIds " + sql);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
    }

    

    @Override
    public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
        try {
            this.dao.fakeDelete(clz, id);
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {

        log.info(clz + " want delete " + ids);
        try {
            this.dao.deleteList(clz, ids);
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }

    public static void main(String[] args) throws ServiceException, ServiceDaoException {

        BaseDaoServiceImpl s = new BaseDaoServiceImpl();

        Map<String, Object> params = new HashMap();

        params.put("p.type & like ", "\"%团购%\"");
        params.put("p.name & like ", "\"%恒信饮料%\"");
        params.put(" p.update_by", "29");
        params.put(" p.status", "0");
        params.put("p.id", "pr.provider_id");
        params.put("@query", "p.id");
        params.put("@table", "provider p ,provider_publics_relation pr");
        params.put("@order", "p.update_at desc");
        params.put("p.id & in ", "3,5,6");
        params.put("@table", "provider p ,provider_publics_relation pr");
        // s.getIdsByDynamicCondition(String.class, params, 0,
        // Integer.MAX_VALUE);
        String sql = SQLUtil.convert2Sql(params, 0, Integer.MAX_VALUE);
        log.info("sql is " + sql);
        
        
        
        Map<String, Object> params2 = new HashMap();

        params2.put("@update", "update");
        params2.put("@table", "statistics");
        params2.put("@field", "statistics_count");
        params2.put("@value", "statistics_count+1");
        params2.put("product_id", "1");
       
        String sql2 = SQLUtil.convert2Sql(params2, 0, Integer.MAX_VALUE);
        log.info(sql2+" is right ? ");
        
        
        
        
        
        

    }

	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {

        // log.info(clz + " want run dynamic  " + conditions + " start " + start
        // + " size " + limit);

        String table = null;
        String sql = "";
        Method method;
        try {
            Annotation annotation = clz.getAnnotation(Table.class);
            Class<Annotation> type = (Class<Annotation>) annotation.annotationType();

            method = type.getDeclaredMethod("name", null);
            table = (String) method.invoke(annotation, null);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(clz + "  run dynamic  wrong " + conditions + " start " + start + " size " + limit);
        }

        try {

           
            sql = SQLUtil.convert2Sql(conditions, start, limit);
            // log.info("sql:" + sql);

            Object o = dao.excuteSimpleSql(sql, clz);
            log.info(sql + " result is not list " + o + " instance " + o.getClass());

          
            return o;
           

        } catch (DaoException e) {
            log.error(" count by getPuserIds " + sql);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
    
	}

}
