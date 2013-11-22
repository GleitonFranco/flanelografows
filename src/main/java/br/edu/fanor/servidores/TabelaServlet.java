package br.edu.fanor.servidores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The simplest possible servlet.
 *
 * @author Gleiton Franco
 */

public class TabelaServlet extends HttpServlet {

	private static final long serialVersionUID = -6778860586754767813L;
	Flanelografo quadro = Flanelografo.getInstance();
	public final String ATUALIZAR = "Atualizar";
	public final String INSERIR = "Inserir";
	public final String APAGAR = "Apagar";
	public final String TITULO = "Tabela de Horários";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (request.getParameter("action")!=null) {
			receber(request);
		}
		System.out.println("******* ACTION=======> "+request.getParameter("action"));
		quadro.ordenaLista();
		Collections.sort(quadro.lista);

		out.println("<html>");
		out.println("<head>");

		out.println("<title>" + TITULO + "</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");

		out.println("<form action=\"tabela\" >"); // method=\"post\"
		out.println("<table border=1 bgcolor='yellow' width='100%'>");
//		out.println("<col width=\"100\">");
		out.println("<tr>");
//		out.println("<td bgcolor='#aaddbb'>");
//		out.println("LINHA");
//		out.println("</td>")
		out.println("<td>");
		out.println("CURSO");
		out.println("</td>");
		out.println("<td>");
		out.println("DISCIPLINA");
		out.println("</td>");
		out.println("<td>");
		out.println("SALA");
		out.println("</td>");
		out.println("<td>");
		out.println("PROFESSOR");
		out.println("</td>");
		out.println("<td>");
		out.println("TURNO");
		out.println("</td>");
		out.println("<td>");
		out.println("DIA");
		out.println("</td>");
		out.println("<td>");
		out.println("SEMESTRE");
		out.println("</td>");
		out.println("<td>");
		out.println("ATUALIZAR");
		out.println("</td>");
		out.println("<td>");
		out.println("APAGAR");
		out.println("</td>");
		out.println("</tr>");

		int n=0;
		for (Disciplina d : quadro.lista) {
			out.println("<tr>");
//			out.println("<td bgcolor='#aaddbb'>");
//			out.println(n);
//			out.println("</td>");
			out.println("<td>");
			out.println("<input type=\"text\" name=\"curso"+n+"\" value=\""+d.curso+"\"/><br />");
			out.println("</td>");
			out.println("<td>");
			out.println("<input type=\"text\" name=\"nome"+n+"\" value=\""+d.nome+"\"/><br />");
			out.println("</td>");
			out.println("<td>");
			out.println("<input type=\"text\" name=\"sala"+n+"\" value=\""+d.sala+"\"/><br />");
			out.println("</td>");
			out.println("<td>");
			out.println("<input type=\"text\" name=\"prof"+n+"\" value=\""+d.prof+"\"/><br />");
			out.println("</td>");
			out.println("<td>");
			out.println("<input type=\"text\" name=\"turno"+n+"\" value=\""+d.turno+"\"/><br />");
			out.println("</td>");
			out.println("<td>");
			out.println("<input type=\"text\" name=\"dia"+n+"\" value=\""+d.dia+"\"/><br />");
			out.println("</td>");
			out.println("<td>");
			out.println("<input type=\"text\" name=\"semestre"+n+"\" value=\""+d.semestre+"\"/><br />");
			out.println("</td>");
			out.println("<td>");
			out.println("<input type=\"submit\" name=\"action\" value=\""+ATUALIZAR+"-"+n+"\"/><br />");
			out.println("</td>");
			out.println("<td>");
			out.println("<input type=\"submit\" name=\"action\" value=\""+APAGAR+"-"+n+"\"/><br />");
			out.println("</td>");

			out.println("</tr>");
			n++;
		}

		out.println("</table>");
		out.println("<input type=\"submit\" name=\"action\" value=\"Inserir\" />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	public void receber(HttpServletRequest request) {
		String[] acao = request.getParameter("action").split("-");
		
		if (ATUALIZAR.equals(acao[0])) {
			int indice = Integer.parseInt(acao[1]);
			Disciplina d = new Disciplina( 
				request.getParameter("curso"+indice),
				request.getParameter("nome"+indice),
				request.getParameter("sala"+indice),
				request.getParameter("prof"+indice),
				request.getParameter("turno"+indice),
				request.getParameter("dia"+indice),
				request.getParameter("semestre"+indice) 
			);
			quadro.lista.set(indice, d);
			quadro.salva();
		}
		if (INSERIR.equals(acao[0])) {
			quadro.lista.add(new Disciplina("","","","","","","1"));
		}
		if (APAGAR.equals(acao[0])) {
			quadro.lista.remove(Integer.parseInt(acao[1]));
			quadro.salva();
		}
	}

}







