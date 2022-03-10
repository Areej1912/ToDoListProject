package com.qa.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.Repo.ToDoRepo;
import com.qa.entity.ToDoItem;

@SpringBootTest
public class ToDoServiceUnitTest {

	@Autowired
	private ToDoService service;
	
	@MockBean
	private ToDoRepo repo;
	
	@Test
	void getToDoItemByIdTest() {
	
		Long id = (long) 1;
		ToDoItem todoitem1 = new ToDoItem(id, "Buy Groceries", false);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(todoitem1));
		assertThat(this.service.getToDoItemById(id)).isEqualTo(todoitem1);
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
}
	@Test 
	void createToDoItemTest() {
		ToDoItem newToDoItem = new ToDoItem(null, "Complete Project", false);
		ToDoItem savedToDoItem = new ToDoItem(1L, "Complete Project", false);
		Mockito.when(this.repo.save(newToDoItem)).thenReturn(savedToDoItem);
		assertThat(this.service.createToDoItem(newToDoItem)).isEqualTo(savedToDoItem);
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(ToDoItem.class));
		
	}
	
	@Test
	void deleteToDoItemTest() {
		Long id= (long) 1;
		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		assertThat(this.service.deleteToDoItem(id)).isEqualTo(true);
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(Mockito.anyLong());
		Mockito.verify(this.repo, Mockito.times(1)).existsById(Mockito.anyLong());
		
				
	}
	@Test
	void getALLToDoItemsTest() {
		ToDoItem todoitem1 = new ToDoItem(1L,"Write email", false);
		ToDoItem todoitem2 = new ToDoItem(2L,"Send email", false);
		Mockito.when(this.repo.findAll()).thenReturn(List.of(todoitem1, todoitem2));
		assertThat(this.service.getALLToDoItems()).isEqualTo(List.of(todoitem1, todoitem2));
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
		
	}
	
	@Test
	void updateToDoItem() {
		Long id= (long) 1;
		ToDoItem savedToDoItem = new ToDoItem(1L, "Buy Present", true);
		ToDoItem updatingToDoItem = new ToDoItem(null, "Buy Present", true);
		ToDoItem updatedToDoItem = new ToDoItem(1L, "Buy Present", true);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(savedToDoItem));
		Mockito.when(this.repo.save(updatedToDoItem)).thenReturn(updatedToDoItem);
		assertThat(this.service.updateToDoItem(id, updatingToDoItem)).isEqualTo(updatedToDoItem);
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(ToDoItem.class));
	}
	
}
