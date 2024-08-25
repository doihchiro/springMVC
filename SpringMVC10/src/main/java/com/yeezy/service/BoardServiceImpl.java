package com.yeezy.service;

import com.yeezy.entity.Board;
import com.yeezy.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Board get(Long idx) {
        Optional<Board> board = boardRepository.findById(idx);
        return board.get();
    }

    @Override
    public void delete(Long idx) {
        boardRepository.deleteById(idx);
    }
}
