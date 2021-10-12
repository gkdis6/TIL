package com.study.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.model.BbsDTO;
import com.study.model.BbsMapper;
import com.study.utility.Utility;

@Controller
public class BbsController {

	@Autowired
	private BbsMapper mapper;

	@GetMapping("/")
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		return "/home";
	}

	@GetMapping("/bbs/create")
	public String create() {
		return "/bbs/create";
	}

	@PostMapping("/bbs/create")
	public String create(BbsDTO dto, HttpServletRequest request) throws IOException {
		String basePath = new ClassPathResource("/static/storage").getFile().getPath();

		if (dto.getFilenameMF() != null || dto.getFilenameMF().getSize()>0 ) {
			dto.setFilename(Utility.saveFileSpring(dto.getFilenameMF(), basePath));
			dto.setFilesize((int) dto.getFilenameMF().getSize());
		}
		boolean flag = false;

		int cnt = mapper.create(dto);

		if (cnt > 0) {
			flag = true;
		}

		if (flag) {
			return "redirect:/bbs/list";
		} else {
			return "bbs/error";
		}
	}

	@RequestMapping("/bbs/list")
	public String list(HttpServletRequest request) {

		// 검색관련------------------------
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));

		if (col.equals("total")) {
			word = "";
		}

		// 페이지관련-----------------------
		int nowPage = 1;// 현재 보고있는 페이지
		if (request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		int recordPerPage = 3;// 한페이지당 보여줄 레코드갯수

		// DB에서 가져올 순번-----------------
		int sno = ((nowPage - 1) * recordPerPage) + 1;
		int eno = nowPage * recordPerPage;

		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);

		int total = mapper.total(map);

		// List<BbsDTO> list = dao.list(map);
		List<BbsDTO> list = mapper.list(map);

		String paging = Utility.paging(total, nowPage, recordPerPage, col, word);

		// request에 Model사용 결과 담는다
		request.setAttribute("list", list);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("paging", paging);

		return "/bbs/list";

	}

	@GetMapping("/bbs/read")
	public String read(int bbsno, Model model) {

		mapper.upViewcnt(bbsno);
		BbsDTO dto = mapper.read(bbsno);

		String content = dto.getContent().replaceAll("\r\n", "<br>");
		dto.setContent(content);

		model.addAttribute("dto", dto);

		return "/bbs/read";
	}

	@GetMapping("/bbs/update")
	public String update(int bbsno, Model model) {
		model.addAttribute("dto", mapper.read(bbsno));

		return "/bbs/update";
	}

	@PostMapping("/bbs/update")
	public String update(BbsDTO dto, String oldfile, Model model, RedirectAttributes redirect,
			HttpServletRequest request) throws IOException {
		String basePath = new ClassPathResource("/static/storage").getFile().getAbsolutePath();

		System.out.println("MF:" + dto.getFilenameMF());
		if (dto.getFilenameMF().getSize() > 0) {
			if (oldfile != null)
				Utility.deleteFile(basePath, oldfile);
			dto.setFilename(Utility.saveFileSpring(dto.getFilenameMF(), basePath));
			dto.setFilesize((int) dto.getFilenameMF().getSize());
		}

		Map map = new HashMap();
		map.put("bbsno", dto.getBbsno());
		map.put("passwd", dto.getPasswd());
		boolean pflag = false;
		int cnt = mapper.passCheck(map);
		if (cnt > 0)
			pflag = true;
		boolean flag = false;

		if (pflag) {
			int cnt2 = mapper.update(dto);
			if (cnt2 > 0)
				flag = true;
		}

		if (!pflag) {
			return "/bbs/passwdError";
		} else if (flag) {
			redirect.addAttribute("col", request.getParameter("col"));
			redirect.addAttribute("word", request.getParameter("word"));
			redirect.addAttribute("nowPage", request.getParameter("nowPage"));
			return "redirect:/bbs/list";
		} else {
			return "/bbs/error";
		}
	}

	@PostMapping("/bbs/reply")
	public String reply(BbsDTO dto, HttpServletRequest request) throws IOException {
		String basePath = new ClassPathResource("/static/storage").getFile().getAbsolutePath();
		if (dto.getFilenameMF() != null || dto.getFilenameMF().getSize() > 0) {
			dto.setFilename(Utility.saveFileSpring(dto.getFilenameMF(), basePath));
			dto.setFilesize((int) dto.getFilenameMF().getSize());
		}else {
			dto.setFilename("");
		}

		Map map = new HashMap();
		map.put("grpno", dto.getGrpno());
		map.put("ansnum", dto.getAnsnum());

		mapper.upAnsnum(map);

		boolean flag = false;
		int cnt = mapper.createReply(dto);
		if (cnt > 0)
			flag = true;

		if (flag) {
			return "redirect:/bbs/list"; // 재요청
		} else {
			return "/bbs/error";
		}

	}

	@GetMapping("/bbs/reply")
	public String reply(int bbsno, Model model) {

		model.addAttribute("dto", mapper.readReply(bbsno));
		return "/bbs/reply";
	}

	@PostMapping("/bbs/delete")
	public String delete(int bbsno, String passwd, String oldfile, RedirectAttributes redirect, HttpServletRequest request) throws IOException {

		String upDir = new ClassPathResource("/static/storage").getFile().getAbsolutePath();
		Map map = new HashMap();
		map.put("bbsno", bbsno);
		map.put("passwd", passwd);
		int cnt = mapper.passCheck(map);

		String url = "/bbs/passwdError";

		if (cnt > 0) {

			try {
				mapper.delete(bbsno);
				redirect.addAttribute("col", request.getParameter("col"));
				redirect.addAttribute("word", request.getParameter("word"));
				redirect.addAttribute("nowPage", request.getParameter("nowPage"));
				url = "redirect:/bbs/list";
				if (oldfile != null)
					Utility.deleteFile(upDir, oldfile);
			} catch (Exception e) {
				e.printStackTrace();
				url = "/bbs/error";
			}

		}

		return url;
	}

	@GetMapping("/bbs/delete")
	public String delete(int bbsno, Model model) {
		int cnt = mapper.checkRefnum(bbsno);
		
		boolean flag = false;
		if(cnt > 0) flag = true;
		model.addAttribute("flag", flag);

		return "/bbs/delete";

	}
}
