package com.dstcs.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dstcs.common.util.MapUtil;
import com.dstcs.domain.RoadDevelopmentInfo;
import com.dstcs.mongo.repositories.RoadDevelopmentRepository;

@Controller
public class RoadDevelopmentController {

	@Autowired
	private RoadDevelopmentRepository roadDevelopmentRepository;
	
	
	   @RequestMapping(value = "/roaddevelopmentform", method = RequestMethod.GET)
	   public ModelAndView getRoadDevelopmentForm() {
	      return new ModelAndView("roadDevelopmentForm", "command", new RoadDevelopmentInfo());
	   }
	   
	   @RequestMapping(value = "/checkroaddevelopment", method = RequestMethod.GET)
	   public ModelAndView checkroaddevelopment() {
	      return new ModelAndView("checkrd");
	   }
	   
	   @RequestMapping(value = "/saveroaddevelopmentinfo", method = RequestMethod.POST)
	   public String saveRoadDevelopmentInfo(@ModelAttribute("SpringWeb")RoadDevelopmentInfo roadDevelopmentInfo, 
	   ModelMap model) {
		   
		   System.out.println("fLongitude : "+roadDevelopmentInfo.getfLongitude());
		   System.out.println("fLatitude : "+roadDevelopmentInfo.getfLatitude());
		   System.out.println("tLongitude : "+roadDevelopmentInfo.gettLongitude());
		   System.out.println("tLatitude : "+roadDevelopmentInfo.gettLatitude());
		   System.out.println("fAddress : "+roadDevelopmentInfo.getfAddress());
		   System.out.println("tAddress : "+roadDevelopmentInfo.gettAddress());
		   System.out.println("tFromDate : "+roadDevelopmentInfo.getFromDate());
		   System.out.println("tToDate : "+roadDevelopmentInfo.getToDate());
		   System.out.println("tLevel : "+roadDevelopmentInfo.getLevel());
		   System.out.println("tDescription : "+roadDevelopmentInfo.getDescription());
		   
		   /*RoadDevelopmentInfo developmentInfo = new RoadDevelopmentInfo();
		   developmentInfo.setDescription(roadDevelopmentInfo.getDescription());
		   developmentInfo.setfAddress(roadDevelopmentInfo.getfAddress());
		   developmentInfo.setfLatitude(roadDevelopmentInfo.getfLatitude());
		   developmentInfo.setfLongitude(roadDevelopmentInfo.getfLongitude());
		   developmentInfo.setFromDate(roadDevelopmentInfo.getFromDate());
		   developmentInfo.setLevel(roadDevelopmentInfo.getLevel());
		   developmentInfo.settAddress(roadDevelopmentInfo.gettAddress());
		   developmentInfo.settLatitude(roadDevelopmentInfo.gettLatitude());
		   developmentInfo.settLongitude(roadDevelopmentInfo.gettLongitude());
		   developmentInfo.setToDate(roadDevelopmentInfo.getToDate());*/
		   
		   double distance = MapUtil.calculateDistance(roadDevelopmentInfo.getfLatitude(),roadDevelopmentInfo.getfLongitude(),roadDevelopmentInfo.gettLatitude(),roadDevelopmentInfo.gettLongitude(),'K');
		   System.out.println("distance : "+distance);
		   roadDevelopmentInfo.setDistance(distance);
		   roadDevelopmentInfo.setDate(new Date());
		   
		   roadDevelopmentRepository.save(roadDevelopmentInfo);
		   
		   model.addAttribute("msg","Successfully saved..!!");
		   model.addAttribute("command", new RoadDevelopmentInfo());
		   return "roadDevelopmentForm";
	   }
}
