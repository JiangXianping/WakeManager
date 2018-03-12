package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUDataResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	
	EUDataResult getContentList(Long categoryId,int page,int rows);
	
	TaotaoResult insertContent(TbContent content);
	
	
}
