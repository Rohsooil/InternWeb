package com.roh.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.roh.exception.DateInvalidException;
import com.roh.exception.InputInvalidException;

public interface Service {
	void doService(HttpServletRequest request) throws InputInvalidException, ServletException, DateInvalidException;
}
