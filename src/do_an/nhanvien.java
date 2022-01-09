package do_an;

import java.io.Serializable;

public class nhanvien extends connguoi implements Serializable {

    protected String manv;
    protected String calamviec;
    protected String chucvu;

    public nhanvien() {
        super();
        manv = "";
        calamviec = "";
        chucvu = "";
    }

    public nhanvien(String manv, String calamviec, String chucvu, String hoten, String ngaysinh, String gioitinh, String diachi, String dienthoai, String email) {
        super(hoten, ngaysinh, gioitinh, diachi, dienthoai, email);
        this.manv = manv;
        this.calamviec = calamviec;
        this.chucvu = chucvu;
    }

    public void setmanv(String manv) {
        System.out.println("- Nhập mã nhân viên: ");
        manv = kt.KiemTraNhapMaNhanVien();
        this.manv = manv;
    }

    public void setcalamviec(String calamviec) {
        System.out.println("- Nhập ca làm việc: ");
        calamviec = sc.nextLine();
        this.calamviec = calamviec;
    }

    public String getmanv() {
        return manv;
    }

    public String getcalamviec() {
        return calamviec;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    @Override
    public String toString() {
        return manv + "\t" + calamviec + "\t" + getChucvu() + "\t";
    }

    @Override
    public void nhap() {
        setmanv(getmanv());
        super.nhap();
        setcalamviec(getcalamviec());
    }

    @Override
    public void HienThi() {
        System.out.printf("|%-15s|%-15s|%-15s|%-20s|%-12s|%-12s|%-20s|%-15s|%-27s|\n", manv, calamviec, chucvu, super.hoten, super.ngaysinh, super.gioitinh, super.diachi, super.dienthoai, super.email);
    }
}
