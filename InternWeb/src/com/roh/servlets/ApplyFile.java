package com.roh.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/apply/file")
public class ApplyFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part path = request.getPart("file");
		InputStream is = path.getInputStream();
		String imagesDir = "C:\\Users\\kev\\Documents\\files\\" + request.getParameter("file_dir");
		File file = new File(imagesDir, request.getSession().getId() + "-" + request.getParameter("file_name"));
		FileOutputStream fos = new FileOutputStream(file);
		int stream = 0;
		while ((stream = is.read()) >= 0) {
			fos.write(stream);
		}
		is.close();
		fos.close();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().println(file.getCanonicalPath());
		response.getWriter().close();

	}

}
