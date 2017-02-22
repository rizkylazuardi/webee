package com.anabatic.webee.ws.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anabatic.pmo.persistence.entity.Employee;
import com.anabatic.webee.ws.dto.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<List<String>> login(@RequestBody LoginRequest param, HttpServletRequest request) {
		System.out.println(param.getUsername());
		System.out.println(request.getLocalAddr());
		System.out.println(request.getLocalPort());
		System.out.println(request.getContextPath());
		
		try {
			String url = request.getLocalAddr()+":"+request.getLocalPort()+"/"+request.getContextPath()+"/login";
			PostMethod pm = new PostMethod(url);
			pm.addParameter("username", param.getUsername());
			pm.addParameter("password", param.getPassword());
			/*ObjectMapper mapper = newObjectMapper();
		    StringRequestEntity requestEntity = new StringRequestEntity(mapper.writeValueAsString(param), "application/json","UTF-8");
			pm.setRequestEntity(requestEntity);*/
			

			HttpClient hc = new HttpClient();
			hc.executeMethod(pm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<String>>(new ArrayList<String>(), HttpStatus.OK);
	}
}
