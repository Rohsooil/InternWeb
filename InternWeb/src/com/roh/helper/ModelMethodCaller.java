package com.roh.helper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;

import com.roh.model.application.ApplicationModel;

public class ModelMethodCaller {

	public void callSetter(ApplicationModel model, String memberName, String value) throws ServletException {
		try {
			getSetter(model, memberName).invoke(model, value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ServletException(e);
		}
	}

	public String callGetter(ApplicationModel model, int index) throws ServletException {
		String value = null;
		try {
			value = getGetter(model, index).invoke(model).toString();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ServletException(e);
		}

		return value;
	}

	private Method getSetter(ApplicationModel model, String memberName) throws ServletException {
		Method method = null;

		try {
			String methodName = getMethodName("set", memberName);
			method = model.getClass().getDeclaredMethod(methodName, String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new ServletException(e);
		}

		return method;
	}

	private Method getGetter(ApplicationModel model, int index) throws ServletException {
		Method method = null;

		try {
			Field[] fieldArr = model.getClass().getDeclaredFields();
			String methodName = getMethodName("get", fieldArr[index - 1].getName());

			method = model.getClass().getMethod(methodName);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new ServletException(e);
		}

		return method;
	}

	private String getMethodName(String prefix, String memberName) {
		String rearName = memberName.substring(0, 1).toUpperCase() + memberName.substring(1);
		return prefix + rearName;
	}
}
