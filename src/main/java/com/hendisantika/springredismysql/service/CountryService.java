package com.hendisantika.springredismysql.service;

import com.hendisantika.springredismysql.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
