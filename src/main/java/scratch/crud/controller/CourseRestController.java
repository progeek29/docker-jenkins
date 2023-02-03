package scratch.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import scratch.crud.entity.Course;
import scratch.crud.service.CourseService;

import java.util.List;

@RestController
public class CourseRestController {

    @Autowired
    private CourseService service;

    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        String status = service.upsert(course);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @PostMapping("/addCourses") //
    public ResponseEntity<List<Course>> addCourses(@RequestBody List<Course> courses){
        List<Course> addAll = service.saveCourses(courses);
        return new ResponseEntity<>(addAll,HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Integer id) {
        Course course = service.getById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> allCourses = service.getAllCourse();
        return new ResponseEntity<>(allCourses, HttpStatus.OK);
    }

    @GetMapping("/course/{name}") //
    public ResponseEntity<Course> getCourseByName(@PathVariable String name){
        Course course = service.getByName(name);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @PutMapping("/course")
    public ResponseEntity<String> updateCourse(@RequestBody Course course) {
        String status = service.upsert(course);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer id) {
        String status = service.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


}
