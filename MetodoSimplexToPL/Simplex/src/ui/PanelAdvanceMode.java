/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Juan David
 */
public class PanelAdvanceMode extends javax.swing.JPanel{

    private JFrame frame;
    
    private LinealProgrammingInterface ui;
    
    /**
     * Creates new form PanelAdvaceMode
     */
    public PanelAdvanceMode(LinealProgrammingInterface ui,String stringNumberOfVariables, String stringNumberOfConstrains, String criterion, JFrame screen) {
        initComponents();
        labCriterion.setText(criterion);
        frame = screen;
        int numberOfVariables = Integer.parseInt(stringNumberOfVariables);
        int numberOfConstrains = Integer.parseInt(stringNumberOfConstrains);
        numberOfVariables += 3;
        numberOfConstrains += 1;
        String[] titles = new String[numberOfVariables];
        titles[0] = "Variable";
        for (int i = 1; i < titles.length-2; i++) {
            titles [i] = "X"+i;
        }
        titles[titles.length-2] = "Direction";
        titles[titles.length-1] = "RHS"; 
        
        String[][] data = new String[numberOfConstrains][numberOfVariables];
     
        for (int i = 0; i < numberOfConstrains; i++) {
            for (int j = 0; j < numberOfVariables; j++) {
               
                if(j == 0){
                    if(i == 0){
                       data[i][j] = "Z";
                    }else{
                        data[i][j] = "C"+i;
                    }
                }
            }
        }
        
        tabAdvanced = new JTable(data, titles);
        this.ui = ui;
        scrollPane.setViewportView(tabAdvanced);
        add(scrollPane);
    }
    public JTable getTable(){
        return tabAdvanced;
    }
    
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabAdvanced = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        butSolve = new javax.swing.JButton();
        labCriterion = new javax.swing.JLabel();

        tabAdvanced.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabAdvanced);

        scrollPane.setViewportView(jScrollPane1);

        jPanel1.setLayout(new java.awt.BorderLayout());

        butSolve.setText("SOLVE");
        butSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSolveActionPerformed(evt);
            }
        });
        jPanel1.add(butSolve, java.awt.BorderLayout.PAGE_START);

        labCriterion.setText("Max/Min");
        jPanel1.add(labCriterion, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSolveActionPerformed
        ui.FinalSolution(getInformation(), labCriterion.getText());
    }//GEN-LAST:event_butSolveActionPerformed

    public String[] getInformation(){
        String[] information = new String[tabAdvanced.getColumnCount()];
        for (int i = 1; i < tabAdvanced.getRowCount(); i++){
           
            String line = "";
            for (int j = 0; j < tabAdvanced.getColumnCount(); j++) {
                if(tabAdvanced.getModel().getValueAt(i, j) == null){
                    line+="0 "+"X"+j;
                }else{
                       if(j == 0){
                          if(tabAdvanced.getModel().getValueAt(i, j).equals("Z")){
                            line += "1 "+"Z"; 
                       }else{
                            line += "0 "+"Z"; 
                          }
                       
                      }else{
                           line+=tabAdvanced.getModel().getValueAt(i, j)+" X"+j;
                       }
                }
      
            }
         information[i] = line;
        }
        for (int i = 0; i < information.length; i++) {
            System.out.println(information[i]);
        }
        return information;
    }
    
    public static void main(String[] args){
        JFrame ui = null;
        LinealProgrammingInterface lp = null;
        PanelAdvanceMode p = new PanelAdvanceMode(lp, "5", "6", "Max", ui);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butSolve;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labCriterion;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabAdvanced;
    // End of variables declaration//GEN-END:variables
}
