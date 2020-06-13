package org.crazyit.booksys.exception;

public class BookException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	//提供一个无参数的构造器
	public BookException()
	{
	}
	//提供一个带字符串参数的构造器
	public BookException(String msg)
	{
		super(msg);
	}
}
