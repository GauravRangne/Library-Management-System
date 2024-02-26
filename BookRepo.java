package com.boot.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boot.entity.Book;

@Transactional
@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	@Modifying
	@Transactional
	@Query("update Book b set b.bookName=:bn, b.bookPrice=:bp , b.bookInfo=:bin, b.releasedDate=:rdt where b.bookId=:bid")
	void updateInfo(@Param("bid") int bid, @Param("bn") String bn, @Param("bp") int bp, @Param("bin") String bin, @Param("rdt") String rdt);

}
