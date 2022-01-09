/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.Serializable;
import java.util.Scanner;

public abstract class sanpham implements Serializable {

    static kiemtra kt = new kiemtra();
    protected String maSP;
    protected String tenSP;
    protected int gia;
    protected int soluong;
    static Scanner sc = new Scanner(System.in);

    public sanpham() {
        maSP = "";
        tenSP = "";
        soluong = 0;
        gia = 0;

    }

    public sanpham(String maSP, String tenSP, int gia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.gia = gia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        System.out.println("- Nhập mã sản phẩm: ");
        maSP = kt.KiemTraNhapMaSanPham();
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        System.out.println("- Nhập tên sản phẩm: ");
        tenSP = kt.KiemTraNhapTenSanPham();
        this.tenSP = tenSP;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(double gia) {
        System.out.println("- Nhập giá sản phẩm: ");
        gia = kt.KiemTraNhapGiaTien();
        this.gia = (int) gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        System.out.println("- Nhap so luong: ");
        soluong = kt.KiemTraNhapSoNguyenDuong();
        this.soluong = soluong;
    }

    public void nhap() {
        setMaSP(getMaSP());
        setTenSP(getTenSP());
        setGia(getGia());
        setSoluong(soluong);
    }

    abstract public void HienThi();

}
