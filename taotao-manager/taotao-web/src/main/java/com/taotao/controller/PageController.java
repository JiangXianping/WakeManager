package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * @author jiangxianping
 * 
 */
@Controller
public class PageController {
	
	/**
	 * 打开首页
	 */
	@RequestMapping("/index")
	public String showIndex(){
		return "index";
	}
	/**
	 * 展示其他页面
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	@RequestMapping("/rest/page/list-edit")
	public String editPage(@PathVariable String page){
		return "item-edit";
	}
}
