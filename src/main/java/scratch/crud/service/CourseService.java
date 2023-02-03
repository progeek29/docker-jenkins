package scratch.crud.service;

import scratch.crud.entity.Course;

import java.util.List;

public interface CourseService {

    public String upsert(Course course); //insert & update

    public List<Course> saveCourses(List<Course> courses);

    public Course getById(Integer id);

    public Course getByName(String name);

    public List<Course> getAllCourse();

    public String deleteById(Integer id);




}
