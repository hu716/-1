package org.crazyit.booksys.controller;

import java.util.HashMap;
import java.util.Map;

import org.crazyit.booksys.exception.BookException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController
{
	@ExceptionHandler(BookException.class)
	@ResponseBody
	public Object exp(Exception ex)
	{
		// 将捕捉到的BookException转换成Map传给前端jQuery
		Map<String, String> map = new HashMap<String, String>();
		map.put("exception", ex.getMessage());
		return map;
	}
}