package kiet.com.vn.jdbcweek4www.dao;

import kiet.com.vn.jdbcweek4www.models.Candidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CandidateDAO extends AbstractDAO<Candidate, UUID>{
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public CandidateDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean create(Candidate candidate) {
        String sql = "INSERT cadidate VALUES (?,?,?,?,?,?)";
        int insert = jdbcTemplate.update(sql,candidate.getId(), candidate.getDob(),candidate.getEmail(), candidate.getFullName(),candidate.getPhone(),candidate.getListAddress());
        return insert >0;
    }

    @Override
    public List<Candidate> getAll() {
        String sql = "SELECT * from candidate";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Candidate.class));
    }

    @Override
    public Optional<Candidate> findById(UUID uuid) {
        String sql = "SELECT * FROM candidate where id = ?";
        try {
            Candidate candidate = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Candidate.class), uuid);
            assert candidate != null;
            return Optional.of(candidate);
        } catch (Exception e) {
            e.getMessage();
        }
        return Optional.empty();
    }

    @Override
    public boolean update(Candidate candidate) {
        String sql = "UPDATE candidate SET dob = ?, email = ?, full_name = ?, phone = ?, address = ? WHERE id = ?";
        int updated = jdbcTemplate.update(sql, candidate.getDob(), candidate.getEmail(), candidate.getFullName(), candidate.getPhone(), candidate.getListAddress(), candidate.getId());
        return updated > 0;
    }

    @Override
    public boolean delete(UUID uuid) {
        String sql = "DELETE FROM candidate where id = ?";
        int delete = jdbcTemplate.update(sql, uuid);
        return delete > 0;
    }
}
