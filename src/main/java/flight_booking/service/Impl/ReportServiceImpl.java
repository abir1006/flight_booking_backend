package flight_booking.service.Impl;

import flight_booking.domain.Report;
import flight_booking.dto.ReportDto;
import flight_booking.repositories.ReportRepository;
import flight_booking.service.ReportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReportServiceImpl extends GenericServiceImpl<Report, Long, ReportDto> implements ReportService {

    private final ReportRepository reportRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, ModelMapper modelMapper) {
        super(reportRepository, modelMapper, Report.class, ReportDto.class);
        this.reportRepository = reportRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReportDto generateReport(String type) {
        String content = "Report content for type: " + type; // Placeholder for actual content generation logic
        Report report = new Report();
        report.setType(type);
        report.setGeneratedDate(LocalDate.now());
        report.setContent(content);
        report = reportRepository.save(report);
        return modelMapper.map(report, ReportDto.class);
    }
}