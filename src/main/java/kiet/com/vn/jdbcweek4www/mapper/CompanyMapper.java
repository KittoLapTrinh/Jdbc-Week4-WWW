package kiet.com.vn.jdbcweek4www.mapper;

import kiet.com.vn.jdbcweek4www.models.Address;
import kiet.com.vn.jdbcweek4www.models.Company;
import org.springframework.jdbc.core.RowMapper;


import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompanyMapper implements RowMapper<Company> {
    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("comp_id");
        String about = rs.getString("about");
        String email = rs.getString("email");
        String name = rs.getString("comp_name");
        String phone = rs.getString("phone");
        String webUrl = rs.getString("web_url");
        List<Company>companyList = new ArrayList<>();

        return new Company(id,about,email,name,phone,webUrl,new ArrayList<>());
    }


}
