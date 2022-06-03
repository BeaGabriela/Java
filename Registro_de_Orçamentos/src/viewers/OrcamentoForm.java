package viewers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.OrcamentoProcess;
import modelo.Orcamento;

public class OrcamentoForm extends JDialog implements ActionListener {

	private JPanel panel;
	private JTable table;
	private JLabel Lid, Lfornecedor, Lproduto, Lpreco;
	private JTextField id, fornecedor, produto, preco;
//	private JPanel adicionar, alterar, excluir, buscar;
	private JTextField texto;
	private JScrollPane rolagem;
	private DecimalFormat df = new DecimalFormat("#.00");
	private JButton Badicionar, Balterar, Bexcluir, Bbuscar;
	private DefaultTableModel tableModel;
	private int autoId = OrcamentoProcess.orcamento.get(OrcamentoProcess.orcamento.size() - 1).getId() + 1;
	private final Locale Brasil = new Locale("pt", "BR");
	
	OrcamentoForm() {
		setTitle("Registros de Orcamentos");
		setBounds(500, 200, 470, 400);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		panel.setBackground(new Color(204, 255, 229));

		Lid = new JLabel("Id:");
		Lid.setBounds(20, 20, 100, 30);
		panel.add(Lid);

		Lfornecedor = new JLabel("Fornecedor:");
		Lfornecedor.setBounds(20, 55, 100, 30);
		panel.add(Lfornecedor);

		Lproduto = new JLabel("Produto:");
		Lproduto.setBounds(20, 90, 120, 30);
		panel.add(Lproduto);

		Lpreco = new JLabel("Preço:");
		Lpreco.setBounds(20, 120, 115, 30);
		panel.add(Lpreco);

		id = new JTextField(String.format("%d", autoId));
		id.setEnabled(false);
		id.setBounds(135, 20, 100, 30);
		panel.add(id);

		fornecedor = new JTextField();
		fornecedor.setBounds(135, 55, 100, 30);
		panel.add(fornecedor);

		produto = new JTextField();
		produto.setBounds(135, 90, 100, 30);
		panel.add(produto);

		preco = new JTextField();
		preco.setBounds(135, 130, 100, 30);
		panel.add(preco);

		table = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Fornecedor");
		tableModel.addColumn("Produto");
		tableModel.addColumn("Preço");
		tableModel.addColumn("Mais barato");
		if (OrcamentoProcess.orcamento.size() != 0) {
			listarTodos();
		}

		table = new JTable(tableModel);
		table.setEnabled(false);
		rolagem = new JScrollPane(table);
		rolagem.setBounds(20, 210, 420, 100);
		panel.add(rolagem);

		Badicionar = new JButton("Adicionar");
		Balterar = new JButton("Alterar");
		Bbuscar = new JButton("Buscar");
		Bexcluir = new JButton("Excluir");

		Badicionar.setBounds(335, 50, 100, 30);
		Bbuscar.setBounds(335, 90, 100, 30);
		Balterar.setBounds(335, 130, 100, 30);
		Bexcluir.setBounds(335, 170, 100, 30);

		panel.add(Badicionar);
		panel.add(Bbuscar);
		panel.add(Balterar);
		panel.add(Bexcluir);

		Badicionar.addActionListener(this);
		Bbuscar.addActionListener(this);
		Balterar.addActionListener(this);
		Bexcluir.addActionListener(this);

		Balterar.setEnabled(false);
		Bexcluir.setEnabled(false);
	}

	int obterIndiceOrcamentos(String orca) {
		switch (orca) {
		case "Caixa":
			return 0;
		case "Maquina":
			return 1;
		default:
			return -1;
		}
	}


	public void listarTodos() {
		int totlinhas = tableModel.getRowCount();
		if (tableModel.getRowCount() > 0) {
			for (int i = 0; i < totlinhas; i++) {
				tableModel.removeRow(0);
			}
		}
		for (Orcamento o : OrcamentoProcess.orcamento) {
			tableModel.addRow(new String[] { o.getId("s"), o.getFornecedor(), o.getProduto(), o.getPreco("s") });
		}

	}

	public void adicionar() {
		if (fornecedor.getText().length() != 0 && produto.getText().length() != 0 && preco.getText().length() != 0) {
			df.setCurrency(Currency.getInstance(Brasil));
			double pre;
			try {
				pre = Double.parseDouble(df.parse(preco.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				pre = 0;
	}
			OrcamentoProcess.orcamento.add(new Orcamento(autoId, fornecedor.getText(), produto.getText(), pre, false));
	autoId++;
	listarTodos();
	limparCampos();
	OrcamentoProcess.salvar();
} else {
	JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos");
}

}
		private void limparCampos() {
			id.setText(String.format("%d", autoId));
			fornecedor.setText(null);
			produto.setText(null);
			preco.setText(null);
		}
		
	


	public void alterar() {
		int idd = Integer.parseInt(id.getText());
		Orcamento or = new Orcamento(idd);
		int indice = OrcamentoProcess.orcamento.indexOf(or);
		if (fornecedor.getText().length() != 0 && produto.getText().length() != 0 && preco.getText().length() != 0) {
			df.setCurrency(Currency.getInstance(Brasil));
			double pre;
			try {
				pre = Double.parseDouble(df.parse(preco.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				pre = 0;
	}
			OrcamentoProcess.orcamento.set(indice,new Orcamento(idd, fornecedor.getText(), produto.getText(), pre, false));
			listarTodos();
			limparCampos();
			OrcamentoProcess.salvar();
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, preencher todos os campos");
		}
		Badicionar.setEnabled(true);
		Balterar.setEnabled(false);
		Bexcluir.setEnabled(false);
		id.setText(String.format("%d", autoId));
			
	}
	public void excluir() {
		int idd = Integer.parseInt(id.getText());
		Orcamento orc = new Orcamento(idd);
		int indice = OrcamentoProcess.orcamento.indexOf(orc);
		OrcamentoProcess.orcamento.remove(indice);
		listarTodos();
		limparCampos();
		Badicionar.setEnabled(true);
		Balterar.setEnabled(false);
		Bexcluir.setEnabled(false);
		id.setText(String.format("%d", autoId));
		OrcamentoProcess.salvar();

	}
	
	public void buscar() {
		String entrada = JOptionPane.showInputDialog(this, "Digite o Id da manutenção:");
		boolean isNumeric = true;
		if (entrada != null) {
			for (int i = 0; i < entrada.length(); i++) {
				if (!Character.isDigit(entrada.charAt(i))) {
					isNumeric = false;
				}
			}
		} else {
			isNumeric = false;
		}
		if (isNumeric) {
			int iid = Integer.parseInt(entrada);
			Orcamento or = new Orcamento(iid);
			if (OrcamentoProcess.orcamento.contains(or)) {
				int indice = OrcamentoProcess.orcamento.indexOf(or);
				id.setText(OrcamentoProcess.orcamento.get(indice).getId("s"));
				fornecedor.setText(OrcamentoProcess.orcamento.get(indice).getFornecedor());
				produto.setText(OrcamentoProcess.orcamento.get(indice).getProduto());
				preco.setText(OrcamentoProcess.orcamento.get(indice).getPreco("s"));
				Badicionar.setEnabled(false);
				Balterar.setEnabled(true);
				Bexcluir.setEnabled(true);
				OrcamentoProcess.salvar();
			} else {
				JOptionPane.showMessageDialog(this, "Manutenção não encontrada!");
			}
			
		}
	}	

	public static void main(String[] args) {
		OrcamentoProcess.abrir();
		OrcamentoForm tela = new OrcamentoForm();
		tela.setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Badicionar) {
			adicionar();
		}
		if (e.getSource() == Bbuscar) {
			buscar();
		}
		if (e.getSource() == Balterar) {
			alterar();
		}
		if (e.getSource() == Bexcluir) {
			excluir();
		}
	}
}

