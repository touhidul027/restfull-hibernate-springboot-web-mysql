package com.example.demo;

import org.springframework.http.MediaType;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
class PersonController {

	private final PersonRepository repository;

	PersonController(PersonRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

//	@GetMapping("/Persons")
//	List<Person> all() {
//		return repository.findAll();
//	}
	
	@GetMapping("/")
	ModelAndView start() {
		return getAll() ; 
	}
	
//	@GetMapping("/Persons/{id}")
//	ModelAndView get(@PathVariable Long id) {
////		// forward request to persons list  UI 
//		ModelAndView mv = new ModelAndView("index");
//		mv.addObject("person", repository.findById(id).get()  ) ; 
//    	mv.addObject("persons",repository.findAll()) ; 
//        return mv;  
// 		//return null ; 
//	}
	
	@GetMapping("/Persons/{id}")
	ModelAndView get(@PathVariable Long id) { 		 
        return new ModelAndView("index")
        		.addObject("person", repository.findById(id).get())
        		.addObject("persons",repository.findAll());   		
	}
	
	@GetMapping("/Persons")
	ModelAndView getAll() {
		// forward request to persons list  UI 
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("person", new Person()) ; 
    	mv.addObject("persons",repository.findAll()) ; 
      //  mv.setViewName("index");
        return mv;  		
	}
	
	@PostMapping(value="/Persons")
	ModelAndView post( Person newPerson) {
		  repository.save(newPerson);
		return getAll();
	}

//	@PostMapping(value="/Persons")
//	Person newPerson(@RequestBody Person newPerson) {
//		return repository.save(newPerson);
//	}
	
	@PostMapping(value="/Persons/{id}")
	ModelAndView updateDelete(HttpServletRequest req,@PathVariable Long id,@RequestParam String method) {
		Person person ; 
		if(method.equals("delete"))
			return deletePerson(id);
		else {
			person = new Person() ; 
			person.setId(id); 
			person.setFirstName(req.getParameter("firstName"));
			person.setLastName(req.getParameter("lastName")); 
		}
		
 		return updatePerson( person);
 	}
	
	
	@DeleteMapping("/Persons/{id}")
	ModelAndView deletePerson(@PathVariable Long id) {
		 repository.deleteById(id);
		return start();
	}
	

	@PutMapping("/Persons/{id}")
	ModelAndView updatePerson(Person person) {		
		repository.save(person) ; 
       return  get(person.getId()) ; 	
	}
	
	@PostMapping(value = "/add")
	ModelAndView add(@RequestBody Person newPerson) {
		System.out.println("Hello");

		 repository.save(newPerson);
		 return getAll();
	}

	
	
	@GetMapping("/delete/{id}")
	ModelAndView delete(@PathVariable Long id) {
		repository.deleteById(id);
		return new ModelAndView("index").addObject("persons", repository.findAll()).addObject("person",new Person());
	}
	
	
	@GetMapping("/persons/{id}")
	Person one(@PathVariable Long id) {		
		return repository.findById(id)
			.orElseThrow(()->null);
	}
	
//	@PutMapping("/persons/{id}")
//	Person replaceEmployee(@RequestBody Person newPerson, @PathVariable Long id) {
//	
//		return repository.findById(id)
//			.map(employee -> {
//				employee.setFirstName(newPerson.getFirstName());
//				employee.setLastName(newPerson.getLastName());
//				return repository.save(employee);
//			})
//			.orElseGet( () -> {
//				newPerson.setId(id);
//				return repository.save(newPerson);
//			});
//	}
	
	
	
}