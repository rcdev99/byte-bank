package br.com.alura.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JFrame implements ActionListener, KeyListener {

	/**
	 * Versionamento dos componentes da tela de Login
	 */
	private static final long serialVersionUID = 1L;
	
	//Componentes da tela
		JButton btnRecuperarSenha, btnAcessar;
		JLabel lblLogin, lblSenha, lblTitulo; 
		JTextField txtLogin;
		JPasswordField pwdSenha;

	//Construtor
	public TelaLogin() {
		
		// width: largura | heigth:altura 
		//setSize (widht, height) 
		setSize(410,320);
		setTitle("Login");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		init();
		setVisible(true);
			
	}
	
	private void init() {
		
		//Instanciando e definindo valores e dimensões para os componentes
				//Botão cadastrar
				btnAcessar = new JButton("Acessar");
				btnAcessar.setBounds(20, 								// parâmetro: 'x' - define localizacao do botão  -->  
									(getY() - 10),						// parâmetro: 'y' - define localizacao do botão  ^
									(getWidth() - 50), 					// parâmetro: "Widht" - define a largura do botão 
									 35);								// parâmetro: "Height" - define a altura do botão
				//Botão Acessar
				btnRecuperarSenha = new JButton("Recuperar senha");
				btnRecuperarSenha.setBounds( 20,   								// parâmetro: 'x' - define localizacao do botão  -->  
						(btnAcessar.getY() + btnAcessar.getHeight() + 10),   	// parâmtro: 'y' - define localizacao do botão  ^
									 btnAcessar.getWidth(), 					// parâmetro: "Widht" - define a largura do botão 
									 btnAcessar.getHeight() );					// parâmetro: "Height" - define a altura do botão		
				//Lable Título
				Font f1 = new Font("ComicSansMS", Font.BOLD, 30);
				lblTitulo = new JLabel("Byte Bank");
				lblTitulo.setFont(f1);
				lblTitulo.setBounds( 120,							// parâmetro: 'x' - define localizacao da label  -->  
									25,								// parâmtro: 'y' - define localizacao da label  ^
									200,							// parâmetro: "Widht" - define a largura da label
									35);							// parâmetro: "Height" - define a altura da label
				
				//Label Login
				//Definindo formatação do conteúdo da label
				Font f = new Font("ComicSansMS", Font.BOLD, 14);
				lblLogin = new JLabel("Login: ");
				lblLogin.setFont(f);
				lblLogin.setBounds( btnAcessar.getX(),				//parâmetro: 'x' - define a localização do label  -->  
									75,				  				//parâmetro: 'y' - define define a localização do label  ^  
									75,  							//parâmetro: 'width' - define a largura do label
									50);							//parâmetro: 'height' - define a altura do label 
				//Label Senha
				lblSenha = new JLabel("Senha: ");
				lblSenha.setFont(f);
				lblSenha.setBounds( btnAcessar.getX(),				//parâmetro: 'x' - define localizacao do label  -->  
									lblLogin.getY() + 50 ,			//parâmetro: 'y' - define localizacao do label  ^  
									lblLogin.getWidth(),  			//parâmetro: 'width' - define a largura do label
									lblLogin.getHeight());  		//parâmetro: 'height' - define a altura do label 
				//TextField Login
				txtLogin = new JTextField();
				txtLogin.setBounds( lblLogin.getWidth() ,			//parâmetro: 'x' - define localizacao do TextField -->  
									lblLogin.getY() + 15,			//parâmetro: 'y' - define localizacao do TextField  ^  
									300,							//parâmetro: 'width' - define a largura do TextField
									30);							//parâmetro: 'height' - define a altura do TextField
				//TextField Password
				pwdSenha = new JPasswordField();
				pwdSenha.setBounds( lblSenha.getWidth() ,			//parâmetro: 'x' - define localizacao do TextField -->  
									lblSenha.getY() + 15 ,			//parâmetro: 'y' - define localizacao do TextField  ^  
									300,							//parâmetro: 'width' - define a largura do TextField
									30);							//parâmetro: 'height' - define a altura do TextField
				
				
				//Adicionando componentes à tela
				add(btnAcessar);
				btnAcessar.addActionListener(this);
				add(btnRecuperarSenha);
				btnRecuperarSenha.addActionListener(this);
				add(lblLogin);
				add(lblSenha);
				add(txtLogin);
				add(pwdSenha);
				add(lblTitulo);
		
	}

	//
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		//Definição dos comportamentos a serem adotados de acordo com a interação do usuário
		
		//Ações - Botão Cadastrar
		if(action.getSource().equals(btnAcessar)) {
			JOptionPane.showMessageDialog(null, "Tela em processo de elaboração, desculpe-nos pelo transtorno :( ");
		}
		
		//Ações - Botão Entrar
		if(action.getSource().equals(btnRecuperarSenha)) {
			JOptionPane.showMessageDialog(null, "Calma meu filho, nasceu de 7 meses !?");
		}
		
	}

	
	
}
