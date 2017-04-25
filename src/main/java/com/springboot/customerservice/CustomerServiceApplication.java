package com.springboot.customerservice;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.springboot.customerservice.domain.Customer;
import com.springboot.customerservice.service.MongoService;
import com.springboot.customerservice.service.impl.MongoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}

@RestController
class ServiceInstanceRestController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
}

@RestController
class CustomerController {

	public enum DBCOLLECTION{
		CUSTOMER("customer");

		private String name;
		DBCOLLECTION(String name){
			this.name = name;
		}
		public String getName(){
			return this.name;
		}
	}

	MongoService mongoService = new MongoServiceImpl();

	@RequestMapping("/customer/list")
	public List<Customer> getCustomerList() {
		System.out.println("getCustomerList");
		List<Customer> list = new ArrayList<>();
		MongoCollection customerCollection = mongoService.getCollecionByName(DBCOLLECTION.CUSTOMER.getName());
		MongoCursor<Customer> mongoCursor = customerCollection.find().iterator();
		while(mongoCursor.hasNext()){
			list.add(mongoCursor.next());
		}
		return list;
	}
}