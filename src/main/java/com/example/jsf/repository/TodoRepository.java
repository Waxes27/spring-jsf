package com.example.jsf.repository;


import com.example.jsf.models.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface TodoRepository extends JpaRepository<TodoModel, Long> {
    @Modifying
    @Query("DELETE FROM TodoModel e WHERE e.id = :id")
    void deleteById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update TodoModel t set t.todoItem = ?1 where t.id = ?2")
    int updateTodoItemById(String todoItem, Long id);
}
