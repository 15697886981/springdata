package com.google;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class test01 {
    @Test
    public void test() {
        /*
         * 创建实体管理类工厂 ,借助persistence的静态方法获取
         *           参数为持久化单元名称 需要在jpa配置文件中指定
         * */
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");

        //创建实体管理类
        EntityManager em = factory.createEntityManager();

        //获取事务对象
        EntityTransaction tx = em.getTransaction();

        //开启事务
        tx.begin();

        Customer customer = new Customer();
        customer.setCustAddress("鸡山幼儿园");

        //保存操作
        em.persist(customer);

        //提交事务 释放资源
        tx.commit();
        em.close();
        factory.close();
    }

}
