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
import com.its.mx.application.service.impl.CompoundInterestCalculatorImpl;
import java.util.ArrayList;

/**
 * The Class ApplicationController.
 */
public class ApplicationController {

  /** The calculator. */
  private static CompoundInsterestCalculator calculator = new CompoundInterestCalculatorImpl();

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {

    InitialInvestmentDto initialInvestmentDto = new InitialInvestmentDto();

    initialInvestmentDto.setInitialInvestment(5000.00);
    initialInvestmentDto.setYearlyInput(3000.0);
    initialInvestmentDto.setYearlyInputIncrement(1);
    initialInvestmentDto.setInvestmentYears(5);
    initialInvestmentDto.setInvestmentYield(21);


    if (ApplicationController.calculator.validateInput(initialInvestmentDto)) {
      ArrayList<InvestmentYieldDto> investmentYieldDto =
          ApplicationController.calculator.createRevenueGrid(initialInvestmentDto);
      investmentYieldDto.forEach(System.out::println);
    } else {
      System.out.println("No es posible procesar su solicitud con los datos proporcionados .");
    }

  }

}
