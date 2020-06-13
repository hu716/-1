package org.crazyit.booksys.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="category_tb")
public class Category
{
	// 标识属性
	@Id @Column(name="cate_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 种类名
	private String name;
	// 种类描述
	@Column(name="cate_desc")
	private String desc;
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
	// desc成员变量的getter、setter方法
	public String getDesc()
	{
		return desc;
	}
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
}
