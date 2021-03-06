package com.h2h.tool.data;

import com.h2h.tool.db.DbService;
import com.h2h.tool.db.DbServiceImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DataServiceImpl implements DataService{
	
	/**根据表名获取其他模板要用的Map型数据
	 * (无需操作数据库,不含有列信息)
	 * @param tableName
	 * @return
	 */
	public Map<String, Object> getTemplateDataWithOutDb(String tableName,String packageName,String classPre){
		
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("tableName", tableName);
		templateData.put("package", packageName);
		templateData.put("classPre", classPre);
		return templateData;
		
	}
	
	/**根据表名获取模板要用的Map型数据
	 * (带有列信息)
	 * @param tableName
	 * @return
	 * @throws SQLException 
	 */
	public Map<String, Object> getDbTemplateData(String tableName,String packageName,String className) throws SQLException{
		DbService dbService = new DbServiceImpl();
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("tableName", tableName);
		templateData.put("properties", dbService.getAllColums(tableName, "", "mysql"));
		//templateData.put("className", classPre+"VO");
		templateData.put("className", className.replaceFirst("Ddbes", ""));
		templateData.put("package", packageName);
		return templateData;
	}
	
	


}
