package visao;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PetForm extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	// Atributos
	private JPanel painel;
	private JLabel r1, r2, r3, r4, r5, r6, r7, r8, imagemdoPet;
	private JTextField id, raca, nome, peso, nascimento, dono, telefone, quadro1;
	private JButton cadastrar, buscar, alterar, excluir;
	private JComboBox especie;
	private JTextArea resultados ;
	String imagepath = "C:\\Users\\desenvolvimento\\Desktop\\Programas-em-Java\\PETS\\img\\h.jpg";
	private ImageIcon icon = new ImageIcon(new ImageIcon(imagepath).getImage().getScaledInstance(240, 130, 100)); 
	private int autoId=1;
	PetForm() {
		// Propriedades Basicas;
		setTitle("Formulário de PETS");
		setBounds(1000, 100, 780, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new JPanel();
		setContentPane(painel);
		setLayout(null);
		painel.setBackground(new Color(204,255,229));

		// Conteudo da tela
		r1 = new JLabel("Id: ");
		r1.setBounds(40, 20, 100, 20);

		id = new JTextField(""+autoId);
		id.setEnabled(false);
		id.setBounds(120, 20, 250, 20);

		r2 = new JLabel("Especie: ");
		r2.setBounds(40, 60, 100, 20);

		especie = new JComboBox<Object>(new String [] {"Gato" , "Cachorro", "Coelho", "Passáro", "Hamster", "Outros..."});
		especie.setBounds(120, 60, 250, 20);

		r3 = new JLabel("Raça: ");
		r3.setBounds(40, 100, 100, 20);

		raca = new JTextField();
		raca.setBounds(120, 100, 250, 20);

		r4 = new JLabel("Nome: ");
		r4.setBounds(40, 140, 100, 20);

		nome = new JTextField();
		nome.setBounds(120, 140, 250, 20);

		r5 = new JLabel("Peso: ");
		r5.setBounds(40, 180, 100, 20);

		peso = new JTextField();
		peso.setBounds(120, 180, 250, 20);

		r6 = new JLabel("Nascimento: ");
		r6.setBounds(40, 220, 100, 20);

		nascimento = new JTextField();
		nascimento.setBounds(120, 220, 250, 20);

		r7 = new JLabel("Dono: ");
		r7.setBounds(40, 260, 100, 20);

		dono = new JTextField();
		dono.setBounds(120, 260, 250, 20);

		r8 = new JLabel("Telefone: ");
		r8.setBounds(40, 310, 100, 20);

		telefone = new JTextField();
		telefone.setBounds(120, 310, 250, 20);

		resultados = new JTextArea();
		resultados.setBounds(40, 450, 700, 200);
		resultados.enable(false);

		quadro1 = new JTextField();
		quadro1.setBounds(120, 180, 250, 20);

		cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(500, 50, 200, 30);
		cadastrar.addActionListener(this);

		buscar = new JButton("Buscar");
		buscar.setBounds(500, 90, 200, 30);
		buscar.addActionListener(this);

		alterar = new JButton("Alterar");
		alterar.setBounds(500, 130, 200, 30);
		alterar.addActionListener(this);
		alterar.setEnabled(false);

		excluir = new JButton("Excluir");
		excluir.setBounds(500, 170, 200, 30);
		excluir.addActionListener(this);
		excluir.setEnabled(false);

		imagemdoPet = new JLabel();
		imagemdoPet.setBounds(500, 230, 200, 200);
		imagemdoPet.setIcon(icon);
		
	
		resultados.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		imagemdoPet.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		
		
		painel.add(r1);
		painel.add(id);
		painel.add(r2);
		painel.add(especie);
		painel.add(r3);
		painel.add(raca);
		painel.add(r4);
		painel.add(nome);
		painel.add(r5);
		painel.add(peso);
		painel.add(r6);
		painel.add(nascimento);
		painel.add(r7);
		painel.add(dono);
		painel.add(r8);
		painel.add(telefone);
		painel.add(resultados);
		painel.add(quadro1);
		painel.add(cadastrar);
		painel.add(buscar);
		painel.add(alterar);
		painel.add(excluir);
		painel.add(imagemdoPet);

	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

//		public void actionPerformed(ActionEvent e) {
//			if (e.getSource() == login) {
//				int indice = UsuarioProcessa.checarEmail(Email.getText());
//				if (indice != -1) {
//					if (UsuarioProcessa.checarSenha(indice, Senha.getText())) {
//						JOptionPane.showMessageDialog(this, "Acesso permitido");
//						this.dispose();// Fecha o Formulário
//					} else {
//						JOptionPane.showMessageDialog(this, "Acesso negado");
//					}
//				} else {
//					JOptionPane.showMessageDialog(this, "Usuário não encontrado");
//				}
//			}
//		}
//
	public static void main(String[] args) {
//			UsuarioProcessa.carregar();
		PetForm tela = new PetForm();
		tela.setVisible(true);
		
		
	}
}
