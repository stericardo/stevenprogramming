package com.stevenprogramming.library.core.sprintboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autor Steven Ricardo Mendez Brenes
 * @date 2018-Mar-23 6:25:22 PM
 * @Version 1.0
 */
@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot Steven Ricardo Mendez Brenes!";
	}
}
