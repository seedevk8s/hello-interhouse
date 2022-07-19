package kr.co.ezenac.hello.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ezenac.hello.dto.UserRequest;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
	
	// http://localhost:8080/api/get/query-param?name=추호진&email=chu@gmail.com&age=30

	@GetMapping(path = "query-param")
	public String queryParam(@RequestParam Map<String, String> queryParam) {
		
		StringBuilder sb = new StringBuilder();
		queryParam.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("\n");
			
			sb.append(entry.getKey() +" = "+ entry.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	
	// http://localhost:8080/api/get/query-param02?name=추호진&email=chu@gmail.com&age=30
	
	@GetMapping("query-param02")
	public String queryParam02(
			@RequestParam String name, 
			@RequestParam String email,
			@RequestParam int age
			) {
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(age);
		
		return name +" "+ email +" "+ age;
	}
	
	
	@GetMapping("query-param03")
	public String queryParam03(UserRequest userRequest) {
		
		System.out.println(userRequest.getName());
		System.out.println(userRequest.getEmail());
		System.out.println(userRequest.getAge());
		
		return userRequest.toString();
	}
	
}







