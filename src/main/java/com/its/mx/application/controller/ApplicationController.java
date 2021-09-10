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
* Nombre de archivo: ApplicationController.java
* Autor: gcontrer
* Fecha de creación: 8 sep 2021
*/


package com.its.mx.application.controller;


import com.its.mx.application.dto.InitialInvestmentDto;
import com.its.mx.application.dto.InvestmentYieldDto;
import com.its.mx.application.service.CompoundInsterestCalculator;
import java.util.List;

/**
 * The Class ApplicationController.
 */
public class ApplicationController {

  /** The calculator. */
  private CompoundInsterestCalculator calculator;

  /**
   * Instantiates a new application controller.
   *
   * @param calculator the calculator
   */
  public ApplicationController(CompoundInsterestCalculator calculator) {
    this.calculator = calculator;
  }

  /**
   * Creates the table yield.
   *
   * @param initialInvestmentDto the initial investment dto
   * @return the array list
   */
  public List<InvestmentYieldDto> createTableYield(InitialInvestmentDto initialInvestmentDto) {

    if (calculator.validateInput(initialInvestmentDto)) {
      return calculator.createRevenueGrid(initialInvestmentDto);
    }

    throw new CalculatorInputException(
        "No es posible procesar su solicitud con los datos proporcionados.");

  }

}
