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
* Nombre de archivo: ApplicationStarter.java
* Autor: gcontrer
* Fecha de creación: 10 sep 2021
*/

package com.its.mx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class ApplicationStarter.
 */
@SpringBootApplication
public class ApplicationStarter {

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(ApplicationStarter.class, args);
  }

}
