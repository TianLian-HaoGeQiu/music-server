package com.example.demo.service.impl;

import com.example.demo.dao.SongMapper;
import com.example.demo.domain.Song;
import com.example.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapper songMapper;
    //    返回所有歌曲
    @Override
    public List<Song> allSong()
    {
        return songMapper.allSong();
    }

    //    添加歌曲
    @Override
    public boolean addSong(Song song)
    {

        return songMapper.insertSelective(song) > 0?true:false;
    }

    //    更新歌曲信息
    @Override
    public boolean updateSongMsg(Song song) {
        return songMapper.updateSongMsg(song) >0 ?true:false;
    }

    //    更新歌曲URL
    @Override
    public boolean updateSongUrl(Song song) {

        return songMapper.updateSongUrl(song) >0 ?true:false;
    }

    //    更新歌曲图片
    @Override
    public boolean updateSongPic(Song song) {

        return songMapper.updateSongPic(song) >0 ?true:false;
    }

    //    删除歌曲
    @Override
    public boolean deleteSong(Integer id) {
        return songMapper.deleteSong(id) >0 ?true:false;
    }

    //    返回指定歌手ID的歌曲
    @Override
    public List<Song> songOfSingerId(Integer singerId)

    {
        return songMapper.songOfSingerId(singerId);
    }

    //    返回指定歌曲ID的歌曲
    @Override
    public List<Song> songOfId(Integer id)

    {
        return songMapper.songOfId(id);
    }

    //    返回指定歌手名的歌曲
    @Override
    public List<Song> songOfSingerName(String name)

    {
        return songMapper.songOfSingerName(name);
    }

    //    返回指定歌曲名的歌曲
    @Override
    public List<Song> songOfName(String name)

    {
        return songMapper.songOfName(name);
    }
}
