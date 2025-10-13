package com.hendisantika.springredismysql.controller;

import com.hendisantika.springredismysql.entity.Country;
import com.hendisantika.springredismysql.service.CountryService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("/countries")
@Api(tags = {"CountryController"})
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<Country> save(@RequestBody Country request) throws RuntimeException {
        return new ResponseEntity<>(countryService.save(request), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Country>> findAllCountries() throws RuntimeException {
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/findById")
    public ResponseEntity<Country> findById(@RequestParam Integer id) throws RuntimeException {
        return new ResponseEntity<>(countryService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/deleteById")
    public ResponseEntity<List<Country>> deleteById(@RequestParam Integer id) throws RuntimeException {
        return new ResponseEntity<>(countryService.delete(id), HttpStatus.OK);
    }
}
