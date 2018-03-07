package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUDataResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(Long id);
	
	EUDataResult getItemList(int page,int rows);
	
	List<TbItem> getAllList();
	
	TaotaoResult createItem(TbItem item,String desc,String itemParam)throws Exception;
	
	TaotaoResult updateItem(TbItem item);
	
	TaotaoResult deleteItem(Long itemId);
	
	TaotaoResult insertItemParamItem(Long itemId,String itemParam);
	
}
