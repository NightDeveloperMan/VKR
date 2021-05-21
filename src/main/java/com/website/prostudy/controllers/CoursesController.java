package com.website.prostudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CoursesController {

    @GetMapping("/courses")
    public String MyCourses()
    {
        return "courses/courses";
    }

    @GetMapping("/single-courses")
    public String MySingleCourses()
    {
        return "courses/single-courses";
    }
}
