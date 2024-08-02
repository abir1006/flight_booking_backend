package flight_booking.service;

import flight_booking.dto.ReportDto;

public interface ReportService extends GenericService<Long, ReportDto> {
    ReportDto generateReport(String type);
}