package com.bessada.mapper.custom;


import com.bessada.data.vo.v1.BookVO;
import com.bessada.model.Book;

public class BookMapper {
	
	public BookVO convertEntityToVo(Book book) {
		BookVO vo = new BookVO();
		
		vo.setKey(book.getId());
		vo.setAuthor(book.getAuthor());
		vo.setTitle(book.getTitle());
		vo.setLaunchDate(book.getLaunchDate());
		vo.setPrice(book.getPrice());
		
		return vo;
	}
	
	public Book convertVoToEntity(BookVO book) {
		Book entity = new Book();
		
		entity.setId(book.getKey());
		entity.setAuthor(book.getAuthor());
		entity.setTitle(book.getTitle());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		
		return entity;
	}
	
}

