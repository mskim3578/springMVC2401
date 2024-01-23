package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("index.kic")
	public String name() {
        
		return "index2";
	}
	
	@RequestMapping("index2.kic")
	 public void name2(HttpServletResponse  response) throws IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("안녕하세요  kic 입니다");
		writer.flush();		
	}
	
}
