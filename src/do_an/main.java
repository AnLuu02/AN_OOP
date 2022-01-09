package do_an;

import java.util.Scanner;

public class main {

    kiemtra kt = new kiemtra();
    private dangnhap user;
    private dangnhap admin;
    static Scanner sc = new Scanner(System.in);

    public main() {
    }

    public main(dangnhap user, dangnhap admin) {
        this.user = user;
        this.admin = admin;
    }

    public dangnhap getUser() {
        return user;
    }

    public void setUser(dangnhap user) {
        this.user = user;
    }

    public dangnhap getAdmin() {
        return admin;
    }

    public void setAdmin(dangnhap admin) {
        this.admin = admin;
    }

    public void dangnhap() {
        String chon;
        do {
            System.out.println("----------Welcome to Login!----------");
            System.out.println("+===================================+");
            System.out.println("|               Login               |");
            System.out.println("+===================================+");
            System.out.println("| 1. Đăng nhập với quyền User       |");
            System.out.println("| 2. Đăng nhập với quyên Admin      |");
            System.out.println("| 0. Exit                           |");
            System.out.println("+===================================+");
            System.out.println("- Chọn quyền truy cập: ");
            chon = sc.nextLine();
            switch (chon) {
                case "0":
                    System.out.println("+----------- HẸN GẶP LẠI -----------+");
                    break;
                case "1":
                    user = new user();
                    user.nhap();
                    break;
                case "2":
                    admin = new admin();
                    admin.nhap();
                    break;
                default:
                    System.out.println("- Sai! Mời nhập lại (hãy nhập lựa chọn từ 0->3.)");
            }
        } while (!chon.equals("0"));
    }

    public static void main(String[] args) {
        main bg = new main();
        bg.dangnhap();
    }
}
