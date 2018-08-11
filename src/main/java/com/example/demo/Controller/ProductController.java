package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Model.Supplier;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Services.ProductService;
import com.example.demo.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ProductService productService;



    @RequestMapping(value="/products", method = RequestMethod.GET)
    public ModelAndView products(){
        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("product/list");
        return modelAndView;
    }

    @RequestMapping(value="/product", method = RequestMethod.GET)
    public String create(Model model){
        List<Supplier> suppliers = supplierService.findAll();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("product", new Product());
        return "product/edit";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("product") Product product,
                       BindingResult result, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "product/edit";
        }
        product = productService.save(product);
        return "redirect:/products";
    }



}
