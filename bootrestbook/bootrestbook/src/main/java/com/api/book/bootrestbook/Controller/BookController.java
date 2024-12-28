package com.api.book.bootrestbook.Controller;

import com.api.book.bootrestbook.Entities.Book;
import com.api.book.bootrestbook.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
//@RequestMapping(value = "/books",method = RequestMethod.GET)
@GetMapping("/books")
    @ResponseBody
    public List<Book> getBooks(){

    return bookService.getAllBooks() ;
}

@GetMapping("/books/{id}")
public Book getBook(@PathVariable("id") int id){
    return bookService.getBookById(id);
}

@PostMapping("/books/add")
//request body book ke object ko json me parse kar dega
    public Book addBook(@RequestBody Book book){
    return bookService.addBook(book);
}

@DeleteMapping("/books/delete/{id}")
    public void deleteBook(@PathVariable("id") int id){
   bookService.deleteBook(id);
}

@PutMapping("/books/edit/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int id)
    {
      bookService.updateBook(book,id);
    return book;
    }
}
