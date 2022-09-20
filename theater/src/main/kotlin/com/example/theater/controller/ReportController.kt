package com.example.theater.controller

import com.example.theater.service.ReportingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.websocket.server.PathParam
import kotlin.reflect.full.declaredMemberFunctions

@Controller
@RequestMapping("/reports")
class ReportController {

    @Autowired
    lateinit var reportingService: ReportingService

    fun getListOfReports() = reportingService::class.declaredMemberFunctions.map { it.name }

    @RequestMapping("")
    fun main(): ModelAndView = ModelAndView("reports", mapOf("reports" to getListOfReports()))

    @RequestMapping("/getReport")
    fun selectedReport(@PathParam("report")report : String): ModelAndView {
        //mengambil function yg ada di reportingService dengan nama yg sudah di set
        val matchedReport = reportingService::class.declaredMemberFunctions.filter { it.name == report }.firstOrNull()
        //akses function yg sudah di ambil
        val result = matchedReport?.call(reportingService) ?: ""
        return ModelAndView("reports",mapOf("reports" to getListOfReports(), "result" to result))
    }
}