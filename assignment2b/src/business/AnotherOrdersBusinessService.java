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
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders = new ArrayList<Order>();

	@Override
	public void test() {
		System.out.println("Hello from the AnotherOrdersBusinessService");

	}

	public AnotherOrdersBusinessService() {

		orders.add(new Order("0000a", "Product #a A lternative", (float) 91.30, 23));
		orders.add(new Order("0000b", "Product #b Alternative", (float) 81.04, 944));
		orders.add(new Order("0000c", "Product #c Alternative", (float) 61.05, 3));
		orders.add(new Order("0000d", "Product #d Alternative", (float) 31.06, 99));
		orders.add(new Order("0000e", "Product #e Alternative", (float) 11.08, 5));
		orders.add(new Order("0000f", "Product #f Alternative", (float) 6.80, 3));
		orders.add(new Order("0000g", "Product #g Alternative", (float) 14.50, 4));

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
