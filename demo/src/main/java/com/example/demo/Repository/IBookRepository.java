package com.tuan3jpa.tuan3jpa.Repository;

import com.tuan3jpa.tuan3jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {

}
