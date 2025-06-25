package com.example.Patas.repository;

import com.example.Patas.repository.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    //全件取得
    List<Task> findAll();

    //投稿削除
    void deleteById(Integer id);

    //投稿登録
    void save(Task saveTask);
}
