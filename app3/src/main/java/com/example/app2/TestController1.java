package com.example.app2;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.app2.model.file.MyFile;

@Controller
public class TestController1 {

	@GetMapping("/file/uploadForm")
	public String uploadForm() {
		return "file/form";
	}

	@PostMapping("/file/upload")
	public String upload(@RequestParam("file") MultipartFile f) {
		String path = "C:\\Users\\Playdata\\Desktop\\workspace\\app3\\src\\main\\resources\\static\\img\\";
		String fname = path + f.getOriginalFilename();
		try {
			f.transferTo(new File(fname));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "file/list";
	}

	@PostMapping("/file/upload2")
	public String upload2(MyFile mf) {
		String path = "C:\\Users\\Playdata\\Desktop\\workspace\\app3\\src\\main\\resources\\static\\img\\";
		MultipartFile f = mf.getFile();
		String fname = path + f.getOriginalFilename();
		System.out.println(fname);
		try {
			f.transferTo(new File(fname));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "file/list";
	}
}
