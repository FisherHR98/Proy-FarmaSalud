
package Formularios;
import Clases.*;
import Util.Controlador;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

public class frmVenta extends javax.swing.JFrame {
int tipo;
Controlador obj=new Controlador();
Acceso vent=new Acceso();
Date da = new Date();
    public frmVenta() {
        initComponents();
        jpBDni.setVisible(false);
        jpBRuc.setVisible(false);
        txtCodV.setText(vent.CUsuario);
        cerrar();
    }
    
    String buscarArchivo(){
        String elegirArchivo="";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Excel", "xls", "xlsx"); 
        fileChooser.setFileFilter(imgFilter);

        int result = fileChooser.showOpenDialog(this);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = fileChooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                JOptionPane.showMessageDialog(null, "Ha elegido la opción Cancelar.");
            } else {
                elegirArchivo=fileChooser.getSelectedFile().toString();
                JOptionPane.showMessageDialog(null, elegirArchivo);
            }
        }
        return elegirArchivo;
    }

    void muestraD(String id){
        DefaultTableModel dt=(DefaultTableModel)jtCli.getModel();
        dt.setRowCount(0);
        for(Clientes x: obj.LisCliDNI(id)){
            Object v[]={x.getCodC(),x.getNom(),x.getDni(),x.getRuc(),x.getTelefono(),x.getCod_dis(),x.getDirec(), x.getEstado()};

            dt.addRow(v);
        
    }}
    void muestraR(String id){
        DefaultTableModel dt=(DefaultTableModel)jtCli.getModel();
        dt.setRowCount(0);
        for(Clientes x: obj.LisCliRUC(id)){
            Object v[]={x.getCodC(),x.getNom(),x.getDni(),x.getRuc(),x.getTelefono(),x.getCod_dis(),x.getDirec(), x.getEstado()};

            dt.addRow(v);
        
    }}
    
    void InsertaP(String id, int cant){
        DefaultTableModel dt=(DefaultTableModel)jtPro.getModel();
        
        for(Producto x: obj.LisProCod(id)){
            Object v[]={x.getCodPro(),x.getDesc(),x.getPrecio(),
                cant, Math.round((x.getPrecio()*cant)*100d)/100d};
            dt.addRow(v);
        }
        obj.restaStock(id, cant);
    }
    
    void muestraPro(String nom){
        DefaultTableModel dt=(DefaultTableModel)jtProd.getModel();
        dt.setRowCount(0);
        for(Producto x: obj.LisProNom(nom)){
            if(x.getEstado().equals("1")){
            Object v[]={x.getCodPro(),x.getDesc(),x.getPrecio(),x.getStock(),
                x.getCodMarca(), x.getEstado()};
            dt.addRow(v);}
        
    }}
    
    public void cerrar(){
        try {
            this.setDefaultCloseOperation(frmVenta.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void confirmarSalida(){
        int valor=JOptionPane.showConfirmDialog(this, "¿Desea salir de la aplicación?","Advertencia",JOptionPane.YES_NO_OPTION);
        if(valor==JOptionPane.YES_OPTION){
            try {
                for (int i = 0; i <= jtPro.getRowCount(); i++) {
                    obj.agregaStock(jtPro.getValueAt(i, 0).toString(), Integer.parseInt(jtPro.getValueAt(i, 3).toString()));
                }
                DefaultTableModel dt=(DefaultTableModel)jtPro.getModel();
                dt.setRowCount(0);
                JOptionPane.showMessageDialog(null, "Hasta pronto", "Salir", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hasta pronto", "Salir", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        btnAgregaCli = new javax.swing.JButton();
        jpBDni = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscaD = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtCli = new javax.swing.JTable();
        jpBRuc = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscaR = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNomCli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCodCli = new javax.swing.JTextField();
        txtCodV = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnBuscaP = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNomProd = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtProd = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtCodPro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPro = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        chkIGV = new javax.swing.JCheckBox();
        txtIGV = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSubT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnBorraP = new javax.swing.JButton();
        btnBorraAll = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();

        setTitle("Módulo: Venta");

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Recibo");

        jLabel2.setText("Tipo:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija tipo", "Boleta", "Factura", "Anonimo" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        btnAgregaCli.setText("Agrega Cliente");
        btnAgregaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaCliActionPerformed(evt);
            }
        });

        jLabel3.setText("Busca DNI");

        txtBuscaD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaDActionPerformed(evt);
            }
        });
        txtBuscaD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaDKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jpBDniLayout = new javax.swing.GroupLayout(jpBDni);
        jpBDni.setLayout(jpBDniLayout);
        jpBDniLayout.setHorizontalGroup(
            jpBDniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBDniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtBuscaD, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jpBDniLayout.setVerticalGroup(
            jpBDniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBDniLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpBDniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBuscaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jtCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre/razon", "DNI", "RUC", "Telefono", "Distrito", "Direccion", "Estado"
            }
        ));
        jtCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCliMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtCli);

        jLabel4.setText("Busca Ruc");

        txtBuscaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaRActionPerformed(evt);
            }
        });
        txtBuscaR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaRKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jpBRucLayout = new javax.swing.GroupLayout(jpBRuc);
        jpBRuc.setLayout(jpBRucLayout);
        jpBRucLayout.setHorizontalGroup(
            jpBRucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBRucLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtBuscaR, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBRucLayout.setVerticalGroup(
            jpBRucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBRucLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpBRucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cod Clientes");

        txtNomCli.setEditable(false);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre");

        txtCodCli.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNomCli, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNomCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCodV.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(262, 262, 262)
                        .addComponent(btnAgregaCli)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jpBDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpBRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCodV, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtCodV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregaCli))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpBRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prductos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnBuscaP.setText("<html><p>Agrega</p><p>producto</p></html>");
        btnBuscaP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaPActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombre");

        txtNomProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomProdKeyReleased(evt);
            }
        });

        jtProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Precio", "Stock", "Marca", "Estado"
            }
        ));
        jtProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtProd);

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel9.setText("Busqueda de productos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(txtNomProd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtNomProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        txtCodPro.setEditable(false);

        jLabel10.setText("Cantidad");

        jLabel11.setText("Codigo de producto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscaP))
                .addGap(162, 162, 162))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnBuscaP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(37, 37, 37))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Precio", "Cantidad", "Total"
            }
        ));
        jtPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPro);

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel6.setText("Lista de carrito");

        chkIGV.setBackground(new java.awt.Color(204, 255, 204));
        chkIGV.setText("IGV");
        chkIGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkIGVActionPerformed(evt);
            }
        });

        txtIGV.setEditable(false);

        jLabel12.setText("SubTotal");

        txtSubT.setEditable(false);

        jLabel13.setText("TOTAL:");

        txtTotal.setEditable(false);

        btnBorraP.setText("Borrar producto");
        btnBorraP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorraPActionPerformed(evt);
            }
        });

        btnBorraAll.setText("Borrar todo");
        btnBorraAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorraAllActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel6)
                        .addGap(0, 138, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(chkIGV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(15, 15, 15)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSubT, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(txtIGV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBorraP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorraAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGrabar)
                .addGap(170, 170, 170))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSubT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorraP))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkIGV)
                    .addComponent(txtIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorraAll))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnGrabar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 723, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCliMouseClicked
        int fila=jtCli.getSelectedRow();
        txtNomCli.setText(jtCli.getValueAt(fila, 1).toString());
        txtCodCli.setText(jtCli.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_jtCliMouseClicked

    private void jtProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProMouseClicked
        int f=jtPro.getSelectedRow();
        String cod=jtPro.getValueAt(f, 0).toString();
        txtCodPro.setText(cod);
    }//GEN-LAST:event_jtProMouseClicked

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        tipo=cbTipo.getSelectedIndex();
        jpBDni.setVisible(tipo==1);
        jpBRuc.setVisible(tipo==2);
        if(tipo==3){
            DefaultTableModel dt=(DefaultTableModel)jtCli.getModel();
            dt.setRowCount(0);
            txtCodCli.setText("C0000");
            txtNomCli.setText("Anonimo");
        }else{
            DefaultTableModel dt=(DefaultTableModel)jtCli.getModel();
            dt.setRowCount(0);
            txtCodCli.setText("");
            txtNomCli.setText("");
        }
    }//GEN-LAST:event_cbTipoActionPerformed

    private void btnAgregaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaCliActionPerformed
        new FCliente().setVisible(true);
    }//GEN-LAST:event_btnAgregaCliActionPerformed

    private void txtBuscaDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaDActionPerformed

    private void txtBuscaDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaDKeyReleased
        muestraD(txtBuscaD.getText());
    }//GEN-LAST:event_txtBuscaDKeyReleased

    private void txtBuscaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaRActionPerformed
        
    }//GEN-LAST:event_txtBuscaRActionPerformed

    private void btnBuscaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaPActionPerformed
        
        String codP=txtCodPro.getText();
        int cant=Integer.parseInt(txtCant.getText());
        if(cant <= obj.obStock(codP)){
            InsertaP(codP, cant);
            double sumat=0;
            if (chkIGV.isSelected()==true){
                for (int i = 0; i <= jtPro.getRowCount()-1; i++) {
                    double ptr=Double.parseDouble(jtPro.getValueAt(i, 4).toString());
                    sumat=sumat+ptr;
                }
                Double igv=sumat*0.18;
                txtSubT.setText(String.valueOf(Math.round((sumat)*100d)/100d));
                txtIGV.setText(String.valueOf(Math.round((igv)*100d)/100d));
                txtTotal.setText(String.valueOf((Math.round((sumat+igv)*100d)/100d)));
            }else{
                for (int i = 0; i <= jtPro.getRowCount()-1; i++) {
                    double ptr=Double.parseDouble(jtPro.getValueAt(i, 4).toString());
                    sumat=sumat+ptr;
                }
                txtSubT.setText(String.valueOf(Math.round((sumat)*100d)/100d));
                txtIGV.setText(String.valueOf(0));
                txtTotal.setText(String.valueOf(Math.round((sumat)*100d)/100d));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Cantidad no valida");
        }
        txtCant.setText("");
        txtCodPro.setText("");
    }//GEN-LAST:event_btnBuscaPActionPerformed

    private void txtNomProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProdKeyReleased
        muestraPro(txtNomProd.getText());
    }//GEN-LAST:event_txtNomProdKeyReleased

    private void jtProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdMouseClicked
        int f=jtProd.getSelectedRow();
        String cod=jtProd.getValueAt(f, 0).toString();
        txtCodPro.setText(cod);
    }//GEN-LAST:event_jtProdMouseClicked

    private void btnBorraPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorraPActionPerformed
        DefaultTableModel dt=(DefaultTableModel)jtPro.getModel();
        obj.agregaStock(jtPro.getValueAt(jtPro.getSelectedRow(), 0).toString(), Integer.parseInt(jtPro.getValueAt(jtPro.getSelectedRow(), 3).toString()));
        dt.removeRow(jtPro.getSelectedRow());
    }//GEN-LAST:event_btnBorraPActionPerformed

    private void chkIGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkIGVActionPerformed
        
        Double subt=Double.parseDouble(txtSubT.getText());
        Double igv=subt*0.18;
        if (chkIGV.isSelected()==true){
            txtIGV.setText(String.valueOf(Math.round((igv)*100d)/100d));
            txtTotal.setText(String.valueOf(Math.round((igv+subt)*100d)/100d));
        }else{
            txtIGV.setText(String.valueOf(0));
            txtTotal.setText(String.valueOf(String.valueOf(Math.round((subt)*100d)/100d)));
        }
        
        
    }//GEN-LAST:event_chkIGVActionPerformed

    private void txtBuscaRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaRKeyReleased
        muestraR(txtBuscaR.getText());
    }//GEN-LAST:event_txtBuscaRKeyReleased

    private void btnBorraAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorraAllActionPerformed
        for (int i = 0; i < jtPro.getRowCount(); i++) {
            obj.agregaStock(jtPro.getValueAt(i, 0).toString(), Integer.parseInt(jtPro.getValueAt(i, 3).toString()));
        }
        DefaultTableModel dt=(DefaultTableModel)jtPro.getModel();
        dt.setRowCount(0);
        txtTotal.setText("");
        txtSubT.setText("");
        txtIGV.setText("");
        chkIGV.setSelected(false);
    }//GEN-LAST:event_btnBorraAllActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        try {
        SimpleDateFormat forma = new SimpleDateFormat("yyyy-MM-dd");
        String fecha=forma.format(da);
        String codc=txtCodCli.getText();
        String igv;
        if (chkIGV.isSelected()==true){
            igv="S";
        }else{
            igv="N";
        }
        String codv=txtCodV.getText();
        int est=1;
        
        String tip=cbTipo.getSelectedItem().toString();
        Factura f= new Factura(fecha, igv, codv, est,  codc, tip, null);
        if(tip.equals("Factura")){
            obj.AgregaFac(f);
        }else{
            obj.AgregaB(f);
        }
        
        
        String nrofa=obj.NroFac();
        int cant=0;
        String codp="";
        
        for (int i = 0; i < jtPro.getRowCount(); i++) {
            codp=jtPro.getValueAt(i, 0).toString();
            cant=Integer.parseInt(jtPro.getValueAt(i, 3).toString());
            DetalleR d=new DetalleR(nrofa, cant, codp, est);
            obj.AgregaDET(d);
        }
        
        JOptionPane.showMessageDialog(this, "Se grabo correctamente");
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
            try {
                String vend=obj.obEmp(vent.CUsuario);
                String ruta_copia="";
                String nombre = txtNomCli.getText();
                try{
                    JOptionPane.showMessageDialog(null,"Elija modelo", "Modelo",JOptionPane.INFORMATION_MESSAGE);
                    Path original = Paths.get(buscarArchivo());
                    JOptionPane.showMessageDialog(null,"Elija destino", "Destino",JOptionPane.INFORMATION_MESSAGE);
                    ruta_copia = buscarArchivo();
                    Path copia = Paths.get(ruta_copia);

                    Files.copy(original, copia, StandardCopyOption.REPLACE_EXISTING);
                     String excelFilePath = ruta_copia;
                     
                     try{
                        FileInputStream fileInputStream = new FileInputStream(excelFilePath);
                        Workbook workbook = WorkbookFactory.create(fileInputStream);
                        org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

                        int lastRowCount = sheet.getLastRowNum();
                        System.out.println("Last Row Count: " + lastRowCount);
                        Row dataRow = sheet.createRow(++lastRowCount);
                        dataRow.createCell(0).setCellValue("Fecha:");
                        dataRow.createCell(1).setCellValue(fecha);
                        dataRow = sheet.createRow(++lastRowCount);
                        dataRow.createCell(0).setCellValue("Vendedor:");
                        dataRow.createCell(1).setCellValue(vend);
                        dataRow = sheet.createRow(++lastRowCount);
                        dataRow.createCell(0).setCellValue("Cliente:");
                        dataRow.createCell(1).setCellValue(nombre);
                        if(cbTipo.getSelectedIndex()==1){
                            dataRow = sheet.createRow(++lastRowCount);
                            dataRow.createCell(0).setCellValue("DNI:");
                            dataRow.createCell(1).setCellValue(jtCli.getValueAt(jtCli.getSelectedRow(), 2).toString());
                            dataRow = sheet.createRow(++lastRowCount);
                            dataRow.createCell(0).setCellValue("Boleta:");
                            dataRow.createCell(1).setCellValue(nrofa);
                        }else if(cbTipo.getSelectedIndex()==2){
                            dataRow = sheet.createRow(++lastRowCount);
                            dataRow.createCell(0).setCellValue("RUC:");
                            dataRow.createCell(1).setCellValue(jtCli.getValueAt(jtCli.getSelectedRow(), 3).toString());
                            dataRow = sheet.createRow(++lastRowCount);
                            dataRow.createCell(0).setCellValue("Factura:");
                            dataRow.createCell(1).setCellValue(nrofa);
                        }
                        
                        dataRow = sheet.createRow(++lastRowCount);
                        dataRow.createCell(0).setCellValue("Cant");
                        dataRow.createCell(1).setCellValue("Desc");
                        dataRow.createCell(2).setCellValue("P. Unit");
                        dataRow.createCell(3).setCellValue("P. Total");
                        
                        for(int i = 0; i < jtPro.getRowCount() ; i++){
                            dataRow = sheet.createRow(++lastRowCount);
                                dataRow.createCell(0).setCellValue(jtPro.getValueAt(i, 3).toString());
                                dataRow.createCell(1).setCellValue(jtPro.getValueAt(i, 1).toString());
                                dataRow.createCell(2).setCellValue(jtPro.getValueAt(i, 2).toString());
                                dataRow.createCell(3).setCellValue(jtPro.getValueAt(i, 4).toString());
                                }
                        
                        dataRow = sheet.createRow(++lastRowCount);
                        dataRow.createCell(2).setCellValue("SubTotal");
                        dataRow.createCell(3).setCellValue(txtSubT.getText());
                        dataRow = sheet.createRow(++lastRowCount);
                        dataRow.createCell(2).setCellValue("IGV");
                        dataRow.createCell(3).setCellValue(txtIGV.getText());
                        dataRow = sheet.createRow(++lastRowCount);
                        dataRow.createCell(0).setCellValue("Total");
                        dataRow.createCell(1).setCellValue(txtTotal.getText());
                        dataRow = sheet.createRow(++lastRowCount);
                        dataRow.createCell(0).setCellValue("Gracias por su compra");
                        sheet.addMergedRegion(new CellRangeAddress(lastRowCount,lastRowCount,0,4));
                        
                        JOptionPane.showMessageDialog(null,"La boleta fue exportado con éxito.");
                        fileInputStream.close();
                        FileOutputStream fileOutputStream = new FileOutputStream(excelFilePath);
                        workbook.write(fileOutputStream);
                        fileOutputStream.close();
                        System.out.println("Hoja de excel actualizada...");

                    }catch(Exception e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null,"La boleta no fue exportado.");
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }        
            } catch (Exception e) {
            }
////////////////////////////////////////////////////////////////////////////////////////////////////
        
        DefaultTableModel dt=(DefaultTableModel)jtCli.getModel();
        dt.setRowCount(0);
        txtBuscaD.setText("");
        txtBuscaR.setText("");
        txtCodCli.setText("");
        txtNomCli.setText("");
        int filas=jtCli.getRowCount();
        for(int i=0; i<filas; i++){
            dt.removeRow(0);
        }
        DefaultTableModel pd=(DefaultTableModel)jtProd.getModel();
        pd.setRowCount(0);
        txtCodPro.setText("");
        txtCant.setText("");
        txtNomProd.setText("");

        int fila=jtProd.getRowCount();
        for(int i=0; i<fila; i++){
            pd.removeRow(0);
        }
        
        DefaultTableModel dp=(DefaultTableModel)jtPro.getModel();
        dp.setRowCount(0);
        txtTotal.setText("");
        txtSubT.setText("");
        txtIGV.setText("");
        chkIGV.setSelected(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se grabo la venta");
        }
        
        
        
    }//GEN-LAST:event_btnGrabarActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(frmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregaCli;
    private javax.swing.JButton btnBorraAll;
    private javax.swing.JButton btnBorraP;
    private javax.swing.JButton btnBuscaP;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JCheckBox chkIGV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpBDni;
    private javax.swing.JPanel jpBRuc;
    private javax.swing.JTable jtCli;
    public javax.swing.JTable jtPro;
    private javax.swing.JTable jtProd;
    private javax.swing.JTextField txtBuscaD;
    private javax.swing.JTextField txtBuscaR;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCodCli;
    private javax.swing.JTextField txtCodPro;
    private javax.swing.JTextField txtCodV;
    private javax.swing.JTextField txtIGV;
    private javax.swing.JTextField txtNomCli;
    private javax.swing.JTextField txtNomProd;
    private javax.swing.JTextField txtSubT;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
