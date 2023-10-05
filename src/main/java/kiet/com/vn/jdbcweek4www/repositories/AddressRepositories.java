package kiet.com.vn.jdbcweek4www.repositories;

import kiet.com.vn.jdbcweek4www.models.Address;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

public class AddressRepositories extends AbstractRepositories<Address, UUID>{
    public AddressRepositories(DataSource dataSource){
        super(dataSource);
    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public Address getByID(UUID uuid) {
        return null;
    }

    @Override
    public boolean add(Address address) throws Exception {
        String sql = "INSERT INTO `address` (`id`, `street`,`city`,`country`,`number`,`zipcode`) VALUES(?,?,?,?,?,?)";
        boolean b = false;
        try{
            b = jdbcTemplate.update(sql, address.getId(), address.getStreet(), address.getCity(), address.getCountry(), address.getNumber(), address.getZipcode()) > 0;
        }catch (Exception e){
            throw new Exception("DuplicateKey");
        }
        return b;
    }

    @Override
    public boolean update(Address address) {
        String sql = "UPDATE address set street = ?, city = ?, country = ?, number = ?, zipcode = ? where id = ?";
        int updated = jdbcTemplate.update(sql, address.getStreet(), address.getCity(), address.getCountry(), address.getNumber(), address.getZipcode(), address.getId());
        return updated > 0;
    }

    @Override
    public boolean delete(UUID uuid) {
        String sql = "DELETE FROM address where id = ?";
        return jdbcTemplate.update(sql, uuid) > 0;
    }
}
