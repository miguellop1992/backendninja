package com.udemy.backendninja.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static final String COURSE_VIEW = "courses";
	private static final Log LOG = LogFactory.getLog(CourseController.class);

	private int index = -1;

	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;

	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;

	@GetMapping("/listcourses")
	public ModelAndView listAllCourse() {
		LOG.info("Call: listAllCourse()");
		ModelAndView mav = new ModelAndView(COURSE_VIEW);
		List<Course> list = courseService.listAllCourse();
		mav.addObject("course", new Course());
		if (index > -1)
			mav.addObject("updateCourse", list.get(index));
		mav.addObject("courses", list);
		return mav;

	}

	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		LOG.info("Call: addCourse() --Param: " + course);

		courseService.addCourse(course);
		index = -1;

		return "redirect:/courses/listcourses";
	}

	@PostMapping("/updatecourse")
	public String updateCourse(@ModelAttribute("course") Course course) {
		LOG.info("Call: updateCourse() --Param: " + course);
		courseService.updateCourse(course);
		index = -1;

		return "redirect:/courses/listcourses";
	}

	@GetMapping("/deletecourse/{id}")
	public String deleteCourse(@PathVariable("id") String id) {
		LOG.info("Call: deletecourse() --Param: " + id);

		courseService.removeCourse(Integer.valueOf(id));
		index = -1;

		return "redirect:/courses/listcourses";
	}

	@GetMapping("/updatecourse/{id}")
	public String updatecourse(@PathVariable("id") Integer id) {
		LOG.info("Call: updatecourse() --Param: " + id);

		index = id;

		return "redirect:/courses/listcourses";
	}

}
