package dhruv.demoProject.controller;

import dhruv.demoProject.service.XyzService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dhruv.demoProject.service.XyzService;

import java.security.Provider;
import java.util.List;

@RestController
public class Xyz{
    @Autowired
    private XyzService service;
    @GetMapping("/")
    public String getMessage(){
        return "Hellow From Dhruv";
    }

    @PostMapping("/Products")
    public String addProduct(@RequestBody String product){
        return service.addProduct(product);
    }

    @GetMapping("/Products")
    public List<String> getProduct(){
        return service.getProduct();
    }

//    The @PathVariable annotation in Spring is used to extract values from the URI path of an
//    HTTP request and bind them to method parameters in your controller. This is particularly
//    useful for creating RESTful APIs where parts of the URL represent dynamic values, such as
//    resource identifiers
    @DeleteMapping("Products/{product}")
    public String deleteProduct(@PathVariable("product") String product){
        return service.deleteProduct(product);
    }

}
