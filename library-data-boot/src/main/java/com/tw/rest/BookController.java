package com.tw.rest;

import com.tw.entity.Book;
import com.tw.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value="/book")
public class BookController {

    @Autowired
    private BookService bookService;


//    public Book save(@RequestBody Book book){
//        return bookService.save(book);
//    }

   //this should be practice to get correct output ti client
   @PostMapping(value="/add",consumes="application/json",produces="application/json")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book savedBook = bookService.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    //http://localhost:8080/book/id?ISBN

//    public Book findById(@RequestParam("ISBN") int id){
//        return bookService.findByIsbn(id);
//    }
     @GetMapping(value="/id", produces="application/json")
    public ResponseEntity<Book> findById(@RequestParam("ISBN") int id){
        Book book= bookService.findByIsbn(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping(value="/all",produces="application/json")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping(value="/author/{author}",produces = "application/json")
    public ResponseEntity<List<Book>> findByAuthor(@PathVariable("author") String author) {

        List<Book> books = bookService.findByAuthor(author);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
    }

    @GetMapping(value="/title",produces="application/json")
    public Book findByTitle(@RequestParam("title") String title){
        return bookService.findByTitle(title);
    }

    @GetMapping(value="/genre/{genre}",produces="application/json")
    public List<Book> findByGenre(@PathVariable("genre") String genre){
        return bookService.findByGenre(genre);
    }

    @GetMapping(value = "/price", produces = "application/json")
    public List<Book> findByPriceRange(@RequestParam double min, @RequestParam double max) {
        return bookService.findByPriceRange(min, max);
    }

    @DeleteMapping("/{isbn}")
    public String deleteByIsbn(@PathVariable int isbn) {
        if(bookService.deleteByIsbn(isbn))
            return "Book deleted";
        else
            return "Book not found";
    }
}
