package com.mongotelusko.joblisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongotelusko.joblisting.model.Post;
import com.mongotelusko.joblisting.repository.PostRepository;
import com.mongotelusko.joblisting.utility.ResponseHandler;

@RestController
public class PostController {

	@Autowired
	PostRepository postRepository;
	
//    @RequestMapping(value="/")
//    public void redirect(HttpServletResponse response) throws IOException {
//        response.sendRedirect("/swagger-ui.html");
//    }
	
	@RequestMapping(value="/jobs")
	public List<Post> getJobs() {
		return postRepository.findAll();
	}
	
	@RequestMapping(value="/jobsByTech/{tech}")
	public List<Post> getJobByTech(@PathVariable String tech){
		return postRepository.findByTech(tech);
	}
	
	@PostMapping(value = "/postJob")
	public Post postNewJob(@RequestBody Post post) {   
	   return postRepository.save(post);
	}
	
	@PutMapping(value = "/update/{jobId}")
	public Post updateJobs(@PathVariable String jobId, @RequestBody Post post) {
	   return postRepository.save(post);
	}
	
	@PutMapping(value = "/updateProfile/{jobId}")
	public ResponseEntity<Object> updateJobProfile(@PathVariable String jobId, @RequestBody String profile){
		try {
		Post post=postRepository.findById(jobId).get();
		post.setProfile(profile);
		return ResponseHandler.generateResponse("Updated", HttpStatus.OK, post);
		 }
		catch(Exception e){
			return ResponseHandler.generateResponse("User Not Found", HttpStatus.BAD_REQUEST, null);
		}
	}
	
	@DeleteMapping(value = "/delete/{jobId}")
	public void deleteJob(@PathVariable String jobId) {
	   postRepository.deleteById(jobId);
	}
	
	/*@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK",response = Post.class),
	        @ApiResponse(code = 400, message = "Job Not Found"),
	        @ApiResponse(code = 500, message = "Internal server error")})
	@PutMapping(value = "/updateProfileViaAPI/{jobId}")
	public ResponseEntity<Object> updateJobProfileAPI(@PathVariable String jobId, @RequestBody String profile){
		Post post=postRepository.findById(jobId).get();
		post.setProfile(profile);
		return ResponseHandler.generateResponse("Updated", HttpStatus.OK, post);
	}*/
}
