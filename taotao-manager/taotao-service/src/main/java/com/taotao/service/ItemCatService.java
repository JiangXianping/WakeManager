package com.taotao.service;
/**
 * 
 * @author jiangxianping
 *
 */
import java.util.List;

import com.taotao.common.pojo.EUTreeNode;
public interface ItemCatService {
	
	List<EUTreeNode> getCatList(long parentId);
}
