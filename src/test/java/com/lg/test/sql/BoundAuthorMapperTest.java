package com.lg.test.sql;

import com.lg.mapper.BoundAuthorMapper;
import com.lg.pojo.Author;
import com.lg.pojo.Post;
import com.lg.pojo.Section;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoundAuthorMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void createSqlSessionFactory() throws IOException {
        sqlSessionFactory = BaseMapperTest.createSqlSessionFactory();
    }
    @Test
    public void findPostsInArray(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BoundAuthorMapper mapper = sqlSessionFactory.getConfiguration().getMapperRegistry().getMapper(BoundAuthorMapper.class, sqlSession);
        List<Post> postsInArray = mapper.findPostsInArray(new Integer[]{2, 3, 4,5});
        assert postsInArray.size() > 0;
    }

    @Test
    public void findPostsInList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BoundAuthorMapper mapper = sqlSessionFactory.getConfiguration().getMapperRegistry().getMapper(BoundAuthorMapper.class, sqlSession);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        List<Post> postsInArray = mapper.findPostsInList(integers);
        assert postsInArray.size() > 0;
    }

    /**
     * 不添加对应的参数列表的构造方法，由constructor标签指定用哪个构造方法映射
     */
    @Test
    public void selectAuthorById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BoundAuthorMapper mapper = sqlSessionFactory.getConfiguration().getMapperRegistry().getMapper(BoundAuthorMapper.class, sqlSession);
        Author author = mapper.selectAuthor(102);
        assert author.getId() == 102;
    }

    /**
     * 实体类添加对应参数列表的构造方法
     */
    @Test
    public void selectAuthorMapToPropertiesUsingRepeatable(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BoundAuthorMapper mapper = sqlSessionFactory.getConfiguration().getMapperRegistry().getMapper(BoundAuthorMapper.class, sqlSession);
        Author author = mapper.selectAuthorMapToPropertiesUsingRepeatable(102);
        assert author.getId() == 102;
    }

    /**
     * 插入后返回获取主键id的值
     */
    @Test
    public void insertAuthor(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BoundAuthorMapper mapper = sqlSession.getMapper(BoundAuthorMapper.class);
        Author author = new Author(-1, "cbegin", "******", "cbegin@nowhere.com", "N/A", Section.NEWS);
        int row = mapper.insertAuthor(author);
        assert author.getId() != -1;
        sqlSession.rollback();
    }

    @Test
    public void insertAuthorInvalidSelectKey(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BoundAuthorMapper mapper = sqlSession.getMapper(BoundAuthorMapper.class);
            Author author = new Author(-1, "cbegin", "******", "cbegin@nowhere.com", "N/A", Section.NEWS);
            int row = mapper.insertAuthorInvalidSelectKey(author);
            assert author.getId() != -1;
        }
        finally {
            sqlSession.rollback();
        }
    }

    @Test
    public void findThreeSpecificPosts(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BoundAuthorMapper mapper = sqlSession.getMapper(BoundAuthorMapper.class);
            RowBounds rowBounds = new RowBounds(1,1);
            List<Post> threeSpecificPosts = mapper.findThreeSpecificPosts(0, rowBounds, 1, 2);
            assert threeSpecificPosts.size() > 0;
        }finally {

        }
    }

    @Test
    public void selectAuthorConstructor(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BoundAuthorMapper mapper = sqlSession.getMapper(BoundAuthorMapper.class);
            Author author = mapper.selectAuthorConstructor(102);
            assert author.getId() == 102;
        }finally {

        }
    }
}
