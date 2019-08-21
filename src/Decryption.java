import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class Decryption extends cryption{
	
	public Decryption() {
		panel = this;
		
		title.setText("복호화");
		
		before_text.setText("암호문 : ");
		after_text.setText("평문 : ");
		change_btn.setText("복호문 만들기");
		
		
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
						str = str.substring(0,i)+str.substring(i+1,str.length());
				}
					
				decryption_str = strDecryption(key, str, Check);

				after_str.setText(decryption_str);
					
				System.out.println("복호화된 문자열 : " + decryption_str);
			}
		});
	}
}
