package com.example.demo.Controller;



//import ch.qos.logback.core.model.Model;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.services.BookService;
import com.example.demo.services.CategoryService;
import jakarta.Validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
//@RequestMapping("/books")
@Controller
public class BookController {
    @Autowired
        private BookService bookService;
    @Autowired
    private CategoryService categoryService;
//        @Autowired
//        private   BookService bookService;//
    @GetMapping("/books")
    public String showAllBooks(Model model){
        List<Book> books= bookService.getALLBooks();
          model.addAttribute("books",books);
          return "book/list";
        }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories",categoryService.getAllCaterories());
        return "book/add";
    }


    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book, BindingResult bindingResult, Model model){
        bookService.addBook(book);
        if(bindingResult.hasErrors()){
            model.addAttribute("categories",categoryService.getAllCaterories());
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }


    @GetMapping("/delete/{id}")
    public  String deleteBook(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            // Nếu tìm thấy Book với Id tương ứng, xoá Book này
            bookService.deleteBook(id);
            return  "redirect:/";
        } else {
            // Nếu không tìm thấy Book nào với Id tương ứng, trả về HTTP Status 404 Not Found
            return "redirect:/";
        }


    }



    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        List<Category> categories = categoryService.getAllCaterories();

        model.addAttribute("book", book);
        model.addAttribute("categories", categories);

        return "book/edit";
    }

//    @PostMapping("/edit")
//    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
//        bookService.updateBook(id,book);
//
//        return "redirect:/books";
//    }



}
