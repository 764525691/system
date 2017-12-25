package com.system.frame;



import com.system.model.User;
import com.system.ui.Style;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import static com.system.ui.Style.setButtonStyle;
import static com.system.ui.Style.setBoldFontFont;
import static com.system.ui.Style.setSmallButtonStyle;

/**
 * @author 邓益聪
 * 主界面与权限功能的实现
 * Created by asus on 2017/12/20.
 */
public class MainFrame extends JFrame{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel contentPanel;
    private JLabel iconLabel;
    private JButton cancelButton;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel logoLabel;
    private JLabel dateLabel;
    private JLabel wheatherLabel;
    private JButton[] buttons;
    private JButton[] jButtons;
    private int i = 0;
    private User user;
    private Map<String,List<String>> userAuthorityMap;



    public MainFrame(User user, Map<String,List<String>> userAuthorityMap) {
        this.user = user;
        this.userAuthorityMap = userAuthorityMap;
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        add(mainPanel);

        topPanel = new JPanel();
        nameLabel.setText(user.getName());
        idLabel.setText(user.getUserid());
        iconLabel.setIcon(new ImageIcon(user.getPicture()));

        setButtonStyle(cancelButton);
        setBoldFontFont(cancelButton);


        int count = userAuthorityMap.entrySet().size();
        buttons = new JButton[count];

        CardLayout card = new CardLayout();
        contentPanel.setLayout(card);

        Iterator<Map.Entry<String, List<String>>> iterator = userAuthorityMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            String groupName = entry.getKey();
            //生成权限组按钮
            JButton jButton = new JButton(groupName);
            Style.setButtonStyle(jButton);
            leftPanel.add(jButton);
            buttons[i] = jButton;

            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int lenght = entry.getValue().size();
                    jButtons = new JButton[lenght];
                    for (int j = 0 ; j < lenght ; j ++){
                        jButtons[j] = new JButton(entry.getValue().toString());
                        leftPanel.add(jButtons[i]);
                    }

                }
            });

            i++;
        }




        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }



}




