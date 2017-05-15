package com.ptteng.common.dao.util;

import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SQLUtil {
	
	 private static final Log log = LogFactory.getLog(SQLUtil.class);

	public static String convert2Sql(Map<String, Object> conditions, Integer start, Integer limit) {
		
		
        StringBuffer sqlBuffer = new StringBuffer();
        if (conditions.containsKey("@update")) {
        	
        	 // update
        	 sqlBuffer = sqlBuffer.append("update ");                
             if (conditions.containsKey("@table")) {
                 String table = (String) conditions.get("@table");
                 sqlBuffer = sqlBuffer.append(table);
             }else{
                    log.error("not get any table ");	
             }
            
             sqlBuffer = sqlBuffer.append(" set ");

             boolean querySentence = false;
             
             if (conditions.containsKey("@field")) {
                 String field = (String) conditions.get("@field");
                 sqlBuffer = sqlBuffer.append(field);
             }else{
                    log.error("not get any field ");	
             }
          
             sqlBuffer = sqlBuffer.append(" = ");

             if (conditions.containsKey("@value")) {
                 String value = (String) conditions.get("@value");
                 sqlBuffer = sqlBuffer.append(value);
             }else{
                    log.error("not get any value ");	
             }

              sqlBuffer = sqlBuffer.append(" where ");
              boolean first=true;
              for (String field : conditions.keySet()) {

                  String[] ps = field.split("&");

                  if (ps.length == 1) {
                      if (field.startsWith("@")) {

                          continue;
                      } else {

                    	  if(first){
                    		  
                    	  }else{
                    		  sqlBuffer = sqlBuffer.append(" and ");  
                    	  }
                    	  first=false;
                          
                      }

                      sqlBuffer = sqlBuffer.append(field);
                      sqlBuffer = sqlBuffer.append(" = ");

                  } else {
                	  
                	  if(first){
                		  
                	  }else{
                		  sqlBuffer = sqlBuffer.append(" and ");  
                	  }
                	  first=false;
                	  
                    
                      sqlBuffer = sqlBuffer.append(ps[0]);

                      sqlBuffer = sqlBuffer.append(ps[1]);

                  }


                  sqlBuffer = sqlBuffer.append(conditions.get(field));


              }


            

            
            
            
        } else {
        	
        	 // select 
        	 sqlBuffer = sqlBuffer.append("select ");
           
             if (conditions.containsKey("@query")) {
                 sqlBuffer = sqlBuffer.append(conditions.get("@query"));
             } else {
                 sqlBuffer = sqlBuffer.append("id");
             }

             sqlBuffer = sqlBuffer.append(" from ");
             
             if (conditions.containsKey("@table")) {
                 String table = (String) conditions.get("@table");
                 sqlBuffer = sqlBuffer.append(table);
             }else{
                    log.error("not get any table ");	
             }
            
             sqlBuffer = sqlBuffer.append(" where 1 = 1 ");

             boolean querySentence = false;
             for (String field : conditions.keySet()) {

                 String[] ps = field.split("&");

                 if (ps.length == 1) {
                     if (field.startsWith("@")) {

                         continue;
                     } else {

                         sqlBuffer = sqlBuffer.append(" and ");
                     }

                     sqlBuffer = sqlBuffer.append(field);
                     sqlBuffer = sqlBuffer.append(" = ");

                 } else {
                     sqlBuffer = sqlBuffer.append(" and ");
                     sqlBuffer = sqlBuffer.append(ps[0]);

                     sqlBuffer = sqlBuffer.append(ps[1]);

                 }


                 sqlBuffer = sqlBuffer.append(conditions.get(field));


             }


             
             if (conditions.containsKey("@group")) {
                 sqlBuffer = sqlBuffer.append(" group by ");
                 sqlBuffer = sqlBuffer.append(conditions.get("@group"));
             } else {

             }
            if (conditions.containsKey("@order")) {
                sqlBuffer = sqlBuffer.append(" order by ");
                sqlBuffer = sqlBuffer.append(conditions.get("@order"));
            } else {

            }
             sqlBuffer = sqlBuffer.append(" limit ");
             sqlBuffer = sqlBuffer.append(start);
             sqlBuffer = sqlBuffer.append(" , ");
             sqlBuffer = sqlBuffer.append(limit);

          
             
        }
       
        
        
        
        return sqlBuffer.toString();
    }

	public static String convertTable(Set<String> tables) {
		StringBuffer tableBuffer=new StringBuffer();
	
		int index=0;
		for(String table:tables){
			index++;
			tableBuffer=tableBuffer.append(table);
			if(index>=tables.size()){
				
			}else{
				tableBuffer=tableBuffer.append(",");
			}
		
		}
			
		
		return tableBuffer.toString();
	}
	
	

}
