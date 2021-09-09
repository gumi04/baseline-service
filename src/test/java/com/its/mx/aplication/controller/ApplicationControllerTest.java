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
* Nombre de archivo: ApplicationControllerTest.java
* Autor: gcontrer
* Fecha de creación: 9 sep 2021
*/

package com.its.mx.aplication.controller;

import static org.junit.Assert.assertEquals;

import com.its.mx.application.controller.ApplicationController;
import com.its.mx.application.dto.InitialInvestmentDto;
import com.its.mx.application.dto.InvestmentYieldDto;
import com.its.mx.application.service.CompoundInsterestCalculator;
import com.its.mx.application.service.impl.CompoundInterestCalculatorImpl;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


/**
 * The Class ApplicationControllerTest.
 */
public class ApplicationControllerTest {

  /** The controller. */
  private ApplicationController controller;

  /** The initial investment. */
  private InitialInvestmentDto initialInvestment;

  /** The calculator. */
  private CompoundInsterestCalculator calculator;

  /**
   * Creates the values before to test.
   */
  @Before
  public void createValuesBeforeToTest() {
    // Crear calculadora
    this.calculator = new CompoundInterestCalculatorImpl();
    this.controller = new ApplicationController(this.calculator);

    // Crear los valores iniciales de la inversion
    this.initialInvestment = new InitialInvestmentDto();

    this.initialInvestment.setInitialInvestment(Double.valueOf(5000.00));
    this.initialInvestment.setYearlyInput(Double.valueOf(3000.0));
    this.initialInvestment.setYearlyInputIncrement(Integer.valueOf(1));
    this.initialInvestment.setInvestmentYears(5);
    this.initialInvestment.setInvestmentYield(Float.valueOf(21f));
  }

  /**
   * Should generate table yield.
   */
  @Test
  public void shouldGenerateTableYield() {
    List<InvestmentYieldDto> tableYield = controller.createTableYield(initialInvestment);

    assertEquals(5, tableYield.size());


    InvestmentYieldDto firstYear = tableYield.get(0);
    assertEquals(Double.valueOf(5000.00), firstYear.getInitialInvestment());
    assertEquals(Double.valueOf(3000.00), firstYear.getYearlyInput());
    assertEquals(Double.valueOf(1680.00), firstYear.getInvestmentYield());
    assertEquals(Double.valueOf(9680.00), firstYear.getFinalBalance());

  }
}
