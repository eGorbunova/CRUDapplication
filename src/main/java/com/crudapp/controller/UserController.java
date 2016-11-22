package com.crudapp.controller;

import com.crudapp.model.User;
import com.crudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Work on 18.11.2016.
 */
@Controller
public class UserController {
    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(value = "/userList/page/{page}", method = RequestMethod.GET)
//    public String listUsers(@PathVariable("page")int page, Model model){
//
//
//        PagedListHolder<?> pagedListHolder =  new PagedListHolder<>(this.userService.getListUsers());
//        pagedListHolder.setPage(page);
//        pagedListHolder.setPageSize(10);
//        model.addAttribute("listUsers", pagedListHolder.getPageList());
//        model.addAttribute("page", pagedListHolder.getPage());
//        model.addAttribute("pages", pagedListHolder.getPageCount());
//        return "user";
//    }
//
//    @RequestMapping(value = "users", method = RequestMethod.GET)
//    public String listUsers(Model model){
//        model.addAttribute("user", new User());
//        model.addAttribute("listUsers", this.userService.getListUsers());
//
//        return "users";
//    }
@RequestMapping(value="/users")
public ModelAndView listUsers(@RequestParam(required = false) Integer page) {
    ModelAndView modelAndView = new ModelAndView("users");

    List<User> users = this.userService.getListUsers();

    modelAndView.addObject("user", new User());
    modelAndView.addObject("listUsers", users);


    PagedListHolder<User> pagedListHolder = new PagedListHolder<User>(users);
    pagedListHolder.setPageSize(5);
    modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

    if (page == null || page < 1 || page > pagedListHolder.getPageCount()) page = 1;
    modelAndView.addObject("page", page);

    if (page == null || page < 1 || page > pagedListHolder.getPageCount()){
        pagedListHolder.setPage(0);
        modelAndView.addObject("listUsers", pagedListHolder.getPageList());
    }
    else if(page <= pagedListHolder.getPageCount()) {
        pagedListHolder.setPage(page-1);
        modelAndView.addObject("listUsers", pagedListHolder.getPageList());
    }

    return modelAndView;
}
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if(user.getId() == 0){
            this.userService.addUser(user);
        }else {
            this.userService.updateUser(user);
        }

        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.deleteUser(id);

        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.getListUsers());

        return "users";
    }


    @RequestMapping(value = "/users/search", method = RequestMethod.GET)
    public String getSearchForm(Model model) {
        model.addAttribute("user", new User());
        return "searchpage";
    }

    @RequestMapping(value = "/users/searchresult", method = RequestMethod.GET)
    public String getSearchResult(@RequestParam(value="name", required=true) String name,  Model model) {
        List<User> users=userService.getUser(name);
        model.addAttribute("users", users);
        return "searchresultpage";
    }

}
