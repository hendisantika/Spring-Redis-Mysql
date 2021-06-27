package com.hendisantika.springredismysql.repository;

import com.hendisantika.springredismysql.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : Spring-Redis-Mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/06/21
 * Time: 14.57
 */
@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
    Country findFirstById(Integer id);

    @Override
    List<Country> findAll();

    @Override
    void deleteById(Integer integer);
}
