package com.snoroc.stream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private Integer id;
    private String invoice;
    private List<LineItem> lineItems;
    private BigDecimal total;
}
