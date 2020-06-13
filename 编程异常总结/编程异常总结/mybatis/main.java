package org.fkit.test;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;
import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Order;

import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.OrderMapper;


import javax.jws.soap.SOAPBinding;
import java.util.List;

public class OnetoOneTest {
    public static void main(String[] args) {
        SqlSession sqlSession=null;
        try {
            sqlSession= FKSqlSessionFactory.getSqlSession();


            OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
            Order order=orderMapper.selectById(1);
            System.out.println(order.getId()+" "+order.getCode()+" "+order.getTotal());
            order.getUser().forEach(user -> System.out.println(user));
            order.getArticles().forEach(article -> System.out.println(article));


            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }


    }
