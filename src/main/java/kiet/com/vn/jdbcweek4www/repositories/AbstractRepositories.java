package kiet.com.vn.jdbcweek4www.repositories;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public abstract class AbstractRepositories<T, UUID> {
    protected JdbcTemplate jdbcTemplate;
    public AbstractRepositories(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    abstract  public List<T> getAll();
    abstract public T getByID(UUID uuid);
    abstract public boolean add(T entity) throws Exception;
    abstract public boolean update(T entity);
    abstract public  boolean delete(UUID uuid);

}
