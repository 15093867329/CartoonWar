import javax.swing.*;

public class JFrameHelloWorld{
    public static void main(String[] args){
        // �൱��body
		JFrame frame = new JFrame("ThisIsJFrame");
		// �൱��div
		JPanel panel = new JPanel();
		// �൱������
		JLabel label = new JLabel("helloword");
		// �����ַ���div��
		panel.add(label);
		// ��div����body��
		frame.setContentPane(panel);
		// ����body���
		frame.setSize(300,200);
		// ��body����Ϊ�ɼ�
		frame.setVisible(true);
	}
	
}