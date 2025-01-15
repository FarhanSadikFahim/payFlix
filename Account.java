import java.io.*;
import java.util.*;

public class Account {
    private String user;
    private String pass;

    private File file;
    private FileWriter fwrite;
    private Scanner sc;

    public Account() {
    }

    public Account(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return this.user;
    }

    public String getPass() {
        return this.pass;
    }

    // Method to add account to the file
    public void addAccount() {
        try {
            file = new File("./data.txt");
            file.createNewFile();
            fwrite = new FileWriter(file, true);
            fwrite.write(getUser() + "\t");
            fwrite.write(getPass() + "\n");
            fwrite.flush();
            fwrite.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    // Method to check if account exists
    public boolean checkAccount(String user, String pass) {
        boolean flag = false;
        file = new File("./data.txt");
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] value = line.split("\t");
                if (value[0].equals(user) && value[1].equals(pass)) {
                    flag = true;
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        return flag;
    }

    // Method to delete account
    public void deleteAccount(String user) {
        try {
            File inputFile = new File("./data.txt");
            File tempFile = new File("./temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] values = currentLine.split("\t");
                if (!values[0].equals(user)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to update password
    public void updatePassword(String user, String newPass) {
        try {
            File inputFile = new File("./data.txt");
            File tempFile = new File("./temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] values = currentLine.split("\t");
                if (values[0].equals(user)) {
                    writer.write(user + "\t" + newPass + System.getProperty("line.separator"));
                } else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
