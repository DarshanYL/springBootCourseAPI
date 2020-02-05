package io.javabrains.springbootstarter.topics;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	
	/*
	 * private List<Topics> topics = new ArrayList<> (Arrays.asList(
	 * 
	 * new Topics("1234", "CPSC430", "Does AI stuff"), new Topics("5678", "CPSC433",
	 * "Does ML stuff"), new Topics("9012", "CPSC435", "Does DL stuff")
	 * 
	 * ))
	 */;
	 
	
	public List<Topics> getAllTopics(){
		List<Topics> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
		
	}
	
	public Optional<Topics> getTopic(String id) {
		
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
		
	}

	public void addTopic(Topics topics2) {
		
		topicRepository.save(topics2);
		
	}

	public void updateTopic(String id, Topics topic) {
		/*
		 * for (int i =0; i< topics.size(); i++) { Topics t = topics.get(i);
		 * if(t.getId().equals(id)) { topics.set(i, topic); } } return null;
		 */
		
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
		
}
