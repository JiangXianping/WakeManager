package com.taotao.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/test")
public class TestController {

	@ResponseBody
	@RequestMapping("/helloworld")
	public String sayHi(){
		return "login";
	}
}
