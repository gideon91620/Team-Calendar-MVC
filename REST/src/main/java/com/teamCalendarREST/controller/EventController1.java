package com.teamCalendarREST.controller;
/*
 * package com.teamCalendar.controller;
 

import com.teamCalendar.model.Event;
import com.teamCalendar.service.EventService;




	import java.io.IOException;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet("/EventController")
	public class EventController extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private EventService eventService;

	    public EventController() {
	        eventService = new EventService();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");
	        if (action == null) {
	            action = "list";
	        }
	        switch (action) {
	        case "create":
	            createEvent(request, response);
	            break;
	        case "read":
	            readEvent(request, response);
	            break;
	        case "update":
	            updateEvent(request, response);
	            break;
	        case "delete":
	            deleteEvent(request, response);
	            break;
	        case "list":
	            listEvents(request, response);
	            break;
	        default:
	            listEvents(request, response);
	            break;
	        }
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }

	    private void listEvents(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        List<Event> events = eventService.getAllEvents();
	        request.setAttribute("events", events);
	    }
	    
	    private void createEvent(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String name = request.getParameter("eventName");
	        String type = request.getParameter("eventType");
	        String location = request.getParameter("eventLocation");
	        String date = request.getParameter("eventDate");
	        String time = request.getParameter("eventTime");
	        String reason = request.getParameter("eventReason");

	        Event event = new Event();
	        event.setName(name);
	        event.setType(type);
	        event.setLocation(location);
	        event.setDate(date);
	        event.setTime(time);
	        event.setReason(reason);

	        eventService.addEvent(event);

	        listEvents(request, response);
	    }

	    private void readEvent(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String name = request.getParameter("eventName");
	        Event event = eventService.getEvent(name);
	        request.setAttribute("event", event);
	        request.getRequestDispatcher("event.jsp").forward(request, response);
	    }

	    private void updateEvent(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String name = request.getParameter("eventName");
	        String type = request.getParameter("eventType");
	        String location = request.getParameter("eventLocation");
	        String date = request.getParameter("eventDate");
	        String time = request.getParameter("eventTime");
	        String reason = request.getParameter("eventReason");

	        Event event = eventService.getEvent(name);
	        event.setType(type);
	        event.setLocation(location);
	        event.setDate(date);
	        event.setTime(time);
	        event.setReason(reason);

	        eventService.updateEvent(event);

	        listEvents(request, response);
	    }

	    private void deleteEvent(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String name = request.getParameter("eventName");
	        eventService.deleteEvent(name);

	        listEvents(request, response);
	    }
	}
	
*/
	
	/*
	@Autowired
    EventService eventService; 
    private static Logger logger = LoggerFactory.getLogger(EventController.class);
    
    @InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	@RequestMapping(value = "/users/add", method = RequestMethod.POST)
	public ResponseEntity<Void> register(@RequestBody @Valid Event form) {
		logger.info("register success {}", form);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	*/
		

