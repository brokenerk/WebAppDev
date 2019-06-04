package wad.cart.ramos.diaz.bs;

import java.time.Instant;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import io.conekta.Conekta;
import io.conekta.Error;
import io.conekta.ErrorList;
import io.conekta.Order;
import io.conekta.Token;
import wad.cart.ramos.diaz.entidad.Product;
import wad.cart.ramos.diaz.entidad.User;

@Service("buyBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class BuyBs {
	

	public Order buy(String json) throws ErrorList, Error {
		// Llave privada (servidor) para pruebas
		Conekta.setApiKey("key_yV9kDKjLq5AwAsBRrQ5WJw");
		Conekta.setApiVerion("2.0.0");
		Conekta.setLocale("en");
		JSONObject buyJSON = new JSONObject(json);

		return Order.create(buyJSON);
	}
	
	public String createPaymentMethod(String creditCard, String owner, String expMonth, String expYear,
									  String cvc, Integer idUser, String address) {
		String paymentMethod = "{" +
							   "'card': {" + 
							   "  'number': '" + creditCard + "'," + 
							   "  'name': '" + owner + "'," + 
							   "  'exp_month': '" + expMonth + "'," + 
							   "  'exp_year': '" + expYear + "'," + 
							   "  'cvc': '" + cvc + "'," +
								   address + 
							   "  }" +
							   "}";
		return paymentMethod;
	}
	
	public String createAddress(String street, String city, String state, String zipCode) {
		String address = "'address': {" + 
						"	'street1': '" + street + "'," + 
						"	'city': '" + city + "'," + 
						"	'state': '" + state + "'," + 
						"	'country': 'Mexico'," + 
						"	'postal_code': '" + zipCode + "'" + 
						"}";
		return address;
	}
	
	public String formatTelephone(String tel) {
		return "+521" + tel.replace("-", "");
	}
	
	public String createOrder(Integer idOrder, Float t, User user, Product product, String paymentMethod) {
		// Llave publica para tokenizar tarjeta (prueba)
		Conekta.setApiKey("key_FqD7qn3VvVoy6fUnuFA32CQ");
		Conekta.setApiVerion("2.0.0");
		
		Integer total = Math.round(t);
		System.out.println("--------------->" + total);
		
		//Token creditCard = Token.create(new JSONObject(paymentMethod));
		//String tokenID = creditCard.getId();
		//System.out.println(tokenID);
			
		String order = "{" + 
				"		  'livemode': false," + 
				"		  'amount': " + total + "," + 
				"		  'amount_refunded': 0," + 
				"		  'payment_status': 'paid'," + 
				"		  'currency': 'MXN'," + 
				"		  'customer_info': {" + 
				"		    'name': '" + user.getName() + " " + 
									   user.getLastName() + " " + 
									   user.getSecondLastName() +"'," + 
				"		    'email': '" + user.getLogin() + "'," + 
				"		    'phone': '" + formatTelephone(user.getTelephone()) + "'" +
				"		  }," + 
				"		  'created_at': " + Instant.now().getEpochSecond() + "," + 
				"		  'updated_at': " + Instant.now().getEpochSecond() +"," + 
				"		  'line_items': [{" + 
				"		      'name': '" + product.getName() +"'," + 
				"		      'unit_price': " + total + "," + 
				"		      'quantity': 1," + 
				"		      'parent_id': '" + idOrder + "'," + 
				"		  }]," + 
				"		  'charges': [{" + 
				"		      'livemode': false," + 
				"		      'created_at': " + Instant.now().getEpochSecond() + "," + 
				"		      'status': 'paid'," + 
				"		      'amount': " + total + "," + 
				"		      'paid_at': " + Instant.now().getEpochSecond() + "," + 
				"		      'currency': 'MXN'," + 
				"		      'fee': 0," + 
				"    		  'payment_method': {" +
		        "        		'type': 'card'," +
		        "        		'token_id': 'tok_test_visa_4242'" + //TokenId de pruebas
				"			   }" +			
				"		    }]" + 
				"		  }]," + 
				"		}";

		return order;
	}

}
