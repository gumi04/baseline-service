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
* Nombre de archivo: CompoundInterestCalculatorImpl.java
* Autor: gcontrer
* Fecha de creación: 7 sep 2021
*/


package com.its.mx.application.service.impl;


import com.its.mx.application.dto.InitialInvestmentDto;
import com.its.mx.application.dto.InvestmentYieldDto;
import com.its.mx.application.service.CompoundInsterestCalculator;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 * The Class CompoundInterestCalculatorImpl.
 */
@Service
public class CompoundInterestCalculatorImpl implements CompoundInsterestCalculator {

  /**
   * Creates the revenue grid.
   *
   * @param initialInvestmentDto the initial investment dto
   * @return the array list
   */
  @Override
  public ArrayList<InvestmentYieldDto> createRevenueGrid(
      InitialInvestmentDto initialInvestmentDto) {

    ArrayList<InvestmentYieldDto> years = new ArrayList<>();
    for (int i = 0; i < initialInvestmentDto.getInvestmentYears(); i++) {

      InvestmentYieldDto investmentYieldDto = new InvestmentYieldDto();
      investmentYieldDto.setInvestmentYear(i + 1);

      if (i != 0) {
        investmentYieldDto.setInitialInvestment(years.get(i - 1).getFinalBalance());
        Double yearlyInput = (years.get(i - 1).getYearlyInput()) 
            *  (1 + ((double) initialInvestmentDto.getYearlyInputIncrement() / 100));
        investmentYieldDto.setYearlyInput((double) Math.round(yearlyInput));
      } else {
        investmentYieldDto.setInitialInvestment(initialInvestmentDto.getInitialInvestment());
        investmentYieldDto.setYearlyInput(initialInvestmentDto.getYearlyInput());
      }
      
      Double investmentYield = (investmentYieldDto.getInitialInvestment() 
          + investmentYieldDto.getYearlyInput()) 
          * (initialInvestmentDto.getInvestmentYield() / 100);
      investmentYieldDto.setInvestmentYield((double) Math.round(investmentYield));

      investmentYieldDto.setFinalBalance(investmentYieldDto.getInitialInvestment()
          + investmentYieldDto.getYearlyInput() + investmentYieldDto.getInvestmentYield());

      years.add(investmentYieldDto);
    }
    return years;
  }

  /**
   * Validate input.
   *
   * @param initialInvestmentDto the initial investment dto
   * @return true, if successful
   */
  @Override
  public boolean validateInput(InitialInvestmentDto initialInvestmentDto) {
    
    this.setDefaults(initialInvestmentDto);
    
    boolean flagValidate = true; 

    flagValidate = flagValidate && (initialInvestmentDto.getInitialInvestment() >= 1000);
    flagValidate = flagValidate && (initialInvestmentDto.getYearlyInput() >= 0.0);
    flagValidate = flagValidate && (initialInvestmentDto.getYearlyInputIncrement() >= 0);
    flagValidate = flagValidate && (initialInvestmentDto.getInvestmentYears() > 0);
    flagValidate = flagValidate && (initialInvestmentDto.getInvestmentYield() > 0);

    return flagValidate;
  }
  
  private void setDefaults(InitialInvestmentDto initialInvestmentDto) {
    Double yearlyInput = initialInvestmentDto.getYearlyInput();
    yearlyInput = yearlyInput == null ? 0.0 : yearlyInput;
    initialInvestmentDto.setYearlyInput(yearlyInput);
    
    Integer yearlyInputIncrement = initialInvestmentDto.getYearlyInputIncrement();
    yearlyInputIncrement = yearlyInputIncrement == null ? 0 : yearlyInputIncrement;
    initialInvestmentDto.setYearlyInputIncrement(yearlyInputIncrement);
  }

}
