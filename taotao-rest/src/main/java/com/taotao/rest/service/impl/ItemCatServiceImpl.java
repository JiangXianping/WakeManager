package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	@Override
	public CatResult getItemCatList() {
		CatResult catResult = new CatResult();
		catResult.setData(getCatList(0));
		return catResult;
	}

	public List<?> getCatList(long parentId){
		//创建查询条件
		TbItemCatExample tbItemCatExample = new TbItemCatExample();
		Criteria criteria = tbItemCatExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = tbItemCatMapper.selectByExample(tbItemCatExample);
		
		//返回值List
		List resultList = new ArrayList<>();
		//向list中添加节点
		int count = 0;
		for(TbItemCat tbItemCat:list){
			//判断是否是父节点
			if(tbItemCat.getIsParent()){
				CatNode catNode = new CatNode();
				if(parentId == 0){
					catNode.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
				}else{
					catNode.setName(tbItemCat.getName());
				}
				catNode.setUrl("/products"+tbItemCat.getId()+".html");
				catNode.setItem(getCatList(tbItemCat.getId()));
				
				resultList.add(catNode);
				count++;
				//第一层只取14条记录
				if(parentId==0 && count>=14){
					break;
				}
				//如果是叶子节点
			}else{
				resultList.add("/products/"+tbItemCat.getId()+".html|"+tbItemCat.getName());
		}
		}
		return resultList;
	}

}
