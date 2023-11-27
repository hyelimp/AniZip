package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	// Page300 소스 코딩할 때, 아래 5줄 소스는 주석 처리를 해줍니다.
//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list 글 목록 조회를 처리합니다!");
//		model.addAttribute("list", service.getList());
//	}
	
	// Page300 : 페이징 매개변수 적용 /list 소스 코딩을 아래와 같이 5줄 추가해 줍니다.
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list 글 목록 조회를 처리합니다!" + cri);
		model.addAttribute("list", service.getList(cri));
		
		int total = service.getTotal(cri);
		
		log.info("total 전체 데이터 수 = " + total);		
													// total 변수 데이터수 = 123개로 가정함
//		model.addAttribute("pageMaker", new PageDTO(cri, 123));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}	
	
	// Page238 11.3 등록 입력 페이지와 등록 처리
	// 게시물의 등록 작업은 POST 방식으로 처리하지만,
	// 화면에서 입력을 받아야 하므로 GET 방식으로 입력 페이지를 볼 수 있도록
	// BoardController에 메서드를 추가해 줍니다.
	// register() 메서드는 입력 페이지를 보여주는 역할만을 하기 때문에
	// 별도의 처리가 필요하지 않습니다.
	@GetMapping("/register")
	public void register() {
		
	}
	
	
	@PostMapping("/register") // @PostMapping() POST 방식 URL 메핑
	// register() 메서드는 String을 리턴 타입으로 지정하고, Redirect Attributes를
	// 파라미터로 지정합니다. 이것은 등록 작업이 끝난 후 다시 목록 화면으로 이동하기 위함이며,
	// 추가적으로 새롭게 등록된 게시물의 번호를 같이 전달하기 위해서 RedirectAttributes를
	// 이용합니다. 이때, 리턴 시에는 "redirect:" 접두어를 사용하는데,
	// 이것을 이용하면 스프링 MVC가 내부적으로 response.sendRedirect()를 처리해 주기
	// 때문에 편리합니다.
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register(등록) : " + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());		
		return "redirect:/board/list";
	}
	
	// 조회 처리와 테스트 : 등록처리와 유사하게 조회 처리도 BoardController를 이용해서
	// 처리할 수 있습니다. 특별한 경우가 아니라면 조회는 GET 방식으로 처리하므로,
	// @GetMapping을 이용합니다.
//	@GetMapping("/get")
	// Page316 소스 코딩할 때, 주석을 제외한 아래 5줄 소스 주석 처리합니다.
//	@GetMapping({"/get", "/modify"})
	// BoardController의 get() 메서드에는 bno 값을 좀 더 명시적으로 처리하는
	// @RequestParam을 이용해서 지정합니다.(파라미터 이름과 변수 이름을 기준으로 동작하기
	// 때문에 생략해도 됩니다). 또한 화면 쪽으로 해당 번호의 게시물을 전달해야 하므로
	// Model을 파라미터로 지정합니다.	
//	public void get(@RequestParam("bno") Long bno, Model model) {
//		log.info("/get 조회 처리");
//		log.info("/get or modify 조회 처리");
//		model.addAttribute("board", service.get(bno));
//	}
	
	// Page316 : 조회 페이지에서 다시 목록 페이지로 이동 : 페이지 번호 유지를 위한 BoardController 소스 코딩을 해줍니다.
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify 조회 처리");
		model.addAttribute("board", service.get(bno));
	}
	
	// 수정 처리와 테스트 : 수정 작업은 등록과 비슷합니다. 변경된 내용을 수집해서
	// BoardVO 파라미터로 처리하고, BoardService를 호출합니다. 수정 작업을 시작하는
	// 화면의 경우에는 GET 방식으로 접근하지만 실제 작업은 POST 방식으로 동작하므로
	// @PostMapping을 이용해서 처리합니다.
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify: 수정 처리 " + board);
		// service.modify() 메서드는 수정 여부를 boolean으로 처리하므로
		// 이것을 이용해서 성공한 경우에만 RedirectAttributes에 추가합니다.
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());	
		rttr.addAttribute("type", cri.getType());	
		rttr.addAttribute("keyword", cri.getKeyword());		
		
		return "redirect:/board/list";
	}
	
	// 삭제 처리와 테스트 : 삭제 처리도 조회와 유사하게 BoardController와 테스트 코드를
	// 작성합니다. 삭제는 반드시 POST 방식으로만 처리합니다.
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove: 삭제 처리 " + bno);
		// BoardController의 remove() 메서드는 삭제 후 페이지의 이동이 필요하므로
		// RedirectAttributes를 파라미터로 사용하고, 'redirect'를 이용해서
		// 삭제 처리 후에 다시 목록 페이지로 이동 처리 합니다.		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());	
		rttr.addAttribute("type", cri.getType());	
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
}
