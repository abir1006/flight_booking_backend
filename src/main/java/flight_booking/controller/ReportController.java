package flight_booking.controller;

import flight_booking.controller.genericcontroller.GenericController;
import flight_booking.dto.ReportDto;
import flight_booking.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/reports")
public class ReportController extends GenericController<Long, ReportDto> {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        super(reportService);
        this.reportService = reportService;
    }

    @PostMapping("/generate")
    public ResponseEntity<ReportDto> generateReport(@RequestParam String type) {
        ReportDto reportDto = reportService.generateReport(type);
        return ResponseEntity.ok(reportDto);
    }
}