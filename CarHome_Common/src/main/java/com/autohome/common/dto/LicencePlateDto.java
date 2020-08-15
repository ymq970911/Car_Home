package com.autohome.common.dto;

import com.autohome.common.jsonpojo.LicencePlate;
import lombok.Data;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-09 22:01
 **/
@Data
public class LicencePlateDto {
    private Integer cid;
    private Integer uid;
    private Integer uniqueId;
    private LicencePlate licence_plate;
}
