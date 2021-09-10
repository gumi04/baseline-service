/* 
* This program is free software: you can redistribute it and/or modify  
* it under the terms of the GNU General Public License as published by  
* the Free Software Foundation, version 3.
*
* This program is distributed in the hope that it will be useful, but 
* WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
* General Public License for more details.
*
* Nombre de archivo: InvestmentYieldDto.java
* Autor: gcontrer
* Fecha de creación: 6 sep 2021
*/

package com.its.mx.application.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class InvestmentYieldDto.
 */

@Setter
@Getter
public class InvestmentYieldDto {

  /** The investment year. */
  private Integer investmentYear;

  /** The initial investment. */
  private Double initialInvestment;

  /** The yearly input. */
  private Double yearlyInput;

  /** The investment yield. */
  private Double investmentYield;

  /** The final balance. */
  private Double finalBalance;

}
