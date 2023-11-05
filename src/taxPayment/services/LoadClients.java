/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxPayment.services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import taxPayment.data.Client;
import taxPayment.ui.TaxClientsLoad;

/**
 *
 * @author PaulM
 */
public class LoadClients {
 
    public List<Client> loadClientFile(java.awt.Component parentComponent){
         List<Client> clients = new ArrayList<Client>();
         List < String > linesInFile = null ;
 
        /// **************************
        /// Select the file to process
        /// **************************
        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.setCurrentDirectory(new File("."));

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma seperated files", "csv");    
        chooser.setFileFilter(filter);
        chooser.setSelectedFile(new File("client_income.csv"));
        int option = chooser.showOpenDialog( parentComponent); //this);
        
        /// **************************
        /// Read the file 
        /// **************************
        if (option == JFileChooser.APPROVE_OPTION) {
            Path filePath = Paths.get(chooser.getSelectedFile().getPath());
            try {
                linesInFile = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            } catch (IOException ex) {
                Logger.getLogger(TaxClientsLoad.class.getName()).log(Level.SEVERE, null, ex);
            }

            // for debugging purpose
            linesInFile.forEach(line -> System.out.println(line));
        }

        /// **************************
        /// Create Client Records from line in the file 
        /// **************************
        for (String clientRow : linesInFile)
        {
            String[] clientItems = clientRow.split(",");
            var client = new Client();
            client.Name = clientItems[0];
            client.income =Integer.parseInt(clientItems[1].trim());
            clients.add(client);
        }

        
        return clients;
    }
}
