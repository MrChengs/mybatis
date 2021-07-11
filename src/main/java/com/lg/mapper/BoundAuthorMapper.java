package com.lg.mapper;

import com.lg.pojo.Author;
import com.lg.pojo.Post;
import com.lg.pojo.Section;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BoundAuthorMapper {

    List<Post> findPostsInArray(Integer[] ids);

    List<Post> findPostsInList(List<Integer> ids);


    int insertAuthor(Author author);

    int insertAuthorInvalidSelectKey(Author author);

    int insertAuthorInvalidInsert(Author author);

    int insertAuthorDynamic(Author author);

    Author selectAuthor(int id);

    Author selectAuthorMapToPropertiesUsingRepeatable(int id);


    @ConstructorArgs({
            @Arg(column = "AUTHOR_ID", javaType = Integer.class),
            @Arg(column = "AUTHOR_USERNAME", javaType = String.class),
            @Arg(column = "AUTHOR_PASSWORD", javaType = String.class),
            @Arg(column = "AUTHOR_EMAIL", javaType = String.class),
            @Arg(column = "AUTHOR_BIO", javaType = String.class),
            @Arg(column = "AUTHOR_SECTION", javaType = Section.class)
    })
    @Select({
            "SELECT ",
            "  ID as AUTHOR_ID,",
            "  USERNAME as AUTHOR_USERNAME,",
            "  PASSWORD as AUTHOR_PASSWORD,",
            "  EMAIL as AUTHOR_EMAIL,",
            "  BIO as AUTHOR_BIO," +
                    "  FAVOURITE_SECTION as AUTHOR_SECTION",
            "FROM AUTHOR WHERE ID = #{id}"})
    Author selectAuthorConstructor(int id);

    @Arg(column = "AUTHOR_ID", javaType = Integer.class, id = true)
    @Arg(column = "AUTHOR_USERNAME", javaType = String.class)
    @Arg(column = "AUTHOR_PASSWORD", javaType = String.class)
    @Arg(column = "AUTHOR_EMAIL", javaType = String.class)
    @Arg(column = "AUTHOR_BIO", javaType = String.class)
    @Arg(column = "AUTHOR_SECTION", javaType = Section.class)
    @Select({
            "SELECT ",
            "  ID as AUTHOR_ID,",
            "  USERNAME as AUTHOR_USERNAME,",
            "  PASSWORD as AUTHOR_PASSWORD,",
            "  EMAIL as AUTHOR_EMAIL,",
            "  BIO as AUTHOR_BIO," +
                    "  FAVOURITE_SECTION as AUTHOR_SECTION",
            "FROM AUTHOR WHERE ID = #{id}"})
    Author selectAuthorMapToConstructorUsingRepeatable(int id);


    @Arg(column = "AUTHOR_ID", javaType = int.class)
    @Result(property = "username", column = "AUTHOR_USERNAME")
    @Select({
            "SELECT ",
            "  ID as AUTHOR_ID,",
            "  USERNAME as AUTHOR_USERNAME,",
            "  PASSWORD as AUTHOR_PASSWORD,",
            "  EMAIL as AUTHOR_EMAIL,",
            "  BIO as AUTHOR_BIO",
            "FROM AUTHOR WHERE ID = #{id}"})
    Author selectAuthorUsingSingleRepeatable(int id);


    @ConstructorArgs({
            @Arg(column = "AUTHOR_ID", javaType = Integer.class),
            @Arg(column = "AUTHOR_USERNAME", javaType = String.class),
            @Arg(column = "AUTHOR_PASSWORD", javaType = String.class),
            @Arg(column = "AUTHOR_EMAIL", javaType = String.class),
            @Arg(column = "AUTHOR_BIO", javaType = String.class)
    })
    @Arg(column = "AUTHOR_SECTION", javaType = Section.class)
    @Select({
            "SELECT ",
            "  ID as AUTHOR_ID,",
            "  USERNAME as AUTHOR_USERNAME,",
            "  PASSWORD as AUTHOR_PASSWORD,",
            "  EMAIL as AUTHOR_EMAIL,",
            "  BIO as AUTHOR_BIO," +
                    "  FAVOURITE_SECTION as AUTHOR_SECTION",
            "FROM AUTHOR WHERE ID = #{id}"})
    Author selectAuthorUsingBothArgAndConstructorArgs(int id);


    @Results(
            @Result(property = "id", column = "AUTHOR_ID")
    )
    @Result(property = "username", column = "AUTHOR_USERNAME")
    @Select({
            "SELECT ",
            "  ID as AUTHOR_ID,",
            "  USERNAME as AUTHOR_USERNAME",
            "FROM AUTHOR WHERE ID = #{id}"})
    Author selectAuthorUsingBothResultAndResults(int id);

    List<Post> findThreeSpecificPosts(@Param("one") int one, RowBounds rowBounds, @Param("two") int two, int three);

    @Flush
    List<BatchResult> flush();
}
