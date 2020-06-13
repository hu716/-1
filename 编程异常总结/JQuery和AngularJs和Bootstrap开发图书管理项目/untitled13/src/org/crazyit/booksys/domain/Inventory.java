package org.crazyit.booksys.domain;

import java.util.Date;

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
@Table(name="inventory_tb")
public class Inventory
{
	// 标识属性
	@Id @Column(name="invent_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 入库单编号
	@Column(name="invent_no")
	private String no;
	// 入库时间
	@Column(name="insert_time")
	private Date insertTime;
	// 入库操作员
	private String operator;
	// 标识属性的getter、setter方法
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	// no成员变量的getter、setter方法
	public String getNo()
	{
		return no;
	}
	public void setNo(String no)
	{
		this.no = no;
	}
	// insertTime成员变量的getter、setter方法
	public Date getInsertTime()
	{
		return insertTime;
	}
	public void setInsertTime(Date insertTime)
	{
		this.insertTime = insertTime;
	}
	// operator成员变量的getter、setter方法
	public String getOperator()
	{
		return operator;
	}
	public void setOperator(String operator)
	{
		this.operator = operator;
	}
}
