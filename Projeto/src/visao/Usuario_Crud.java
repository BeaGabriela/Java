package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import modelo.Usuario;
import uteis.Cripto;

public class Usuario_Crud extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel nomeCliente, genClient, tipoProuduto, valProduto, descont, qtd, nomeVendedor, imagemVendedor;
	private JTextField tfCliente, tfvalProduto, tfQtd, tfnome;
	private JComboBox<String> produtos, genCliente, desconto, tfVendedor;
	private JTable table;
	private JPasswordField pfSenha;
	private JButton create, read, update, delete;
	private JScrollPane scroll;
	private DefaultTableModel tableModel;
	private int indice = -1;
	private String imgIco = "D:\\fpoo\\work3\\modelo\\src\\modelo\\Roupas\\assets\\flor.png";
	private String[] imagens = { "./assets/ana.jpg", "./assets/beatriz.jpg", "./assets/Carlos.png",
			"./assets/julia.png", "./assets/marcelo.jpg", "./assets/maria.png", "./assets/Victor.png" };
	private ImageIcon icon;
	private String texto = "";

	Usuario_Crud() {

		setTitle("Gerenciamento de vendedores");
		setBounds(500, 200, 470, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new JPanel();
		setContentPane(painel);
		setLayout(null);

		// Textos e Bot�es
		nomeVendedor = new JLabel("*Nome vendedor:");
		nomeVendedor.setBounds(450, 280, 120, 30);
		tfVendedor = new JComboBox<String>(
				new String[] { "Ana", "Beatriz", "Carlos", "Julia", "Marcelo", "Maria", "Victor" });
		tfVendedor.setBounds(453, 310, 255, 30);

		imagemVendedor = new JLabel();
		imagemVendedor.setBounds(465, 75, 230, 200);
		imagemVendedor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		alternarImagens(0);

		nomeCliente = new JLabel("*Nome do Cliente:");
		nomeCliente.setBounds(20, 90, 120, 30);
		tfCliente = new JTextField();
		tfCliente.setBounds(140, 95, 255, 30);

		genClient = new JLabel("*Gênero Roupa:");
		genClient.setBounds(20, 125, 120, 30);
		genCliente = new JComboBox<String>(new String[] { "Feminina", "Masculina" });
		genCliente.setBounds(140, 130, 255, 30);

		tipoProuduto = new JLabel("*Produto:");
		tipoProuduto.setBounds(20, 165, 120, 30);
		produtos = new JComboBox<String>(new String[] { "Calça Jeans", "Blusa moletom", "Vestido", "Calça Moletom",
				"Camiseta", "Blusa", "Tênis", "Salto" });
		produtos.setBounds(140, 165, 255, 30);

		valProduto = new JLabel("*Valor do Produto:");
		valProduto.setBounds(20, 240, 120, 30);
		tfvalProduto = new JTextField();
		tfvalProduto.setBounds(140, 240, 255, 30);

		descont = new JLabel("*Desconto:");
		descont.setBounds(20, 200, 120, 30);
		desconto = new JComboBox<String>(new String[] { "5%", "10%", "15%", "20%", "25%", "30%", "40%", "Não" });
		desconto.setBounds(140, 200, 255, 30);

		qtd = new JLabel("*Quantidade:");
		qtd.setBounds(20, 280, 120, 30);
		tfQtd = new JTextField();
		tfQtd.setBounds(140, 280, 255, 30);

		tfnome = new JTextField();
		tfnome.setBounds(135, 20, 300, 30);
		painel.add(tfnome);

		create = new JButton("Cadastrar");
		read = new JButton("Consultar");
		update = new JButton("Alterar");
		delete = new JButton("Excluir");

		create.setBounds(20, 90, 100, 30);
		read.setBounds(125, 90, 100, 30);
		update.setBounds(230, 90, 100, 30);
		delete.setBounds(335, 90, 100, 30);

		painel.add(create);
		painel.add(read);
		painel.add(update);
		painel.add(delete);

		tableModel = new DefaultTableModel();
		tableModel.addColumn("Produto");
		tableModel.addColumn("Quantidade");
		tableModel.addColumn("Data");
		tableModel.addColumn("Vendedor");
		tableModel.addColumn("Cliente");
		tableModel.addColumn("Total com desconto");
		if (Usuario_Processa.usuarios.size() != 0) {
			preencheTabela();
		}
		table = new JTable(tableModel);
		table.setEnabled(false);
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 125, 415, 215);
		painel.add(scroll);

		create.addActionListener(this);
		read.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);

		update.setEnabled(false);
		delete.setEnabled(false);
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
		tfnome.setText("");
		pfSenha.setText("");
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

	public static void main(String[] agrs) throws ParseException {
		new Usuario_Crud().setVisible(true);

	}

	// Propriedades B�sicas

	private void create() {
		if (tfnome.getText().length() > 0) {
		String data = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		Usuario us;
		if (tfCliente.getText().length() != 0 && tfvalProduto.getText().length() != 0 && tfQtd.getText().length() != 0
				&& table.getTable().length() != 0) {
			us = new Usuario(tfnome.getText());
			JOptionPane.showMessageDialog(this, "Usuário já cadastrado");
		}else{
		Usuario_Processa.usuarios.add(us);
		Usuario_Processa.salvar();
		preencheTabela();
		limparCampos();
	}else{
		JOptionPane.showMessageDialog(this,"Preencha o email e a senha de no mínimo 4 dígitos");
		
	}

		
		}
	}


	private void read() {
		if (tfnome.getText().length() > 0) {
			Usuario user = new Usuario(tfnome.getText(), "");
			if (Usuario_Processa.usuarios.contains(user)) {
				indice = Usuario_Processa.usuarios.indexOf(user);
				tfnome.setEnabled(false);
				create.setEnabled(false);
				read.setEnabled(false);
				update.setEnabled(true);
				delete.setEnabled(true);
			} else {
				JOptionPane.showMessageDialog(this, "Usuário não encontrado");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Preencha o campo email");
		}
	}

	private void update() {
		if (tfnome.getText().length() > 0 && new String(pfSenha.getPassword()).length() > 3) {
			Usuario user = new Usuario(tfnome.getText(), Cripto.encripta(new String(pfSenha.getPassword())));
			Usuario_Processa.usuarios.set(indice, user);
			Usuario_Processa.salvar();
			preencheTabela();
			limparCampos();
			tfnome.setEnabled(true);
			create.setEnabled(true);
			read.setEnabled(true);
			update.setEnabled(false);
			delete.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(this, "Preencha o email e a senha de no mínimo 4 dígitos");
		}
	}

	private void delete() {
		Usuario_Processa.usuarios.remove(indice);
		Usuario_Processa.salvar();
		preencheTabela();
		limparCampos();
		tfnome.setEnabled(true);
		create.setEnabled(true);
		read.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == create) {
			create();
		}
		if (e.getSource() == read) {
			read();
		}
		if (e.getSource() == update) {
			update();
		}
		if (e.getSource() == delete) {
			delete();
		}
	}

}