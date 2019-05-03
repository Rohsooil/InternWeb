package com.roh.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.roh.model.FilePath;

@MultipartConfig
@WebServlet("/apply/file")
public class ApplicationFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("file") == null) {
			resp.sendError(405);
		} else {
			String filePath = FilePath.filePath + req.getParameter("file");
			String realFileName = new String(req.getParameter("realFileName").getBytes("UTF-8"), "ISO-8859-1");

			URL url = new URL("file:" + filePath);
			File file = new File(url.getFile());

			resp.setContentType("application/octet-stream;charset=utf-8");
			resp.setHeader("Content-Disposition", "attachment; filename=\"" + realFileName);

			BufferedInputStream is = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream os = new BufferedOutputStream(resp.getOutputStream());

			byte[] b = new byte[(int) file.length()];

			int stream = 0;

			while ((stream = is.read(b)) != -1) {
				os.write(b, 0, stream);
			}
			os.flush();
			is.close();
			os.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getPart("file") == null) {
			response.sendError(405);
		} else {
			Part path = request.getPart("file");
			InputStream is = path.getInputStream();
			String dir = FilePath.filePath + request.getParameter("file_dir");
			File file = new File(dir, request.getSession().getId() + "-" + request.getParameter("file_name"));
			FileOutputStream fos = new FileOutputStream(file);
			int stream = 0;
			while ((stream = is.read()) >= 0) {
				fos.write(stream);
			}
			is.close();
			fos.close();
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().println(request.getParameter("file_dir") + "\\" + file.getName());
			response.getWriter().close();
		}
	}

}
