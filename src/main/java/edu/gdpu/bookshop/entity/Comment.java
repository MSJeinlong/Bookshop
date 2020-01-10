package edu.gdpu.bookshop.entity;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private String commentDesc;

    private Integer commentLevel;

    private Integer commentGrade;

    private Integer userId;

    private Integer bookId;

    private Date createTime;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc == null ? null : commentDesc.trim();
    }

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public Integer getCommentGrade() {
        return commentGrade;
    }

    public void setCommentGrade(Integer commentGrade) {
        this.commentGrade = commentGrade;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentDesc='" + commentDesc + '\'' +
                ", commentLevel=" + commentLevel +
                ", commentGrade=" + commentGrade +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", createTime=" + createTime +
                '}';
    }
}