package com.api.book.bootrestbook.Services;

import com.api.book.bootrestbook.Entities.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

public Book addBook(Book book) {
    list.add(book);
    return book;
}

public void deleteBook(int id){

//    for(Book book : list){
//        if(book.getId()==id){
//            b= book;
//            list.remove(b);
//            System.out.println("data deleted");
//        }
//    }
    // we used stream api for filtering first one by one it will check book id and if the book id is not found it will simply add it to list and if found it will remove it
    list = list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
}

public void updateBook(Book book,int id){

//    for(Book b : list){
//        if(b.getId() == id){
//            book=b;
//        }
//    }
    list = list.stream().map(b->{
        if(b.getId()==id){
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
        }
        return b;
    }).toList();

 }
}
