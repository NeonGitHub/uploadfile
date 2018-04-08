package cn.fileUpload.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UpLoadController {

	@RequestMapping(value = "/upload")
	public String uploadPicture(HttpServletRequest requset, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {

		if (!file.isEmpty()) {

			String realPath = requset.getSession().getServletContext().getRealPath("/images/");
			String filename = file.getOriginalFilename();
			System.out.println(filename);
			File filepath=new File(realPath,filename);
			if(!filepath.exists()) {
				filepath.mkdirs();
			}
			System.out.println(realPath);
			file.transferTo(new File(realPath+File.separator+filename));
			return "success";
		} else {
			return "error";
		}

	}

}
