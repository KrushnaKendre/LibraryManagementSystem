import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LibraryManagementSystem extends JFrame implements ActionListener {

    JTextField bookIDField, bookNameField, authorField;
    JButton addBtn, deleteBtn, clearBtn, exitBtn;
    JTable table;
    DefaultTableModel model;

    ArrayList<String[]> bookList = new ArrayList<>();

    public LibraryManagementSystem() {

        setTitle("Library Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Gradient background panel
        JPanel bg = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(75, 0, 130),
                        0, getHeight(), new Color(123, 31, 162));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bg.setLayout(null);
        bg.setBounds(0, 0, 900, 600);
        add(bg);

        JLabel title = new JLabel("Library Management System");
        title.setBounds(200, 20, 600, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        bg.add(title);

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setBounds(50, 80, 350, 400);
        formPanel.setBackground(new Color(255, 255, 255, 220));
        formPanel.setLayout(null);
        formPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        bg.add(formPanel);

        JLabel idLabel = new JLabel("Book ID:");
        idLabel.setBounds(20, 30, 120, 25);
        idLabel.setFont(new Font("Arial", Font.BOLD, 16));
        formPanel.add(idLabel);

        bookIDField = new JTextField();
        bookIDField.setBounds(150, 30, 150, 25);
        formPanel.add(bookIDField);

        JLabel nameLabel = new JLabel("Book Name:");
        nameLabel.setBounds(20, 80, 120, 25);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        formPanel.add(nameLabel);

        bookNameField = new JTextField();
        bookNameField.setBounds(150, 80, 150, 25);
        formPanel.add(bookNameField);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(20, 130, 120, 25);
        authorLabel.setFont(new Font("Arial", Font.BOLD, 16));
        formPanel.add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(150, 130, 150, 25);
        formPanel.add(authorField);

        // Buttons
        addBtn = new JButton("Add Book");
        addBtn.setBounds(20, 200, 130, 40);
        addBtn.setBackground(new Color(46, 125, 50));
        addBtn.setForeground(Color.WHITE);
        addBtn.addActionListener(this);
        formPanel.add(addBtn);

        deleteBtn = new JButton("Delete Book");
        deleteBtn.setBounds(170, 200, 130, 40);
        deleteBtn.setBackground(new Color(198, 40, 40));
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.addActionListener(this);
        formPanel.add(deleteBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(20, 260, 130, 40);
        clearBtn.setBackground(new Color(25, 118, 210));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.addActionListener(this);
        formPanel.add(clearBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(170, 260, 130, 40);
        exitBtn.setBackground(new Color(230, 81, 0));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener(this);
        formPanel.add(exitBtn);

        // Table Panel
        model = new DefaultTableModel(new String[]{"Book ID", "Book Name", "Author"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBounds(430, 80, 430, 400);
        bg.add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addBtn) {

            String id = bookIDField.getText();
            String name = bookNameField.getText();
            String author = authorField.getText();

            if (id.isEmpty() || name.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
                return;
            }

            model.addRow(new Object[]{id, name, author});
            JOptionPane.showMessageDialog(this, "Book Added Successfully!");

        }

        else if (e.getSource() == deleteBtn) {
            int row = table.getSelectedRow();
            if (row >= 0) {
                model.removeRow(row);
                JOptionPane.showMessageDialog(this, "Book Deleted!");
            } else {
                JOptionPane.showMessageDialog(this, "Select a row to delete!");
            }
        }

        else if (e.getSource() == clearBtn) {
            bookIDField.setText("");
            bookNameField.setText("");
            authorField.setText("");
        }

        else if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
}
