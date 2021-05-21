package com.website.prostudy.controllers;


import com.website.prostudy.DAO.Dao;
import com.website.prostudy.models.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/people")
public class PeopleController {

    private Dao dao;

    public PeopleController(Dao dao) {
        this.dao = dao;
    }

    @GetMapping()
    public String allPeople(Model model)
    {
        model.addAttribute("allPeople", dao.allPeople());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String peopleInfo(@PathVariable ("id") int id, Model model)
    {

        model.addAttribute("onePeople", dao.allPeople().get(id-1));
        return "people/people";
    }

    @GetMapping("/new")
    public String newPeople(Model model)
    {
        model.addAttribute("people", new People());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("people") @Valid People people,
                         BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "people/new";

        dao.addPeople(people);
        return "redirect:/people";
    }


    @PatchMapping("/{id}")
    public String update (@PathVariable("id") int id,
                          @ModelAttribute("people") @Valid People people,
                          BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "redirect:/people/";

        dao.updatePeople(people);
        return "redirect:/people/";
    }


    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") int id, @ModelAttribute("people") People people)
    {
        people.setId(id);
        dao.deletePeople(people);
        return "redirect:/people";
    }
}
