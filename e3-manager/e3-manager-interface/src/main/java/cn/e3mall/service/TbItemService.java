package cn.e3mall.service;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.pojo.TbItem;

public interface TbItemService {
	public TbItem fingByTbItemId(Long id);
	public DataGridResult getTbItemList(int page,int rows);
}
