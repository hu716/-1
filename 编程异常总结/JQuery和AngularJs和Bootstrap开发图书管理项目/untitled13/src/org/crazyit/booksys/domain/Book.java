package org.crazyit.booksys.domain;

import javax.persistence.*;
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
@Table(name="book_tb")
public class Book
{
	// 标识属性
	@Id @Column(name="book_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 该图书的名称
	private String name;
	// 图书的价格
	private double price;
	// 图书的作者
	private String author;
	// 图书的当前库存数
	private int amount;
	// 图书的出版社
	private String pubHouse;
	@ManyToOne(targetEntity=Category.class)
	// 定义名为cate_id外键列，该外键列引用category_tb表的cate_id列。
	@JoinColumn(name="cate_id" , referencedColumnName="cate_id"
		, nullable=false)
	// 图书所属的种类
	private Category category;
	// 标识属性的getter、setter方法
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	// name成员变量的getter、setter方法
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	// price成员变量的getter、setter方法
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	// author成员变量的getter、setter方法
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	// amount成员变量的getter或setter方法
	public int getAmount()
	{
		return amount;
	}
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	// pubHouse成员变量的getter、setter方法
	public String getPubHouse()
	{
		return pubHouse;
	}
	public void setPubHouse(String pubHouse)
	{
		this.pubHouse = pubHouse;
	}
	// category成员变量的getter、setter方法
	public Category getCategory()
	{
		return category;
	}
	public void setCategory(Category category)
	{
		this.category = category;
	}
}
