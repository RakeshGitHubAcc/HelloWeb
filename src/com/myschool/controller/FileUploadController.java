package com.myschool.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myschool.constant.GlobalConstant;
import com.myschool.form.model.FileBucket;
import com.myschool.form.validator.FileValidator;

@Controller
public class FileUploadController {
	@Autowired
	FileValidator fileValidator;

	@RequestMapping(value = "/singleUpload", method = RequestMethod.GET)
	public String getSingleUploadPage(ModelMap model) {
		String viewName = GlobalConstant.ERROR_PAGE;
		FileBucket fileModel = new FileBucket();
		fileModel.setUserActionUrl(GlobalConstant.SINGLE_FILE_UPLOAD_ACTION);
		model.addAttribute("fileBucket", fileModel);
		viewName = GlobalConstant.SINGLE_FILE_UPLOAD;
		return viewName;
	}

	@RequestMapping(value = "/singleUpload", method = RequestMethod.POST)
	public String singleFileUpload(
			@Validated @ModelAttribute("fileBucket") FileBucket fileBucket,
			BindingResult result, ModelMap model) throws IOException {
		String viewName = GlobalConstant.ERROR_PAGE;
		try {
			// Validation code
			fileValidator.validate(fileBucket, result);
			if (result.hasErrors()) {
				System.out.println("validation errors");
				viewName=GlobalConstant.SINGLE_FILE_UPLOAD;
			} else {
				System.out.println("Fetching file");
				MultipartFile multipartFile = fileBucket.getFile();
				// Now do something with file...
				FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(
						GlobalConstant.FILE_UPLOAD_LOCATION
								+ fileBucket.getFile().getOriginalFilename()));
				String fileName = multipartFile.getOriginalFilename();
				model.addAttribute("fileName", fileName);
				viewName = GlobalConstant.WELCOME_PAGE;
			}
		} catch (Exception e) {
			// log error
			// redirect to error page
			System.out.println("inside doLogin()...Exception");
			e.printStackTrace();
		}
		return viewName;
	}
}
