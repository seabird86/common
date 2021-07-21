package com.anhnt.common.domain.payment.event;

import com.anhnt.common.domain.payment.constant.OrderState;
import io.eventuate.tram.events.common.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent implements DomainEvent {
  private Long id;
  private Long customerId;
  private OrderState state;
  private BigDecimal amount;
}
