package com.example.theater.controller

import com.example.theater.domain.CheckAvailabilityBackingBean
import com.example.theater.domain.Seat
import com.example.theater.repository.BookingRepository
import com.example.theater.repository.PerformanceRepository
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
    @Autowired
    lateinit var performanceRepository: PerformanceRepository
    @Autowired
    lateinit var bookingRepository: BookingRepository

    @RequestMapping("")
    fun homePage(): ModelAndView {
        val model = mapOf("bean" to CheckAvailabilityBackingBean(),
            "performances" to performanceRepository.findAll(),
            "seatNums" to 1..36,
            "seatRows" to 'A'..'O')

        return ModelAndView("seatBooking", model)
    }

    @RequestMapping("/checkAvailability", method= arrayOf(RequestMethod.POST))
    fun checkAvailability(bean: CheckAvailabilityBackingBean): ModelAndView{
        //!! = not null to null? handler easy way
        val selectedSeat: Seat = bookingService.findSeat(bean.selectedSeatNum, bean.selectedSeatRow)!!
        val selectedPerfomance = performanceRepository.findById(bean.selectedPerformance!!).get()
        bean.seat = selectedSeat
        bean.performance = selectedPerfomance
        val result = bookingService.isSeatFree(selectedSeat, selectedPerfomance)
        bean.available = result
        if (!result) {
            bean.booking = bookingService.findBooking(selectedSeat,selectedPerfomance)
        }

        val model = mapOf("bean" to bean,
            "performances" to performanceRepository.findAll(),
            "seatNums" to 1..36,
            "seatRows" to 'A'..'O')

        return ModelAndView("seatBooking",model)
    }

    @RequestMapping("booking",method = arrayOf(RequestMethod.POST))
    fun bookASeat(bean: CheckAvailabilityBackingBean): ModelAndView {
        val bookedSeat = bookingService.reserveSeat(bean.seat!!, bean.performance!!, bean.customerName)
        return ModelAndView("bookingConfirmed","booking", bookedSeat)

    }

//    @RequestMapping("bootstrap")
//    fun createIntialData(): ModelAndView{
//        val seats = theaterService.seats
//        seatRepository.saveAll(seats)
//        return homePage()
//    }

}