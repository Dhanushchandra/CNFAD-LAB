package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/resource")
public class ResourceController {
	
	private List<Resource> resources = new ArrayList<>();
	
	@GetMapping
	public List<Resource> getAllResource(){
		return resources;
	}
	
	@PostMapping
	public Resource createResource(@RequestBody Resource resource) {
		resource.setId(resources.size() + 1);
		resources.add(resource);
		return resource;
	}
	
	  @PutMapping("/{id}")
	    public Resource updateResource(@PathVariable int id, @RequestBody Resource updatedResource) {
	        for (Resource resource : resources) {
	            if (resource.getId() == id) {
	                resource.setName(updatedResource.getName());
	                return resource;
	            }
	        }
	        return null;
	    }
	  
	  @DeleteMapping("/{id}")
	    public String deleteResource(@PathVariable int id) {
	        resources.removeIf(resource -> resource.getId() == id);
	        return "Resource with id " + id + " deleted.";
	    }

}
