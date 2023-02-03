package scratch.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scratch.crud.entity.Course;
import scratch.crud.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public String upsert(Course course) {
        repository.save(course);  //upsert - insesrt/update based on primary key
        return "success";
    }

    @Override
    public List<Course> saveCourses(List<Course> courses) {   //adddAll
        repository.saveAll(courses);
        return null;
    }

    @Override
    public Course getById(Integer id) {
        Optional<Course> findById = repository.findById(id);
        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    @Override
    public Course getByName(String name) { // findByNAme
        repository.findByName(name);
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        return repository.findAll();
    }

    @Override
    public String deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Delete Success";
        } else {
            return "No Record Found";
        }
    }
}
