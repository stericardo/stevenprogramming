package com.stevenprogramming.spring.rest;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import com.stevenprogramming.spring.rest.config.StevenEnvironmentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s! > ContainerName %s and ContainerDescription %s";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private StevenEnvironmentProperties stevenEnvironmentProperties;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		new ResponseEntity<>("", HttpStatus.NOT_FOUND);
		return new Greeting(counter.incrementAndGet(), String.format(template, name, stevenEnvironmentProperties.getContainerName(),
				stevenEnvironmentProperties.getContainerDescription()));
	}

	public static void main(String[] args){
		Solution sol = new Solution();
		String result = sol.longestPalindrome("babad");
		System.out.println(result);

		result = sol.longestPalindrome("cbbd");
		System.out.println(result);
	}

	// https://leetcode.com/problems/longest-palindromic-substring/

	static class Solution {
		public String longestPalindrome(String s) {
			if(s.length() < 0 || s.length() > 1000){
				return "";
			}

			String temp = "";
			for(int cont = 0; cont < s.length(); cont++){
				temp = s.substring(0, s.length()-cont);

				StringBuilder reverseString = new StringBuilder();
				for(int reverseCont = s.length() - (cont + 1) ; reverseCont > -1; reverseCont--){
					reverseString.append(s.charAt(reverseCont));
				}

				if(reverseString.toString().equals(temp)){
					return reverseString.toString();
				}
			}

			temp = "";
			for(int cont = 0; cont < s.length(); cont++){
				temp = s.substring(cont, s.length());

				StringBuilder reverseString = new StringBuilder();
				for(int reverseCont = s.length() - (cont + 1) ; reverseCont > -1; reverseCont--){
					reverseString.append(s.charAt(reverseCont));
				}

				if(reverseString.toString().equals(temp)){
					return reverseString.toString();
				}
			}
			return "";
		}
	}


}
