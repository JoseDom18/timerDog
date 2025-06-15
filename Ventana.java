import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;

public class Ventana extends JFrame {

  private JLabel etiqueta;
  private JButton boton;

  public Ventana() {

    setTitle("Timer Dog");
    setSize(500, 400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    
    etiqueta = new JLabel("Presiona para iniciar el TimerDog");
    boton = new JButton("Presioname!");
    
    add(etiqueta);
    add(boton);
    
    boton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        etiqueta.setText("TimerDog iniciado");
      }
    });
    
    setVisible(true);
    
  }


}
