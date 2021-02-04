package com.example.demo.service.impl;

import com.example.demo.dao.RankMapper;
import com.example.demo.domain.Rank;
import com.example.demo.service.RankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankMapper rankMapper;

    //rankOfSongListId()获取指定歌单的评分，具体计算方式为所以对这个歌单评分的总分数/所以对这个歌单评分用户数量
    @Override
    public int rankOfSongListId(Long songListId) {
        log.info ("当前的评分: [{}]",rankMapper.selectScoreSum(songListId) / rankMapper.selectRankNum(songListId));
        return rankMapper.selectScoreSum(songListId) / rankMapper.selectRankNum(songListId);
        /*return 6;*/
    }
    //新增某一用户对某一歌单的评分
    @Override
    public boolean addRank(Rank rank) {

        return rankMapper.insertSelective(rank) > 0 ? true:false;
    }
}
