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
import com.dstcs.domain.EventInfo;
import com.dstcs.domain.User;
import com.dstcs.mongo.repositories.EventInfoRepository;
import com.dstcs.mongo.repositories.UserRepository;

@Controller
public class EventController {

	@Autowired
	private EventInfoRepository eventInfoRepository;
	 
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/eventinfoform", method = RequestMethod.GET)
	   public ModelAndView getEventInfoForm() {
	      return new ModelAndView("eventInfoForm", "command", new EventInfo());
	   }
	 
	 @RequestMapping(value = "/saveeventinfo", method = RequestMethod.POST)
	   public String saveEventInfo(@ModelAttribute("SpringWeb")EventInfo eventInfo, 
	   ModelMap model) {
		   
		   System.out.println("event name : "+eventInfo.getEventName());
		   System.out.println("event address : "+eventInfo.geteAddress());
		   System.out.println("event Longitude : "+eventInfo.geteLongitude());
		   System.out.println("event Latitude : "+eventInfo.geteLatitude());
		   System.out.println("fLongitude : "+eventInfo.getfLongitude());
		   System.out.println("fLatitude : "+eventInfo.getfLatitude());
		   System.out.println("tLongitude : "+eventInfo.gettLongitude());
		   System.out.println("tLatitude : "+eventInfo.gettLatitude());
		   System.out.println("fAddress : "+eventInfo.getfAddress());
		   System.out.println("tAddress : "+eventInfo.gettAddress());
		   System.out.println("tFromDate : "+eventInfo.getEventFrom());
		   System.out.println("tToDate : "+eventInfo.getEventTo());
		   System.out.println("tLevel : "+eventInfo.getLevel());
		   System.out.println("tDescription : "+eventInfo.getEventDescription());
		   
		   double distance = MapUtil.calculateDistance(eventInfo.getfLatitude(),eventInfo.getfLongitude(),eventInfo.gettLatitude(),eventInfo.gettLongitude(),'K');
		   System.out.println("distance : "+distance);
		   eventInfo.setDistance(distance);
		   eventInfo.setDate(new Date());
		   
		   /*User newUser = new User();
		   newUser.setFirstName("Pabasara");
		   newUser.setLastName("Wijerathne");
		   newUser.setAddress("Katuwawala");
		   newUser.setMobileNo("0771231233");
		   newUser.setUsername("pabasara");
		   newUser.setPassword("123123");
		   newUser.setPhoneNo("011234344");
		   newUser.setUserType("system");
		   
		   userRepository.save(newUser);*/
		   
		   User user = userRepository.findByUsername("pabasara");
		   System.out.println("password : "+user.getPassword());
		   eventInfo.setUser(user);
		   
		   eventInfoRepository.save(eventInfo);
		   
		   model.addAttribute("msg","Successfully saved..!!");
		   model.addAttribute("command", new EventInfo());
		   return "eventInfoForm";
	   }
}
