package org.crazyit.booksys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.crazyit.booksys.domain.Sale;
import org.crazyit.booksys.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
@Controller
public class SaleController extends BaseController
{
	// 依赖注入Service组件
	@Resource(name="bookService")
	private BookService bookService;
	
	// @ResponseBody会将集合数据转换为JSON格式返回客户端
	@ResponseBody
	@GetMapping(value="/getAllSales")
	public Object getAll()
	{
		return bookService.getAllSales();
	}
	
	// @ResponseBody会将集合数据转换为JSON格式返回客户端
	@ResponseBody
	@PostMapping(value="/saleBook")
	public Object add(@ModelAttribute Sale sale, Integer bookId)
	{
		Integer id = bookService.saleBook(sale, bookId);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("status", id);
		return map;
	}
}
