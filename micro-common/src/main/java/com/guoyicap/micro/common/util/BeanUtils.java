package com.guoyicap.micro.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.beanutils.PropertyUtils;

import com.guoyicap.micro.common.exception.BusinessException;

/**
 * 扩展org.apache.commons.beanutils.BeanUtils<br>
 * 
 * @author guang<br>
 * 
 */
public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {
	private static String LOB_SUFIX="String";//LOB 类型对象 ，对应的转String类型的属性，命名规则  ***String
	//add  by guang  配置文件：读取需要解密的数据库字段

	/**
	 * 将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性
	 * 
	 * @param dest
	 *            目标对象，标准的JavaBean
	 * @param orig
	 *            源对象，可为Map、标准的JavaBean
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws BusinessException
	 */
	@SuppressWarnings("rawtypes")
	public static void toJavaBean(Object dest, Object orig) throws BusinessException  {
		
			if (orig instanceof Map) {
				Iterator names = ((Map) orig).keySet().iterator();
				while (names.hasNext()) {
					String name = (String) names.next();
					if (PropertyUtils.isWriteable(dest, name)) {
						Object value = ((Map) orig).get(name);
						if (value != null) {
							//dest 目标对象 对应属性的数据类型
							Class clazz=null;
							try {
								clazz = PropertyUtils.getPropertyType(dest, name);
							} catch (IllegalAccessException e) {
								e.printStackTrace();
								throw new BusinessException("MapToBean方法IllegalAccessException",e);
							} catch (InvocationTargetException e) {
								e.printStackTrace();
								throw new BusinessException("MapToBean方法InvocationTargetException",e);
							} catch (NoSuchMethodException e) {
								e.printStackTrace();
								throw new BusinessException("MapToBean方法NoSuchMethodException",e);
							}
							if (null == clazz) {
				                  continue;
				              }
							//数据类型 className
							  String className = clazz.getName();
							  //不处理
							  if (className.equalsIgnoreCase("java.sql.Timestamp")) {
				                  if (value == null || value.equals("")) {
				                      continue;
				                  }else{
				                	  value=DateUtils.str2Timestamp(value.toString());
				                  }
				              }else
							  //String类型
				              if (className.equalsIgnoreCase("java.lang.String")) {
				                  if (value == null|| value.equals("")) {
				                      value = null;
				                  }else{
				                	  value=value.toString();//获取String，解决char类型数据
				                  }
				                 
				              }else
				              if (className.equalsIgnoreCase("java.lang.Long")) {
				                  if (value == null|| value.equals("")) {
				                      value = null;
				                  }else{
				                	  value=Long.valueOf(value.toString());
				                  }
				              }else
				              if (className.equalsIgnoreCase("java.lang.Double")) {
				                  if (value == null|| value.equals("")) {
				                      value = null;
				                  }else{
				                	  value=Double.valueOf(value.toString());
				                  }
				              }else
				              if (className.equalsIgnoreCase("java.lang.Float")) {
				                  if (value == null|| value.equals("")) {
				                      value = null;
				                  }else{
				                	  value=Float.valueOf(value.toString());
				                  }
				              }else
				              if (className.equalsIgnoreCase("java.lang.Integer")) {
				                  if (value == null|| value.equals("")) {
				                      value = null;
				                  }else{
				                	  try{
				                	  value=Integer.valueOf(value.toString());
				                	  } catch (Exception e){
				                		  value=Integer.valueOf((int) Float.parseFloat(value.toString()));
				                	  }
				                  }
				              }else
				              if (className.equalsIgnoreCase("java.math.BigDecimal")) {
				                  if (value == null|| value.equals("")) {
				                      value = null;
				                  }else{
				                	  value=BigDecimal.valueOf(Double.valueOf(value.toString()));
				                  }
				              }else
				              if (className.equalsIgnoreCase("java.util.Date")) {
				                  if (value == null|| value.equals("")) {
				                      value = null;
				                  }else if(value instanceof Double){
				                	  value=new Date(((Double) value).longValue());
				                  }else{
				                	  //yyyy-MM-dd HH:mm:ss 格式默认
				                	  value=DateUtils.str2Date(value.toString(),DateUtils.datetime_sdf);
				                  }
				              }
				              if (className.equalsIgnoreCase("java.sql.Clob")) {
				            	  if(StringUtil.isNotEmpty(value)){
				            		  value=ClobUtil.ClobToString((Clob)value);
				            	  }else{
				            		  value="";
				            	  }
				            	  name=name+LOB_SUFIX;
				              }else if(className.equalsIgnoreCase("java.sql.NClob")){
				            	  if(StringUtil.isNotEmpty(value)){
				            		  value=ClobUtil.NClobToString((NClob)value);
				            	  }else{
				            		  value="";
				            	  }
				            	  name=name+LOB_SUFIX;
				              }else if(className.equalsIgnoreCase("java.lang.Boolean")){
				            	  if(StringUtil.isNotEmpty(value)){				            		  
				            		 if(value.getClass().equals(String.class)){
				            			 value=Boolean.parseBoolean((String)value);
				            		 }else if(value.getClass().equals(Boolean.class)){
				            			value=Boolean.valueOf((boolean) value);
				            		 }
				            		  
				            	  }else{
				            		  value=null;
				            	  }
				              }
				              
				              
							try {
								PropertyUtils.setSimpleProperty(dest, name, value);
							} catch (IllegalAccessException e) {
								e.printStackTrace();
								throw new BusinessException("MapToBean方法IllegalAccessException",e);
							} catch (InvocationTargetException e) {
								e.printStackTrace();
								throw new BusinessException("MapToBean方法InvocationTargetException",e);
							} catch (NoSuchMethodException e) {
								e.printStackTrace();
								throw new BusinessException("MapToBean方法NoSuchMethodException",e);
							}
							
						}
					}
				}
			} else {
				java.lang.reflect.Field[] fields = orig.getClass().getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
					String name = fields[i].getName();
					if (PropertyUtils.isReadable(orig, name) && PropertyUtils.isWriteable(dest, name)) {
						Object value=null;
						try {
							value = PropertyUtils.getSimpleProperty(orig, name);
						} catch (IllegalAccessException e) {
							e.printStackTrace();
							throw new BusinessException("MapToBean方法IllegalAccessException",e);
						} catch (InvocationTargetException e) {
							e.printStackTrace();
							throw new BusinessException("MapToBean方法InvocationTargetException",e);
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
							throw new BusinessException("MapToBean方法NoSuchMethodException",e);
						}
						if (value != null) {
							try {
								PropertyUtils.setSimpleProperty(dest, name, value);
							} catch (IllegalAccessException e) {
								e.printStackTrace();
								throw new BusinessException("MapToBean方法IllegalAccessException",e);
							} catch (InvocationTargetException e) {
								e.printStackTrace();
								throw new BusinessException("MapToBean方法InvocationTargetException",e);
							} catch (NoSuchMethodException e) {
								e.printStackTrace();
								throw new BusinessException("MapToBean方法NoSuchMethodException",e);
							}
						}
					}
				}
			}
		
	}

	/**
	 * 将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性
	 * 
	 * @param orig
	 *            源对象，标准的JavaBean
	 * @param dest
	 *            排除检查的属性，Map
	 * 
	 * @throws BusinessException
	 */
	@SuppressWarnings("rawtypes")
	public static boolean checkObjProperty(Object orig, Map dest) throws Exception {
		try {
			java.lang.reflect.Field[] fields = orig.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				String name = fields[i].getName();
				if (!dest.containsKey(name)) {
					if (PropertyUtils.isReadable(orig, name)) {
						Object value = PropertyUtils.getSimpleProperty(orig, name);
						if (value == null) {
							return true;
						}
					}
				}
			}
			return false;
		} catch (Exception e) {
			throw new Exception("将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性", e);
		}
	}
	
	
	/** 
     * 将一个 JavaBean 对象转化为一个  Map 
     * @param bean 要转化的JavaBean 对象 
     * @return 转化出来的  Map 对象 
     * @throws IntrospectionException 如果分析类属性失败 
     * @throws IllegalAccessException 如果实例化 JavaBean 失败 
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败 
	 * @throws java.beans.IntrospectionException 
     */   
    @SuppressWarnings({ "rawtypes", "unchecked" })   
    public static Map convertBeanToMap(Object bean)   
            throws IntrospectionException, IllegalAccessException, InvocationTargetException, java.beans.IntrospectionException {   
        Class type = bean.getClass(); //Class  
        Map returnMap = new ConcurrentHashMap();   
        BeanInfo beanInfo = Introspector.getBeanInfo(type);   
   
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();   
        for (int i = 0; i< propertyDescriptors.length; i++) {   
            PropertyDescriptor descriptor = propertyDescriptors[i];   
            String propertyName = descriptor.getName();   
            if (!propertyName.equals("class")) { //过滤掉class  
                Method readMethod = descriptor.getReadMethod();   
                Object result = readMethod.invoke(bean, new Object[0]);   
                if (result != null) {   
                    returnMap.put(propertyName, result);   
                } else {   
                    returnMap.put(propertyName, "");   
                }   
            }   
        }   
        return returnMap;   
    }  
    
    
    /**
    * @Title: describeBean2StringMap
    * @Description: 将 Bean 转为Map<String,String>,非String类型value自动转为String类型
    * @param @param bean
    * @param @return
    * @param @throws IntrospectionException
    * @param @throws IllegalAccessException
    * @param @throws InvocationTargetException
    * @param @throws java.beans.IntrospectionException    设定文件
    * @return Map    返回类型
    * @throws
    */ 
    @SuppressWarnings({ "rawtypes", "unchecked" })   
    public static Map<String,String> describeBean2StringMap(Object bean)   
            throws BusinessException {   
        Class type = bean.getClass(); //Class  
        Map returnMap = new ConcurrentHashMap<String,String>();   
        BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(type);
		} catch (java.beans.IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e);
		}   
   
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();   
        for (int i = 0; i< propertyDescriptors.length; i++) {   
            PropertyDescriptor descriptor = propertyDescriptors[i];   
            String propertyName = descriptor.getName();   
            if (!propertyName.equals("class")) { //过滤掉class  
                Method readMethod = descriptor.getReadMethod();   
                Object result;
				try {
					result = readMethod.invoke(bean, new Object[0]);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new BusinessException(e);
				}   
                if (result != null) {                	
                	//变量  类型
                	Class clazz=descriptor.getPropertyType();
                	if(clazz.equals(Date.class)){  //日期转字符串              		
                		result=DateUtils.date2Str((Date)result, DateUtils.datetime_sdf);
                	}else if(clazz.equals(Timestamp.class)){//时间戳
                		result=DateUtils.timestamptoStr((Timestamp)result);
                	}else if(clazz.equals(Clob.class)){
                		result=ClobUtil.ClobToString((Clob) result);
                	}else if(clazz.equals(NClob.class)){
                		result=ClobUtil.NClobToString((NClob) result);
                	}
                	else{
                		result=String.valueOf(result);
                	}
                    returnMap.put(propertyName, result);   
                } else {   
                    returnMap.put(propertyName, "");   
                }   
            }   
        }   
        return returnMap;   
    }
    
    
}

