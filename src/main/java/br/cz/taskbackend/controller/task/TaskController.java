package br.cz.taskbackend.controller.task;

import br.cz.taskbackend.model.Task;
import br.cz.taskbackend.repo.TaskRepo;
import br.cz.taskbackend.utils.DateUtils;
import br.cz.taskbackend.utils.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value ="/todo")
public class TaskController {

	@Autowired
	private TaskRepo todoRepo;
	
	@GetMapping
	public List<Task> findAll() {
		return todoRepo.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Task> save(@RequestBody Task todo) throws ValidationException {
		if(todo.getTask() == null || Objects.equals(todo.getTask(), "")) {
			throw new ValidationException("Fill the task description");
		}
		if(todo.getDueDate() == null) {
			throw new ValidationException("Fill the due date");
		}
		if(!DateUtils.isEqualOrFutureDate(todo.getDueDate())) {
			throw new ValidationException("Due date must not be in past");
		}
		Task saved = todoRepo.save(todo);
		return new ResponseEntity<Task>(saved, HttpStatus.CREATED);
	}
	 
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		todoRepo.deleteById(id);
	}
}
