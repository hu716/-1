package org.crazyit.booksys.service;

import java.util.List;

import org.crazyit.booksys.domain.Book;
import org.crazyit.booksys.domain.Category;
import org.crazyit.booksys.domain.Inventory;
import org.crazyit.booksys.domain.Sale;

public interface BookService
{
	/**
	 * 定义添加图书种类的业务方法
	 * @param category 代表要添加的图书种类
	 * @return 新增的种类的ID
	 */
	Integer addCategory(Category category);

	/**
	 * 定义添加图书的业务方法
	 * @param book 代表要添加的图书
	 * @param categoryId 该图书所属的种类ID
	 * @return 新增的图书的ID
	 */
	Integer addBook(Book book, Integer categoryId);

	/**
	 * 获取所有图书种类的方法
	 * @return 所有图书种类
	 */
	List<Category> getAllCategories();

	/**
	 * 获取所有图书的方法
	 * @return 所有图书
	 */
	List<Book> getAllBooks();

	/**
	 * 定义添加图书入库的业务方法
	 * @param inventory 代表要添加的入库单
	 * @param amounts 代表各入库项对应的数量
	 * @param bookIds 代表各入库项对应的图书
	 * @return 新增的入库单的ID
	 */
	Integer addInventory(Inventory inventory, int[] amounts,
		Integer[] bookIds);

	/**
	 * 定义添加图书销售的业务方法
	 * @param sale 代表要添加的销售记录
	 * @param bookId 代表要销售的图书ID
	 * @return 新增的销售记录的ID
	 */	
	Integer saleBook(Sale sale, Integer bookId);

	/**
	 * 获取所有的入库单
	 * @return 所有入库单
	 */
	List<Inventory> getAllInventories();

	/**
	 * 获取所有的销售记录
	 * @return 所有销售记录
	 */
	List<Sale> getAllSales();

	/**
	 * 获取指定入库单对应的所有入库项
	 * @param inventoryId 入库单的ID
	 * @return 指定入库单对应的所有入库项
	 */
	Object getItemsByInventoryId(Integer inventoryId);

	/**
	 * 更新图书种类
	 * @param category 要更新的图书种类
	 */
	void updateCategory(Category category);

	/**
	 * 更新图书
	 * @param book 要更新的图书
	 * @param categoryId 更新该图书后所属的种类ID
	 */
	void updateBook(Book book, Integer categoryId);
}
