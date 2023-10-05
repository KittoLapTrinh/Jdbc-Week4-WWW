package kiet.com.vn.jdbcweek4www.services;

import kiet.com.vn.jdbcweek4www.models.Address;
import kiet.com.vn.jdbcweek4www.repositories.AddressRepositories;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressService {
    private final AddressRepositories addressRepositories;
    private static AddressService addressService;
    public AddressService(AddressRepositories addressRepositories){
        this.addressRepositories = addressRepositories;
    }
    public boolean add(Address entity) throws Exception{
        return addressRepositories.add(entity);
    }
    public static List<Address> getAll() {
        return addressService.getAll();
    }


}
