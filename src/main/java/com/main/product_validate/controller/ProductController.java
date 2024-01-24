package com.main.product_validate.controller;

import com.main.product_validate.model.Product;
import com.main.product_validate.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductRepository iproductService;

    @GetMapping("")
    public String home(Model model){
        List<Product> products = iproductService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("/product/create")
    public String create(Model model){
        model.addAttribute("products", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product){
        product.setId((int) (Math.random()*1000));
        iproductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("productEdit", iproductService.findById(id));

        System.out.println(iproductService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product) {
        iproductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("productDelete", iproductService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product, RedirectAttributes redirect) {
        iproductService.delete(product);
        redirect.addFlashAttribute("success", "Removed product successful!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("productView", iproductService.findById(id));
        return "/view";
    }
}
