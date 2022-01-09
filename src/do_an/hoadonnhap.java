/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class hoadonnhap extends danhsachsanpham implements Serializable {

    protected String ngaynhap;
    protected nhacungcap nhacc;
    protected nhanviennhaphang nvnh;
    protected String mahoadon;
    protected sanpham[] spnhap;
    //protected sanpham[] temp;
    protected int tongtien;
    protected int soluong;

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        System.out.println("- Mã hóa đơn: ");
        mahoadon = kt.KiemTraNhapMaHoaDon();
        this.mahoadon = mahoadon;
    }

//    public sanpham[] getSpn() {
//        return spn;
//    }
//
//    public void setSpn(sanpham[] spn) {
//        this.spn = spn;
//    }
    public int getTongtien(int giaspn, int soluongspn) {
        tongtien = giaspn * soluongspn;
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        System.out.println("Ngày nhập: ");
        ngaynhap = kt.KiemTraNhapChuoi();
        this.ngaynhap = ngaynhap;
    }

    public nhacungcap getNhacc() {
        return nhacc;
    }

    public void setNhacc(nhacungcap nhacc) {
        nhacc = new nhacungcap();
        nhacc.setManhacungcap(nhacc.getManhacungcap());
        this.nhacc = nhacc;
    }

    public nhanviennhaphang getNvnh() {
        return nvnh;
    }

    public void setNvnh(nhanviennhaphang nvnh) {
        nvnh = new nhanviennhaphang();
        nvnh.setmanv(nvnh.getmanv());
        this.nvnh = nvnh;
    }

    public void nhaphang() throws IOException {
        setMahoadon(getMahoadon());
        setNhacc(getNhacc());
        setNvnh(getNvnh());
        setNgaynhap(getNgaynhap());
        int dem = 0;
        int k = 0;
        super.doc_file("sanpham.txt");
        super.HienThi();
        if (super.sp.length == 0) {
            System.out.println("- Hết hàng");
        } else {
            System.out.println("- Bạn cần nhập bao nhiêu sản phẩm?");
            soluong = kt.KiemTraNhapSoNguyen();
            spnhap = new sanpham[soluong];
            sanpham[] spn = new sanpham[sp.length + soluong];
            sanpham[] temp = new sanpham[sp.length + soluong];
            for (int i = 0; i < soluong; i++) {
                System.out.println("+==========================+");
                System.out.println("|           Loại           |");
                System.out.println("+==========================+");
                System.out.println("| 1. Thức ăn               |");
                System.out.println("| 2. Nước giải khát        |");
                System.out.println("+==========================+");
                System.out.println("- Bạn hãy lựa chọn: ");
                chon = sc.nextLine();
                switch (chon) {
                    case "1":
                        System.out.println("- Nhập sản phẩm thứ: " + (i + sp.length + 1));
                        spnhap[i] = new thucan();
                        spnhap[i].nhap();
                        tongtien += getTongtien(spnhap[i].getGia(), spnhap[i].getSoluong());

                        break;
                    case "2":
                        System.out.println("- Nhập sản phẩm thứ: " + (i + sp.length + 1));
                        spnhap[i] = new nuocgiaikhat();
                        spnhap[i].nhap();
                        tongtien += getTongtien(spnhap[i].getGia(), spnhap[i].getSoluong());

                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                }
            }
            for (int i = 0; i < sp.length; i++) {
                spn[i] = new sanpham() {
                    @Override
                    public void HienThi() {
                    }
                };
                spn[i] = super.sp[i];
            }
            for (int i = sp.length; i < (sp.length + soluong); i++) {
                spn[i] = new sanpham() {
                    @Override
                    public void HienThi() {
                    }
                };

                for (int j = 0; j < super.sp.length; j++) {
                    if (spnhap[i - sp.length].getTenSP().equals(spn[j].getTenSP())) {
                        System.out.println("- Sản phẩm " + spn[j].tenSP + " đã tồn tại. Số lượng sản phẩm đã được thêm vào.");
                        spn[j].soluong += spnhap[i - sp.length].getSoluong();
                        temp = super.sp;
                        break;
                    } else {
                        spn[i] = spnhap[i - sp.length];
                        temp = spn;
                    }
                }
            }
            file.ghi_file(temp, "sanpham.txt");
        }

    }

    @Override
    public void HienThi() {
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|\n", getMahoadon(), getNhacc().manhacungcap, getNvnh().manv, getNgaynhap(), tongtien);

    }

    public static void main(String[] args) throws IOException {
        hoadonnhap hdn = new hoadonnhap();
        hdn.nhaphang();
        System.out.println("Tong: " + hdn.tongtien);
    }
}
