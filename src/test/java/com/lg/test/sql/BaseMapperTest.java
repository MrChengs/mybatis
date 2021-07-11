package com.lg.test.sql;

import com.lg.mapper.AuthorMapper;
import com.lg.mapper.BlogMapper;
import com.lg.mapper.BoundAuthorMapper;
import com.lg.mapper.BoundBlogMapper;
import com.lg.pojo.Author;
import com.lg.pojo.Blog;
import com.lg.pojo.Post;
import com.lg.pojo.Section;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.util.Properties;

public class BaseMapperTest {
    public static SqlSessionFactory createSqlSessionFactory() throws IOException {
        String resource = "jdbc.properties";
        String id = "Production";
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Properties props = Resources.getResourceAsProperties(resource);
        UnpooledDataSource dataSource = new UnpooledDataSource();
        dataSource.setDriver(props.getProperty("jdbc.driver"));
        dataSource.setUrl(props.getProperty("jdbc.url"));
        dataSource.setUsername(props.getProperty("jdbc.username"));
        dataSource.setPassword(props.getProperty("jdbc.password"));
        Environment environment = new Environment(id,transactionFactory,dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.setLazyLoadingEnabled(true);
        configuration.setUseActualParamName(false);
        configuration.getTypeAliasRegistry().registerAlias(Blog.class);
        configuration.getTypeAliasRegistry().registerAlias(Post.class);
        configuration.getTypeAliasRegistry().registerAlias(Author.class);

        configuration.addMapper(AuthorMapper.class);
        configuration.addMapper(BlogMapper.class);

        configuration.addMapper(BoundBlogMapper.class);
        configuration.addMapper(BoundAuthorMapper.class);

        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
