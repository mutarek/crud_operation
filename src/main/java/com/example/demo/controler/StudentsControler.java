package com.example.demo.controler;

import com.example.demo.models.Students;
import com.example.demo.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class StudentsControler {
    @Autowired
    StudentsRepository studentsRepository;

    @GetMapping("/students")
    public List<Students> retrieveAllStudents() {
        return studentsRepository.findAll();
    }

    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Optional<Students>> getStudentsById(@PathVariable(name = "id") int id) {
        Optional<Students> students = studentsRepository.findById(id);
        return new ResponseEntity<Optional<Students>>(students, new HttpHeaders(), HttpStatus.OK);

    }

    @PostMapping(value = "/students")
    public ResponseEntity<Students> postStudents(@RequestBody Students students) {
        Students students1 = studentsRepository.save(students);
        return new ResponseEntity<Students>(students1, new HttpHeaders(), HttpStatus.OK);
    }

}
