package com.yiwang.ticket.service;

import com.yiwang.ticket.service.TicketService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《九品芝麻官》";
    }
}
