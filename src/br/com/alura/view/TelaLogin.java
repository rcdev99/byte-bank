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
		
		//Instanciando e definindo valores e dimens�es para os componentes
				//Bot�o cadastrar
				btnAcessar = new JButton("Acessar");
				btnAcessar.setBounds(20, 								// par�metro: 'x' - define localizacao do bot�o  -->  
									(getY() - 10),						// par�metro: 'y' - define localizacao do bot�o  ^
									(getWidth() - 50), 					// par�metro: "Widht" - define a largura do bot�o 
									 35);								// par�metro: "Height" - define a altura do bot�o
				//Bot�o Acessar
				btnRecuperarSenha = new JButton("Recuperar senha");
				btnRecuperarSenha.setBounds( 20,   								// par�metro: 'x' - define localizacao do bot�o  -->  
						(btnAcessar.getY() + btnAcessar.getHeight() + 10),   	// par�mtro: 'y' - define localizacao do bot�o  ^
									 btnAcessar.getWidth(), 					// par�metro: "Widht" - define a largura do bot�o 
									 btnAcessar.getHeight() );					// par�metro: "Height" - define a altura do bot�o		
				//Lable T�tulo
				Font f1 = new Font("ComicSansMS", Font.BOLD, 30);
				lblTitulo = new JLabel("Byte Bank");
				lblTitulo.setFont(f1);
				lblTitulo.setBounds( 120,							// par�metro: 'x' - define localizacao da label  -->  
									25,								// par�mtro: 'y' - define localizacao da label  ^
									200,							// par�metro: "Widht" - define a largura da label
									35);							// par�metro: "Height" - define a altura da label
				
				//Label Login
				//Definindo formata��o do conte�do da label
				Font f = new Font("ComicSansMS", Font.BOLD, 14);
				lblLogin = new JLabel("Login: ");
				lblLogin.setFont(f);
				lblLogin.setBounds( btnAcessar.getX(),				//par�metro: 'x' - define a localiza��o do label  -->  
									75,				  				//par�metro: 'y' - define define a localiza��o do label  ^  
									75,  							//par�metro: 'width' - define a largura do label
									50);							//par�metro: 'height' - define a altura do label 
				//Label Senha
				lblSenha = new JLabel("Senha: ");
				lblSenha.setFont(f);
				lblSenha.setBounds( btnAcessar.getX(),				//par�metro: 'x' - define localizacao do label  -->  
									lblLogin.getY() + 50 ,			//par�metro: 'y' - define localizacao do label  ^  
									lblLogin.getWidth(),  			//par�metro: 'width' - define a largura do label
									lblLogin.getHeight());  		//par�metro: 'height' - define a altura do label 
				//TextField Login
				txtLogin = new JTextField();
				txtLogin.setBounds( lblLogin.getWidth() ,			//par�metro: 'x' - define localizacao do TextField -->  
									lblLogin.getY() + 15,			//par�metro: 'y' - define localizacao do TextField  ^  
									300,							//par�metro: 'width' - define a largura do TextField
									30);							//par�metro: 'height' - define a altura do TextField
				//TextField Password
				pwdSenha = new JPasswordField();
				pwdSenha.setBounds( lblSenha.getWidth() ,			//par�metro: 'x' - define localizacao do TextField -->  
									lblSenha.getY() + 15 ,			//par�metro: 'y' - define localizacao do TextField  ^  
									300,							//par�metro: 'width' - define a largura do TextField
									30);							//par�metro: 'height' - define a altura do TextField
				
				
				//Adicionando componentes � tela
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
		//Defini��o dos comportamentos a serem adotados de acordo com a intera��o do usu�rio
		
		//A��es - Bot�o Cadastrar
		if(action.getSource().equals(btnAcessar)) {
			JOptionPane.showMessageDialog(null, "Tela em processo de elabora��o, desculpe-nos pelo transtorno :( ");
		}
		
		//A��es - Bot�o Entrar
		if(action.getSource().equals(btnRecuperarSenha)) {
			JOptionPane.showMessageDialog(null, "Calma meu filho, nasceu de 7 meses !?");
		}
		
	}

	
	
}
