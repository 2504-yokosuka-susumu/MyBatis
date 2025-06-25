package com.example.Patas.service;

import com.example.Patas.controller.form.TaskForm;
import com.example.Patas.repository.TaskMapper;
import com.example.Patas.repository.TaskRepository;
import com.example.Patas.repository.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddService {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskMapper taskMapper;

    /*
     * レコード1件追加
     */
    public void saveTask(TaskForm raqTask) {
        Task saveTask = setTaskEntity(raqTask);
        taskMapper.save(saveTask);
    }

    /*
     * リクエストから取得した情報をEntityに設定
     */
    private Task setTaskEntity(TaskForm reqTask) {
        Task task = new Task();
        task.setId(reqTask.getId());
        task.setStatus((1));
        task.setContent(reqTask.getContent());
        task.setLimitDate(reqTask.getLimitDate());
        task.setCreatedDate(reqTask.getCreatedDate());
        task.setUpdatedDate(reqTask.getUpdatedDate());
        return task;
    }
}
