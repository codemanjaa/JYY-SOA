package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clientWS_CS.CardValidator;

/**
 * Servlet implementation class MyConvertor_Servlet
 */
@WebServlet("/MyCardValidator_Servlet")
public class MyCardValidator_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCardValidator_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		//NumberConvertor client = new NumberConvertor();
		
		CardValidator client = new CardValidator();

		String value = request.getParameter("value").toString();
		String type = request.getParameter("type").toString();
		PrintWriter out = response.getWriter();
		if(value.equals("")){
			out.write("error: Please, provide a card number!");
		}else if((value.length() < 13) || (value.length() > 16)) {
			out.write("error: invalid card length of chars");
		}else{
			String result = "";
				String cardType = client.getCardType(value);
				boolean isCommercial = client.isCommercialCard(value);
				String commercial = "";
				if(isCommercial) {
					commercial = "Commercial";
				}
				else {
					commercial = "This not a commercial card";
				}
				
				//result = cardType + " "+ isDebitCard.indexOf(0);
				result = cardType+ ". \n "+ commercial;
				
			out.write(result); 			
		}
					 
		out.flush();
	    out.close();

	}

}
