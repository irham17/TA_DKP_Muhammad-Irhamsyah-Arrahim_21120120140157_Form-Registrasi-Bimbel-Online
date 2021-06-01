import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tugasakhir {

    public JPanel panel1;
    private JComboBox comboboxbulan;
    private JButton beliButton;
    private JLabel labeljudul;
    private JLabel labelnama;
    private JLabel labelnomortelepon;
    private JLabel labelttl;
    private JLabel labelalamat;
    private JTextField textfieldnomortelepon;
    private JLabel labeljeniskelamin;
    private JTextField textfieldnama;
    private JRadioButton radiobuttonlaki;
    private JRadioButton radiobuttonperempuan;
    private JComboBox comboboxtahun;
    private JComboBox comboboxtanggal;
    private JTextArea textareaalamat;
    private JRadioButton radiobuttonsyarat;
    private JTextArea textareahasil;
    private JButton buttonsubmit;
    private JButton buttonbatal;
    private JTextField textfieldemail;
    private JLabel labelemail;
    private JTextField textfieldtempat;
    private JLabel labeldata;
    private JComboBox comboboxpaket;
    private JLabel labeljadwal;
    private JLabel labelharga;
    private JLabel labeldatadiri;
    private JLabel labelbiayadanjadwal;
    private JComboBox comboboxjadwal;
    private JTextField textfieldharga;
    private JTextArea textarearincian;
    private JLabel labelrincian;
    public String awalan;
    int harga;

    public void setAwalan(String awalan) {
        this.awalan = awalan;
    }

    public String getAwalan() {
        return awalan;
    }

    int cekemail(){
        String email = textfieldemail.getText();
        if(email.contains("@")) {
            textfieldemail.setEditable(true);
            return 1;
        }else{
            JOptionPane.showMessageDialog(panel1, "Masukkan email yang valid");
            return 0;
        }
    }

    public tugasakhir() {
        buttonsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonsubmit) {
                    if(textfieldnama.getText().equals("")){
                        JOptionPane.showMessageDialog(panel1, "Silakan masukkan nama");
                    }else if(textfieldnomortelepon.getText().equals("")){
                        JOptionPane.showMessageDialog(panel1, "Silakan masukkan nomor telepon");
                    }else if(textfieldemail.getText().equals("")){
                        JOptionPane.showMessageDialog(panel1, "Silakan masukkan email");
                    }else if(textareaalamat.getText().equals("")){
                        JOptionPane.showMessageDialog(panel1, "Silakan masukkan alamat");
                    }else if(textfieldtempat.getText().equals("")){
                        JOptionPane.showMessageDialog(panel1, "Silakan masukkan tempat lahir");
                    }else if(comboboxjadwal.getSelectedItem().equals("...")){
                        JOptionPane.showMessageDialog(panel1, "Silakan pilih jadwal yang tersedia");
                    }else if(comboboxpaket.getSelectedItem().equals("...")) {
                        JOptionPane.showMessageDialog(panel1, "Silakan pilih paket yang tersedia");
                    }else{
                        if (radiobuttonsyarat.isSelected()) {
                            String data1 = null;
                            String data4 = null;
                            String data = "Nama : " + textfieldnama.getText() + "\n" + "Nomor telepon : " + textfieldnomortelepon.getText() + "\n";
                            if (cekemail() == 1) {
                                if (radiobuttonlaki.isSelected()){
                                    data1 = "Jenis kelamin : Laki-laki" + "\n";
                                }else if(radiobuttonperempuan.isSelected()){
                                    data1 = "Jenis kelamin : Perempuan" + "\n";
                                }

                                if(comboboxpaket.getSelectedItem().equals("Standard")){
                                    data4 = "Paket : Standard" + "\n" + "Harga : Rp 5.000.000,-" + "\n";
                                }else if(comboboxpaket.getSelectedItem().equals("Intermediate")){
                                    data4 = "Paket : Intermediate" + "\n" + "Harga : Rp 6.000.000,-" + "\n";
                                }else if(comboboxpaket.getSelectedItem().equals("High")){
                                    data4 = "Paket : High" + "\n" + "Harga : Rp 7.000.000,-" + "\n";
                                }

                                String data2 = "Tempat, tanggal lahir : " + textfieldtempat.getText() + ", " + (String) comboboxtanggal.getSelectedItem() + " "
                                        + (String) comboboxbulan.getSelectedItem() + " " + (String) comboboxtahun.getSelectedItem() + "\n";

                                String data3 = "Alamat : " + textareaalamat.getText() + "\n" + "Email : " + textfieldemail.getText() + "\n";

                                String data5 = "Jadwal : " + comboboxjadwal.getSelectedItem() + "\n";

                                textareahasil.setText(data + data1 + data2 + data3);
                                textarearincian.setText(data4 + data5);
                                textareahasil.setEditable(false);
                                textarearincian.setEditable(false);
                                JOptionPane.showMessageDialog(panel1, "Registrasi berhasil");
                            }else if(cekemail() == 0){
                                JOptionPane.showMessageDialog(panel1, "Masukkan email yang valid");
                            }
                        }else {
                            textareahasil.setText("");
                            JOptionPane.showMessageDialog(panel1, "Mohon tekan syarat dan ketentuan");
                        }
                    }
                }
            }
        });

        textfieldnomortelepon.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                String nomor = textfieldnomortelepon.getText();
                int length = nomor.length();
                char c = e.getKeyChar();
                if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {
                    if(length<=12){
                        textfieldnomortelepon.setEditable(true);
                    }else{
                        textfieldnomortelepon.setEditable(false);
                    }
                }else{
                    if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
                        textfieldnomortelepon.setEditable(true);
                    }else{
                        textfieldnomortelepon.setEditable(false);
                    }
                }
            }
        });

        buttonbatal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfieldnama.setText("");
                textareaalamat.setText("");
                textfieldnomortelepon.setText("");
                textareahasil.setText("");
                radiobuttonsyarat.setSelected(false);
                textfieldtempat.setText("");
                comboboxtanggal.setSelectedIndex(0);
                comboboxbulan.setSelectedIndex(0);
                comboboxtahun.setSelectedIndex(0);
                textareaalamat.setText("");
                textfieldemail.setText("");
                comboboxpaket.setSelectedIndex(0);
                comboboxjadwal.setSelectedIndex(0);
                textarearincian.setText("");
                textfieldharga.setText("");
            }
        });

        comboboxpaket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paket = (String) comboboxpaket.getSelectedItem();
                switch (paket) {
                    case "Standard":
                        textareahasil.setText("");
                        harga = 5000000;
                        break;
                    case "Intermediate":
                        textareahasil.setText("");
                        harga = 6000000;
                        break;
                    case "High":
                        textareahasil.setText("");
                        harga = 7000000;
                        break;
                }
                textfieldharga.setText("Rp " + Integer.toString(harga));
                textfieldharga.setEditable(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form Registrasi TEKA Bimbel");
        frame.setContentPane(new tugasakhir().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 700);
        frame.setResizable(false);

        tugasakhir obj = new tugasakhir();
        obj.setAwalan("Silakan isi data berikut");

        JOptionPane.showMessageDialog(frame, obj.getAwalan());
    }

}
