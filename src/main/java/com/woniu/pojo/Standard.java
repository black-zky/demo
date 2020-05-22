package com.woniu.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * standard
 * @author 
 */
@Data
public class Standard implements Serializable {
    private Integer id;

    private String stdnum;

    private String zhname;

    private String version;

    private String stdkeys;

    private Date releasedate;

    private Date impldate;

    private String packagepath;

    private static final long serialVersionUID = 1L;
}