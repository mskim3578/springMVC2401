package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import fileupload.FileCommand;

@Controller
public class UploadController {

	String uploadPath;

	@ModelAttribute
	public void init(HttpServletRequest request) {
		uploadPath = request.getServletContext().getRealPath("/") + "upload";
		System.out.println(uploadPath);
	}

	@GetMapping("/upload/form")
	public String form() {
		return "upload/fileUploadForm";
	}

	@PostMapping("/upload/multipartFile")
	public String uploadByMultipartFile(@RequestParam("f") MultipartFile multipartFile,
			@RequestParam("title") String title, Model model) throws IOException {
		if (!multipartFile.isEmpty()) {
			File file = new File(uploadPath, multipartFile.getOriginalFilename());
			multipartFile.transferTo(file);			
			model.addAttribute("title", title);
			model.addAttribute("fileName", multipartFile.getOriginalFilename());
			model.addAttribute("uploadPath", file.getAbsolutePath());
			return "upload/fileUploaded";
		}	
		return "upload/noUploadFile";	}
	
	

	@PostMapping(value = "/upload/multipartHttpServletRequest")
	public String uploadByMultipartHttpServletRequest(
			MultipartHttpServletRequest mutiReq, Model model) throws IOException {
		MultipartFile multipartFile = mutiReq.getFile("f");
		
		if (!multipartFile.isEmpty()) {
			File file = new File(uploadPath, multipartFile.getOriginalFilename());
			multipartFile.transferTo(file);
			model.addAttribute("title", mutiReq.getParameter("title"));
			model.addAttribute("fileName", multipartFile.getOriginalFilename());
			model.addAttribute("uploadPath", file.getAbsolutePath());
			return "upload/fileUploaded";
		}
		return "upload/noUploadFile";
	}
	@PostMapping(value = "/upload/commandObject")
	public String uploadByMultipartHttpServletRequest(
			FileCommand command, Model model) throws IOException {
		MultipartFile multipartFile = command.getF();
		if (!multipartFile.isEmpty()) {
			File file = new File(uploadPath, multipartFile.getOriginalFilename());
			multipartFile.transferTo(file);
			model.addAttribute("title", command.getTitle());
			model.addAttribute("fileName", multipartFile.getOriginalFilename());
			model.addAttribute("uploadPath", file.getAbsolutePath());
			return "upload/fileUploaded";
		}
		return "upload/noUploadFile";
	}
	

}




