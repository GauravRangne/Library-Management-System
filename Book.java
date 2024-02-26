package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	private int bookId;
	@Column(length = 20)
	private String bookName;
	private int bookPrice;
	@Column(length = 200)
	private String bookInfo;
	@Column(length = 9)
	private String releasedDate;
}
