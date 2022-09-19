package com.example.theater.controller

import com.example.theater.domain.CheckAvailabilityBackingBean
import com.example.theater.repository.SeatRepository
import com.example.theater.service.BookingService
import com.example.theater.service.TheaterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
class MainController {

    @Autowired
    lateinit var theaterService: TheaterService
    @Autowired
    lateinit var bookingService: BookingService
    @Autowired
    lateinit var seatRepository: SeatRepository

    @RequestMapping("")
    fun homePage(): ModelAndView {
        return ModelAndView("seatBooking", "bean", CheckAvailabilityBackingBean())
    }

    @RequestMapping("/checkAvailability", method= arrayOf(RequestMethod.POST))
    fun checkAvailability(bean: CheckAvailabilityBackingBean): ModelAndView{
        val selectedSeat = theaterService.find(bean.selectedSeatNum, bean.selectedSeatRow)
        val result = bookingService.isSeatFree(selectedSeat)
        bean.result = "Seat $selectedSeat is "+if (result) "available" else "booked"
        return ModelAndView("seatBooking","bean",bean)
    }

    @RequestMapping("bootstrap")
    fun createIntialData(): ModelAndView{
        val seats = theaterService.seats
        seatRepository.saveAll(seats)
        return homePage()
    }

}