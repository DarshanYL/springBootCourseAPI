package io.javabrains.springbootstarter.topics;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topics> getAllTopics(){
		
		return topicService.getAllTopics();
		
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<Topics> getTopic(@PathVariable String id) {
		
		return topicService.getTopic(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void postTopic(@RequestBody Topics topics) {
		topicService.addTopic(topics);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@PathVariable String id, @RequestBody Topics topic) {
		
		 topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void updateTopic(@PathVariable String id) {
		
		topicService.deleteTopic(id);
	}
	
}
