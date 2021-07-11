package com.lg.pojo;

public class PostLite {
    private PostLiteId theId;
    private  int blogId;

    public PostLiteId getTheId() {
        return theId;
    }

    public void setTheId(PostLiteId theId) {
        this.theId = theId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public PostLite(PostLiteId theId, int blogId) {
        this.theId = theId;
        this.blogId = blogId;
    }
}
