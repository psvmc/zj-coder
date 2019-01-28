package cn.psvmc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.psvmc.utils.ZJ_ConfigUtils;
import cn.psvmc.utils.ZJ_FolderUtils;
import freemarker.template.TemplateException;

import javax.swing.JTextArea;
import javax.swing.JTabbedPane;

/**
 * @文件名：Index.java
 * @作用：
 * @作者：张剑
 * @创建时间：2014-2-3
 */
public class Index extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private static String selectTableName = "";
    private static String namespace = "";
    private static String tablePrefix = "";
    private static String fileNameSuffix = "";
    private static String fileName = "";
    private static String fileSuffix = "";
    private static String templateName = "";
    private static String outputPath = "";

    private static String host = "127.0.0.1";
    private static String port = "3306";
    private static String database = null;
    private static String charset = "UTF-8";
    private static String username = "root";
    private static String password = "root";

    public Index() {
        setBackground(Color.ORANGE);
        initComponents();
        init();
        StringBuffer onefile = new StringBuffer();
        onefile.append(" now(当前时间 )\n");
        onefile.append(" namespace(命名空间 如：cn.psvmc.model)\n");
        onefile.append(" fileSuffix(文件后缀 如：userVo.java中的java)\n");
        onefile.append(" fileName(文件名 如：userVo.java中的user)\n");
        onefile.append(" fileSuffix(文件名 如：userVo.java中的java)\n");
        onefile.append(" tableList(库中表列表列表 )\n");
        this.ta_database.setText(onefile.toString());

        StringBuffer tablefile = new StringBuffer();
        tablefile.append(" now(当前时间 )\n");
        tablefile.append(" namespace(命名空间 如：cn.psvmc.model)\n");
        tablefile.append(" fileNameSuffix(文件名后缀 如：userVo.java中的Vo)\n");
        tablefile.append(" fileName(文件名 如：userVo.java中的user)\n");
        tablefile.append(" fileSuffix(文件名 如：userVo.java中的java)\n");
        tablefile.append(" tablePojo(表对象 )\n");
        this.ta_table.setText(tablefile.toString());

        StringBuffer tablePars = new StringBuffer();
        tablePars.append(" tableName(数据库中的表名 如：tb_user)\n");
        tablePars.append(" className(对应的类名 如：User)\n");
        tablePars.append(" objectsName(对应的文件名 如：user)\n");
        tablePars.append(" tableComment(表的描述 如：用户表)\n");
        tablePars.append(" fieldList(表中字段列表 )\n");
        this.ta_table_pars.setText(tablePars.toString());

        StringBuffer fieldPars = new StringBuffer();
        fieldPars.append(" fieldName(表中字段名 如：name)\n");
        fieldPars.append(" methodName(对应的方法名 如：Name)\n");
        fieldPars.append(" fieldComment(表中字段的描述 如：用户名)\n");
        fieldPars.append(" fieldType(表中字段的类型 如：varchar)\n");
        fieldPars.append(" attributeType(对应实体类的类型 如：String)\n");
        fieldPars.append(" isKey(是否为主键 如：0)\n");
        fieldPars.append(" isIncrease(是否自增长 如：0)\n");
        this.ta_field_pars.setText(fieldPars.toString());
    }

    // GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jDialog1 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_namespace = new javax.swing.JTextField();
        tf_namespace.setToolTipText("namespace");
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField3.setToolTipText("把数据库中表类似于tb_user中的tb_去掉");
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField4.setToolTipText("文件名后缀 如：abcVo.java 中的Vo");
        jButton2 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jTextField10.setToolTipText("保存生成文件的位置");
        jButton4 = new javax.swing.JButton();

        jDialog1.setAlwaysOnTop(true);
        jDialog1.setBounds(new java.awt.Rectangle(0, 0, 600, 400));

        jFileChooser1.setApproveButtonText("\u786e\u5b9a");
        jFileChooser1.setApproveButtonToolTipText("\u786e\u5b9a");
        jFileChooser1.setCurrentDirectory(new java.io.File("D:\\代码生成"));
        jFileChooser1.setDialogTitle("\u6587\u4ef6\u5939\u9009\u62e9");
        jFileChooser1.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup().addContainerGap().addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE).addContainerGap()));
        jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jDialog1Layout.createSequentialGroup().addContainerGap().addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));

        jFileChooser1.getAccessibleContext().setAccessibleParent(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u4ee3\u7801\u751f\u6210\u5668(by\u5f20\u5251)");
        setAlwaysOnTop(true);
        setBounds(new Rectangle(100, 100, 400, 500));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("新宋体", 0, 12));
        setForeground(java.awt.Color.white);
        setResizable(false);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel3.setLayout(new java.awt.BorderLayout());

        GridBagLayout gbl_jPanel2 = new GridBagLayout();
        gbl_jPanel2.columnWeights = new double[]{0.0, 1.0};
        jPanel2.setLayout(gbl_jPanel2);

        jLabel11.setText("PORT：");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel11, gridBagConstraints);

        jLabel10.setText("HOST：");
        gridBagConstraints_21 = new java.awt.GridBagConstraints();
        gridBagConstraints_21.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_21.gridx = 0;
        gridBagConstraints_21.gridy = 0;
        gridBagConstraints_21.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel10, gridBagConstraints_21);

        jTextField11.setText("jTextField11");
        gridBagConstraints_22 = new java.awt.GridBagConstraints();
        gridBagConstraints_22.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints_22.gridx = 1;
        gridBagConstraints_22.gridy = 0;
        gridBagConstraints_22.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints_22.weightx = 1.0;
        jPanel2.add(jTextField11, gridBagConstraints_22);

        jTextField12.setText("jTextField12");
        gridBagConstraints_23 = new java.awt.GridBagConstraints();
        gridBagConstraints_23.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints_23.gridx = 1;
        gridBagConstraints_23.gridy = 1;
        gridBagConstraints_23.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints_23.weightx = 1.0;
        jPanel2.add(jTextField12, gridBagConstraints_23);

        jPanel3.add(jPanel2, BorderLayout.NORTH);

        lblDatabase = new JLabel();
        lblDatabase.setText("数据库名：");
        GridBagConstraints gbc_lblDatabase = new GridBagConstraints();
        gbc_lblDatabase.anchor = GridBagConstraints.EAST;
        gbc_lblDatabase.insets = new Insets(0, 0, 5, 5);
        gbc_lblDatabase.gridx = 0;
        gbc_lblDatabase.gridy = 2;
        jPanel2.add(lblDatabase, gbc_lblDatabase);

        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 2;
        jPanel2.add(textField_1, gbc_textField_1);

        label_2 = new JLabel();
        label_2.setText("字符编码：");
        GridBagConstraints gbc_label_2 = new GridBagConstraints();
        gbc_label_2.anchor = GridBagConstraints.EAST;
        gbc_label_2.insets = new Insets(0, 0, 5, 5);
        gbc_label_2.gridx = 0;
        gbc_label_2.gridy = 3;
        jPanel2.add(label_2, gbc_label_2);

        textField_2 = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 3;
        jPanel2.add(textField_2, gbc_textField_2);
        jLabel12 = new javax.swing.JLabel();

        jLabel12.setText("\u7528\u6237\u540d\uff1a");
        gridBagConstraints_25 = new java.awt.GridBagConstraints();
        gridBagConstraints_25.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_25.gridx = 0;
        gridBagConstraints_25.gridy = 4;
        gridBagConstraints_25.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel12, gridBagConstraints_25);
        jTextField13 = new javax.swing.JTextField();

        jTextField13.setText("jTextField13");
        gridBagConstraints_24 = new java.awt.GridBagConstraints();
        gridBagConstraints_24.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints_24.gridx = 1;
        gridBagConstraints_24.gridy = 4;
        gridBagConstraints_24.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints_24.weightx = 1.0;
        jPanel2.add(jTextField13, gridBagConstraints_24);
        jLabel13 = new javax.swing.JLabel();

        jLabel13.setText("\u5bc6\u7801\uff1a");
        gridBagConstraints_26 = new java.awt.GridBagConstraints();
        gridBagConstraints_26.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_26.gridx = 0;
        gridBagConstraints_26.gridy = 5;
        gridBagConstraints_26.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel13, gridBagConstraints_26);
        jTextField14 = new javax.swing.JTextField();

        jTextField14.setText("jTextField14");
        gridBagConstraints_27 = new java.awt.GridBagConstraints();
        gridBagConstraints_27.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints_27.gridx = 1;
        gridBagConstraints_27.gridy = 5;
        gridBagConstraints_27.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints_27.weightx = 1.0;
        jPanel2.add(jTextField14, gridBagConstraints_27);
        jButton3 = new javax.swing.JButton();

        jButton3.setText("\u6570\u636e\u5e93\u4fee\u6539");
        gridBagConstraints_28 = new java.awt.GridBagConstraints();
        gridBagConstraints_28.gridx = 0;
        gridBagConstraints_28.gridy = 7;
        gridBagConstraints_28.gridwidth = 2;
        gridBagConstraints_28.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(jButton3, gridBagConstraints_28);

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTabbedPane1.addTab("\u6570\u636e\u5e93\u8fde\u63a5\u914d\u7f6e", jPanel3);

        GridBagLayout gbl_jPanel1 = new GridBagLayout();
        gbl_jPanel1.columnWeights = new double[]{0.0, 1.0};
        jPanel1.setLayout(gbl_jPanel1);

        label_1 = new JLabel("删除原文件：");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.EAST;
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 0;
        jPanel1.add(label_1, gbc_label_1);

        checkBox = new JCheckBox("");
        checkBox.setToolTipText("是否删除目录中的原有文件");
        GridBagConstraints gbc_checkBox = new GridBagConstraints();
        gbc_checkBox.anchor = GridBagConstraints.WEST;
        gbc_checkBox.insets = new Insets(0, 0, 5, 0);
        gbc_checkBox.gridx = 1;
        gbc_checkBox.gridy = 0;
        jPanel1.add(checkBox, gbc_checkBox);

        label = new JLabel("过滤表名：");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.anchor = GridBagConstraints.EAST;
        gbc_label.fill = GridBagConstraints.VERTICAL;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 1;
        jPanel1.add(label, gbc_label);

        tf_tableName = new JTextField();
        tf_tableName.setToolTipText("模糊匹配数据库中的表名");
        GridBagConstraints gbc_tf_tableName = new GridBagConstraints();
        gbc_tf_tableName.insets = new Insets(0, 0, 5, 0);
        gbc_tf_tableName.fill = GridBagConstraints.HORIZONTAL;
        gbc_tf_tableName.gridx = 1;
        gbc_tf_tableName.gridy = 1;
        jPanel1.add(tf_tableName, gbc_tf_tableName);
        tf_tableName.setColumns(10);

        label_3 = new JLabel("所用模板：");
        GridBagConstraints gbc_label_3 = new GridBagConstraints();
        gbc_label_3.anchor = GridBagConstraints.EAST;
        gbc_label_3.insets = new Insets(0, 0, 5, 5);
        gbc_label_3.gridx = 0;
        gbc_label_3.gridy = 2;
        jPanel1.add(label_3, gbc_label_3);

        tf_templateName = new JTextField();
        tf_templateName.setToolTipText("所用的模板");
        tf_templateName.setText((String) null);
        tf_templateName.setColumns(10);
        GridBagConstraints gbc_tf_templateName = new GridBagConstraints();
        gbc_tf_templateName.insets = new Insets(0, 0, 5, 0);
        gbc_tf_templateName.fill = GridBagConstraints.BOTH;
        gbc_tf_templateName.gridx = 1;
        gbc_tf_templateName.gridy = 2;
        jPanel1.add(tf_templateName, gbc_tf_templateName);

        label_5 = new JLabel("文件后缀：");
        GridBagConstraints gbc_label_5 = new GridBagConstraints();
        gbc_label_5.anchor = GridBagConstraints.EAST;
        gbc_label_5.insets = new Insets(0, 0, 5, 5);
        gbc_label_5.gridx = 0;
        gbc_label_5.gridy = 3;
        jPanel1.add(label_5, gbc_label_5);

        tf_fileSuffix = new JTextField();
        tf_fileSuffix.setToolTipText("文件名后缀 如：abcVo.java 中的java");
        tf_fileSuffix.setColumns(10);
        GridBagConstraints gbc_tf_fileSuffix = new GridBagConstraints();
        gbc_tf_fileSuffix.insets = new Insets(0, 0, 5, 0);
        gbc_tf_fileSuffix.fill = GridBagConstraints.HORIZONTAL;
        gbc_tf_fileSuffix.gridx = 1;
        gbc_tf_fileSuffix.gridy = 3;
        jPanel1.add(tf_fileSuffix, gbc_tf_fileSuffix);

        label_4 = new JLabel("单文件名：");
        GridBagConstraints gbc_label_4 = new GridBagConstraints();
        gbc_label_4.anchor = GridBagConstraints.EAST;
        gbc_label_4.insets = new Insets(0, 0, 5, 5);
        gbc_label_4.gridx = 0;
        gbc_label_4.gridy = 4;
        jPanel1.add(label_4, gbc_label_4);

        tf_fileName = new JTextField();
        tf_fileName.setToolTipText("该字段只有在生成单个文件时生效");
        GridBagConstraints gbc_tf_fileName = new GridBagConstraints();
        gbc_tf_fileName.insets = new Insets(0, 0, 5, 0);
        gbc_tf_fileName.fill = GridBagConstraints.BOTH;
        gbc_tf_fileName.gridx = 1;
        gbc_tf_fileName.gridy = 4;
        jPanel1.add(tf_fileName, gbc_tf_fileName);
        tf_fileName.setColumns(10);

        jLabel2.setText("命名空间：");
        gridBagConstraints_3 = new java.awt.GridBagConstraints();
        gridBagConstraints_3.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_3.gridx = 0;
        gridBagConstraints_3.gridy = 5;
        gridBagConstraints_3.anchor = GridBagConstraints.EAST;
        jPanel1.add(jLabel2, gridBagConstraints_3);

        tf_namespace.setText("jTextField2");
        gbc_tf_namespace = new java.awt.GridBagConstraints();
        gbc_tf_namespace.insets = new Insets(0, 0, 5, 0);
        gbc_tf_namespace.gridx = 1;
        gbc_tf_namespace.gridy = 5;
        gbc_tf_namespace.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(tf_namespace, gbc_tf_namespace);

        jLabel3.setText("表名前缀(去掉)：");
        gridBagConstraints_5 = new java.awt.GridBagConstraints();
        gridBagConstraints_5.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_5.gridx = 0;
        gridBagConstraints_5.gridy = 6;
        gridBagConstraints_5.anchor = GridBagConstraints.EAST;
        jPanel1.add(jLabel3, gridBagConstraints_5);

        jTextField3.setText("jTextField3");
        gridBagConstraints_6 = new java.awt.GridBagConstraints();
        gridBagConstraints_6.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints_6.gridx = 1;
        gridBagConstraints_6.gridy = 6;
        gridBagConstraints_6.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jTextField3, gridBagConstraints_6);

        jLabel4.setText("生成文件名后缀：");
        gridBagConstraints_7 = new java.awt.GridBagConstraints();
        gridBagConstraints_7.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_7.gridx = 0;
        gridBagConstraints_7.gridy = 7;
        gridBagConstraints_7.anchor = GridBagConstraints.EAST;
        jPanel1.add(jLabel4, gridBagConstraints_7);

        jTextField4.setText("jTextField4");
        gridBagConstraints_9 = new java.awt.GridBagConstraints();
        gridBagConstraints_9.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints_9.gridx = 1;
        gridBagConstraints_9.gridy = 7;
        gridBagConstraints_9.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jTextField4, gridBagConstraints_9);

        jButton2.setText("\u751f\u6210\u4f4d\u7f6e");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        gridBagConstraints_12 = new java.awt.GridBagConstraints();
        gridBagConstraints_12.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints_12.gridx = 0;
        gridBagConstraints_12.gridy = 8;
        gridBagConstraints_12.anchor = GridBagConstraints.EAST;
        gridBagConstraints_12.weightx = 0.1;
        jPanel1.add(jButton2, gridBagConstraints_12);

        jTextField10.setText("jTextField10");
        gridBagConstraints_20 = new java.awt.GridBagConstraints();
        gridBagConstraints_20.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints_20.gridx = 1;
        gridBagConstraints_20.gridy = 8;
        gridBagConstraints_20.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints_20.weightx = 0.7;
        jPanel1.add(jTextField10, gridBagConstraints_20);

        jButton4.setText("\u4fee\u6539");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jButton4, gridBagConstraints);

        jTabbedPane1.addTab("\u751f\u6210\u914d\u7f6e", jPanel1);

        getContentPane().add(jTabbedPane1, BorderLayout.CENTER);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        jTabbedPane1.addTab("使用说明", null, tabbedPane, null);

        ta_table = new JTextArea();
        ta_table.setColumns(10);
        ta_table.setRows(12);
        tabbedPane.addTab("多表生成", null, ta_table, null);

        ta_database = new JTextArea();
        ta_database.setRows(12);
        ta_database.setColumns(10);
        tabbedPane.addTab("单文件生成", null, ta_database, null);

        ta_table_pars = new JTextArea();
        tabbedPane.addTab("可取表参数", null, ta_table_pars, null);

        ta_field_pars = new JTextArea();
        tabbedPane.addTab("可取字段参数", null, ta_field_pars, null);

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        act_panel = new JPanel();
        getContentPane().add(act_panel, BorderLayout.SOUTH);
        GridBagLayout gbl_act_panel = new GridBagLayout();
        gbl_act_panel.columnWidths = new int[]{153, 153};
        gbl_act_panel.rowHeights = new int[]{42, 0};
        gbl_act_panel.columnWeights = new double[]{0.0, 0.0};
        gbl_act_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        act_panel.setLayout(gbl_act_panel);

        btn2 = new JButton("对库和表生成一个文件");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jButton1 = new javax.swing.JButton();
        GridBagConstraints gbc_jButton1 = new GridBagConstraints();
        gbc_jButton1.fill = GridBagConstraints.HORIZONTAL;
        gbc_jButton1.insets = new Insets(0, 0, 0, 5);
        gbc_jButton1.gridx = 1;
        gbc_jButton1.gridy = 0;
        act_panel.add(jButton1, gbc_jButton1);

        jButton1.setText("对每个表生成");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        GridBagConstraints gbc_btn2 = new GridBagConstraints();
        gbc_btn2.fill = GridBagConstraints.HORIZONTAL;
        gbc_btn2.gridx = 0;
        gbc_btn2.gridy = 0;
        act_panel.add(btn2, gbc_btn2);
    }// </editor-fold>
    // GEN-END:initComponents
    // GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        jDialog1.setVisible(true);
    }

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getActionCommand().equals("ApproveSelection")) {
            this.jTextField10.setText(jFileChooser1.getSelectedFile().getAbsolutePath());
            jDialog1.setVisible(false);
        } else {
            jDialog1.setVisible(false);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (checkBox.isSelected()) {
                System.out.println("****************************************************************");
                ZJ_FolderUtils.delFolder(outputPath);
                System.out.println("****************************************************************");
            }
            CodeCreater.tableCreator();
            JOptionPane.showMessageDialog(this, "代码生成完毕！");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "输出错误！");
        } catch (TemplateException e) {
            JOptionPane.showMessageDialog(this, "模板加载错误！");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "加载错误！");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "数据库连接有误！");
        }

    }

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {
        int result = JOptionPane.showConfirmDialog(this, "该生成中模板不能调用表中字段信息,是否继续生成？", "注意", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {
                if (checkBox.isSelected()) {
                    System.out.println("****************************************************************");
                    ZJ_FolderUtils.delFolder(outputPath);
                    System.out.println("****************************************************************");
                }
                CodeCreater.databaseCreator();
                JOptionPane.showMessageDialog(this, "代码生成完毕！");
            } catch (IOException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "输出错误！");
            } catch (TemplateException e) {
                JOptionPane.showMessageDialog(this, "模板加载错误！");
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this, "加载错误！");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "数据库连接有误！");
            }
        }
    }

    /**
     * 修改方法
     *
     * @param evt
     * @author 张剑
     * @date 2014年11月13日 上午10:25:48
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        ZJ_ConfigUtils.setProperty("host", jTextField11.getText());
        ZJ_ConfigUtils.setProperty("port", jTextField12.getText());
        ZJ_ConfigUtils.setProperty("database", textField_1.getText());
        ZJ_ConfigUtils.setProperty("charset", textField_2.getText());
        ZJ_ConfigUtils.setProperty("username", jTextField13.getText());
        ZJ_ConfigUtils.setProperty("password", jTextField14.getText());
        init();
        JOptionPane.showMessageDialog(this, "修改成功！");
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        ZJ_ConfigUtils.setProperty("database", this.textField_1.getText());
        ZJ_ConfigUtils.setProperty("selectTableName", this.tf_tableName.getText());
        ZJ_ConfigUtils.setProperty("namespace", this.tf_namespace.getText());
        ZJ_ConfigUtils.setProperty("tablePrefix", this.jTextField3.getText());
        ZJ_ConfigUtils.setProperty("fileNameSuffix", this.jTextField4.getText());
        ZJ_ConfigUtils.setProperty("fileSuffix", this.tf_fileSuffix.getText());
        ZJ_ConfigUtils.setProperty("fileName", this.tf_fileName.getText());
        ZJ_ConfigUtils.setProperty("templateName", this.tf_templateName.getText());
        ZJ_ConfigUtils.setProperty("outputPath", this.jTextField10.getText());
        init();
        JOptionPane.showMessageDialog(this, "修改成功！");
    }

    /**
     * 初始化方法
     *
     * @author 张剑
     * @date 2014年11月13日 上午10:19:22
     */
    private void init() {
        selectTableName = ZJ_ConfigUtils.getProperty("selectTableName");
        namespace = ZJ_ConfigUtils.getProperty("namespace");
        tablePrefix = ZJ_ConfigUtils.getProperty("tablePrefix");
        fileNameSuffix = ZJ_ConfigUtils.getProperty("fileNameSuffix");
        fileSuffix = ZJ_ConfigUtils.getProperty("fileSuffix");
        fileName = ZJ_ConfigUtils.getProperty("fileName");
        templateName = ZJ_ConfigUtils.getProperty("templateName");
        outputPath = ZJ_ConfigUtils.getProperty("outputPath");

        host = ZJ_ConfigUtils.getProperty("host");
        port = ZJ_ConfigUtils.getProperty("port");
        database = ZJ_ConfigUtils.getProperty("database");
        charset = ZJ_ConfigUtils.getProperty("charset");
        username = ZJ_ConfigUtils.getProperty("username");
        password = ZJ_ConfigUtils.getProperty("password");
        this.tf_tableName.setText(selectTableName);
        this.tf_namespace.setText(namespace);
        this.jTextField3.setText(tablePrefix);
        this.jTextField4.setText(fileNameSuffix);
        this.tf_fileSuffix.setText(fileSuffix);
        this.tf_fileName.setText(fileName);
        this.jTextField4.setText(fileNameSuffix);
        this.tf_templateName.setText(templateName);
        this.jTextField10.setText(outputPath);
        this.jTextField11.setText(host);
        this.jTextField12.setText(port);
        this.textField_1.setText(database);
        this.textField_2.setText(charset);
        this.jTextField13.setText(username);
        this.jTextField14.setText(password);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField tf_namespace;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private JLabel label;
    private GridBagConstraints gridBagConstraints_3;
    private GridBagConstraints gbc_tf_namespace;
    private GridBagConstraints gridBagConstraints_5;
    private GridBagConstraints gridBagConstraints_6;
    private GridBagConstraints gridBagConstraints_7;
    private GridBagConstraints gridBagConstraints_9;
    private GridBagConstraints gridBagConstraints_12;
    private GridBagConstraints gridBagConstraints_20;
    private JTextField tf_tableName;
    private GridBagConstraints gridBagConstraints_21;
    private GridBagConstraints gridBagConstraints_22;
    private GridBagConstraints gridBagConstraints_23;
    private GridBagConstraints gridBagConstraints_24;
    private GridBagConstraints gridBagConstraints_25;
    private GridBagConstraints gridBagConstraints_26;
    private GridBagConstraints gridBagConstraints_27;
    private GridBagConstraints gridBagConstraints_28;
    private JCheckBox checkBox;
    private JLabel label_1;
    private JLabel lblDatabase;
    private JLabel label_2;
    private JTextField textField_1;
    private JTextField textField_2;
    private JLabel label_3;
    private JTextField tf_templateName;
    private JPanel act_panel;
    private JButton btn2;
    private JLabel label_4;
    private JTextField tf_fileName;
    private JLabel label_5;
    private JTextField tf_fileSuffix;
    private JTabbedPane tabbedPane;
    private JTextArea ta_table;
    private JTextArea ta_database;
    private JTextArea ta_table_pars;
    private JTextArea ta_field_pars;

}