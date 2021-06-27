package com.hendisantika.springredismysql.service;

import com.hendisantika.springredismysql.entity.Country;
import com.hendisantika.springredismysql.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : Spring-Redis-Mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/06/21
 * Time: 14.58
 */
@Service
@RequiredArgsConstructor
public class CountryService {
    private static final String REDIS_CACHE_VALUE = "country";

    private CountryRepository countryRepository;

    @CachePut(value = REDIS_CACHE_VALUE, key = "#country.id")
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Cacheable(value = REDIS_CACHE_VALUE, key = "#id")
    public Country findById(Integer id) {
        return countryRepository.findFirstById(id);
    }

    @CacheEvict(value = REDIS_CACHE_VALUE, key = "#id")
    public List<Country> delete(Integer id) {
        countryRepository.deleteById(id);
        return countryRepository.findAll();
    }
}
