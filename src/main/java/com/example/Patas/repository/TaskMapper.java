package com.example.Patas.repository;

import com.example.Patas.repository.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface TaskMapper {

    //全件取得
    List<Task> findAll();

    //一件投稿取得
    Task findById(Integer id);

    //投稿削除
    void deleteById(Integer id);

    //投稿登録
    void save(Task saveTask);

    //投稿編集
    void edit(Task saveTask);

    //ステータス変更
    void update(@Param("id") Integer id, @Param("status") Integer status,
              @Param("updatedDate") Date updatedDate);

    //日付 絞り込み
    List<Task> searchDate(Date start, Date end);

    //日付 ステータス 絞り込み
    List<Task> searchStatus(Date start, Date end, int status);

    //日付 内容 絞り込み
    List<Task> searchContent(Date start, Date end, String content);

    //日付 内容 ステータス 絞り込み
    List<Task> searchExactMatch(Date start, Date end, String content, int status);
}
