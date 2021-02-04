package com.example.demo.service.impl;

import com.example.demo.dao.ListSongMapper;
import com.example.demo.domain.ListSong;
import com.example.demo.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSongServiceImpl implements ListSongService {

    @Autowired
    private ListSongMapper listSongMapper;

    //allListSong()返回所有对应歌单的歌曲信息
    @Override
    public List<ListSong> allListSong()
    {
        return listSongMapper.allListSong();
    }

    //updateListSongMsg()更新歌单中歌曲信息，也可以是添加某一首歌进入某一歌单
    @Override
    public boolean updateListSongMsg(ListSong listSong) {
        return listSongMapper.updateListSongMsg(listSong) >0 ?true:false;
    }
    //deleteListSong()从某一歌单中删除某一首歌
    @Override
    public boolean deleteListSong(Integer songId) {
        return listSongMapper.deleteListSong(songId) >0 ?true:false;
    }

    //addListSong()增加歌曲与歌单
    @Override
    public boolean addListSong(ListSong listSong)
    {
        return listSongMapper.insertSelective(listSong) > 0?true:false;
    }

    //listSongOfSongId()返回某一首歌对应的歌曲信息
    @Override
    public List<ListSong> listSongOfSongId(Integer songListId)
    {
        return listSongMapper.listSongOfSongId(songListId);
    }

}
