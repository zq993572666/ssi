package com.dou.book.data.services.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dou.book.data.mappers.SBookMapper;
import com.dou.book.data.pojo.SBook;
import com.dou.book.data.services.ISBookServices;

@Service("bookServices")
@SuppressWarnings("unchecked")
public class SBookServices implements ISBookServices {
	@Autowired
	SBookMapper bookMapper;

	public List findAllBook() throws RuntimeException {
		return bookMapper.findAllBook();
	}

	/*
	 * public SBook getBookByISBN(String isbn) throws RuntimeException { return
	 * sbookMapper.findBookByISBN(isbn); }
	 */
	/*
	 * public List<SBook> getBooksByPublisher(String publisher) throws
	 * RuntimeException { return sbookMapper.findBooksByPublisher(publisher); }
	 */
	public void removeBook(int id) throws RuntimeException {
		bookMapper.deleteBook(id);
	}

	public void saveBook(SBook book) throws RuntimeException {
		bookMapper.saveBook(book);
	}

	
	public SBook getBookById(int id) throws RuntimeException {
		// TODO Auto-generated method stub
		return bookMapper.findBookById(id);
	}

	
	public void updateBook(SBook book) throws RuntimeException {
		bookMapper.updateBook(book);

	}

	public void updateTrantion() throws RuntimeException {
		SBook book = getBookById(41);
		book.setAuthor("jjj");
		book.setIsbn("jjj");
		bookMapper.updateBook(book);

		removeBook(44);
		throw new RuntimeException();

	}
	// public void deleteBook(int book) throws RuntimeException {
	// TODO Auto-generated method stub
	// bookMapper.deleteBook(book);
	// }

	/*public List<Boo> getBookPage(){
		
	}*/
	public int getBookTotal() {
		// TODO Auto-generated method stub
		return bookMapper.getBookTotal();
	}


	public List findPageBook(Map map) {
		// TODO Auto-generated method stub
		return bookMapper.findPageBook(map);
	}

	/* (non-Javadoc)
	 * @see com.dou.book.data.services.ISBookServices#findPage(java.util.Map, org.apache.ibatis.session.RowBounds)
	 */
	@Override
	public List<SBook> findPage(Map map, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return bookMapper.findPage(map, rowBounds);
	}


}
