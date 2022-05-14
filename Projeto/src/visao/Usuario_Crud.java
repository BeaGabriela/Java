
package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controle.Usuario_Processa;
import controle.Venda;
import modelo.Usuario;
import uteis.Cripto;

public class Usuario_Crud extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel nomeCliente, genClient, tipoProuduto, valProduto, descont, qtd, nomeVendedor, imagemVendedor, lbEmail, lbSenha;
	private JTextField tfCliente, tfvalProduto, tfQtd;
	private JComboBox<String> produtos, genCliente, desconto, tfVendedor;
	private JTextArea totalcompra;
	private JButton cadastrar, buscarProduto, apagar, mudarVendedor;
	private String imgIco = "D:\\fpoo\\work3\\modelo\\src\\modelo\\Roupas\\assets\\flor.png";
	private String[] imagens = { "./assets/ana.jpg",
			"./assets/beatriz.jpg",
			"./assets/Carlos.png",
			"./assets/julia.png",
			"./assets/marcelo.jpg",
			"./assets/maria.png",
			"./assets/Victor.png" };
	private ImageIcon icon;
	private String texto = "";
	private JTextField tfEmail;
	private JPasswordField pfSenha;
	private JScrollPane scroll;
	private JTable table;
	private DefaultTableModel tableModel;
	private int indice = -1;

	Usuario_Crud() {
		
		setTitle("Gerenciamento de Vendedores");
		setBounds(500, 200, 470, 400);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		painel.setBackground(new Color(199, 199, 199));
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
				
		lbEmail = new JLabel("E-mail:");
		lbEmail.setBounds(20, 20, 100, 30);
		painel.add(lbEmail);

		lbSenha = new JLabel("Senha:");
		lbSenha.setBounds(20, 55, 100, 30);
		painel.add(lbSenha);

		tfEmail = new JTextField();
		tfEmail.setBounds(135, 20, 300, 30);
		painel.add(tfEmail);

		pfSenha = new JPasswordField();
		pfSenha.setEchoChar('*');
		pfSenha.setBounds(135, 55, 300, 30);
		painel.add(pfSenha);

		nomeCliente = new JLabel("*Nome do Cliente:");
		nomeCliente.setBounds(20, 90, 120, 30);
		tfCliente = new JTextField();
		tfCliente.setBounds(140, 95, 255, 30);
		//
		genClient = new JLabel("*Gênero Roupa:");
		genClient.setBounds(20, 125, 120, 30);
		genCliente = new JComboBox<String>(new String[] { "Feminina", "Masculina" });
		genCliente.setBounds(140, 130, 255, 30);
		//
		tipoProuduto = new JLabel("*Produto:");
		tipoProuduto.setBounds(20, 165, 120, 30);
		produtos = new JComboBox<String>(new String[] { "Calça Jeans", "Blusa moletom", "Vestido", "Calça Moletom",
				"Camiseta", "Blusa", "Tênis", "Salto" });
		produtos.setBounds(140, 165, 255, 30);
		//
		valProduto = new JLabel("*Valor do Produto:");
		valProduto.setBounds(20, 240, 120, 30);
		tfvalProduto = new JTextField();
		tfvalProduto.setBounds(140, 240, 255, 30);
		//
		descont = new JLabel("*Desconto:");
		descont.setBounds(20, 200, 120, 30);
		desconto = new JComboBox<String>(new String[] { "5%", "10%", "15%", "20%", "25%", "30%", "40%", "Não" });
		desconto.setBounds(140, 200, 255, 30);
		//
		qtd = new JLabel("*Quantidade:");
		qtd.setBounds(20, 280, 120, 30);
		tfQtd = new JTextField();
		tfQtd.setBounds(140, 280, 255, 30);
		//

		totalcompra = new JTextArea();
		totalcompra.setBounds(10, 350, 760, 200);
		totalcompra.setEnabled(false);
		totalcompra.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		//
		nomeVendedor = new JLabel("*Nome vendedor:");
		nomeVendedor.setBounds(450, 280, 120, 30);
		tfVendedor = new JComboBox<String>(
				new String[] { "Ana", "Beatriz", "Carlos", "Julia", "Marcelo", "Maria", "Victor" });
		tfVendedor.setBounds(453, 310, 255, 30);
		//
		imagemVendedor = new JLabel();
		imagemVendedor.setBounds(465, 75, 230, 200);
		imagemVendedor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		alternarImagens(0);
		//
		//
		cadastrar = new JButton("Cadastrar");
		buscarProduto = new JButton("Buscar");
		mudarVendedor = new JButton("Alterar");
		apagar = new JButton("Excluir");

		cadastrar.setBounds(20, 90, 100, 30);
		buscarProduto.setBounds(125, 90, 100, 30);
		mudarVendedor.setBounds(230, 90, 100, 30);
		mudarVendedor.setEnabled(false);
		apagar.setBounds(335, 90, 100, 30);
		apagar.setEnabled(false);

		produtos.addActionListener(this);
		genCliente.addActionListener(this);
		desconto.addActionListener(this);
		cadastrar.addActionListener(this);
		buscarProduto.addActionListener(this);
		tfVendedor.addActionListener(this);
		apagar.addActionListener(this);

		painel.add(nomeCliente);
		painel.add(tfCliente);
		//
		painel.add(genClient);
		painel.add(genCliente);
		//
		painel.add(tipoProuduto);
		painel.add(produtos);
		//
		painel.add(valProduto);
		painel.add(tfvalProduto);
		//
		painel.add(qtd);
		painel.add(tfQtd);
		//
		painel.add(descont);
		painel.add(desconto);
		//
		painel.add(totalcompra);
		//
		painel.add(nomeVendedor);
		painel.add(tfVendedor);
		//
		painel.add(imagemVendedor);
		//
		painel.add(cadastrar);
		painel.add(buscarProduto);
		//
		painel.add(apagar);
		painel.add(mudarVendedor);

	
	tableModel = new DefaultTableModel();
	tableModel.addColumn("Produto");
	tableModel.addColumn("Quantidade");
	tableModel.addColumn("Genêro");
	tableModel.addColumn("Cliente");
	tableModel.addColumn("Data");
	if (Usuario_Processa.usuarios.size() != 0) {
		preencheTabela();
	}
	
	table = new JTable(tableModel);
	table.setEnabled(false);
	scroll = new JScrollPane(table);
	scroll.setBounds(20, 125, 415, 215);
	painel.add(scroll);

}

	private void alternarImagens(int indice) {
		icon = new ImageIcon(new ImageIcon(imagens[indice]).getImage().getScaledInstance(230, 200, 100));
		imagemVendedor.setIcon(icon);
	}

	int obterIndiceEspecie(String Vendedor) {
		switch (Vendedor) {
		case "Ana":
			return 0;
		case "Beatriz":
			return 1;
		case "Carlos":
			return 2;
		case "Julia":
			return 3;
		case "Marcelo":
			return 4;
		case "Maria":
			return 5;
		case "Victor":
			return 6;
		default:
			return -1;
		}
	}
	
	private void preencheTabela() {
		int totLinhas = tableModel.getRowCount();
		if (tableModel.getRowCount() > 0) {
			for (int i = 0; i < totLinhas; i++) {
				tableModel.removeRow(0);
			}
		}
	
		for (Usuario u : Usuario_Processa.usuarios) {
			tableModel.addRow(new String[] { u.getEmail(), u.getSenha() });
		}
	}
	
	private void limparCampos() {
		tfEmail.setText("");
		pfSenha.setText("");
	}
	
	private void cadastrar() {
		if (tfEmail.getText().length() > 0 && new String(pfSenha.getPassword()).length() > 3) {
			Usuario user = new Usuario(tfEmail.getText(),(new String(pfSenha.getPassword())));
			if (Usuario_Processa.usuarios.contains(user)) {
				JOptionPane.showMessageDialog(this, "Usuário já cadastrado");
			} else {
				Usuario_Processa.usuarios.add(user);
				Usuario_Processa.salvar();
				preencheTabela();
				limparCampos();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Preencha o email e a senha de no mínimo 4 dígitos");
		}
	}
	
	private void buscar() {
		if (tfEmail.getText().length() > 0) {
			Usuario user = new Usuario(tfEmail.getText(), "");
			if (Usuario_Processa.usuarios.contains(user)) {
				indice = Usuario_Processa.usuarios.indexOf(user);
				tfEmail.setEnabled(false);
				cadastrar.setEnabled(false);
				buscarProduto.setEnabled(false);
				mudarVendedor.setEnabled(true);
				apagar.setEnabled(true);
			} else {
				JOptionPane.showMessageDialog(this, "Usuário não encontrado");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Preencha o campo email");
		}
	}
	
	private void alterar() {
		if (tfEmail.getText().length() > 0 && new String(pfSenha.getPassword()).length() > 3) {
			Usuario user = new Usuario(tfEmail.getText(),(new String(pfSenha.getPassword())));
			Usuario_Processa.usuarios.set(indice, user);
			Usuario_Processa.salvar();
			preencheTabela();
			limparCampos();
			tfEmail.setEnabled(true);
			cadastrar.setEnabled(true);
			buscarProduto.setEnabled(true);
			mudarVendedor.setEnabled(false);
			apagar.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(this, "Preencha o email e a senha de no mínimo 4 dígitos");
		}
	}
	
	private void apagar() {
		Usuario_Processa.usuarios.remove(indice);
		Usuario_Processa.salvar();
		preencheTabela();
		limparCampos();
		tfEmail.setEnabled(true);
		cadastrar.setEnabled(true);
		buscarProduto.setEnabled(true);
		mudarVendedor.setEnabled(false);
		apagar.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrar) {
			cadastrar();
		}
		if (e.getSource() == buscarProduto) {
			buscar();
		}
		if (e.getSource() == mudarVendedor) {
			alterar();
		}
		if (e.getSource() == apagar) {
			apagar();
		}
	}

}

	