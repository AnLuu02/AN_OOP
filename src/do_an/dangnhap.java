package do_an;

import java.util.Scanner;

public class dangnhap {

    protected String taikhoan;
    protected String matkhau;
    static Scanner sc = new Scanner(System.in);
    static kiemtra kt = new kiemtra();
    static String chon = null;

    public dangnhap() {
    }

    public dangnhap(String taikhoan, String matkhau) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void nhap() {
        System.out.print("- Tài khỏan: ");
        taikhoan = sc.nextLine();
        System.out.print("- Mật khẩu: ");
        matkhau = sc.nextLine();
    }
}
