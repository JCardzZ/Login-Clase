package com.mm.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.com.dao.UsuarioDao;
import com.mm.com.model.TbUsuariop;

/**
 * Servlet implementation class ServletUser
 */
public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String usu = request.getParameter("usuario");
		String contra = request.getParameter("contra");
		
		TbUsuariop usuario = new TbUsuariop();
		
		UsuarioDao usuDao = new UsuarioDao();
		
		usuario.setUsuario(usu);
		usuario.setContrasenia(contra);
		
		int  verificarUsuario = usuDao.ingresoUsuario(usuario).size();
		
		if(verificarUsuario==1) {
			
			response.sendRedirect("principal.jsp");
			
		//	System.out.println("entrastes");
			
		} else {
			
			System.out.println("ERROR");
			
		}
		
		response.sendRedirect("index.jsp");
		
		
	}

}
