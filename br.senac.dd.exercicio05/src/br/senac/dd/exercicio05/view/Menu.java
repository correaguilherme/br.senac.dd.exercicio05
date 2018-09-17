/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.dd.exercicio05.view;

import br.senac.dd.exercicio05.controller.FuncionarioController;
import br.senac.dd.exercicio05.model.bo.FuncionarioBO;
import br.senac.dd.exercicio05.model.dao.FuncionarioDAO;
import br.senac.dd.exercicio05.model.vo.FuncionarioVO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guilherme Corrêa
 */
public class Menu extends javax.swing.JFrame {
    
    private static List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
    private FuncionarioVO funcionario = new FuncionarioVO();
    private FuncionarioBO bo = new FuncionarioBO();
    private FuncionarioController controlador = new FuncionarioController();
    
    public FuncionarioVO construirFuncionario(){
        funcionario.setNome(txtFuncionario_Nome.getText());
        funcionario.setCpf(txtFuncionario_Cpf.getText());
        funcionario.setSalario(Double.parseDouble(txtFuncionario_Salario.getText()));
         
        return funcionario;
    } 

    protected void limparTela() {
	funcionario = new FuncionarioVO();
	txtFuncionario_Nome.setText("");
	txtFuncionario_Cpf.setText("");
	txtFuncionario_Salario.setText("");
    }
    
    public void ManipulaInterfaceFunc(String modo){
        switch(modo){
            case "Navegar":
                txtFuncionario_Nome.setEnabled(true);
                txtFuncionario_Cpf.setEnabled(true);
                txtFuncionario_Salario.setEnabled(true);
                btnFuncionario_Novo.setEnabled(true);
                btnFuncionario_Editar.setEnabled(false);
                btnFuncionario_Excluir.setEnabled(false);
                btnFuncionario_Buscar.setEnabled(true);
                btnFuncionario_BuscarTodos.setEnabled(true);
                break;
            
            case "Novo":
                txtFuncionario_Nome.setEnabled(true);
                txtFuncionario_Cpf.setEnabled(true);
                txtFuncionario_Salario.setEnabled(true);
                btnFuncionario_Novo.setEnabled(false);
                btnFuncionario_Editar.setEnabled(false);
                btnFuncionario_Excluir.setEnabled(false);
                btnFuncionario_Buscar.setEnabled(false);
                btnFuncionario_BuscarTodos.setEnabled(false);
                break;
                
            case "Editar":
                txtFuncionario_Nome.setEnabled(true);
                txtFuncionario_Cpf.setEnabled(true);
                txtFuncionario_Salario.setEnabled(true);
                btnFuncionario_Novo.setEnabled(false);
                btnFuncionario_Editar.setEnabled(false);
                btnFuncionario_Excluir.setEnabled(false);
                btnFuncionario_Buscar.setEnabled(false);
                btnFuncionario_BuscarTodos.setEnabled(false);
                break;
                
            case "Excluir":
                txtFuncionario_Nome.setEnabled(false);
                txtFuncionario_Cpf.setEnabled(false);
                txtFuncionario_Salario.setEnabled(false);
                btnFuncionario_Novo.setEnabled(true);
                btnFuncionario_Editar.setEnabled(false);
                btnFuncionario_Excluir.setEnabled(false);
                btnFuncionario_Buscar.setEnabled(false);
                btnFuncionario_BuscarTodos.setEnabled(false);
                break;
                
            case "Selecao":
                txtFuncionario_Nome.setEnabled(true);
                txtFuncionario_Cpf.setEnabled(true);
                txtFuncionario_Salario.setEnabled(true);
                btnFuncionario_Novo.setEnabled(true);
                btnFuncionario_Editar.setEnabled(true);
                btnFuncionario_Excluir.setEnabled(true);
                btnFuncionario_Buscar.setEnabled(true);
                btnFuncionario_BuscarTodos.setEnabled(true);
                break;
            default: JOptionPane.showMessageDialog(null, "Modo inválido");
        }
    }
 
    public void readJTable() {
        
        DefaultTableModel modelo = (DefaultTableModel) tblFuncionario.getModel();
        modelo.setNumRows(0);
        FuncionarioDAO fdao = new FuncionarioDAO();

        for (FuncionarioVO f : fdao.listarTodos()) {

            modelo.addRow(new Object[]{
                f.getIdFuncionario(),
                f.getNome(),
                f.getCpf(),
                f.getSalario()
            });

        }

    /* protected void atualizarTabelaFuncionarios(List<FuncionarioVO> funcionarios) {
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"ID","Nome","CPF","Salário"},0);
        
        
        for(FuncionarioVO funcionario : funcionarios){
            Object linha[] = new Object[]{funcionario.getIdFuncionario(),
                                        funcionario.getNome(),
                                        funcionario.getCpf(),
                                        funcionario.getSalario()};
            modelo.addRow(linha);
        }
        tblFuncionario.setModel(modelo);
        tblFuncionario.getColumnModel().getColumn(0).setPreferredWidth(10);    
    } */
    
    /* protected void atualizarTabela(List<FuncionarioVO> funcionarios) {
		//Limpa a tabela
		tblFuncionario.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"ID", "Nome", "CPF", "Salário"}));
		
		DefaultTableModel modelo = (DefaultTableModel) tblFuncionario.getModel();
		
		for(FuncionarioVO funcionario: funcionarios) {
			//Crio uma nova linha na tabela
			//Preencher a linha com os atributos do produto
			//na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] {
                                        funcionario.getIdFuncionario(),
					funcionario.getNome(),
					funcionario.getCpf(),
					funcionario.getSalario()
			};
			modelo.addRow(novaLinha);
                        tblFuncionario.setModel(modelo);
                        tblFuncionario.getColumnModel().getColumn(0).setPreferredWidth(10); 
		} /*

    /**
     * Creates new form MenuProduto
     */
    public Menu() {
        initComponents();

        ManipulaInterfaceFunc("Navegar");
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        painelFuncionario = new javax.swing.JPanel();
        lblFuncionario_Nome = new javax.swing.JLabel();
        lblFuncionario_Cpf = new javax.swing.JLabel();
        lblFuncionario_Salario = new javax.swing.JLabel();
        txtFuncionario_Nome = new javax.swing.JTextField();
        txtFuncionario_Cpf = new javax.swing.JTextField();
        txtFuncionario_Salario = new javax.swing.JTextField();
        btnFuncionario_Excluir = new javax.swing.JButton();
        btnFuncionario_Editar = new javax.swing.JButton();
        btnFuncionario_Novo = new javax.swing.JButton();
        btnFuncionario_Buscar = new javax.swing.JButton();
        btnFuncionario_BuscarTodos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        painelProduto = new javax.swing.JPanel();
        lblProduto_ID = new javax.swing.JLabel();
        lblProduto_Nome = new javax.swing.JLabel();
        lblProduto_Fornecedor = new javax.swing.JLabel();
        lblProduto_Valor = new javax.swing.JLabel();
        lblProduto_Peso = new javax.swing.JLabel();
        txtProduto_ID = new javax.swing.JTextField();
        txtProduto_Nome = new javax.swing.JTextField();
        txtProduto_Fornecedor = new javax.swing.JTextField();
        txtProduto_Valor = new javax.swing.JTextField();
        txtProduto_Peso = new javax.swing.JTextField();
        btnProduto_Salvar = new javax.swing.JButton();
        btnProduto_Cancelar = new javax.swing.JButton();
        btnProduto_Novo = new javax.swing.JButton();
        btnProduto_Editar = new javax.swing.JButton();
        btnProduto_Excluir = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD");

        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Salário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblFuncionario);
        if (tblFuncionario.getColumnModel().getColumnCount() > 0) {
            tblFuncionario.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        painelFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Funcionário"));

        lblFuncionario_Nome.setText("Nome:");

        lblFuncionario_Cpf.setText("CPF:");

        lblFuncionario_Salario.setText("Salário:");

        javax.swing.GroupLayout painelFuncionarioLayout = new javax.swing.GroupLayout(painelFuncionario);
        painelFuncionario.setLayout(painelFuncionarioLayout);
        painelFuncionarioLayout.setHorizontalGroup(
            painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFuncionario_Nome)
                .addGap(25, 25, 25)
                .addComponent(txtFuncionario_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFuncionario_Cpf)
                .addGap(18, 18, 18)
                .addComponent(txtFuncionario_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFuncionario_Salario)
                .addGap(18, 18, 18)
                .addComponent(txtFuncionario_Salario, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        painelFuncionarioLayout.setVerticalGroup(
            painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncionarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionario_Nome)
                    .addComponent(txtFuncionario_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFuncionario_Cpf)
                    .addComponent(txtFuncionario_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFuncionario_Salario)
                        .addComponent(txtFuncionario_Salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(179, 179, 179))
        );

        btnFuncionario_Excluir.setText("Excluir");
        btnFuncionario_Excluir.setMaximumSize(null);

        btnFuncionario_Editar.setText("Atualizar");
        btnFuncionario_Editar.setMinimumSize(new java.awt.Dimension(69, 25));
        btnFuncionario_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionario_EditarActionPerformed(evt);
            }
        });

        btnFuncionario_Novo.setText("Cadastrar");
        btnFuncionario_Novo.setMinimumSize(new java.awt.Dimension(69, 25));
        btnFuncionario_Novo.setPreferredSize(new java.awt.Dimension(69, 25));
        btnFuncionario_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionario_NovoActionPerformed(evt);
            }
        });

        btnFuncionario_Buscar.setText("Buscar por ID");
        btnFuncionario_Buscar.setMinimumSize(new java.awt.Dimension(109, 25));
        btnFuncionario_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionario_BuscarActionPerformed(evt);
            }
        });

        btnFuncionario_BuscarTodos.setText("Buscar Todos");
        btnFuncionario_BuscarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionario_BuscarTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(painelFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(btnFuncionario_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFuncionario_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(btnFuncionario_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFuncionario_BuscarTodos)
                                .addGap(18, 18, 18)
                                .addComponent(btnFuncionario_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFuncionario_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFuncionario_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFuncionario_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFuncionario_BuscarTodos)
                    .addComponent(btnFuncionario_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Funcionario", jPanel2);

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Fornecedor", "Valor", "Peso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProduto);
        if (tblProduto.getColumnModel().getColumnCount() > 0) {
            tblProduto.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblProduto.getColumnModel().getColumn(4).setPreferredWidth(30);
        }
        tblProduto.getAccessibleContext().setAccessibleName("tabelaProduto");

        painelProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Produto"));

        lblProduto_ID.setText("Código:");

        lblProduto_Nome.setText("Nome:");

        lblProduto_Fornecedor.setText("Fornecedor:");

        lblProduto_Valor.setText("Valor:");

        lblProduto_Peso.setText("Peso:");

        btnProduto_Salvar.setText("Salvar");

        btnProduto_Cancelar.setText("Cancelar");

        javax.swing.GroupLayout painelProdutoLayout = new javax.swing.GroupLayout(painelProduto);
        painelProduto.setLayout(painelProdutoLayout);
        painelProdutoLayout.setHorizontalGroup(
            painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelProdutoLayout.createSequentialGroup()
                        .addComponent(lblProduto_Nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProduto_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelProdutoLayout.createSequentialGroup()
                        .addComponent(lblProduto_Fornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProduto_Fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelProdutoLayout.createSequentialGroup()
                        .addComponent(lblProduto_ID)
                        .addGap(18, 18, 18)
                        .addComponent(txtProduto_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelProdutoLayout.createSequentialGroup()
                        .addComponent(lblProduto_Valor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProduto_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelProdutoLayout.createSequentialGroup()
                        .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnProduto_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelProdutoLayout.createSequentialGroup()
                                .addComponent(lblProduto_Peso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProduto_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnProduto_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelProdutoLayout.setVerticalGroup(
            painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdutoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduto_ID)
                    .addComponent(txtProduto_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduto_Nome)
                    .addComponent(txtProduto_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduto_Fornecedor)
                    .addComponent(txtProduto_Fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduto_Valor)
                    .addComponent(txtProduto_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduto_Peso)
                    .addComponent(txtProduto_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProduto_Salvar)
                    .addComponent(btnProduto_Cancelar))
                .addContainerGap())
        );

        lblProduto_ID.getAccessibleContext().setAccessibleName("lblID");
        lblProduto_ID.getAccessibleContext().setAccessibleDescription("");
        lblProduto_Nome.getAccessibleContext().setAccessibleName("lblNome");
        lblProduto_Nome.getAccessibleContext().setAccessibleDescription("");
        lblProduto_Fornecedor.getAccessibleContext().setAccessibleName("lblFornecedor");
        lblProduto_Valor.getAccessibleContext().setAccessibleName("lblValor");
        lblProduto_Peso.getAccessibleContext().setAccessibleName("lblPeso");

        btnProduto_Novo.setText("Novo");

        btnProduto_Editar.setText("Editar");

        btnProduto_Excluir.setText("Excluir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnProduto_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnProduto_Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnProduto_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProduto_Novo)
                    .addComponent(btnProduto_Editar)
                    .addComponent(btnProduto_Excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelProduto.getAccessibleContext().setAccessibleName("painelProduto");

        jTabbedPane1.addTab("Produto", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("tab");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFuncionario_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionario_NovoActionPerformed
        FuncionarioVO funcionario = construirFuncionario();
        String mensagem = controlador.salvar(funcionario);
	JOptionPane.showMessageDialog(null, mensagem);
	limparTela();
        readJTable();
    }//GEN-LAST:event_btnFuncionario_NovoActionPerformed

    private void btnFuncionario_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionario_BuscarActionPerformed
     
    }//GEN-LAST:event_btnFuncionario_BuscarActionPerformed

    private void btnFuncionario_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionario_EditarActionPerformed
         ManipulaInterfaceFunc("Editar");
         
         if (tblFuncionario.getSelectedRow() != -1) {
         FuncionarioVO funcionario = construirFuncionario();
         String mensagem = controlador.atualizar(funcionario);
	 JOptionPane.showMessageDialog(null, mensagem);
	 limparTela();
         readJTable();
         }
    }//GEN-LAST:event_btnFuncionario_EditarActionPerformed

    private void btnFuncionario_BuscarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionario_BuscarTodosActionPerformed
        readJTable();
        
        btnFuncionario_Editar.setEnabled(true);
        btnFuncionario_Excluir.setEnabled(true);
    }//GEN-LAST:event_btnFuncionario_BuscarTodosActionPerformed

    private void tblFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionarioMouseClicked
        
        if(tblFuncionario.getSelectedRow() != -1){
            txtFuncionario_Nome.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 1).toString());
            txtFuncionario_Cpf.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 2).toString());
            txtFuncionario_Salario.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 3).toString());
        }
        
         ManipulaInterfaceFunc("Selecao");
        
    }//GEN-LAST:event_tblFuncionarioMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFuncionario_Buscar;
    private javax.swing.JButton btnFuncionario_BuscarTodos;
    private javax.swing.JButton btnFuncionario_Editar;
    private javax.swing.JButton btnFuncionario_Excluir;
    private javax.swing.JButton btnFuncionario_Novo;
    private javax.swing.JButton btnProduto_Cancelar;
    private javax.swing.JButton btnProduto_Editar;
    private javax.swing.JButton btnProduto_Excluir;
    private javax.swing.JButton btnProduto_Novo;
    private javax.swing.JButton btnProduto_Salvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFuncionario_Cpf;
    private javax.swing.JLabel lblFuncionario_Nome;
    private javax.swing.JLabel lblFuncionario_Salario;
    private javax.swing.JLabel lblProduto_Fornecedor;
    private javax.swing.JLabel lblProduto_ID;
    private javax.swing.JLabel lblProduto_Nome;
    private javax.swing.JLabel lblProduto_Peso;
    private javax.swing.JLabel lblProduto_Valor;
    private javax.swing.JPanel painelFuncionario;
    private javax.swing.JPanel painelProduto;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtFuncionario_Cpf;
    private javax.swing.JTextField txtFuncionario_Nome;
    private javax.swing.JTextField txtFuncionario_Salario;
    private javax.swing.JTextField txtProduto_Fornecedor;
    private javax.swing.JTextField txtProduto_ID;
    private javax.swing.JTextField txtProduto_Nome;
    private javax.swing.JTextField txtProduto_Peso;
    private javax.swing.JTextField txtProduto_Valor;
    // End of variables declaration//GEN-END:variables
}
