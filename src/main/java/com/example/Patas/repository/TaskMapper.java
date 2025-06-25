package com.example.Patas.repository;

import com.example.Patas.repository.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    //全件取得
    //@Select("SELECT * FROM tasks")
    List<Task> findAll();

    //投稿削除
    void deleteById(Integer id);

//
//    //１件取得
//    @Select({"SELECT * FROM user",
//            "WHERE id = #{id}"
//    })
//    User selectByPrimaryKey(Long id);
//
//
//    //登録
//    @Insert({
//            "INSERT INTO user(user_name, email)",
//            "VALUES(#{userName}, #{email})"
//    })
//    int insert(User record);
//
//
//    //更新
//    @Update({
//            "UPDATE user",
//            "SET user_name = #{userName}, email = #{email}",
//            "WHERE id = #{id}"
//    })
//    int updateByPrimaryKey(User record);
//
//
//    //削除
//    @Delete({
//            "DELETE FROM user",
//            "WHERE id = #{id}"
//    })
//    int deleteByPrimaryKey(Long id);
}
