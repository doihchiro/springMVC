package com.yeezy.controller;

import com.yeezy.entity.Board;
import com.yeezy.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Board> list = boardService.getList();
        model.addAttribute("list", list);
        return "board/list";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(Board board) {
        boardService.register(board);
        return "redirect:/board/list";
    }

    @GetMapping("/get")
    public @ResponseBody Board get(Long idx) {
        Board board = boardService.get(idx);
        return board;
    }

    @GetMapping("/remove")
    public String remove(Long idx) {
        boardService.delete(idx);
        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String modify(Board board) {
        boardService.update(board);
        return "redirect:/board/list";
    }
}
