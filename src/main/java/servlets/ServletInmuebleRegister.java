package servlets;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import controller.InmuebleController;

	/**
	 * Servlet implementation class ServletUsuarioRegister
	 */
	@WebServlet("/ServletInmuebleRegister")
	public class ServletInmuebleRegister extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public ServletInmuebleRegister() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			InmuebleController inmueble = new InmuebleController();
			
			String tipo_inmueble = request.getParameter("tipo_inmueble");
			int n_habitaciones = Integer.valueOf(request.getParameter("n_habitaciones"));
			int n_banos = Integer.valueOf(request.getParameter("n_banos"));
			String direccion_i = request.getParameter("direccion_i");
                        String patio = request.getParameter("patio");
			String parqueadero = request.getParameter("parqueadero");
			String telefono_i = request.getParameter("telefono_i");
                        String ciudad_i = request.getParameter("ciudad_i");
                        String comuna_i = request.getParameter("comuna_i");
                        double valor_alquiler = Double.valueOf(request.getParameter("valor_alquiler"));
			
			String result = inmueble.register(tipo_inmueble, n_habitaciones, n_banos, direccion_i, patio, parqueadero, telefono_i, ciudad_i, comuna_i, valor_alquiler);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(result);
			out.flush();
			out.close();
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}