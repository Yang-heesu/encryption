import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class Decryption extends cryption{
	
	public Decryption() {
		panel = this;
		
		title.setText("��ȣȭ");
		
		before_text.setText("��ȣ�� : ");
		after_text.setText("�� : ");
		change_btn.setText("��ȣ�� �����");
		
		
		change_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				key = key_str.getText();
				key = key.toLowerCase();
				str = before_str.getText();
				str = str.toLowerCase();
				
				setBoard(key);							//��ȣȭ�� ���� ��ȣ�� ����
				
					
				for( int i = 0 ; i < str.length() ; i++ ) 
				{
					if(str.charAt(i)==' ') //��������
						str = str.substring(0,i)+str.substring(i+1,str.length());
				}
					
				decryption_str = strDecryption(key, str, Check);

				after_str.setText(decryption_str);
					
				System.out.println("��ȣȭ�� ���ڿ� : " + decryption_str);
			}
		});
	}
}
