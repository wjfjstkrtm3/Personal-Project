package com.tistory.pentode;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tistory.pentode.service.BoardService;
import com.tistory.pentode.vo.BoardVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "/boardList.do")
	public String boardList(Model model) throws Exception {
		
		List<BoardVO> list = boardService.selectBoardList();
		
		logger.info(list.toString());
		
		model.addAttribute("list", list);
		
		return "boardList";
	}
	
	@RequestMapping(value = "/boardView.do")
	public String boardView(@RequestParam Integer num,  Model model) throws Exception {
		
		BoardVO vo = boardService.selectBoardView(num);
		
		model.addAttribute("vo", vo);
		
		return "boardView";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
}
