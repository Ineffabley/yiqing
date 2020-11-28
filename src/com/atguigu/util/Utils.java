package com.atguigu.util;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class Utils {
	/**
	 * @param request
	 * @param bean
	 */
	public static <T> T copyParamToBean(Map value,T bean) {
		try {
//			System.out.println("注入之前：" + bean);
			// populate 把map的值注入到User对象中
			/**
			 * Map中的值是请求的参数。<br/>	
			 * 		key=value
			 * 		刚好是
			 * 		name=value
			 * 要求请求的参数名必须和javaBean的属性名一致！！！ <br/>
			 * 	我们前面使用EL表达式取bean对象的属性值的时候，走的是读方法getXxx<br/>
			 * 	今天我们使用BeaUtils工具类给bean对象赋值的时候，走的是setXxx方法
			 */
			BeanUtils.populate(bean, value);
			System.out.println("注入之后：" + bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	/**
	 * 将字符串类型的int数据转换成为integer类型
	 */
	public static Integer parseInt(String strInt,Integer defaultValue) {
		try {
			return Integer.parseInt(strInt);
		} catch (NumberFormatException e) {
		}
		return defaultValue;
	}
	
}
