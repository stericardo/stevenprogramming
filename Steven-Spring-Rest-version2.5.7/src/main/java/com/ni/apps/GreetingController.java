package com.ni.apps;

import com.ni.apps.config.StevenEnvironmentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s! > ContainerName %s, ContainerDescription %s " +
			" NodeName %s, PodNamespace %s";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private StevenEnvironmentProperties stevenEnvironmentProperties;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		new ResponseEntity<>("", HttpStatus.NOT_FOUND);
		return new Greeting(counter.incrementAndGet(), String.format(template, name,
				stevenEnvironmentProperties.getContainerName(),
				stevenEnvironmentProperties.getContainerDescription(),
				stevenEnvironmentProperties.getMyNodeName(),
				stevenEnvironmentProperties.getMyPodNamespace()));
	}


}
