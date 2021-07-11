package com.lg.test.sql;

import com.lg.mapper.AuthorMapper;
import com.lg.mapper.BlogMapper;
import com.lg.pojo.Blog;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BlogMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void createSqlSession() throws IOException {
        sqlSessionFactory = BaseMapperTest.createSqlSessionFactory();
    }

    @Test
    public void selectAllPosts(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(BlogMapper.class, sqlSession);
            List<Map> maps = mapper.selectAllPosts();
            assert maps != null;
        }finally {
            sqlSession.commit();
        }
    }

    @Test
    public void selectAllPostsRowBounds(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(BlogMapper.class, sqlSession);
            RowBounds rowBounds = new RowBounds(1,2);
            List<Map> maps = mapper.selectAllPosts(rowBounds);
            assert maps != null;
        }finally {
            sqlSession.commit();
        }
    }

    @Test
    public void selectAllPostsRowBoundsParam(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(BlogMapper.class, sqlSession);
            RowBounds rowBounds = new RowBounds(1,2);
            List<Map> maps = mapper.selectAllPosts(rowBounds,null);
            assert maps != null;
        }finally {
            sqlSession.commit();
        }
    }

    @Test
    public void selectWithBothOneAndMany(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = sqlSession.getConfiguration().getMapperRegistry().getMapper(BlogMapper.class, sqlSession);
            List<Blog> blogs = mapper.selectWithBothOneAndMany();
            assert blogs != null;
        }finally {
            sqlSession.commit();
        }
    }
}
