package com.yeezy.service;

import com.yeezy.entity.Board;
import com.yeezy.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<Board> getList() {
        return boardRepository.findAll();
    }

    @Override
    public void register(Board board) {
        boardRepository.save(board);
    }
}
