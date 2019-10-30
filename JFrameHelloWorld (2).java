import javax.swing.*;
public class JFrameHelloWorld{
	public static void main(String[] args){
		JFrame frame = new JFrame("thisIsJFrame");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("JFrameHelloWorld");
		panel.add(label);
		frame.setContentPane(panel);
		frame.setSize(300,200);
		frame.setVisible(true);
	}
}