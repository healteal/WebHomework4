package com.example.jsp_jdbc_homework.controllers;

import com.example.jsp_jdbc_homework.models.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    public List<UserModel> users = new ArrayList<>();

    {
        users.add(new UserModel("username1", "Ivan", "Ivanov", 25));
        users.add(new UserModel("username2", "Nikolay", "Nikolaev", 35));
        users.add(new UserModel("username3", "Petr", "Petrov", 45));
    }

    @GetMapping("/")
    public String mainPage() {
        return "main-page";
    }

    @GetMapping("/search-page")
    public String searchPage(Model model,
                             @RequestParam(name = "user_login", required = false) Optional<String> isPresent,
                             @RequestParam(name = "user_login", required = false) String userLogin) {
        if (isPresent.isPresent()) {
            if (users.stream().anyMatch(user -> user.getUsername().equals(userLogin))) {
                model.addAttribute("userObject", users
                        .stream()
                        .filter(user -> user.getUsername().equals(userLogin))
                        .findFirst()
                        .orElseThrow());
            } else {
                model.addAttribute("answer", "Пользователь не найден");
            }
        }
        return "search-page";
    }

    @GetMapping("/delete-page")
    public String deletePage() {
        return "delete-page";
    }

    @PostMapping("/delete-page")
    public String deletePage(Model model,
                             @RequestParam(name = "user_login", required = false) String userLogin) {
        if (userLogin != null) {
            if (users.removeIf(user -> user.getUsername().equals(userLogin))) {
                model.addAttribute("response", "Успешно удалён");
            } else {
                model.addAttribute("response", "Пользователь не найден");
            }
        }
        return "delete-page";
    }
}
