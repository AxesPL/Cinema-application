package info.axes.controller;


import info.axes.model.Showing;
import info.axes.repository.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ShowingRestController {

    private ShowingRepository showingRepository;

    @Autowired
    public ShowingRestController(ShowingRepository showingRepository) {
        this.showingRepository = showingRepository;
    }

    @GetMapping(path="api/showings",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Showing>> allShowings() {
        List<Showing> allShowings = showingRepository.findAll();
        return ResponseEntity.ok(allShowings);
    }

    @GetMapping(path = "api/showings/showingdate/{showingDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Showing>> allShowingsByDate(@PathVariable String showingDate) throws ParseException {
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse(showingDate);
        Date date2 = new Date();
        date2.setTime(date1.getTime() + 86400000);
        List<Showing> allShowingsByDate = showingRepository.findAllByShowingDateBetween(date1, date2);
        return ResponseEntity.ok(allShowingsByDate);
    }


}
