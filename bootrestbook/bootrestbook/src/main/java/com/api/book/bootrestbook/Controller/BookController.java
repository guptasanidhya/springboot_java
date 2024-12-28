package com.api.book.bootrestbook.Controller;

import com.api.book.bootrestbook.Entities.Book;
import com.api.book.bootrestbook.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


//@RequestMapping(value = "/books",method = RequestMethod.GET)
@GetMapping("/books")
    @ResponseBody
    public ResponseEntity<List<Book>> getBooks(){
    List<Book> list =  bookService.getAllBooks() ;

    if(!list.isEmpty()){
        return ResponseEntity.of(Optional.of(list));
    }
    else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Book not found
        }
        return ResponseEntity.ok(book); // Book found, return the object
    }


@PostMapping("/books/add")
//request body book ke object ko json me parse kar dega
    public ResponseEntity<Book> addBook(@RequestBody Book book){

    Book b = null;
try {
    b = bookService.addBook(book);
    return ResponseEntity.status(HttpStatus.CREATED).body(b);
}catch(Exception e){
    System.out.println(e);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}

}

@DeleteMapping("/books/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
   try {
       bookService.deleteBook(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }catch(Exception e){
       System.out.println(e);
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

   }
}

    @PutMapping("/books/edit/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        Book existingBook = bookService.getBookById(id);
        if (existingBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Book with the given id not found
        }

        try {
            bookService.updateBook(book, id);
            return ResponseEntity.ok(book); // Return updated book
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
