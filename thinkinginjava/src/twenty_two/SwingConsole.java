package twenty_two;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingConsole {

public static void runJF(final JFrame f,final int  width,final int height){
	SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			f.setTitle(f.getClass().getSimpleName());
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(width,height);
			f.setVisible(true);
		}
	});
}

}
