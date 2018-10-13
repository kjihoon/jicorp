package com.jh.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jh.Service.ContentsService;
import com.jh.Service.PicturesService;
import com.jh.common.CommandMap;
import com.jh.common.CommonMethod;
import com.jh.common.Msg;

@Controller
public class ContentsController implements Msg{
	@Autowired
	ContentsService contentService;
	@Autowired
	PicturesService picturesService;
	Logger log = Logger.getLogger(this.getClass());
	
	CommonMethod cmthd;
	
	/* NEW CONETNT PAGE */
	@RequestMapping("/load/contents")
	public String loadContents(CommandMap params,HttpServletRequest req) {
		req.setAttribute("center", "load");
		
		return "blog/index";
	}
	/* REVISE CONTENT  PAGE*/
	@RequestMapping("/edit/contents")
	public String editContents(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes) {
		Map<String,Object> content = contentService.selectContentsOne(params.getMap());
		List<Map<String,Object>> pictures =picturesService.selectPicturesList(params.getMap());
		
		String thumbNail = "";
		if (pictures.size()==0) {
			thumbNail = "img/prog.jpg";
		}else {
			thumbNail = (String) pictures.get(0).get("PICTURE_URL");
		}
		if (content == null) {
			redirectAttributes.addAttribute("msg", "contents"+SELECT_MSG_ERROR);
			return "redirect:/main/index";
		}
		
		req.setAttribute("thumbNail", thumbNail);
		req.setAttribute("center", "edit");
		req.setAttribute("content", content);
		return "blog/index";
	}
	
	
	
	/* CREATE CONETNS */
	@RequestMapping(value="/create/contents" ,produces = "text/html; charset=utf8",method=RequestMethod.POST) // POST
	public String createContents(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes,@RequestParam("img") MultipartFile img){
		log.info("img tes null test"+img.getOriginalFilename());
		log.info("path null test" + req.getContextPath()+"/resources/img/");
		String path = req.getRealPath("/resources/img");
		
		log.info("path real test"+ path);
		//boolean flag = cmthd.imgHandle(req.getContextPath()+"/resources/img/",img);
		boolean flag = true;
	    if (!img.isEmpty()) {
	    	
	    	String originalFilename = img.getOriginalFilename(); // fileName.jpg
	        path =  path+originalFilename;
	        log.info("file real path" + path);
	        try {
	            byte[] bytes = img.getBytes();
	            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path)));
	            stream.write(bytes);
	            stream.close();
	        } catch (Exception e) {
	        	log.error(e.getMessage());
	        	flag = false;
	        }
	    } else {
	    	flag = false;
	    }
		
		log.info("img test" + flag);
		Object result_con = contentService.insertContents(params.getMap());
		//Object result_pic = contentService.insertContents(params.getMap());
		if (result_con == null/* || result_pic == null*/) {
			redirectAttributes.addAttribute("msg", "content"+INSERT_MSG_ERROR);
		}
		return "redirect:/main/index";
	}
	
	/* UPDATE CONETNS */
	@SuppressWarnings("unused")
	@RequestMapping(value="/update/contents" ,produces = "text/html; charset=utf8",method=RequestMethod.POST) // POST
	public String updateContents(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes){
		Object result =contentService.updateContents(params.getMap());
		if (result == null) {
			redirectAttributes.addAttribute("msg","content"+UPDATE_MSG_ERROR);
		}
		return "redirect:/main/index";
	}
	
	/* SELECT ONE CONENTES */
	@RequestMapping("/select/content")
	public String selectContents(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes){	
		Map<String,Object> content =contentService.selectContentsOne(params.getMap());
		Map<String,Object> arrow =contentService.selectArrow(params.getMap());
		List<Map<String,Object>> pictures =picturesService.selectPicturesList(params.getMap());
		
		String thumbNail = "";
		if (pictures.size()==0) {
			thumbNail = "img/prog.jpg";
		}else {
			thumbNail = (String) pictures.get(0).get("PICTURE_URL");
		}
		
		if (content == null||arrow == null) {
			redirectAttributes.addAttribute("msg", "contents"+SELECT_MSG_ERROR);
			return "redirect:/main/index";
		}
		
		req.setAttribute("thumbNail", thumbNail);
		req.setAttribute("arrow", arrow);
		req.setAttribute("content", content);
		req.setAttribute("center","post");
		return "blog/index";
	}
	
	@RequestMapping("/selectlist/contents")
	@ResponseBody
	public String selectContentsList() throws Exception {
		List<Map<String,Object>> result =contentService.selectContentsList();
		return result.toString();
	}
	
	

}
