package com.example.demo373.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：
 * @date ：Created in 2019/11/7 17:03
 * @description ： user
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int pid;
    private String name;






}
