package kiet.com.vn.jdbcweek4www;

import kiet.com.vn.jdbcweek4www.models.Address;
import kiet.com.vn.jdbcweek4www.models.Candidate;
import kiet.com.vn.jdbcweek4www.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JdbcWeek4WwwApplication {

	@Autowired
	private AddressService addressService;

	public static void main(String[] args) {
		SpringApplication.run(JdbcWeek4WwwApplication.class, args);
	}

	@Bean
	CommandLineRunner test() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Address> addresses = AddressService.getAll();

				System.out.println(addresses);
			}
		};
	}

}
