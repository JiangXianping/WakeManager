package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUDataResult;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;

public interface ContentCategoryService {
	
	List<EUTreeNode> getContentCateList(Long parentid);
	
	TaotaoResult insertConentCategory(Long parentId,String name);
	
	TaotaoResult deleteConectCategory(Long parentId,Long id);
	
	Long selectContentCategory(Long id);
	
	TaotaoResult updateContentCategory(Long id,String name);
	
	
	
}
