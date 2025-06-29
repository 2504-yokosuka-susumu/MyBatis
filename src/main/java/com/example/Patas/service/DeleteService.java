package com.example.Patas.service;

import com.example.Patas.repository.TaskMapper;
import com.example.Patas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {

    //@Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskMapper taskMapper;

    public void delete(Integer id) {
        taskMapper.deleteById(id);
    }
}
