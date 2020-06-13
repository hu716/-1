package org.crazyit.booksys.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@Entity
@Table(name="item_tb")
public class Item
{
	// 标识属性
	@Id @Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 该入库项对应图书的数量g
	private int amount;
	@ManyToOne(targetEntity=Inventory.class)
	// 定义名为invent_id外键列，该外键列引用inventory_tb表的invent_id列。
	@JoinColumn(name="invent_id" , referencedColumnName="invent_id"
		, nullable=false)
	// 该入库项所属的入库单
	private Inventory inventory;
	@ManyToOne(targetEntity=Book.class)
	// 定义名为book_id外键列，该外键列引用book_tb表的book_id列。
	@JoinColumn(name="book_id" , referencedColumnName="book_id"
		, nullable=false)
	// 该入库项对应的图书
	private Book book;
	// 标志属性的getter、setter方法
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	// amount成员变量的getter、setter方法
	public int getAmount()
	{
		return amount;
	}
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	// inventory成员变量的getter、setter方法
	public Inventory getInventory()
	{
		return inventory;
	}
	public void setInventory(Inventory inventory)
	{
		this.inventory = inventory;
	}
	// book成员变量的getter、setter方法
	public Book getBook()
	{
		return book;
	}
	public void setBook(Book book)
	{
		this.book = book;
	}
}
