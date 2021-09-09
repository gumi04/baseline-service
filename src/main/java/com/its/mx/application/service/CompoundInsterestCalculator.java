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
* Nombre de archivo: CompoundInsterestCalculator.java
* Autor: gcontrer
* Fecha de creación: 7 sep 2021
*/


package com.its.mx.application.service;


import com.its.mx.application.dto.InitialInvestmentDto;
import com.its.mx.application.dto.InvestmentYieldDto;
import java.util.ArrayList;

/**
 * The Interface CompoundInsterestCalculator.
 */
public interface CompoundInsterestCalculator {

  /**
   * Creates the revenue grid.
   *
   * @param initialInvestmentDto the initial investment dto
   * @return the array list
   */
  ArrayList<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestmentDto);

  /**
   * Validate input.
   *
   * @param initialInvestmentDto the initial investment dto
   * @return true, if successful
   */
  boolean validateInput(InitialInvestmentDto initialInvestmentDto);
}