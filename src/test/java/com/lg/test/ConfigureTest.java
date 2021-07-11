package com.lg.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import java.io.IOException;
import java.io.InputStream;


public class ConfigureTest {

    @Before
    public void before() throws IOException {
        System.out.println("Before");
    }

    @Test
    public void testCreateSqlSession(){
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();

            sqlSession.commit();
        }catch (IOException e){
            sqlSession.rollback();
        }finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
        System.out.println("Test");
    }

    @After
    public void after(){
        System.out.println("After");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass");
    }
}
