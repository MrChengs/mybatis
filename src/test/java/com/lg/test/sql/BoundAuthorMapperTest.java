package com.lg.test.sql;

import com.lg.mapper.BoundAuthorMapper;
import com.lg.pojo.Author;
import com.lg.pojo.Post;
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
}
