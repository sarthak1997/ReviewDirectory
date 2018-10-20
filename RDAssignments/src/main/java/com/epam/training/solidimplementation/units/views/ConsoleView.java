package com.epam.training.solidimplementation.units.views;

import com.epam.training.solidimplementation.units.converter.FeetToInchConverter;
import com.epam.training.solidimplementation.units.converter.FeetToMeterConverter;
import com.epam.training.solidimplementation.units.converter.InchToFeetConverter;
import com.epam.training.solidimplementation.units.converter.InchToMeterConverter;
import com.epam.training.solidimplementation.units.converter.MeterToFeetConverter;
import com.epam.training.solidimplementation.units.converter.MeterToInchConverter;
import com.epam.training.solidimplementation.units.converter.UnitConverter;
import com.epam.training.solidimplementation.units.io.UnitConverterInputter;
import com.epam.training.solidimplementation.units.io.UnitConverterOutputter;

import java.io.IOException;

/**
 * View class for the console for unit converter.
 */
public class ConsoleView {

  /**
   * Driver method in the console view to operate the application through console.
   */
  public static void main(String[] args) {

    UnitConverter uc;
    Double val;
    UnitConverterOutputter output;
    UnitConverterInputter input = new UnitConverterInputter();

    char ch;
    try {
      while (true) {
        System.out.println("Convert between Meters, Feets and Inches!"
            + "\n\nChoose from the below numbers "
            + "for conversion - \n1. Meter to Feet\n2. Meter to Inch\n3. Feet to Meter"
            + "\n4. Feet to Inch\n5. Inch to Meter\n6. Inch to Feet\n\nPress \'q\' to quit\n");
        ch = input.readConsoleChar();
        switch (ch) {

          case '1': {
            System.out.println("Enter Value in Meter - ");
            try {
              val = input.readConsoleDouble();
              uc = new MeterToFeetConverter(val);
  
              output = new UnitConverterOutputter(uc.convert().toString());
              System.out.println(output.outConsole());
  
            } catch (NumberFormatException nfe) {
              System.out.println("Decimal Inputs Only");
              break;
            }
            break;
          }
          case '2': {
            System.out.println("Enter Value in Meter - ");
  
            try {
              val = input.readConsoleDouble();
              uc = new MeterToInchConverter(val);
  
              output = new UnitConverterOutputter(uc.convert().toString());
              System.out.println(output.outConsole());
  
            } catch (NumberFormatException nfe) {
              System.out.println("Decimal Inputs Only");
              break;
            }
  
            break;
          }
  
          case '3': {
            System.out.println("Enter Value in Feet - ");
  
            try {
              val = input.readConsoleDouble();
              uc = new FeetToMeterConverter(val);
  
              output = new UnitConverterOutputter(uc.convert().toString());
              System.out.println(output.outConsole());
  
            } catch (NumberFormatException nfe) {
              System.out.println("Decimal Inputs Only");
              break;
            }
  
            break;
          }
          case '4': {
            System.out.println("Enter Value in Feet - ");
  
            try {
              val = input.readConsoleDouble();
              uc = new FeetToInchConverter(val);
  
              output = new UnitConverterOutputter(uc.convert().toString());
              System.out.println(output.outConsole());
  
            } catch (NumberFormatException nfe) {
              System.out.println("Decimal Inputs Only");
              break;
            }
  
            break;
          }
          case '5': {
            System.out.println("Enter Value in Inch - ");
  
            try {
              val = input.readConsoleDouble();
              uc = new InchToMeterConverter(val);
  
              output = new UnitConverterOutputter(uc.convert().toString());
              System.out.println(output.outConsole());
  
            } catch (NumberFormatException nfe) {
              System.out.println("Decimal Inputs Only");
              break;
            }
  
            break;
          }
          case '6': {
            System.out.println("Enter Value in Inch - ");
  
            try {
              val = input.readConsoleDouble();
              uc = new InchToFeetConverter(val);
  
              output = new UnitConverterOutputter(uc.convert().toString());
              System.out.println(output.outConsole());
  
            } catch (NumberFormatException nfe) {
              System.out.println("Decimal Inputs Only");
              break;
            }
            break;
          }
          case 'q': {
            break;
          }
  
          default: {
            System.out.println("Invalid input");
            break;
          }

        }

        if ('q' == ch) {
          break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
