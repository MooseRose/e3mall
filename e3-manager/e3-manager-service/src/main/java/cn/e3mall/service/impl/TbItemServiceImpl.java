package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.TbItemService;

@Service
public class TbItemServiceImpl implements TbItemService {
	@Autowired
	private TbItemMapper tbItemMapper;

	public TbItem fingByTbItemId(Long id) {
		return tbItemMapper.selectByPrimaryKey(id);
	}

	public DataGridResult getTbItemList(int page, int rows) {
		// 1、设置分页信息
		PageHelper.startPage(page, rows);
		// 2、执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		// 3、取分页结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		// 4、返回DataGridResult对象
		DataGridResult dataGridResult = new DataGridResult();
		System.out.println("pageInfo.getSize()-------------------->"+pageInfo.getSize());
		System.out.println("pageInfo.getPageSize()-------------------->"+pageInfo.getPageSize());
		System.out.println("pageInfo.getList()-------------------->"+pageInfo.getList());
		dataGridResult.setRows(list);
		dataGridResult.setTotal(pageInfo.getTotal());
		return dataGridResult;
	}

}
