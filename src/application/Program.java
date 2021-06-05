package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(name, email, birthDate);

		sc.nextLine();
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.nextLine();

		Date moment = new Date();

		Order order = new Order(moment, OrderStatus.valueOf(orderStatus), client);

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println();
			System.out.println("Enter #" + i + " item data");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMARY: ");
		
		System.out.println(order);
		

		

		sc.close();
	}

}
