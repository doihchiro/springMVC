package com.yeezy.controller;

import com.yeezy.entity.Board;
import com.yeezy.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Board> list = boardService.getList();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(Board board) {
        boardService.register(board);
        return "redirect:/list";
    }
}
