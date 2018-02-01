package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;	
	
	@Override
	public List<EUTreeNode> getCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);
		List<EUTreeNode> euTreeNodes = new ArrayList<>();
		for (TbItemCat tbItemCat : tbItemCats) {
			EUTreeNode euTreeNode = new EUTreeNode();
			euTreeNode.setId(tbItemCat.getId());
			euTreeNode.setState(tbItemCat.getIsParent()?"closed":"open");
			euTreeNode.setText(tbItemCat.getName());
			euTreeNodes.add(euTreeNode);
		}
		return euTreeNodes;
	}

}
