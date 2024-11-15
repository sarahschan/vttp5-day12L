package sg.edu.nus.iss.vttp5a_day12l.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sg.edu.nus.iss.vttp5a_day12l.model.Student;

@Controller
@RequestMapping("/students")
public class StudentController {
    
    public List<Student> students;

    
    // @GetMapping()
    @RequestMapping(path={"", "/allStudents"}, method=RequestMethod.GET)
    public String studentListing(Model model) throws ParseException {
        
        students = new ArrayList<>();

        String dob = "18 Dec 1975 10:25:00.000 HKT";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS zzz");
        Date dDob = sdf.parse(dob);
        Long epochDOB = dDob.getTime();

        Student s1 = new Student(1, "Damien", "Cumming", epochDOB, "damien@email.com", "25 HMKT 119615");
        Student s2 = new Student(1, "Darryl", "Ng", epochDOB, "darryl@email.com", "25 HMKT 119615");
        Student s3 = new Student(1, "Janice", "Tan", epochDOB, "janice@email.com", "25 HMKT 119615");
        Student s4 = new Student(1, "Mindy", "Heng", epochDOB, "mindy@email.com", "25 HMKT 119615");

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        model.addAttribute("students", students);


        // convert epoch Long to Date
        // Long epochTime = 188101500000L;
        // Date dTime = new Date(epochTime);
        // String formattedDate = sdf.format(dTime);
        // System.out.println(formattedDate);


        return "studentlist";
    }
}
