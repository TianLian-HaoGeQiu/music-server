package com.example.demo.service.impl;

import com.example.demo.dao.SongListMapper;
import com.example.demo.domain.SongList;
import com.example.demo.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongListServiceImpl implements SongListService {

    @Autowired
    private SongListMapper songListMapper;

    //    更新歌单信息
    @Override
    public boolean updateSongListMsg(SongList songList) {
        return songListMapper.updateSongListMsg(songList) >0 ?true:false;
    }

    //    删除歌单
    @Override
    public boolean deleteSongList(Integer id) {
        return songListMapper.deleteSongList(id) >0 ?true:false;
    }

    //    返回所有歌单
    @Override
    public List<SongList> allSongList()
    {
        return songListMapper.allSongList();
    }

    //    返回标题包含文字的歌单
    @Override
    public List<SongList> likeTitle(String title)
    {
        return songListMapper.likeTitle(title);
    }

    //    返回指定类型的歌单
    @Override
    public List<SongList> likeStyle(String style)
    {
        return songListMapper.likeStyle(style);
    }

    //    返回指定标题对应的歌单
    @Override
    public List<SongList> songListOfTitle(String title)
    {
        return songListMapper.songListOfTitle(title);
    }

    //    添加歌单
    @Override
    public boolean addSongList(SongList songList)
    {
        return songListMapper.insertSelective(songList) > 0?true:false;
    }

    //    更新歌单图片
    @Override
    public boolean updateSongListImg(SongList songList) {

        return songListMapper.updateSongListImg(songList) >0 ?true:false;
    }
}
