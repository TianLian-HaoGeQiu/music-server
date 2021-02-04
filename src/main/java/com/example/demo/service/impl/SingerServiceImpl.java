package com.example.demo.service.impl;

import com.example.demo.dao.SingerMapper;
import com.example.demo.domain.Singer;
import com.example.demo.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService{

    @Autowired
    private SingerMapper singerMapper;

    //updateSingerMsg()修改歌手信息
    @Override
    public boolean updateSingerMsg(Singer singer) {
        return singerMapper.updateSingerMsg(singer) >0 ?true:false;
    }

    //updateSingerPic()更新歌手头像路径
    @Override
    public boolean updateSingerPic(Singer singer) {

        return singerMapper.updateSingerPic(singer) >0 ?true:false;
    }

    //删除某一个位歌手
    @Override
    public boolean deleteSinger(Integer id) {
        return singerMapper.deleteSinger(id) >0 ?true:false;
    }

    //返回所有歌手的信息
    @Override
    public List<Singer> allSinger()
    {
        return singerMapper.allSinger();
    }

    //增加一位歌手
    @Override
    public boolean addSinger(Singer singer)  {

        return singerMapper.insertSelective(singer) > 0 ? true : false;
    }

    //根据歌手名查找歌手
    @Override
    public List<Singer> singerOfName(String name)

    {
        return singerMapper.singerOfName(name);
    }

    //根据歌手性别查找歌手
    @Override
    public List<Singer> singerOfSex(Integer sex)

    {
        return singerMapper.singerOfSex(sex);
    }
}
