package com.lg.test.sql;

import com.lg.mapper.AuthorMapper;
import com.lg.pojo.Author;
import com.lg.pojo.Section;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.*;

public class AuthorMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void createSqlSession() throws IOException {
        sqlSessionFactory = BaseMapperTest.createSqlSessionFactory();

//        String resource = "applicationContext.xml";
//        applicationContext = new ClassPathXmlApplicationContext(resource);
    }

    @Test
    public void testSelectAllAuthors(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            AuthorMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(AuthorMapper.class, sqlSession);
            List<Author> authors = mapper.selectAllAuthors();
            assert authors != null;
            assert authors.size() != 0;
        }finally {
            sqlSession.commit();
        }
    }

    @Test
    public void selectAllAuthorsSet(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            AuthorMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(AuthorMapper.class, sqlSession);
            Set<Author> authors = mapper.selectAllAuthorsSet();
            assert authors != null;
            assert authors.size() != 0;
        }finally {
            sqlSession.commit();
        }
    }

    @Test
    public void selectAllAuthorsVector(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            AuthorMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(AuthorMapper.class, sqlSession);
            Vector<Author> authors = mapper.selectAllAuthorsVector();
            assert authors != null;
            assert authors.size() != 0;
        }finally {
            sqlSession.commit();
        }
    }

    @Test
    public void selectAllAuthorsLinkedList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            AuthorMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(AuthorMapper.class, sqlSession);
            LinkedList<Author> authors = mapper.selectAllAuthorsLinkedList();
            assert authors != null;
            assert authors.size() != 0;
        }finally {
            sqlSession.commit();
        }
    }

    @Test
    public void selectAllAuthorsArray(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            AuthorMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(AuthorMapper.class, sqlSession);
            Author[] authors = mapper.selectAllAuthorsArray();
            assert authors != null;
            assert authors.length != 0;
        }finally {
            sqlSession.commit();
        }
    }

    @Test
    public void selectAuthorById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            AuthorMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(AuthorMapper.class, sqlSession);
            Author author = mapper.selectAuthor(101);
            assert author != null;
        }finally {
            sqlSession.commit();
        }
    }

    @Test
    public void selectAuthorLinkedHashMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            AuthorMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(AuthorMapper.class, sqlSession);
            LinkedHashMap<String, Object> stringObjectLinkedHashMap = mapper.selectAuthorLinkedHashMap(101);
            assert stringObjectLinkedHashMap != null;
        }finally {
            sqlSession.commit();
        }
    }

    @Test
    public void insertAuthor(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            AuthorMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(AuthorMapper.class, sqlSession);
            mapper.insertAuthor(new Author(103,"mrchengs","lgsim05!","m18710799187_1@163.com","sdkfl", Section.NEWS));
        }finally {
            sqlSession.commit();
            sqlSession.rollback();
        }
    }

    @Test
    public void updateAuthor(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            AuthorMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(AuthorMapper.class, sqlSession);
            Author author = new Author(103, null,null,null, "qwertyuiop", null);
            mapper.updateAuthor(author);
        }finally {
            sqlSession.commit();
        }
    }

    @Test
    public void deleteAuthor(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            AuthorMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(AuthorMapper.class, sqlSession);
            mapper.deleteAuthor(103);
        }finally {
            sqlSession.commit();
        }
    }

    @Test
    public void selectAllAuthors(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            AuthorMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(AuthorMapper.class, sqlSession);
            mapper.selectAllAuthors(new DefaultResultHandler());

        }finally {
            sqlSession.commit();
        }
    }
}
