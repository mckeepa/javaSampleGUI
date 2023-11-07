/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxPayment.services;

import java.util.ArrayList;

/**
 *
 * @author PaulM
 */
public class TaxProcessing {
    public void TaxProcessing(){
        
    }
    public static  int CaluateTax(int TaxableIncome){
        int taxPayable =0;
        
        if (TaxableIncome <= 32000) return 0;
        if (TaxableIncome <= 52000) return (int) (0 + (TaxableIncome - 32000) *0.10);
        if (TaxableIncome <= 82000) return (int) (CaluateTax(52000) + (TaxableIncome - 52000) *0.20);
        if (TaxableIncome <= 102000) return (int) (CaluateTax(82000) + (TaxableIncome - 82000) *0.30);
        return (int) (CaluateTax(102000) + (TaxableIncome - 102000) *0.40);

        
    }
      
}
