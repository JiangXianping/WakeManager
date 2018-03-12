package com.taotao.controller;

import java.util.List;
import java.util.function.LongToIntFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContentCategory;
import com.taotao.service.ContentCategoryService;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCategoryList(@RequestParam(value="id",defaultValue="0")Long id){
		List<EUTreeNode> list = contentCategoryService.getContentCateList(id);
		return list;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult createContentCategory(Long parentId, String name) {
		TaotaoResult result = contentCategoryService.insertConentCategory(parentId, name);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContentCategory(@RequestParam(value="parentId",defaultValue="0")Long  parentId,Long id){
		//根据id查找parentid
		parentId = contentCategoryService.selectContentCategory(id);
		return contentCategoryService.deleteConectCategory(parentId, id);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult updateContentCategory(Long id,String name){
		return contentCategoryService.updateContentCategory(id, name);
	}
	
}
