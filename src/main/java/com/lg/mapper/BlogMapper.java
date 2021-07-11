package com.lg.mapper;

import com.lg.pojo.Blog;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    List<Map> selectAllPosts();

    List<Map> selectAllPosts(RowBounds rowBounds);

    List<Map> selectAllPosts(RowBounds rowBounds, Object param);

    Blog selectBlog(int id);

//    @Select("select * from blog")
//    @Results({
//            @Result(
//                    property = "author", column = "author_id"
//            )
//    })
    List<Blog> selectWithBothOneAndMany();

    //嵌套查询，返回Blog的详细信息
    Blog selectBlogJoinedWithPostsAndAuthor(int id);
}
