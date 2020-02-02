/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasetUI;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JOptionPane;
import modelBean.Combustivel;
import modelDAO.ProdutoDAO;

/**
 *
 * @author Talyson
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CarregarDataset = new javax.swing.JButton();
        VisualizarDataset = new javax.swing.JButton();
        TextoInicial = new javax.swing.JLabel();
        TextoDev = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        CarregarDataset.setText("Carregar Dataset no Banco de Dados");
        CarregarDataset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarregarDatasetActionPerformed(evt);
            }
        });

        VisualizarDataset.setText("Visualizar Dataset");
        VisualizarDataset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarDatasetActionPerformed(evt);
            }
        });

        TextoInicial.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        TextoInicial.setText("DATASET: Gas Prices in Brazil from 2004-2919");

        TextoDev.setText("Desenvolvido por: Talyson Moreira Penha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(VisualizarDataset)
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextoDev)
                            .addComponent(CarregarDataset))
                        .addGap(108, 108, 108))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(TextoInicial)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(TextoInicial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(CarregarDataset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VisualizarDataset)
                .addGap(73, 73, 73)
                .addComponent(TextoDev)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CarregarDatasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarregarDatasetActionPerformed
        Combustivel p = new Combustivel();
        ProdutoDAO dao = new ProdutoDAO();

        try {
            int i = 0,j = 0, opcao;
            Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Talyson\\Documents\\"
                    + "NetBeansProjects\\Dataset\\src\\arquivoDataset\\Gas Prices in Brazil from 2004 to 2019.csv"));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

            List<String[]> colunas = csvReader.readAll();
            for (String[] coluna : colunas) {
                p.setIdColuna(coluna[0]);
                p.setDataInicio(coluna[1]);
                p.setDataFinal(coluna[2]);
                p.setRegiao(coluna[3]);
                p.setEstado(coluna[4]);
                p.setProduto(coluna[5]);
                p.setNumeroPostos(coluna[6]);
                p.setUnidadeMedida(coluna[7]);
                p.setPrecoMedioRevenda(coluna[8]);
                p.setDesvioPadraoRevenda(coluna[9]);
                p.setPrecoMinimoRevenda(coluna[10]);
                p.setPrecoMaximoRevenda(coluna[11]);
                p.setMargemMediaRevenda(coluna[12]);
                p.setCoefVariacaoRevenda(coluna[13]);
                p.setPrecoMedioDistribuicao(coluna[14]);
                p.setDesvioPadraoDistribuicao(coluna[15]);
                p.setPrecoMinimoDistribuicao(coluna[16]);
                p.setPrecoMaximoDistribuicao(coluna[17]);
                p.setCoefVariacaoDistribuicao(coluna[18]);
                p.setMes(coluna[19]);
                p.setAno(coluna[20]);
                
                dao.create(p);
                
                i++;
                j++;
                
                if(j == 10){
                    opcao = JOptionPane.showConfirmDialog(null, "Você já carregou " + i + " dados no Banco. Deseja Continuar?", "Escolha", JOptionPane.YES_NO_OPTION);
                    j=0;
                    
                    if (opcao == 0) {
                        continue;
                    } else {
                        i = 0;
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_CarregarDatasetActionPerformed

    private void VisualizarDatasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarDatasetActionPerformed
        new TelaVisualizar().setVisible(true);
        dispose();
    }//GEN-LAST:event_VisualizarDatasetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CarregarDataset;
    private javax.swing.JLabel TextoDev;
    private javax.swing.JLabel TextoInicial;
    private javax.swing.JButton VisualizarDataset;
    // End of variables declaration//GEN-END:variables

    private void lerTabela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}