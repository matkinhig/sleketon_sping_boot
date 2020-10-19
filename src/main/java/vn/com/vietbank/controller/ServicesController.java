package vn.com.vietbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.com.vietbank.Application;

@RestController
public class ServicesController {

    @Autowired
    Application context;

    @PostMapping(value = "/ewallet/api/v1/middleware")
    public String index(@RequestBody String request) throws Exception {
        String data = "{\"result\" : \"result\"}";
        return data;
    }
}
