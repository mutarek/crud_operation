package com.example.demo.controler;

import com.example.demo.models.Blogs;
import com.example.demo.repository.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class BlogsControler {
    @Autowired
    BlogsRepository blogsRepository;

    @GetMapping(value = "/allblogs")
    public List<Blogs> getallblogs() {
        return blogsRepository.findAll();
    }

    @PostMapping(value = "/allblogs")
    public ResponseEntity<Blogs> createABlogs(@RequestBody Blogs blogs) {
        Blogs blogs1 = blogsRepository.save(blogs);
        return new ResponseEntity<Blogs>(blogs1, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/allblogs/{id}")
    void deleteEmployee(@PathVariable int id) {
        blogsRepository.deleteById(id);
    }

    @PutMapping("/allblogs/{id}")
    Blogs replaceEmployee(@RequestBody Blogs newEmployee, @PathVariable int id) {

        return blogsRepository.findById(id)
                .map(employee -> {
                    employee.setTitle(newEmployee.getTitle());
                    employee.setDesc(newEmployee.getDesc());
                    employee.setImg(newEmployee.getImg());
                    employee.setLoc(newEmployee.getLoc());
                    return blogsRepository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return blogsRepository.save(newEmployee);
                });
    }


}
