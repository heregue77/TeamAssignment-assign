import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App {
    JPanel panel1 = new JPanel();

    // 메뉴 정보
    String[] menu = {"라면", "치즈볼", "사이다"};
    int[] price = {2222, 3000, 1500};
    int[] cnt = {0, 0, 0};
    int total_price = 0;

    public App() {

        // 프레임 설정
        JFrame frame = new JFrame("vending machine");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().setLayout(null);

        // title
        JLabel main = new JLabel("Vending Machine");
        main.setFont(main.getFont().deriveFont(20.0f));
        main.setHorizontalAlignment(SwingConstants.CENTER);
        main.setBounds(12, 10, 460, 29);
        frame.getContentPane().add(main);

        JButton[] minus = new JButton[3];
        JButton[] plus = new JButton[3];
        JTextField[] cnt_in = new JTextField[3];

        ImageIcon tmp1 = new ImageIcon("images/ramen.jpg");
        ImageIcon img1 = imageSetSize(tmp1, 120, 142);
        JLabel imglabel_1 = new JLabel(img1);
        imglabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        imglabel_1.setBounds(31, 50, 120, 142);
        frame.getContentPane().add(imglabel_1);

        JLabel name_1 = new JLabel("라면, 2222원");
        name_1.setBounds(31,205,119,15);
        frame.getContentPane().add(name_1);

        JLabel cnt_1 = new JLabel("수량 >");
        cnt_1.setBounds(31, 233, 57, 15);
        frame.getContentPane().add(cnt_1);

        cnt_in[0] = new JTextField("0");
        cnt_in[0].setBounds(72, 230, 79, 21);
        cnt_in[0].setEditable(false);
        frame.getContentPane().add(cnt_in[0]);

        minus[0] = new JButton("-");
        minus[0].setBounds(31, 257, 55, 25);
        minus[0].setEnabled(false);
        frame.getContentPane().add(minus[0]);

        plus[0] = new JButton("+");
        plus[0].setBounds(96, 257, 55, 25);
        frame.getContentPane().add(plus[0]);



        ImageIcon tmp2 = new ImageIcon("images/cheese.jpeg");
        ImageIcon img2 = imageSetSize(tmp2, 120, 142);
        JLabel imglabel_2 = new JLabel(img2);
        imglabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        imglabel_2.setBounds(182, 50, 120, 142);
        frame.getContentPane().add(imglabel_2);

        JLabel name_2 = new JLabel("치즈볼, 3000원");
        name_2.setBounds(182,205,119,15);
        frame.getContentPane().add(name_2);

        JLabel cnt_2 = new JLabel("수량 >");
        cnt_2.setBounds(182, 232, 57, 15);
        frame.getContentPane().add(cnt_2);

        cnt_in[1] = new JTextField("0");
        cnt_in[1].setEditable(false);
        cnt_in[1].setBounds(223, 229, 79, 21);
        frame.getContentPane().add(cnt_in[1]);

        minus[1] = new JButton("-");
        minus[1].setBounds(182, 256, 55, 25);
        minus[1].setEnabled(false);
        frame.getContentPane().add(minus[1]);

        plus[1] = new JButton("+");
        plus[1].setBounds(247, 256, 55, 25);
        frame.getContentPane().add(plus[1]);



        ImageIcon tmp3 = new ImageIcon("images/sevenstar.jpg");
        ImageIcon img3 = imageSetSize(tmp3, 120, 142);
        JLabel imglabel_3 = new JLabel(img3);
        imglabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        imglabel_3.setBounds(333, 50, 120, 142);
        frame.getContentPane().add(imglabel_3);

        JLabel name_3 = new JLabel("사이다, 1500");
        name_3.setBounds(333,205,119,15);
        frame.getContentPane().add(name_3);

        JLabel cnt_3 = new JLabel("수량 >");
        cnt_3.setBounds(333, 232, 57, 15);
        frame.getContentPane().add(cnt_3);

        cnt_in[2] = new JTextField("0");
        cnt_in[2].setEditable(false);
        cnt_in[2].setBounds(374, 229, 79, 21);
        frame.getContentPane().add(cnt_in[2]);

        minus[2] = new JButton("-");
        minus[2].setBounds(333, 256, 55, 25);
        minus[2].setEnabled(false);
        frame.getContentPane().add(minus[2]);

        plus[2] = new JButton("+");
        plus[2].setBounds(398, 256, 55, 25);
        frame.getContentPane().add(plus[2]);




        JLabel money = new JLabel("현재 금액 > ");
        money.setBounds(130, 338, 92, 15);
        frame.getContentPane().add(money);

        JTextField money_in = new JTextField("");
        money_in.setColumns(10);
        money_in.setBounds(203, 335, 79, 21);
        frame.getContentPane().add(money_in);

        JLabel total = new JLabel("총액 > ");
        total.setBounds(130, 366, 92, 15);
        frame.getContentPane().add(total);

        JTextField total_out = new JTextField();
        total_out.setColumns(10);
        total_out.setEditable(false);
        total_out.setBounds(203, 363, 79, 21);
        frame.getContentPane().add(total_out);

        JButton calc = new JButton("계산");
        calc.setBounds(294, 334, 65, 50);
        frame.getContentPane().add(calc);

        frame.setVisible(true);

        for(int i = 0 ; i < 3 ; i++ ){
            int j = i;

            minus[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (cnt[j] > 1) {
                        cnt[j] = cnt[j] - 1;
                        cnt_in[j].setText(cnt[j] + "");
                        total_price -= price[j];
                        total_out.setText(total_price + "");
                    } 
                    else {
                        minus[j].setEnabled(false);
                    }
                }
            });

            plus[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(cnt[j] == 0) {
                        minus[j].setEnabled(true);
                    }
                    cnt[j] =cnt[j] + 1;
                    cnt_in[j].setText(cnt[j] + "");
                    total_price += price[j];
                    total_out.setText(total_price + "");
                    if (cnt[j] > 0) {
                        minus[j].setEnabled(true);
                    }
                }
            });
        }

        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(Integer.parseInt(money_in.getText()) < total_price) {
                    JOptionPane result = new JOptionPane();
                    result.showMessageDialog(null, "잔액이 부족해 주문할 수 없습니다.", "잔액 부족", JOptionPane.ERROR_MESSAGE);
                }
                // 여기부터 그리디 알고리즘
                else {
                    int coin[] = {10000, 5000, 1000, 500, 100, 50, 10, 1};
                    int coin_cnt[] = {0, 0, 0, 0, 0, 0, 0, 0};
                    int change = Integer.parseInt(money_in.getText()) - total_price;

                    for(int i = 0 ; i < coin.length ; i++){
                        coin_cnt[i] = change/coin[i];
                        change = change - (coin[i] * coin_cnt[i]);
                    }

                    JOptionPane result = new JOptionPane();
                    result.showMessageDialog(null, "거스름돈은 " + (Integer.parseInt(money_in.getText()) - total_price) + "원 입니다.\n" +
                            "10000원권 : " + coin_cnt[0] + "장\n" + "5000원권 : " + coin_cnt[1] + "장\n" + "1000원권 : " + coin_cnt[2] + "장\n" +
                            "500원 : " + coin_cnt[3] + "개\n" + "100원 : " + coin_cnt[4] + "개\n" + "50원 : " + coin_cnt[5] + "개\n"
                                    + "10원 : " + coin_cnt[6] + "개\n" + "1원 : " + coin_cnt[7] + "개\n"
                            , "거스름돈 반환", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public ImageIcon imageSetSize(ImageIcon icon, int i, int j){
        Image ximg = icon.getImage();
        Image yimg = ximg.getScaledInstance(i, j, Image.SCALE_SMOOTH);
        ImageIcon xyimg = new ImageIcon(yimg);
        return xyimg;
    }

    public static void main(String args[]){
        App app = new App();
    }
}
