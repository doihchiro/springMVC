package com.yeezy.service;

import com.yeezy.entity.Board;

import java.util.List;

public interface BoardService {

    List<Board> getList();
    void register(Board board);
}
