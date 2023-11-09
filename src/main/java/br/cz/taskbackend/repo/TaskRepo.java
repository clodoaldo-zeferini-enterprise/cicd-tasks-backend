package br.cz.taskbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.cz.taskbackend.model.Task;

public interface TaskRepo extends JpaRepository<Task, Long>{

}
