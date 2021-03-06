package com.mm.com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mm.com.dao.HistorialDao;
import com.mm.com.dao.UsuarioDao;
import com.mm.com.model.TbHistorial;
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
		String cerrarSession = request.getParameter("btncerrar");
		
		if (cerrarSession !=null) {
			if	(cerrarSession.equals("CERRAR")) {
				
				HttpSession cerrarSessiones = (HttpSession) request.getSession();
				cerrarSessiones.invalidate();
						
				response.sendRedirect("index.jsp");
				
			}
		}

		TbUsuariop usuario = new TbUsuariop();
		
		UsuarioDao usuDao = new UsuarioDao();
		
		usuario.setUsuario(usu);
		usuario.setContrasenia(contra);
		
		int  verificarUsuario = usuDao.ingresoUsuario(usuario).size();
		
		
		if(verificarUsuario==1) {
			HistorialDao histoDao = new HistorialDao();
			TbHistorial histo = new TbHistorial();
			Date fecha = new Date();
			
			histo.setFecha(fecha);
			usuario.setIdUsuarios(usuario.getIdUsuarios());
			histo.setTbUsuariop(usuario);
			histoDao.agregarDatosHistorial(histo);
			
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("usuario", usu);
			response.sendRedirect("Inicio.jsp");
			
		//	System.out.println("entrastes");
			
		} else {
			
			System.out.println("ERROR");
			
		}
	}
	//	response.sendRedirect("index.jsp");
		
		
	

}
