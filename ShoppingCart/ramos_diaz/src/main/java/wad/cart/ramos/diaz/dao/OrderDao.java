package wad.cart.ramos.diaz.dao;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import wad.cart.ramos.diaz.entidad.OrderC;
import wad.cart.ramos.diaz.entidad.OrderDetail;
import wad.cart.ramos.diaz.entidad.OrderDetailId;
import wad.cart.ramos.diaz.entidad.Product;

@Repository("orderDao")
public class OrderDao {
	@PersistenceContext
	private EntityManager entityManagerFactory;
	
	public OrderC findById(Integer id) {
		return entityManagerFactory.find(OrderC.class, id);
	}
	
	public OrderDetail findOrderDetail(Integer idProduct, Integer idOrder) {
		OrderDetailId id = new OrderDetailId(idProduct, idOrder);
		return entityManagerFactory.find(OrderDetail.class, id);
	}
	
	public Integer createOrder(Date date, Float total, Integer idUser) {
		Integer idOrder = null;
		try {
			OrderC order = new OrderC();
			order.setDate(date);
			order.setPurchased(false);
			order.setTotal(total);
			order.setIdUser(idUser);
			order.setOrderDetails(new ArrayList<>());
			
			entityManagerFactory.persist(order);
			idOrder = order.getId();
			entityManagerFactory.flush();	
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error al crear orden");
		}
		finally {
		}
		return idOrder;
	}
	
	public OrderC updateOrder(Float price, OrderC order) {
		OrderC o = order;
		try {
			order.setDate(new Date());
			order.setTotal(price);
			o = entityManagerFactory.merge(order);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error al actualizar el carrito");
		}
		finally {
		}
		return o;
	}
	
	public OrderC orderIsPurchased(OrderC order) {
		OrderC o = order;
		try {
			order.setPurchased(true);
			o = entityManagerFactory.merge(order);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error al actualizar estado de la orden");
		}
		finally {
		}
		return o;
	}
	
	public void deleteOrder(OrderC order) {
		try {
			entityManagerFactory.remove(order);
			entityManagerFactory.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar la orden/carrito");
		}
		finally {
		}
	}
	
	public void addProduct(Product product, Integer idOrder, Integer amount) {
		try {
			OrderDetail od = new OrderDetail(product.getId(), idOrder);
			od.setIdOrder(idOrder);
			od.setIdProduct(product.getId());
			od.setProduct(product);
			od.setAmount(amount);
			entityManagerFactory.persist(od);
			entityManagerFactory.flush();	
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error al agregar producto al carrito");
		}
		finally {
		}
	}
	
	public Float updateAmount(Product product, Integer idOrder, String operation) {
		Float newPrice = null;
		try {
			Integer newAmount = 0;
			OrderC o = findById(idOrder);
			OrderDetail od = findOrderDetail(product.getId(), idOrder);
			
			if(operation.equals("inc")) {
				System.out.println("------------->Incrementamos");
				newAmount = od.getAmount() + 1;
				newPrice = o.getTotal() + product.getRealPrice();
			}
			else if(operation.equals("dec")) {
				System.out.println("------------->Decrementamos");
				newAmount = od.getAmount() - 1;
				newPrice = o.getTotal() - product.getRealPrice();
			}
			
			//Si no hay cantidad, eliminamos producto
			if(newAmount == 0) {
				System.out.println("------------->Sin cantidad, eliminamos producto");
				removeProduct(product, idOrder);
			}
			else {
				System.out.println("------------->Actualizamos cantidad");
				od.setAmount(newAmount);
				entityManagerFactory.merge(od);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error al incrementar producto del carrito");
		}
		finally {
		}
		return newPrice;
	}
	
	public void removeProduct(Product product, Integer idOrder) {
		try {
			OrderDetail od = findOrderDetail(product.getId(), idOrder);
			entityManagerFactory.remove(od);
			entityManagerFactory.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar producto del carrito");
		}
		finally {
		}
	}
}
