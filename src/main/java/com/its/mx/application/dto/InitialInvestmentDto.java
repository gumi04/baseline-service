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
* Nombre de archivo: InitialInvestmentDto.java
* Autor: gcontrer
* Fecha de creación: 7 sep 2021
*/


package com.its.mx.application.dto;

import lombok.Setter;

/**
 * The Class InitialInvestmentDto.
 */

@Setter
public class InitialInvestmentDto {

  /** The initial investment. */
  private Double initialInvestment;

  /** The yearly input. */
  private Double yearlyInput;

  /** The yearly input increment. */
  private Integer yearlyInputIncrement;

  /** The investment yield. */
  private float investmentYield;

  /** The investment years. */
  private Integer investmentYears;



  /**
   * Gets the initial investment.
   *
   * @return the initial investment
   */
  public Double getInitialInvestment() {
    return initialInvestment;
  }



  /**
   * Gets the yearly input.
   *
   * @return the yearly input
   */
  public Double getYearlyInput() {
    if (yearlyInput == null) {
      return 0.0;
    } else {
      return yearlyInput;
    }

  }



  /**
   * Gets the yearly input increment.
   *
   * @return the yearly input increment
   */
  public Integer getYearlyInputIncrement() {
    if (yearlyInputIncrement == null) {
      return 0;
    } else {
      return yearlyInputIncrement;
    }
  }



  /**
   * Gets the investment yield.
   *
   * @return the investment yield
   */
  public float getInvestmentYield() {
    return investmentYield;
  }



  /**
   * Gets the investment years.
   *
   * @return the investment years
   */
  public Integer getInvestmentYears() {
    return investmentYears;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "InitialInvestmentDto [initialInvestment=" + initialInvestment + ", yearlyInput="
        + yearlyInput + ", yearlyInputIncrement=" + yearlyInputIncrement + ", investmentYield="
        + investmentYield + ", investmentYears=" + investmentYears + "]";
  }

}
