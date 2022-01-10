
package mainPage;

import Model.Customer;
import Model.CustomerDAO;
import Model.Detail;
import Model.Events;
import Model.ProductsDAO;
import Model.Products;
import Model.Provider;
import Model.ProviderDAO;
import Model.SaleDAO;
import Model.Sale;
import Model.Settings;
import Model.login;
import Reports.Excel;
import Reports.Graphic;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author norma
 */
public class page1_system extends javax.swing.JFrame {
    Date saleDate = new Date();
    String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(saleDate);
    Customer cu = new Customer();
    CustomerDAO customer = new CustomerDAO();
    
    Provider pr = new Provider();
    ProviderDAO prDAO = new ProviderDAO();
    
    Products pro = new Products();
    ProductsDAO proDAO = new ProductsDAO();
    
    Sale s = new Sale();
    SaleDAO sDAO = new SaleDAO();
    
    Detail Sd = new Detail();
    Settings Setting = new Settings();
    Events event = new Events();
    int item;
    double totalDue = 0.00;
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel tm = new DefaultTableModel();
    public page1_system() {
        initComponents();
        ListSettings();
    }  
    public page1_system(login priv){
        initComponents();
        this.setLocationRelativeTo(null);
        txtIdCustomer.setVisible(false);
        txtIdSale.setVisible(false);
        txtIdProduct.setVisible(false);
        txtIdProvider.setVisible(false);
        AutoCompleteDecorator.decorate(cbxProductProvider);
        proDAO.ConsultProvider(cbxProductProvider);
        txtIdSettings.setVisible(false); 
        if(priv.getRole().equals("user")){
            btnProducts.setEnabled(false);
            btnProvider.setEnabled(false);
            btnUsers.setEnabled(false);
            labelSeller.setText(priv.getName());
        }else{
           labelSeller.setText(priv.getName()); 
        }
    }
    public void ListCustomer(){
        ArrayList<Customer> ListCu = customer.listCustomer();
        model = (DefaultTableModel) tableCustomer.getModel();
        Object[] ob = new Object[6];
        for(int i=0;i<ListCu.size();i++){
            ob[0]= ListCu.get(i).getId();
            ob[1]= ListCu.get(i).getCl();
            ob[2]= ListCu.get(i).getName();
            ob[3]= ListCu.get(i).getAdress();
            ob[4]= ListCu.get(i).getPhone();
            ob[5]= ListCu.get(i).getEmail();
            model.addRow(ob);
        }
        tableCustomer.setModel(model);
    }
    public void ListProvider(){
        ArrayList<Provider> ListPr = prDAO.ListProvider();
        model = (DefaultTableModel) tableProvider.getModel();
        Object[] ob = new Object[6];
        for(int i=0;i<ListPr.size();i++){
            ob[0]= ListPr.get(i).getId();
            ob[1]= ListPr.get(i).getCl();
            ob[2]= ListPr.get(i).getName();
            ob[3]= ListPr.get(i).getAdress();
            ob[4]= ListPr.get(i).getPhone();
            ob[5]= ListPr.get(i).getEmail();
            model.addRow(ob);
        }
        tableProvider.setModel(model);
    }
    public void ListProducts(){
        ArrayList<Products> ListPro = proDAO.listProducts();
        model = (DefaultTableModel) tableProduct.getModel();
        Object[] ob = new Object[6];
        for(int i=0;i<ListPro.size();i++){
            ob[0]= ListPro.get(i).getId();
            ob[1]= ListPro.get(i).getCode();
            ob[2]= ListPro.get(i).getName();
            ob[3]= ListPro.get(i).getProviderPr();
            ob[4]= ListPro.get(i).getStock();
            ob[5]= ListPro.get(i).getCost();
            model.addRow(ob);
        }
        tableProduct.setModel(model);
    }
    public void ListSettings(){
     Setting  = proDAO.SearchData();
     txtIdSettings.setText(""+Setting.getId());
     txtClSettings.setText(""+Setting.getCl());
     txtNameSettings.setText(""+Setting.getName());
     txtAdressSettings.setText(""+Setting.getAdress());
     txtPhoneSettings.setText(""+Setting.getPhone());
     txtEmailSettings.setText(""+Setting.getEmail());
     
    }
     public void ListSales(){
        ArrayList<Sale> ListSales = sDAO.ListSales();
        model = (DefaultTableModel) tableSales.getModel();
        Object[] ob = new Object[4];
        for(int i=0;i<ListSales.size();i++){
            ob[0]= ListSales.get(i).getId();
            ob[1]= ListSales.get(i).getCustomer();
            ob[2]= ListSales.get(i).getSeller();
            ob[3]= ListSales.get(i).getTotal();
            
            model.addRow(ob);
        }
        tableSales.setModel(model);
    }
    public void CleanTable(){
        for(int i = 0; i<model.getRowCount();i++){
            model.removeRow(i);
            i--;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnNewSale = new javax.swing.JButton();
        btnProducts = new javax.swing.JButton();
        btnSales = new javax.swing.JButton();
        btnProvider = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSaleCost = new javax.swing.JLabel();
        txtSaleStock = new javax.swing.JLabel();
        txtSaleCode = new javax.swing.JTextField();
        txtSaleDescription = new javax.swing.JTextField();
        txtSaleAmount = new javax.swing.JTextField();
        txtNewSaleCost = new javax.swing.JTextField();
        txtSaleAvailableStock = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSale = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtSaleCl = new javax.swing.JTextField();
        txtSaleCustomerName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnDeleteSale = new javax.swing.JButton();
        btnSalePrint = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        txtSaleCustomerPhone = new javax.swing.JTextField();
        txtSaleCustomerAdress = new javax.swing.JTextField();
        txtSaleCustomerEmail = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        labelSeller = new javax.swing.JLabel();
        btnGraphic = new javax.swing.JButton();
        myDate = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtCustomerCl = new javax.swing.JTextField();
        txtCustomerName = new javax.swing.JTextField();
        txtCustomerEmail = new javax.swing.JTextField();
        txtCustomerAdress = new javax.swing.JTextField();
        txtCustomerPhone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        btnNewCustomer = new javax.swing.JButton();
        btnEditCustomer = new javax.swing.JButton();
        btnSaveCustomer = new javax.swing.JButton();
        btnDeleteCustomer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdCustomer = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProvider = new javax.swing.JTable();
        txtProviderCl = new javax.swing.JTextField();
        txtProviderName = new javax.swing.JTextField();
        txtProviderAdress = new javax.swing.JTextField();
        txtProviderPhone = new javax.swing.JTextField();
        txtProviderEmail = new javax.swing.JTextField();
        btnDeleteProvider = new javax.swing.JButton();
        btnNewProvider = new javax.swing.JButton();
        btnEditProvider = new javax.swing.JButton();
        btnSaveProvider = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtIdProvider = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        txtProductCode = new javax.swing.JTextField();
        txtProductAmount = new javax.swing.JTextField();
        txtProductDescription = new javax.swing.JTextField();
        txtProductCost = new javax.swing.JTextField();
        cbxProductProvider = new javax.swing.JComboBox<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        btnEditProduct = new javax.swing.JButton();
        btnSaveProduct = new javax.swing.JButton();
        btnNewProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnExcelProduct = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        txtIdProduct = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        btnPdfSales = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableSales = new javax.swing.JTable();
        txtIdSale = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txtClSettings = new javax.swing.JTextField();
        txtNameSettings = new javax.swing.JTextField();
        txtAdressSettings = new javax.swing.JTextField();
        txtEmailSettings = new javax.swing.JTextField();
        txtPhoneSettings = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        btnSaveSettings = new javax.swing.JButton();
        txtIdSettings = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1035, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1015, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(jTable9);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Facturation system (1) (1).jpg"))); // NOI18N

        btnNewSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_new sales (2).jpg"))); // NOI18N
        btnNewSale.setText("New Sale");
        btnNewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSaleActionPerformed(evt);
            }
        });

        btnProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_products (1).jpg"))); // NOI18N
        btnProducts.setText("Products");
        btnProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsActionPerformed(evt);
            }
        });

        btnSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_sales (1).jpg"))); // NOI18N
        btnSales.setText("Sales");
        btnSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesActionPerformed(evt);
            }
        });

        btnProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_provider (1).jpg"))); // NOI18N
        btnProvider.setText("Provider");
        btnProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProviderActionPerformed(evt);
            }
        });

        btnCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_customers (1).jpg"))); // NOI18N
        btnCustomers.setText("Customers");
        btnCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustomersMouseClicked(evt);
            }
        });
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });

        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon.jpg"))); // NOI18N
        btnConfig.setText("Settings");
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_user.jpg"))); // NOI18N
        btnUsers.setText("Users");
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewSale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(btnProvider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnNewSale, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSales, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnUsers)
                .addGap(18, 18, 18)
                .addComponent(btnConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 640));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 1140, 120));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Code:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Description:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Amount:");

        txtSaleCost.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSaleCost.setText("Cost:");

        txtSaleStock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSaleStock.setText("Stock:");

        txtSaleCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSaleCodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaleCodeKeyTyped(evt);
            }
        });

        txtSaleDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaleDescriptionKeyTyped(evt);
            }
        });

        txtSaleAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaleAmountActionPerformed(evt);
            }
        });
        txtSaleAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSaleAmountKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaleAmountKeyTyped(evt);
            }
        });

        txtNewSaleCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNewSaleCostKeyTyped(evt);
            }
        });

        txtSaleAvailableStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaleAvailableStockKeyTyped(evt);
            }
        });

        tableSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Description", "Amount", "Cost", "Total"
            }
        ));
        jScrollPane2.setViewportView(tableSale);
        if (tableSale.getColumnModel().getColumnCount() > 0) {
            tableSale.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableSale.getColumnModel().getColumn(1).setPreferredWidth(110);
            tableSale.getColumnModel().getColumn(2).setPreferredWidth(30);
            tableSale.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableSale.getColumnModel().getColumn(4).setPreferredWidth(35);
        }

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Name:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("CL:");

        txtSaleCl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSaleClKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaleClKeyTyped(evt);
            }
        });

        txtSaleCustomerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaleCustomerNameKeyTyped(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_money.jpg"))); // NOI18N
        jLabel17.setText("Total");

        btnDeleteSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_Delete.jpg"))); // NOI18N
        btnDeleteSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSaleActionPerformed(evt);
            }
        });

        btnSalePrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_printer.jpg"))); // NOI18N
        btnSalePrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalePrintActionPerformed(evt);
            }
        });

        labelTotal.setText("_________");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        labelSeller.setText("Seller information");

        btnGraphic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_grafic (1).jpg"))); // NOI18N
        btnGraphic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraphicActionPerformed(evt);
            }
        });

        jLabel13.setText("Select");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtSaleCode, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(193, 193, 193)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(txtSaleAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtSaleDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSaleCl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSaleCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(txtSaleCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSaleCustomerAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txtSaleCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(labelSeller))
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSaleCost)
                                .addComponent(txtNewSaleCost, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(myDate, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGraphic, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSaleStock)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(txtSaleAvailableStock, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(btnSalePrint, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(btnDeleteSale, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(txtSaleCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaleCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSaleCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSaleCustomerAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSaleCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(myDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(btnGraphic, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12))
                            .addComponent(txtSaleStock, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSaleCost))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSaleCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSaleDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSaleAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNewSaleCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSaleAvailableStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalePrint, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteSale, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(130, 130, 130))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel4);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("CL:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Name:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Adress:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Phone:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Email:");

        txtCustomerCl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomerClKeyTyped(evt);
            }
        });

        txtCustomerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomerNameKeyTyped(evt);
            }
        });

        txtCustomerEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomerEmailKeyTyped(evt);
            }
        });

        txtCustomerAdress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomerAdressKeyTyped(evt);
            }
        });

        txtCustomerPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomerPhoneKeyTyped(evt);
            }
        });

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "CL", "Name", "Adress", "Phone", "Email"
            }
        ));
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);
        if (tableCustomer.getColumnModel().getColumnCount() > 0) {
            tableCustomer.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableCustomer.getColumnModel().getColumn(1).setPreferredWidth(25);
            tableCustomer.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableCustomer.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableCustomer.getColumnModel().getColumn(4).setPreferredWidth(50);
            tableCustomer.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        btnNewCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_add_customer.jpg"))); // NOI18N
        btnNewCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCustomerActionPerformed(evt);
            }
        });

        btnEditCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_edit.jpg"))); // NOI18N
        btnEditCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCustomerActionPerformed(evt);
            }
        });

        btnSaveCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_save.jpg"))); // NOI18N
        btnSaveCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCustomerActionPerformed(evt);
            }
        });

        btnDeleteCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_Delete (1).jpg"))); // NOI18N
        btnDeleteCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel2.setText("New");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel3.setText("Delete");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel4.setText("Save");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel5.setText("Edit");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtCustomerCl, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCustomerAdress, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(txtCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnEditCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSaveCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnNewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaveCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtCustomerCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtCustomerAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(txtCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1125, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(21, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab5", jPanel7);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("CL:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Name:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Phone:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Adress:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Email:");

        tableProvider.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CL", "Name", "Adress", "Phone", "Email"
            }
        ));
        tableProvider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProviderMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableProvider);
        if (tableProvider.getColumnModel().getColumnCount() > 0) {
            tableProvider.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableProvider.getColumnModel().getColumn(1).setPreferredWidth(30);
            tableProvider.getColumnModel().getColumn(2).setPreferredWidth(120);
            tableProvider.getColumnModel().getColumn(3).setPreferredWidth(120);
            tableProvider.getColumnModel().getColumn(4).setPreferredWidth(50);
            tableProvider.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        txtProviderCl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProviderClKeyTyped(evt);
            }
        });

        txtProviderName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProviderNameKeyTyped(evt);
            }
        });

        txtProviderAdress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProviderAdressKeyTyped(evt);
            }
        });

        txtProviderPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProviderPhoneActionPerformed(evt);
            }
        });
        txtProviderPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProviderPhoneKeyTyped(evt);
            }
        });

        btnDeleteProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_Delete (1).jpg"))); // NOI18N
        btnDeleteProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProviderActionPerformed(evt);
            }
        });

        btnNewProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_add_customer.jpg"))); // NOI18N
        btnNewProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProviderActionPerformed(evt);
            }
        });

        btnEditProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_edit.jpg"))); // NOI18N
        btnEditProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProviderActionPerformed(evt);
            }
        });

        btnSaveProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_save.jpg"))); // NOI18N
        btnSaveProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProviderActionPerformed(evt);
            }
        });

        jLabel24.setText("New");

        jLabel25.setText("Delete");

        jLabel26.setText("Edit");

        jLabel27.setText("Save");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProviderEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProviderPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProviderAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtProviderCl, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(txtIdProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtProviderName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnNewProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnDeleteProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel26)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaveProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel27)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnNewProvider)
                                .addComponent(btnDeleteProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSaveProvider)
                                    .addComponent(btnEditProvider))
                                .addGap(2, 2, 2)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27)))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtProviderCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtProviderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(txtProviderAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtProviderPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtProviderEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(143, 143, 143))
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel78.setText("Code:");

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel79.setText("Description:");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel80.setText("Amount:");

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel81.setText("Cost:");

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel82.setText("Provider:");

        txtProductCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductCodeActionPerformed(evt);
            }
        });
        txtProductCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductCodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductCodeKeyTyped(evt);
            }
        });

        txtProductAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductAmountActionPerformed(evt);
            }
        });
        txtProductAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductAmountKeyTyped(evt);
            }
        });

        txtProductDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductDescriptionActionPerformed(evt);
            }
        });
        txtProductDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductDescriptionKeyTyped(evt);
            }
        });

        txtProductCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductCostKeyTyped(evt);
            }
        });

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Code", "Name", "Provider", "Stock", "Cost"
            }
        ));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tableProduct);
        if (tableProduct.getColumnModel().getColumnCount() > 0) {
            tableProduct.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableProduct.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableProduct.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableProduct.getColumnModel().getColumn(3).setPreferredWidth(70);
            tableProduct.getColumnModel().getColumn(4).setPreferredWidth(35);
            tableProduct.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        btnEditProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_edit.jpg"))); // NOI18N
        btnEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProductActionPerformed(evt);
            }
        });

        btnSaveProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_save.jpg"))); // NOI18N
        btnSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProductActionPerformed(evt);
            }
        });

        btnNewProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_add_product.jpg"))); // NOI18N

        btnDeleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_Delete (1).jpg"))); // NOI18N
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        btnExcelProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_excel.jpg"))); // NOI18N
        btnExcelProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelProductActionPerformed(evt);
            }
        });

        jLabel83.setText("Delete");

        jLabel84.setText("Edit");

        jLabel85.setText("Save");

        jLabel86.setText("New");

        jLabel87.setText("Excel");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductCost, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxProductProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel83)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel84)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel85))
                                    .addComponent(btnSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel86)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel87)
                                    .addComponent(btnExcelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79)
                    .addComponent(jLabel80)
                    .addComponent(txtProductAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81)
                    .addComponent(txtProductCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82)
                    .addComponent(cbxProductProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEditProduct, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSaveProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNewProduct, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnDeleteProduct))
                    .addComponent(btnExcelProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(jLabel84)
                    .addComponent(jLabel85)
                    .addComponent(jLabel86)
                    .addComponent(jLabel87))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab5", jPanel26);

        btnPdfSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_pdf.jpg"))); // NOI18N
        btnPdfSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfSalesActionPerformed(evt);
            }
        });

        tableSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer", "Seller", "Total"
            }
        ));
        tableSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSalesMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tableSales);
        if (tableSales.getColumnModel().getColumnCount() > 0) {
            tableSales.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableSales.getColumnModel().getColumn(1).setPreferredWidth(60);
            tableSales.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableSales.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        txtIdSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdSaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnPdfSales, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdSale, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(425, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPdfSales, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1191, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab6", jPanel23);

        jLabel69.setText("CL:");

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel70.setText("Name:");

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel71.setText("Adress:");

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel72.setText("Phone:");

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel73.setText("Email:");

        txtClSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClSettingsActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel74.setText("Company Data");

        btnSaveSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_save.jpg"))); // NOI18N
        btnSaveSettings.setText("Save");
        btnSaveSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSettingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(btnSaveSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel69)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtClSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(91, 91, 91)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel70)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNameSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhoneSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAdressSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmailSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addComponent(jLabel74)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel74)
                .addGap(18, 18, 18)
                .addComponent(txtIdSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(txtNameSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71)
                    .addComponent(txtAdressSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(txtPhoneSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(txtEmailSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnSaveSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(248, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab7", jPanel25);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 1130, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSaleActionPerformed
       CleanTable();
       jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnNewSaleActionPerformed

    private void txtProviderPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProviderPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProviderPhoneActionPerformed

    private void btnNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCustomerActionPerformed
        CleanCustomer();
    }//GEN-LAST:event_btnNewCustomerActionPerformed

    private void txtClSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClSettingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClSettingsActionPerformed

    private void txtIdSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdSaleActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void btnSaveCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCustomerActionPerformed
        if (!"".equals(txtCustomerCl.getText()) || !"".equals(txtCustomerName.getText())||!"".equals(txtCustomerAdress.getText())||!"".equals(txtCustomerPhone.getText())){
        cu.setCl(Integer.parseInt(txtCustomerCl.getText()));
        cu.setName(txtCustomerName.getText());
        cu.setAdress(txtCustomerAdress.getText());
        cu.setPhone(Integer.parseInt(txtCustomerPhone.getText()));
        cu.setEmail(txtCustomerEmail.getText());
        customer.RegisterCustomer(cu);
        CleanTable();
        CleanCustomer();
        ListCustomer();
        JOptionPane.showMessageDialog(null,"successfully registered customer");
    }else{
                JOptionPane.showMessageDialog(null,"the fields are empty");
                }
    }//GEN-LAST:event_btnSaveCustomerActionPerformed

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        CleanTable();
        ListCustomer();
       jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        int row = tableCustomer.rowAtPoint(evt.getPoint());
        txtIdCustomer.setText(tableCustomer.getValueAt(row, 0).toString());
        txtCustomerCl.setText(tableCustomer.getValueAt(row, 1).toString());
        txtCustomerName.setText(tableCustomer.getValueAt(row, 2).toString());
        txtCustomerAdress.setText(tableCustomer.getValueAt(row, 3).toString());
        txtCustomerPhone.setText(tableCustomer.getValueAt(row, 4).toString());
        txtCustomerEmail.setText(tableCustomer.getValueAt(row, 5).toString());
        
    }//GEN-LAST:event_tableCustomerMouseClicked

    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        if(!"".equals(txtIdCustomer.getText())){
          int confirmation = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this element? ")  ;
          if(confirmation == 0){
              int id = Integer.parseInt(txtIdCustomer.getText());
              customer.DelteCustomer(id);
              CleanTable();
              CleanCustomer();
              ListCustomer();
          }
        }
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    private void btnEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCustomerActionPerformed
        if("".equals(txtIdCustomer.getText())){
          JOptionPane.showMessageDialog(null,"Select a row");
          
        }else{
          
            if(!"".equals(txtCustomerCl.getText())||!"".equals(txtCustomerName.getText()) || !"".equals(txtCustomerAdress.getText())||!"".equals(txtCustomerPhone.getText())||!"".equals(txtCustomerEmail.getText())){
            cu.setCl(Integer.parseInt(txtCustomerCl.getText()));
            cu.setName(txtCustomerName.getText());
            cu.setAdress(txtCustomerAdress.getText());
            cu.setPhone(Integer.parseInt(txtCustomerPhone.getText()));
            cu.setEmail(txtCustomerEmail.getText());
            cu.setId(Integer.parseInt(txtIdCustomer.getText()));
                customer.ModifyCustomer(cu);
               CleanTable();
               CleanCustomer();
               ListCustomer();
            }else{
                JOptionPane.showMessageDialog(null,"The fields are empty");
            }
        }
        
    }//GEN-LAST:event_btnEditCustomerActionPerformed

    private void btnSaveProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProviderActionPerformed
    
        if(!"".equals(txtProviderCl.getText()) || !"".equals(txtProviderName.getText()) ||!"".equals(txtProviderAdress.getText()) ||!"".equals(txtProviderPhone.getText()) ||!"".equals(txtProviderEmail.getText())){
        
        pr.setCl(Integer.parseInt(txtProviderCl.getText()));
        pr.setName(txtProviderName.getText());
        pr.setAdress(txtProviderAdress.getText());
        pr.setPhone(Integer.parseInt(txtProviderPhone.getText()));
        pr.setEmail(txtProviderEmail.getText());
        prDAO.RegisterProvider(pr);
        CleanTable();
        CleanProvider();
        ListProvider();
        JOptionPane.showMessageDialog(null,"successfully registered provider");
                }  else{
            JOptionPane.showMessageDialog(null, "The fields are empty");
        }        
    }//GEN-LAST:event_btnSaveProviderActionPerformed

    private void btnProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProviderActionPerformed
        CleanTable();
        ListProvider();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnProviderActionPerformed

    private void tableProviderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProviderMouseClicked
       int row = tableProvider.rowAtPoint(evt.getPoint());
       txtIdProvider.setText(tableProvider.getValueAt(row,0).toString());
       txtProviderCl.setText(tableProvider.getValueAt(row,1).toString());
       txtProviderName.setText(tableProvider.getValueAt(row,2).toString());
       txtProviderAdress.setText(tableProvider.getValueAt(row,3).toString());
       txtProviderPhone.setText(tableProvider.getValueAt(row,4).toString());
       txtProviderEmail.setText(tableProvider.getValueAt(row,5).toString());
    }//GEN-LAST:event_tableProviderMouseClicked

    private void btnDeleteProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProviderActionPerformed
        if(!"".equals(txtIdProvider.getText())){
            int confirmation = JOptionPane.showConfirmDialog(null," Are sure you want to delete this element?");
            if(confirmation == 0){
              int id = Integer.parseInt(txtIdProvider.getText());  
              prDAO.DeleteProvider(id);
              CleanTable();
              ListProvider();
              CleanProvider();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Select a row");
        }
    }//GEN-LAST:event_btnDeleteProviderActionPerformed

    private void btnEditProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProviderActionPerformed
        if("".equals(txtIdProvider.getText())){
            JOptionPane.showMessageDialog(null,"Select a row");   
        }else{
         if(!"".equals(txtIdProvider.getText())||!"".equals(txtProviderName.getText())||!"".equals(txtProviderAdress.getText())||!"".equals(txtProviderPhone.getText())||!"".equals(txtProviderEmail.getText())){
             pr.setCl(Integer.parseInt(txtProviderCl.getText()));
             pr.setName(txtProviderName.getText());
             pr.setAdress(txtProviderAdress.getText());
             pr.setPhone(Integer.parseInt(txtProviderPhone.getText()));
             pr.setEmail(txtProviderEmail.getText());
             pr.setId(Integer.parseInt(txtIdProvider.getText()));
             prDAO.ModifyProvider(pr);
             JOptionPane.showMessageDialog(null, "Provider Modified");
             CleanTable();
             ListProvider();
             CleanProvider();
         }   
        }
    }//GEN-LAST:event_btnEditProviderActionPerformed

    private void btnNewProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProviderActionPerformed
        CleanProvider();
    }//GEN-LAST:event_btnNewProviderActionPerformed

    private void btnSaveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductActionPerformed
        if(!"".equals(txtProductCode.getText())||!"".equals(txtProductDescription.getText())||!"".equals(cbxProductProvider.getSelectedItem())||!"".equals(txtProductAmount.getText())||!"".equals(txtProductCost.getText())){
        pro.setCode(txtProductCode.getText());
        pro.setName(txtProductDescription.getText());
        pro.setProviderPr( cbxProductProvider.getSelectedItem().toString());
        pro.setStock(Integer.parseInt(txtProductAmount.getText()));
        pro.setCost(Double.parseDouble(txtProductCost.getText()));
        
        proDAO.RegisterProducts(pro);
        CleanTable();
        CleanProducts();
        ListProducts();
        JOptionPane.showMessageDialog(null, "Product registered");
        
        }else{
            JOptionPane.showMessageDialog(null, "The fields are empty");
        }
    }//GEN-LAST:event_btnSaveProductActionPerformed

    private void txtProductDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductDescriptionActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsActionPerformed
        CleanTable();
        ListProducts();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnProductsActionPerformed

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
     int row = tableProduct.rowAtPoint(evt.getPoint());
       txtIdProduct.setText(tableProduct.getValueAt(row,0).toString());
       txtProductCode.setText(tableProduct.getValueAt(row,1).toString());
       txtProductDescription.setText(tableProduct.getValueAt(row,2).toString());
       cbxProductProvider.setSelectedItem(tableProduct.getValueAt(row,3).toString());
       txtProductAmount.setText(tableProduct.getValueAt(row,4).toString());
       txtProductCost.setText(tableProduct.getValueAt(row,5).toString());  
    }//GEN-LAST:event_tableProductMouseClicked

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        if(!"".equals(txtIdProduct.getText())){
          int confirmation = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this element? ")  ;
          if(confirmation == 0){
              int id = Integer.parseInt(txtIdProduct.getText());
              proDAO.DelteProducts(id);
              CleanTable();
              CleanProducts();
              ListProducts();
          }
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProductActionPerformed
        if("".equals(txtIdProduct.getText())){
            JOptionPane.showMessageDialog(null,"Select a row");   
        }else{
         if("".equals(txtIdProduct.getText())||!"".equals(txtProductCode.getText())||!"".equals(txtProductDescription.getText())||!"".equals(cbxProductProvider.getSelectedItem().toString())||!"".equals(txtProductAmount.getText())||!"".equals(txtProductCost.getText())){
             pro.setCode(txtProductCode.getText());
             pro.setName(txtProductDescription.getText());
             pro.setProviderPr(cbxProductProvider.getSelectedItem().toString());
             pro.setStock(Integer.parseInt(txtProductAmount.getText()));
             pro.setCost(Double.parseDouble(txtProductCost.getText()));
             pro.setId(Integer.parseInt(txtIdProduct.getText()));
             proDAO.ModifyProducts(pro);
             JOptionPane.showMessageDialog(null, "Product Modified");
             CleanTable();
             ListProducts();
             CleanProducts();
         }   
        }
    }//GEN-LAST:event_btnEditProductActionPerformed

    private void btnExcelProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelProductActionPerformed
        Excel.report();
    }//GEN-LAST:event_btnExcelProductActionPerformed

    private void btnCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCustomersMouseClicked

    private void btnSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesActionPerformed
        jTabbedPane1.setSelectedIndex(4);
        CleanTable();
        ListSales();
    }//GEN-LAST:event_btnSalesActionPerformed

    private void txtProductCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductCodeActionPerformed
        
    }//GEN-LAST:event_txtProductCodeActionPerformed

    private void txtProductCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductCodeKeyPressed
       
    }//GEN-LAST:event_txtProductCodeKeyPressed

    private void txtSaleCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaleCodeKeyPressed
         if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            if(!"".equals(txtSaleCode.getText())){
                String code = txtSaleCode.getText();
                pro = proDAO.SearchProduct(code);
                if(pro.getName()!=null){
                    txtSaleDescription.setText(""+pro.getName());
                    txtNewSaleCost.setText(""+pro.getCost());
                    txtSaleAvailableStock.setText(""+pro.getStock());
                    txtSaleAmount.requestFocus();
                    
                    
                }else{
                  CleanSale();
                  txtSaleCode.requestFocus();  
                }
            }else{
                JOptionPane.showMessageDialog(null, "Type the product code");
                txtSaleCode.requestFocus();
            }
        }
    }//GEN-LAST:event_txtSaleCodeKeyPressed

    private void txtSaleAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaleAmountKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!"".equals(txtSaleAmount.getText())){
                String code = txtSaleCode.getText();
                String description = txtSaleDescription.getText();
                int amount = Integer.parseInt(txtSaleAmount.getText());
                double cost = Double.parseDouble(txtNewSaleCost.getText());
                double total = amount * cost;
                int stock = Integer.parseInt(txtSaleAvailableStock.getText());
                if(stock >=amount){
                    item = item + 1;
                     tm = (DefaultTableModel)tableSale.getModel();
                    for(int i =0;i<tableSale.getRowCount();i++){
                        if(tableSale.getValueAt(i,1).equals(txtSaleDescription.getText())){
                            JOptionPane.showMessageDialog(null,"The product is already registered");
                            return;
                        }
                    }
                    ArrayList list = new ArrayList();
                    list.add(item);
                    list.add(code);
                    list.add(description);
                    list.add(amount);
                    list.add(cost);
                    list.add(total);
                    Object[] ob = new Object[5];
                    ob[0] = list.get(1);
                    ob[1] = list.get(2);
                    ob[2] = list.get(3);
                    ob[3] = list.get(4);
                    ob[4] = list.get(5);
                    tm.addRow(ob);
                    tableSale.setModel(tm);
                    TotalDue();
                    CleanSale();
                    txtSaleCode.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null,"Stock no available");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Type amount");
            }
        }
    }//GEN-LAST:event_txtSaleAmountKeyPressed

    private void btnDeleteSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSaleActionPerformed
        model = (DefaultTableModel) tableSale.getModel();
        model.removeRow(tableSale.getSelectedRow());
        TotalDue();
        txtSaleCode.requestFocus();
        
    }//GEN-LAST:event_btnDeleteSaleActionPerformed

    private void txtSaleClKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaleClKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           if(!"".equals(txtSaleCl.getText())){
               int c = Integer.parseInt(txtSaleCl.getText());
               cu=customer.SearchCustomer(c);
               if(cu.getName()!=null){
                   txtSaleCustomerName.setText(""+cu.getName());
                   txtSaleCustomerAdress.setText(""+cu.getAdress());
                   txtSaleCustomerPhone.setText(""+cu.getPhone());
                   txtSaleCustomerEmail.setText(""+cu.getEmail());
                   
               }else{
                   txtSaleCl.setText("");
                   JOptionPane.showMessageDialog(null,"The customer doesn't exist");
               }
               
           }
       }
    }//GEN-LAST:event_txtSaleClKeyPressed

    private void btnSalePrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalePrintActionPerformed
        if(tableSale.getRowCount()>0){
            if(!"".equals(txtSaleCustomerName.getText())){
              RegisterSale();
              RegisterDetail();
              UpdateStock();
              pdf();
              CleanSaleTable();
              CleanSale();
              CleanCustomerSale();  
            }else{
                JOptionPane.showMessageDialog(null,"You must select a customer");
            }
        }else{
                JOptionPane.showMessageDialog(null,"You must select a product");
            }
        
        
    }//GEN-LAST:event_btnSalePrintActionPerformed

    private void txtSaleCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaleCodeKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtSaleCodeKeyTyped

    private void txtSaleDescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaleDescriptionKeyTyped
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtSaleDescriptionKeyTyped

    private void txtSaleAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaleAmountKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtSaleAmountKeyTyped

    private void txtSaleClKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaleClKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtSaleClKeyTyped

    private void txtSaleCustomerNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaleCustomerNameKeyTyped
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtSaleCustomerNameKeyTyped

    private void txtSaleAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaleAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaleAmountActionPerformed

    private void txtNewSaleCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewSaleCostKeyTyped
       event.numberDecimalKeyPress(evt, txtProductCost);
    }//GEN-LAST:event_txtNewSaleCostKeyTyped

    private void txtCustomerClKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerClKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCustomerClKeyTyped

    private void txtCustomerNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerNameKeyTyped
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtCustomerNameKeyTyped

    private void txtCustomerAdressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerAdressKeyTyped
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtCustomerAdressKeyTyped

    private void txtCustomerPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerPhoneKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCustomerPhoneKeyTyped

    private void txtCustomerEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerEmailKeyTyped
        
    }//GEN-LAST:event_txtCustomerEmailKeyTyped

    private void txtProviderClKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProviderClKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtProviderClKeyTyped

    private void txtProviderNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProviderNameKeyTyped
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtProviderNameKeyTyped

    private void txtProviderAdressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProviderAdressKeyTyped
       event.textKeyPress(evt);
    }//GEN-LAST:event_txtProviderAdressKeyTyped

    private void txtProviderPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProviderPhoneKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtProviderPhoneKeyTyped

    private void txtProductCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductCodeKeyTyped
        
    }//GEN-LAST:event_txtProductCodeKeyTyped

    private void txtProductDescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductDescriptionKeyTyped
       event.textKeyPress(evt);
    }//GEN-LAST:event_txtProductDescriptionKeyTyped

    private void txtProductAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductAmountActionPerformed

    private void txtProductAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductAmountKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtProductAmountKeyTyped

    private void txtProductCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductCostKeyTyped
        event.numberDecimalKeyPress(evt, txtProductCost);
    }//GEN-LAST:event_txtProductCostKeyTyped

    private void btnSaveSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSettingsActionPerformed
       if(!"".equals(txtClSettings.getText())||!"".equals(txtNameSettings.getText()) || !"".equals(txtAdressSettings.getText())||!"".equals(txtPhoneSettings.getText())||!"".equals(txtEmailSettings.getText())){
            Setting.setCl(Integer.parseInt(txtClSettings.getText()));
            Setting.setName(txtNameSettings.getText());
            Setting.setAdress(txtAdressSettings.getText());
            Setting.setPhone(Integer.parseInt(txtPhoneSettings.getText()));
            Setting.setEmail(txtCustomerEmail.getText());
            Setting.setId(Integer.parseInt(txtIdSettings.getText()));
              proDAO.ModifyData(Setting);
              JOptionPane.showMessageDialog(null,"Company data modified");
              ListSettings();
            }else{
                JOptionPane.showMessageDialog(null,"The fields are empty");
            }
    }//GEN-LAST:event_btnSaveSettingsActionPerformed

    private void txtSaleAvailableStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaleAvailableStockKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtSaleAvailableStockKeyTyped

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_btnConfigActionPerformed

    private void tableSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSalesMouseClicked
      int row = tableSales.rowAtPoint(evt.getPoint());
      txtIdSale.setText(tableSales.getValueAt(row,0).toString());
    }//GEN-LAST:event_tableSalesMouseClicked

    private void btnPdfSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfSalesActionPerformed
        try {
            int id = Integer.parseInt(txtIdSale.getText());
            File file = new File("src/pdf/sale"+id+".pdf");
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            Logger.getLogger(page1_system.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPdfSalesActionPerformed

    private void btnGraphicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraphicActionPerformed
        
        String reportDate = new SimpleDateFormat("dd/MM/yyyy").format(myDate.getDate());
        Graphic.Graphic(reportDate);
    }//GEN-LAST:event_btnGraphicActionPerformed

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        Login reg = new Login();
        reg.setVisible(true);
    }//GEN-LAST:event_btnUsersActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(page1_system.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(page1_system.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(page1_system.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(page1_system.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new page1_system().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnDeleteProvider;
    private javax.swing.JButton btnDeleteSale;
    private javax.swing.JButton btnEditCustomer;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JButton btnEditProvider;
    private javax.swing.JButton btnExcelProduct;
    private javax.swing.JButton btnGraphic;
    private javax.swing.JButton btnNewCustomer;
    private javax.swing.JButton btnNewProduct;
    private javax.swing.JButton btnNewProvider;
    private javax.swing.JButton btnNewSale;
    private javax.swing.JButton btnPdfSales;
    private javax.swing.JButton btnProducts;
    private javax.swing.JButton btnProvider;
    private javax.swing.JButton btnSalePrint;
    private javax.swing.JButton btnSales;
    private javax.swing.JButton btnSaveCustomer;
    private javax.swing.JButton btnSaveProduct;
    private javax.swing.JButton btnSaveProvider;
    private javax.swing.JButton btnSaveSettings;
    private javax.swing.JButton btnUsers;
    private javax.swing.JComboBox<String> cbxProductProvider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelSeller;
    private javax.swing.JLabel labelTotal;
    private com.toedter.calendar.JDateChooser myDate;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTable tableProvider;
    private javax.swing.JTable tableSale;
    private javax.swing.JTable tableSales;
    private javax.swing.JTextField txtAdressSettings;
    private javax.swing.JTextField txtClSettings;
    private javax.swing.JTextField txtCustomerAdress;
    private javax.swing.JTextField txtCustomerCl;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerPhone;
    private javax.swing.JTextField txtEmailSettings;
    private javax.swing.JTextField txtIdCustomer;
    private javax.swing.JTextField txtIdProduct;
    private javax.swing.JTextField txtIdProvider;
    private javax.swing.JTextField txtIdSale;
    private javax.swing.JTextField txtIdSettings;
    private javax.swing.JTextField txtNameSettings;
    private javax.swing.JTextField txtNewSaleCost;
    private javax.swing.JTextField txtPhoneSettings;
    private javax.swing.JTextField txtProductAmount;
    private javax.swing.JTextField txtProductCode;
    private javax.swing.JTextField txtProductCost;
    private javax.swing.JTextField txtProductDescription;
    private javax.swing.JTextField txtProviderAdress;
    private javax.swing.JTextField txtProviderCl;
    private javax.swing.JTextField txtProviderEmail;
    private javax.swing.JTextField txtProviderName;
    private javax.swing.JTextField txtProviderPhone;
    private javax.swing.JTextField txtSaleAmount;
    private javax.swing.JTextField txtSaleAvailableStock;
    private javax.swing.JTextField txtSaleCl;
    private javax.swing.JTextField txtSaleCode;
    private javax.swing.JLabel txtSaleCost;
    private javax.swing.JTextField txtSaleCustomerAdress;
    private javax.swing.JTextField txtSaleCustomerEmail;
    private javax.swing.JTextField txtSaleCustomerName;
    private javax.swing.JTextField txtSaleCustomerPhone;
    private javax.swing.JTextField txtSaleDescription;
    private javax.swing.JLabel txtSaleStock;
    // End of variables declaration//GEN-END:variables
    private void CleanCustomer(){
     txtIdCustomer.setText("");
     txtCustomerCl.setText("");
     txtCustomerName.setText("");
     txtCustomerAdress.setText("");
     txtCustomerPhone.setText("");
     txtCustomerEmail.setText("");
             
    }
     private void CleanProvider(){
     txtIdProvider.setText("");
     txtProviderCl.setText("");
     txtProviderName.setText("");
     txtProviderAdress.setText("");
     txtProviderPhone.setText("");
     txtProviderEmail.setText("");
             
    }
     private void CleanProducts(){
     txtIdProduct.setText("");
     txtProductCode.setText("");
     txtProductDescription.setText("");
     txtProductAmount.setText("");
     txtProductCost.setText("");
     
             
    }
     private void TotalDue(){
         totalDue = 0.00;
         int numRow = tableSale.getRowCount();
         for(int i =0 ;i<numRow;i++){
             double calculate = Double.parseDouble(String.valueOf(tableSale.getModel().getValueAt(i,4)));
             totalDue = totalDue + calculate;
             
         }
         labelTotal.setText(String.format("%.2f",totalDue));
     }
     private void CleanSale(){
         txtSaleCode.setText("");
         txtSaleDescription.setText("");
         txtSaleAmount.setText("");
         txtSaleAvailableStock.setText("");
         txtNewSaleCost.setText("");
         txtIdSale.setText("");
     }
     private void RegisterSale(){
         String customer = txtSaleCustomerName.getText();
         String seller = labelSeller.getText();
         double fee = totalDue;
         s.setCustomer(customer);
         s.setSeller(seller);
         s.setTotal(fee);
         s.setDate(currentDate);
         sDAO.RegisterSale(s);
     }
     private void RegisterDetail(){
         int id = sDAO.IdSale();
         for(int i = 0; i<tableSale.getRowCount();i++){
             String code = tableSale.getValueAt(i,0).toString();
             int amount = Integer.parseInt(tableSale.getValueAt(i,2).toString());
             double cost = Double.parseDouble(tableSale.getValueAt(i,3).toString());
             Sd.setCode_pro(code);
             Sd.setAmount(amount);
             Sd.setCost(cost);
             Sd.setId(id);
             sDAO.RegisterDetail(Sd);
             
         }
     }
     private void UpdateStock(){
         for(int i=0;i<tableSale.getRowCount();i++){
             String code = tableSale.getValueAt(i,0).toString();
             int amount = Integer.parseInt(tableSale.getValueAt(i,2).toString());
             pro = proDAO.SearchProduct(code);
             int CurrentStock = pro.getStock()-amount;
             sDAO.UpdateStock(CurrentStock, code);
         }
     }
     private void CleanSaleTable(){
     tm = (DefaultTableModel) tableSale.getModel(); 
     int row = tableSale.getRowCount();
     for(int i=0;i<row;i++){
         tm.removeRow(0);
     }
}
     private void CleanCustomerSale(){
         txtIdSale.setText("");
        txtSaleCustomerName.setText("");
        txtSaleCustomerAdress.setText("");
        txtSaleCustomerPhone.setText("");
        txtSaleCustomerEmail.setText("");
     }
     private void pdf(){
         try {
             int id = sDAO.IdSale();
             FileOutputStream archive;
             File file = new File("src/pdf/sale"+id+".pdf");
             archive = new FileOutputStream(file);
             Document doc = new Document();
             PdfWriter.getInstance(doc,archive);
             doc.open();
             Image img = Image.getInstance("src/images/logo.png");
             
             Paragraph date = new Paragraph();
             Font bold = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLUE);
             date.add(Chunk.NEWLINE);
             Date da = new Date();
             date.add("Invoice: "+id+"\n"+"Date: "+new SimpleDateFormat("dd-MM-yyyy").format(da)+"\n\n");
             
             PdfPTable header = new PdfPTable(4);
             header.setWidthPercentage(100);
             header.getDefaultCell().setBorder(0);
             float[]ColumnHeader = new float[]{20f,30f,70f,40f};
             header.setWidths(ColumnHeader);
             header.setHorizontalAlignment(Element.ALIGN_LEFT);
             
             header.addCell(img);
             String cl = txtClSettings.getText();
             String name = txtNameSettings.getText();
             String adress = txtAdressSettings.getText();
             String phone = txtPhoneSettings.getText();
             String email = txtEmailSettings.getText();
             
             header.addCell("");
             header.addCell("Cl: "+cl+"\nName: "+name+"\nAdress: "+adress+"\nPhone: " +phone+"\nEmail: "+email);
             header.addCell(date);
             doc.add(header);
             Paragraph cu = new Paragraph();
             cu.add(Chunk.NEWLINE);
             cu.add("Cutomers data"+"\n\n");
             doc.add(cu);
             
             
             PdfPTable CuTable = new PdfPTable(4);
             CuTable.setWidthPercentage(100);
             CuTable.getDefaultCell().setBorder(0);
             float[]ColumnCu = new float[]{20f,50f,30f,40f};
             CuTable.setWidths(ColumnCu);
             CuTable.setHorizontalAlignment(Element.ALIGN_LEFT);
             PdfPCell cu1 = new PdfPCell(new Phrase("Cl",bold));
             PdfPCell cu2 = new PdfPCell(new Phrase("Name",bold));
             PdfPCell cu3 = new PdfPCell(new Phrase("Adress",bold));
             PdfPCell cu4 = new PdfPCell(new Phrase("Phone",bold));
             cu1.setBorder(0);
             cu2.setBorder(0);
             cu3.setBorder(0);
             cu4.setBorder(0);
             CuTable.addCell(cu1);
             CuTable.addCell(cu2);
             CuTable.addCell(cu3);
             CuTable.addCell(cu4);
             CuTable.addCell(txtSaleCl.getText());
             CuTable.addCell(txtSaleCustomerName.getText());
             CuTable.addCell(txtSaleCustomerAdress.getText());
             CuTable.addCell(txtSaleCustomerPhone.getText());
             
             doc.add(CuTable);
             
             //PRODUCTS 
              PdfPTable ProTable = new PdfPTable(4);
             ProTable.setWidthPercentage(100);
             ProTable.getDefaultCell().setBorder(0);
             float[]ColumnPro = new float[]{10f,50f,15f,20f};
             ProTable.setWidths(ColumnPro);
             ProTable.setHorizontalAlignment(Element.ALIGN_LEFT);
             PdfPCell pro1 = new PdfPCell(new Phrase("Amount",bold));
             PdfPCell pro2 = new PdfPCell(new Phrase("Description",bold));
             PdfPCell pro3 = new PdfPCell(new Phrase("Cost",bold));
             PdfPCell pro4 = new PdfPCell(new Phrase("Total due",bold));
             pro1.setBorder(0);
             pro2.setBorder(0);
             pro3.setBorder(0);
             pro4.setBorder(0);
             
             pro1.setBackgroundColor(BaseColor.DARK_GRAY);
             pro2.setBackgroundColor(BaseColor.DARK_GRAY);
             pro3.setBackgroundColor(BaseColor.DARK_GRAY);
             pro4.setBackgroundColor(BaseColor.DARK_GRAY);
             ProTable.addCell(pro1);
             ProTable.addCell(pro2);
             ProTable.addCell(pro3);
             ProTable.addCell(pro4);
             
                 
              
                 for(int i =0;i<tableSale.getRowCount();i++){
                  ProTable.addCell(tableSale.getValueAt(i,1).toString());
                  ProTable.addCell(tableSale.getValueAt(i,2).toString());
                  ProTable.addCell(tableSale.getValueAt(i,3).toString());
                  ProTable.addCell(tableSale.getValueAt(i,4).toString());
                  
             
                 }
            
             doc.add(ProTable);
             
             Paragraph info = new Paragraph();
             info.add(Chunk.NEWLINE);
             info.add("Total due: "+totalDue);
             info.setAlignment(Element.ALIGN_RIGHT);
             doc.add(info);
             
             Paragraph signature = new Paragraph();
             signature.add(Chunk.NEWLINE);
             signature.add("Cancelation and signature\n\n");
             signature.add("____________________________");
             signature.setAlignment(Element.ALIGN_CENTER);
             doc.add(signature);
             
             Paragraph message = new Paragraph();
             message.add(Chunk.NEWLINE);
             message.add("Thank you for purchasing ");
             message.setAlignment(Element.ALIGN_CENTER);
             doc.add(message);
             doc.close();
             archive.close();
             Desktop.getDesktop().open(file);
             
             
             
         } catch (DocumentException | IOException e) {
             System.out.println(e.toString());
         }
     }
}
