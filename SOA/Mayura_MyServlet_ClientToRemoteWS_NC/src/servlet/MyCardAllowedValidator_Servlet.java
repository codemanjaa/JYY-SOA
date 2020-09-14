package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clientWS_CS.CardValidator;
import clientWS_LS.IpConvertor;


/**
 * Servlet implementation class MyCardAllowedValidator_Servlet
 */
@WebServlet("/MyCardAllowedValidator_Servlet")
public class MyCardAllowedValidator_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCardAllowedValidator_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		IpConvertor client = new IpConvertor();
		String value = request.getParameter("value").toString();
		String type = request.getParameter("type").toString();
		String card = request.getParameter("card").toString();
		
		
		PrintWriter out = response.getWriter();
		
		String country = client.getCountry(value);
		String countryCode = client.getCountryCode(value);
		String mCountry[] = {"AL", "BY", "BA", "CU", "CD", "ER", "IR", "IQ", "QZ", "LB","LY","MK","ME","NI","KP","RU","RS","SO","SS","SD","SY","TN","TR","UA","VE","YE","ZW"};
		ArrayList<String> mcRestricted =  new ArrayList<String>(Arrays.asList(mCountry)); 
		
	
		String vCountry[] = {"AL", "BY", "BA", "CU", "CD","IR", "IQ","LB","LY","ME","NI","KP","SO","SS","SD","SY","TR","UA","VE","YE","ZW"};
		ArrayList<String> vcRestricted = new ArrayList<String>(Arrays.asList(vCountry));
		String result = "";
		
		CardValidator cardClient = new CardValidator();
		String cardType = cardClient.getCardType(card);
		
		if((mcRestricted.contains(countryCode) || countryCode.isEmpty()) && cardType.equals("MASTERCARD")) {
			result = "Due to some protocols reasons, This "+cardType +" is not be able to use in this "+ country+ ". Sorry for the incovenience";
		}
		else if((vcRestricted.contains(countryCode) || countryCode.isEmpty()) && cardType.equals("VISA")) {
			result = "Due to some protocols reasons, This "+cardType +" card is not be able to use in this "+ country+ ". Please contact your service provider. Sorry for the incovenience.";
		}
		else {
		
			result = "You can use this "+cardType+" in this "+ country;
		}
		out.write(result);
		out.flush();
	    out.close();
	}

}
