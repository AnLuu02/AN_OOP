package do_an;

import java.io.Serializable;
import java.util.Scanner;

public class connguoi implements Serializable {

    protected String hoten;
    protected String ngaysinh;
    protected String gioitinh;
    protected String diachi;
    protected String dienthoai;
    protected String email;
    static Scanner sc = new Scanner(System.in);
    static kiemtra kt = new kiemtra();

    public connguoi() {
        hoten = "";
        ngaysinh = "";
        gioitinh = "";
        diachi = "";
        dienthoai = "";
        email = "";
    }

    public connguoi(String hoten, String ngaysinh, String gioitinh, String diachi, String dienthoai, String email) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.email = email;
    }

    public void setHoten(String hoten) {
        System.out.println("- Họ tên: ");
        hoten = kt.KiemTraNhapTenSanPham();
        this.hoten = hoten;
    }

    public void setNgaysinh(String ngaysinh) {
        System.out.println("- Ngày sinh: ");
        ngaysinh = sc.nextLine();
        this.ngaysinh = ngaysinh;
    }

    public void setGioitinh(String gioitinh) {
        System.out.println("- Giới tính: ");
        gioitinh = kt.KiemTraNhapTenSanPham();
        this.gioitinh = gioitinh;
    }

    public void setDiachi(String diachi) {
        System.out.println("- Địa chỉ: ");
        diachi = kt.KiemTraNhapChuoi();
        this.diachi = diachi;
    }

    public void setDienthoai(String dienthoai) {
        System.out.println("- Điện thoại: ");
        dienthoai = sc.nextLine();
        this.dienthoai = dienthoai;
    }

    public void setEmail(String email) {
        System.out.println("- Email: ");
        email = sc.nextLine();
        this.email = email;
    }

    public String gethoten() {
        return hoten;
    }

    public String getngaysinh() {
        return ngaysinh;
    }

    public String getgioitinh() {
        return gioitinh;
    }

    public String getdiachi() {
        return diachi;
    }

    public String getdienthoai() {
        return dienthoai;
    }

    public String getemail() {
        return email;
    }

    @Override
    public String toString() {
        return hoten + "\t" + ngaysinh + "\t" + gioitinh + "\t" + diachi + "\t" + dienthoai + "\t" + email + "\t";
    }

    public void nhap() {
        setHoten(gethoten());
        setNgaysinh(getngaysinh());
        setGioitinh(getgioitinh());
        setDiachi(getdiachi());
        setDienthoai(getdienthoai());
        setEmail(getemail());
    }

    public void HienThi() {
        System.out.printf("|%-20s|%-12s|%-12s|%-20s|%-15s|%-27s|\n", hoten, ngaysinh, gioitinh, diachi, dienthoai, email);
    }

}
