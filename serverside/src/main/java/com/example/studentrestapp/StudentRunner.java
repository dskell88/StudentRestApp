package com.example.studentrestapp;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.stream.Stream;
@Component
public class StudentRunner implements CommandLineRunner {
    private final StudentRepository repository;
    public StudentRunner(StudentRepository repository) {
        this.repository = repository;
    }
    @Override
    public void run(String... strings) throws Exception {
        // Top beers from https://www.beeradvocate.com/lists/top/
        Stream.of("Josh Johnson", "Dan Smith", "Chris Doe", "Caesar Julius",
                "Clayton Taylor", "Bill Dean", "Rebecca Davis").forEach(name ->
                repository.save(new Student(name))
        );


        repository.findAll().forEach(System.out::println);
    }
}