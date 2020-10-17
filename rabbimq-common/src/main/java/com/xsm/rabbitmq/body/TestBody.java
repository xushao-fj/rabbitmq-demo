package com.xsm.rabbitmq.body;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xsm
 * @Date 2020/10/17 12:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestBody implements Serializable{

    private static final long serialVersionUID = 3283632551396862563L;
    private Integer num;

    private String msg;

}
