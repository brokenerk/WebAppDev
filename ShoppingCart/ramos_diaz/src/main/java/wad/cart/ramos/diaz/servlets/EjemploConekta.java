package wad.cart.ramos.diaz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import io.conekta.Conekta;
import io.conekta.Error;
import io.conekta.ErrorList;
import io.conekta.Order;

/**
 * Servlet implementation class EjemploConekta
 */
public class EjemploConekta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploConekta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Llave privada (servidor) para pruebas
		Conekta.setApiKey("key_yV9kDKjLq5AwAsBRrQ5WJw");
		
		/*
		 {
		  id = ord_2fw8EWJusiRrxdPzT,
		  object = order,
		  livemode = false,
		  amount = 35000,
		  amount_refunded = 0,
		  payment_status = paid,
		  currency = MXN,
		  customer_info = {
		    object = customer_info,
		    customer_id = cus_zzmjKsnM9oacyCwV3,
		    name = Mario Perez,
		    email = usuario@example.com,
		    phone = +5215555555555
		  },
		  created_at = 1485842107,
		  updated_at = 1485842112,
		  line_items = {
		    object = list,
		    has_more = false,
		    total = 1,
		    data = [{
		      id = line_item_2fw8EWJusiRrxdPzR,
		      object = line_item,
		      name = Box of Cohiba S1s,
		      unit_price = 35000,
		      quantity = 1,
		      parent_id = ord_2fw8EWJusiRrxdPzT,
		      antifraud_info = {},
		      metadata = {}
		    }]
		  },
		  charges = {
		    object = list,
		    has_more = false,
		    total = 1,
		    data = [{
		      id = 589026bbedbb6e56430016ad,
		      object = charge,
		      livemode = false,
		      created_at = 1485842107,
		      status = paid,
		      amount = 35000,
		      paid_at = 1485842112,
		      currency = MXN,
		      fee = 1467,
		      customer_id = ,
		      order_id = ord_2fw8EWJusiRrxdPzT,
		      payment_method = {
		        object = card_payment,
		        type = credit,
		        name = Jorge Lopez,
		        exp_month = 12,
		        exp_year = 19,
		        auth_code = 490884,
		        last4 = 4242,
		        brand = visa,
		        issuer = ,
		        account_type = ,
		        country = MX,
		        fraud_score = 29,
		        fraud_indicators = []
		      }
		    }]
		  },
		  metadata = {}
		}
		*/
		
		JSONObject completeOrderJSON = new JSONObject("{" +
		        "'currency': 'mxn'," +
		        "'metadata': {" +
		        "    'test': true"+
		        "}," +
		        "'line_items': [{" +
		        "    'name': 'Box of Cohiba S1s'," +
		        "    'description': 'Imported From Mex.'," +
		        "    'unit_price': 35000," +
		        "    'quantity': 1," +
		        "    'tags': ['food', 'mexican food']," +
		        "    'type': 'physical'" +
		        "}]," +
		        "'customer_info': { " +
		        "    'name': 'John Constantine'," +
		        "    'phone': '+5213353319758'," +
		        "    'email': 'hola@hola.com'" +
		        "}," +
		        "'charges': [{" +
		        "    'payment_method': {" +
		        "        'type': 'card'," +
		        "        'token_id': 'tok_test_visa_4242'" +
		        "    }, " +
		        "    'amount': 35000" +
		        "}]" +
		        "}");
		
		/* Manejo de errores, automaticamente devuelve mensajes de error
		 * Tarjeta rechazada --> 	tok_test_card_declined
		 * Numero de tarjeta incorrecto
		 * Fondos insuficientes --> tok_test_insufficient_funds
		 * Tiempo de espera para captura de tarjeta termino - 10 min --> tok_test_msi_error
		 * Tarjeta expirada: mes, año
		 * CVC expirado */
		try {
			Order completeOrder = Order.create(completeOrderJSON);
			out.println(completeOrder.charges.get(0));
		} catch (ErrorList e) {
			out.println(e.details.get(0).message);
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
