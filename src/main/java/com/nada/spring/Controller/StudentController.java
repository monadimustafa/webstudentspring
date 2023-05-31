package com.nada.spring.Controller;

import com.nada.spring.Model.Student;
import com.nada.spring.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("")
    public String welcomeMessage(){
        return "index";
    }
    @GetMapping("/listStudents")
    public String listStudents(Model model)
    {
        List<Student> students= studentService.getStudentList();
        System.out.println(students);
        model.addAttribute("students", students);
        return "list-students";
    }
    @GetMapping("/showAddForm")
    public String showAddForm(Model model){
        model.addAttribute("student", new Student());
        return "add-student";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:listStudents";
    }
    @GetMapping("/showEditForm")
    public String showEditForm(@RequestParam("studentId") int id, Model model){
        try
        {
            Student student=studentService.getStudent(id);
            model.addAttribute("student", student);
        }
        catch (IllegalArgumentException ex)
        {return "error-page";    }
        return "edit-student";
    }
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId")int id)
    {try
    {Student student = studentService.getStudent(id);
        studentService.deleteStudent(student);}
    catch(IllegalArgumentException ex)
    {return "error-page"; }
        return "redirect:listStudents";}


}
