package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.service.TbItemCatService;
@Service
public class TbItemCatServiceImpl implements TbItemCatService {

	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	@Override
	public List<EasyUITreeNode> getCatList(Long parentId) {
		//根据parentID查询子节点列表
		//设置查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> tbItemCatList = tbItemCatMapper.selectByExample(example);

		//把TbItemCat列表转换成EasyUITreeNode的列表
		List<EasyUITreeNode> list =new ArrayList();
		for (TbItemCat tbItemCat : tbItemCatList) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			list.add(node);
		}
		//返回结果
		return list;
	}

}
