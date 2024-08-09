package com.springtest.controller;

import com.springtest.beans.Student;
import com.springtest.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
@Controller
public class StudentController
{
    @Autowired
    StudentDAO dao;

    @RequestMapping("/studentform")
    public String showform(Model m){
        m.addAttribute("command", new Student());
        return "studentform";
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("student") Student student)
    {
        System.out.println("at save method");
        dao.save(student);
        return "redirect:/viewstudents";
    }

    @RequestMapping("/viewstudents")
    public String viewStudents(Model m){
        List<Student> list=dao.getStudents();
        System.out.println("list size: "+list.size());
        m.addAttribute("list",list);
        return "viewstudents";
    }


    @RequestMapping(value="/deletestudent/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.delete(id);
        return "redirect:/viewstudents";
    }
}
