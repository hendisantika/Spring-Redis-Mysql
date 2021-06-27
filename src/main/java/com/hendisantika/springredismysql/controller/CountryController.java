package com.hendisantika.springredismysql.controller;

import com.hendisantika.springredismysql.entity.Country;
import com.hendisantika.springredismysql.service.CountryService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : Spring-Redis-Mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/06/21
 * Time: 15.05
 */
@RestController
@RequestMapping("/country")
@Api(tags = {"CountryController"})
@RequiredArgsConstructor
public class CountryController {

    private CountryService countryService;

    @PostMapping(value = "/save")
    public ResponseEntity<Country> save(@RequestBody Country request) throws RuntimeException {
        return new ResponseEntity<>(countryService.save(request), HttpStatus.OK);
    }
}
