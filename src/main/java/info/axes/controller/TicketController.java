package info.axes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {
    @GetMapping(path="/tickets")
    public String ticket(@RequestParam(name = "showingid") Long showingId){
        return "ticket.html";
    }
    }

