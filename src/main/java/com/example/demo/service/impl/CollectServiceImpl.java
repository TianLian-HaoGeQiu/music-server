package com.example.demo.service.impl;

import com.example.demo.dao.CollectMapper;
import com.example.demo.domain.Collect;
import com.example.demo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    //addCollection()新增用户收藏歌曲
    @Override
    public boolean addCollection(Collect collect) {
        return collectMapper.insertSelective(collect) > 0 ? true:false;
    }
    //existSongId()查询用户收藏歌曲的数量
    @Override
    public boolean existSongId(Integer userId, Integer songId) {
        return collectMapper.existSongId(userId, songId)>0 ? true:false;
    }
    //updateCollectMsg()更新用户已经收藏的歌曲
    @Override
    public boolean updateCollectMsg(Collect collect) {
        return collectMapper.updateCollectMsg(collect) >0 ?true:false;
    }

    //deleteCollect()删除用户已经收藏的歌曲
    @Override
    public boolean deleteCollect(Integer userId, Integer songId) {
        return collectMapper.deleteCollect(userId, songId) >0 ?true:false;
    }
    //allCollect()返回所有用户已经收藏的歌曲
    @Override
    public List<Collect> allCollect()

    {
        return collectMapper.allCollect();
    }

    //collectionOfUser()返回某一位用户已经收藏的歌曲
    @Override
    public List<Collect> collectionOfUser(Integer userId)

    {
        return collectMapper.collectionOfUser(userId);
    }
}
