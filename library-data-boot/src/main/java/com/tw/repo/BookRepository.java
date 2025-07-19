package com.tw.repo;

import com.tw.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByAuthor(String author);
   Optional <Book> findByTitle(String title);
    List<Book> findByGenre(String genre);

//    @Query("FROM Book Where price BETWEEN : priceMin AND :priceMax")
//    List<Book> findByPriceRange(double priceMin, double priceMax);

    //jpa can relate with findpricebetween so it can relate but if not we can write our own query
    //or else write

    @Query("FROM Book Where price BETWEEN :min AND :max")
    List<Book> findByPriceRange(@Param("min")double priceMin,@Param("max") double priceMax);
}
