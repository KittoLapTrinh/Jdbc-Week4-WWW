package kiet.com.vn.jdbcweek4www.dao;

import kiet.com.vn.jdbcweek4www.mapper.CompanyMapper;
import kiet.com.vn.jdbcweek4www.models.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CompanyDAO extends AbstractDAO<Company, UUID> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CompanyDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean create(Company company) {
        String sql = "INSERT company VALUES (?,?,?,?,?,?,?)";

        int inserted = jdbcTemplate.update(sql, company.getId(), company.getAbout(), company.getEmail(), company.getName(), company.getPhone(), company.getWebURL(), company.getListAddress());
        return inserted > 0;
    }

    @Override
    public List<Company> getAll() {
        String sql = "SELECT * FROM company";
        return jdbcTemplate.query(sql, new CompanyMapper());
    }

    @Override
    public Optional<Company> findById(UUID uuid) {
        String sql = "SELECT * from company where comp_id = ?";

        try {
            Company company = jdbcTemplate.queryForObject(sql, new CompanyMapper(), uuid);

            assert company != null;
            return Optional.of(company);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public boolean update(Company company) {
        String sql = "UPDATE company SET about = ?, email = ?, comp_name = ?, phone = ?, web_url = ?, address = ? WHERE comp_id = ?";

        int updated = jdbcTemplate.update(sql, company.getAbout(), company.getEmail(), company.getName(), company.getPhone(), company.getWebURL(), company.getListAddress(), company.getId());

        return updated > 0;
    }

    @Override
    public boolean delete(UUID uuid) {
        String sql = "DELETE FROM company WHERE comp_id = ?";

        return jdbcTemplate.update(sql, uuid) > 0;
    }
}