package com.example.mertkandemirhw03.repository;

import com.example.mertkandemirhw03.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private final JdbcTemplate jdbcTemplate;

    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Product> findAll() {
        String sql = "select * from sisdb.products";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public void save(Product product) {
        String sql = "insert into sisdb.products(product_id,product_name,product_photo_url,product_description,product_price,product_category) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,product.getProductID(),product.getProductName(),product.getProductPhotoUrl(),product.getProductDescription(),product.getProductPrice(),product.getProductCategory());

        //String sql = "insert into sisdb.products(product_name,product_photo_url,product_description,product_price,product_category) values(?,?,?,?,?)";
        //jdbcTemplate.update(sql,product.getProductName(),product.getProductPhotoUrl(),product.getProductDescription(),product.getProductPrice(),product.getProductCategory());
    }

    @Override
    public List<Product> findByCategory(String category) {
        String sql = "select * from sisdb.products where product_category = '" + category +"'";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    private static class ProductRowMapper implements RowMapper<Product>{
        @Override
        public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException{
            Product product = new Product();
            product.setProductID(resultSet.getInt("product_id"));
            product.setProductName(resultSet.getString("product_name"));
            product.setProductPhotoUrl(resultSet.getString("product_photo_url"));
            product.setProductDescription(resultSet.getString("product_description"));
            product.setProductPrice(resultSet.getString("product_price"));
            product.setProductCategory(resultSet.getString("product_category"));

            return product;
        }
    }
}
