package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders = new ArrayList<Order>();

	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");

	}

	public OrdersBusinessService() {

		orders.add(new Order("00001", "This is product 1", (float) 9.00, 123));
		orders.add(new Order("00002", "This is product 2", (float) 8.00, 1944));
		orders.add(new Order("00003", "This is product 3", (float) 6.00, 13));
		orders.add(new Order("00004", "This is product 4", (float) 3.00, 199));
		orders.add(new Order("00005", "This is product 5", (float) 1.00, 15));
		orders.add(new Order("00006", "This is product 6", (float) 16.00, 33));
		orders.add(new Order("00007", "This is product 7", (float) 4.00, 14));

	}

	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;

	}

}
