package edu.nsimat.lil.learningspring.webservice;

import edu.nsimat.lil.learningspring.business.ReservationService;
import edu.nsimat.lil.learningspring.business.RoomReservation;
import edu.nsimat.lil.learningspring.data.Guest;
import edu.nsimat.lil.learningspring.data.Room;
import edu.nsimat.lil.learningspring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebServiceController {
    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public WebServiceController(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @GetMapping(path = "/reservations", produces = "application/json")
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false)String dateString){
        Date date = dateUtils.createDateFromDateString(dateString);
        return reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping("/guests")
    public List<Guest> getGuests(){
        return reservationService.getHotelGuests();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest){
        reservationService.addGuest(guest);
    }

    @GetMapping("/rooms")
    public List<Room> getRooms(){
        return reservationService.getRooms();
    }
}
