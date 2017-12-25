package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.TbItemService;

@Controller
public class TbItemController {

	@Autowired
	private TbItemService tbItemService;

	@RequestMapping("/item/{id}")
	@ResponseBody
	public TbItem findByTbItemById(@PathVariable("id") Long id) {
		TbItem tbItem = tbItemService.fingByTbItemId(id);
		return tbItem;
	}
	
	/**
	 * 请求参数：page=1&rows=30
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public DataGridResult getTbItemList(int page,int rows){
		return tbItemService.getTbItemList(page,rows);
	}

}
