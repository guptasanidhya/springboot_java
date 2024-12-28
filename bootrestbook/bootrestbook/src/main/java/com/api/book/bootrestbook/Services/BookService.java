package com.api.book.bootrestbook.Services;

import com.api.book.bootrestbook.Entities.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Component
@Service
public class BookService {

    private static  List<Book>  list = new ArrayList<>();

static {
    list.add(new Book(2,"Python","Nitin"));
    list.add(new Book(3,"c","deepak"));
    list.add(new Book(4,"ruby","mayank"));
}

public List<Book> getAllBooks(){
    return list;
}

public Book getBookById(int id){
    for(Book book : list){
        if(book.getId()==id){
            return book;
        }
    }
    return null;

}
}
