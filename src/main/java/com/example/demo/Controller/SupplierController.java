package com.example.demo.Controller;

import com.example.demo.Model.Supplier;
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
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    @RequestMapping(value="/suppliers", method = RequestMethod.GET)
    public ModelAndView suppliers(){
        List<Supplier> suppliers = supplierService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.setViewName("supplier/list");
        return modelAndView;
    }

    @RequestMapping(value="/supplier", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("supplier", new Supplier());
        return "supplier/edit";
    }

    @RequestMapping(value = "/supplier", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("supplier") Supplier supplier,
                       BindingResult result, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "supplier/edit";
        }
        supplier = supplierService.save(supplier);
        return "redirect:/suppliers";
    }



}
