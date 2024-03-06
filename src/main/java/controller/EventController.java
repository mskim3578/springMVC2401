package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import event.Event;
import event.EventService;
import event.EventType;
import event.SearchOption;

@Controller
@RequestMapping("/event/")
public class EventController {
	
	private EventService eventService = new EventService();
	
	@ModelAttribute("recEventList")  //model.addAttribute("recEventList",return List<Event>)
	public List<Event> recommend() {
		return eventService.getRecommendedEventService();
	}
	
	
	
	
	
	@RequestMapping("list")
	public String list(Model model, SearchOption option) {  //Model : Request 역활
		System.out.println(option);
		List<Event> eventList = eventService.getOpenedEventList(option);
		System.out.println(eventList.size());
		model.addAttribute("eventList", eventList);  //request.setAttribute
		model.addAttribute("eventTypes", EventType.values());  //enum
		return "event/list";
	}
	
	@InitBinder  //400 에러 방지
	protected void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(
				new SimpleDateFormat("yyyyMMdd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	private static final String REDIRECT_EVENT_LIST = "redirect:/event/list";
	@RequestMapping("detail2")
	public String detail(HttpServletRequest request,    Model model) {  //Model : Request 역활
		String id = request.getParameter("id");
		if (id == null)
			return REDIRECT_EVENT_LIST;
		Long eventId = null;
		try {
			eventId = Long.parseLong(id);  //id="a"
		} catch (NumberFormatException e) {
			return REDIRECT_EVENT_LIST;
		}
		Event event = getEvent(eventId);
		if (event == null)
			return REDIRECT_EVENT_LIST;

		model.addAttribute("event", event);
		return "event/detail";  
	}
	
	private Event getEvent(Long eventId) {
		return eventService.getEvent(eventId);
	}
	
	@RequestMapping("/detail")
	public String detail2(@RequestParam("id") long eventId,    Model model) {
	
		Event event = getEvent(eventId);
		if (event==null) {
			return REDIRECT_EVENT_LIST;
		}
		model.addAttribute("event", event);
		return "event/detail"; 
	}
	
} //class end
