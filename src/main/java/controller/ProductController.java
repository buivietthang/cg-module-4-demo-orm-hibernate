package controller;

import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("showProduct");
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("createProduct");
        modelAndView.addObject("products", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Product product) {
        Category category = new Category();
        category.setId(1);
        product.setCategory(category);
        product.setStatus(true);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        return modelAndView;
    }
}
