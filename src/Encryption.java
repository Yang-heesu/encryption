import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Encryption extends cryption{
	
	public Encryption() {
		panel = this;
		
		key = key_str.getText();
		key = key.toLowerCase();
		str = before_str.getText();
		str = str.toLowerCase();
		
		
		title.setText("암호화");
		change_btn.setText("암호문 만들기");
		change_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				key = key_str.getText();
				key = key.toLowerCase();
				str = before_str.getText();
				str = str.toLowerCase();
				
				setBoard(key);							//암호화에 쓰일 암호판 세팅
					
				for( int i = 0 ; i < str.length() ; i++ ) 
				{
					if(str.charAt(i)==' ') //공백제거
					{
						str = str.substring(0,i)+str.substring(i+1,str.length());
						b_Check+=10;
					}
					else
					{
						b_Check+=0;
					}
					if(str.charAt(i)=='z') //z를 q로 바꿔줘서 처리함.
					{
						str = str.substring(0,i)+'q'+str.substring(i+1,str.length());
						Check+=1;
					}
					else 
					{
						Check+=0;
					}
				}
					
				encryption_str = strEncryption(key, str);
				after_str.setText(encryption_str);
				System.out.println("암호화된 문자열 : " + encryption_str);
				}
		});
	}

}
