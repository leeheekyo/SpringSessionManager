package com.naver.blog;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class MainController {
	
	@GetMapping("/")
	public String main(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		HttpSession session = request.getSession();
		
		sb.append("session id : " + session.getId() + "<br />");
		
		Object value = session.getAttribute("key");
		
		if(value != null) {
			sb.append("key value : " + value);
		}
		else {
			sb.append("key is null");
		}
		
		return sb.toString();
		
	}
	
	@GetMapping("/key")
	public String keyValue(HttpServletRequest request
			, @RequestParam("value") String reqValue) {
		StringBuffer sb = new StringBuffer();
		HttpSession session = request.getSession();
		
		session.setAttribute("key", reqValue);
		
		sb.append("session id : " + session.getId() + "<br />");
		
		Object value = session.getAttribute("key");
		
		if(value != null) {
			sb.append("key value : " + value);
		}
		else {
			sb.append("key is null");
		}
		
		return sb.toString();
	}
	
}
