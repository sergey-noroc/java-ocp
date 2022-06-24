package com.snoroc.stream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LineItem {

    private Integer id;
    private String item;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal total;
}
