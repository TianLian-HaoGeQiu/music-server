package com.example.demo.service.impl;

import com.example.demo.dao.CommentMapper;
import com.example.demo.domain.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentMapper commentMapper;
    //addComment()增加用户对歌曲的评论
    @Override
    public boolean addComment(Comment comment) {
        return commentMapper.insertSelective(comment) > 0 ? true:false;
    }

    //addComment()更新用户对歌曲的评论，比如点赞
    @Override
    public boolean updateCommentMsg(Comment comment) {
        return commentMapper.updateCommentMsg(comment) >0 ?true:false;
    }

//    删除评论
    @Override
    public boolean deleteComment(Integer id) {
        return commentMapper.deleteComment(id) >0 ?true:false;
    }

    //allComment()返回所有用户的评论信息
    @Override
    public List<Comment> allComment()
    {
        return commentMapper.allComment();
    }

    //commentOfSongId()返回某一首歌的评论信息
    @Override
    public List<Comment> commentOfSongId(Integer songId)

    {
        return commentMapper.commentOfSongId(songId);
    }

    //commentOfSongListId()返回某一个歌单的评论信息
    @Override
    public List<Comment> commentOfSongListId(Integer songListId)

    {
        return commentMapper.commentOfSongListId(songListId);
    }
}
