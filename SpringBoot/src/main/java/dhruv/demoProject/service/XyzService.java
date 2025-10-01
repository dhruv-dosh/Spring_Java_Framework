package dhruv.demoProject.service;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class XyzService {

    //Dependency injection
    List<String> products = new ArrayList<String>();
    public List<String> getProduct(){
        return this.products;
    }
    public String addProduct(String product){
        this.products.add(product);
        return "Product added Successfully";
    }

    public String deleteProduct(String product){
        this.products.remove(product);
        return "product "+product+" deleted";
    }

}
