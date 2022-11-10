package com.cydeo.service;

import com.cydeo.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    void save(TaskDTO dto);
    void update(TaskDTO dto);
    void delete(Long id);//because we not have anything unique
    List<TaskDTO>listAllTasks();
    TaskDTO findById(Long id);
    int totalNonCompletedTask(String projectCode);
    int totalCompletedTask(String projectCode);


}
