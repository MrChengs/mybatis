package com.lg.mapper;

import org.apache.ibatis.jdbc.SQL;

public class BoundBlogSql {
    public String selectBlogsSql() {
        return new SQL() {
            {
                SELECT("*");
                FROM("BLOG");
            }
        }.toString();
    }
}
