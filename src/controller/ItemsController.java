package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Items;
import pojo.QueryVo;
import service.ItemsService;

@Controller
public class ItemsController {
	@Autowired
	private ItemsService itemsService;

	@RequestMapping("/items.action")
	public ModelAndView itemList() {
		ModelAndView mv = new ModelAndView();
		List<Items> itemList = itemsService.getItemsList();
		mv.addObject("itemList", itemList);
		mv.setViewName("itemList");
		return mv;
	}

	@RequestMapping("/itemEdit.action")
	// public ModelAndView itemEdit(HttpServletRequest request) {
	public ModelAndView itemEdit(Integer id) {
		// String id = request.getParameter("id");
		ModelAndView mv = new ModelAndView();
		// Items item = itemsService.getItemById(Integer.parseInt(id));
		Items item = itemsService.getItemById(id);
		mv.addObject("item", item);
		mv.setViewName("editItem");
		return mv;
	}

	// // 提交修改页面，入参是poji类型
	// @RequestMapping("/updateitem.action")
	// public ModelAndView updateItem(Items item) {
	// itemsService.updateItem(item);
	// ModelAndView mv = new ModelAndView();
	// mv.setViewName("success");
	// return mv;
	// }

	// 提交修改页面，入参是queryvo类型(对象包对象)
	@RequestMapping("/updateitem.action")
	public ModelAndView updateItem(QueryVo vo) {
	
		itemsService.updateItem(vo.getItems());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		return mv;

	}
}
