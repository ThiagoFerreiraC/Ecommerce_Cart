package general;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetUserDataView {

    List<String> userData;

    int necessaryDatas;

    public GetUserDataView(int necessaryDatas) {
        this.necessaryDatas = necessaryDatas;
    }

    public void display() {
        System.out.println("Please insert the required informations:");
    }

    public void getName() {
        System.out.println("Name");
        userData.add(getInput());
    }

    public void getPassword() {
        System.out.println("Password");
        userData.add(getInput());
    }

    public void getEmail() {
        System.out.println("E-mail");
        userData.add(getInput());
    }
    public void displayMenuOptions() {
        switch (necessaryDatas) {
            case 1:
                getEmail();
                getPassword();
                break;
            case 2:
                getName();
                getEmail();
                getPassword();
                break;
            default:
                System.out.println("invalid input");
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public List<String> getUserData() {
        return userData;
    }
}
