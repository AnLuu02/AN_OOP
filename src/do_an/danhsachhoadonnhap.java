/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author PC
 */
public class danhsachhoadonnhap extends danhsachnhanvien {

    protected hoadonnhap[] hdn;
    private int soluong1;
    protected danhsachnhacungcap dsncc;

    public danhsachhoadonnhap() {
    }

    public danhsachhoadonnhap(hoadonnhap[] hdn, int soluong1, nhanvien[] nv, int soluong) {
        super(nv, soluong);
        this.hdn = hdn;
        this.soluong1 = soluong1;
    }

    public hoadonnhap[] getHdn() {
        return hdn;
    }

    public void setHdn(hoadonnhap[] hdn) {
        this.hdn = hdn;
    }

    public int getSoluong1() {
        return soluong1;
    }

    public void setSoluong1(int soluong) {
        this.soluong1 = soluong;
    }

    @Override
    public void doc_file(String link) throws IOException {
        FileInputStream in = null;
        ObjectInputStream InputStream = null;
        try {
            in = new FileInputStream(link);
            InputStream = new ObjectInputStream(in);
            hdn = (hoadonnhap[]) InputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {

        } finally {
            if (in != null) {
                in.close();
            }
            if (InputStream != null) {
                InputStream.close();
            }
        }
    }

    @Override
    public void table() {
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tDanh sách sản phẩm\t\t\t\t|");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "Mã HD", "Mã KH", "Mã NCC", "Ngày xuất", "Tổng tiền");
        System.out.println("+-------------------------------------------------------------------------------+");

    }

    @Override
    public void footer() {
        System.out.println("+-------------------------------------------------------------------------------+");
    }

    public void nhaphoadon() throws IOException {
        System.out.println("- Hóa đơn nhập");
        hdn = new hoadonnhap[1];
        for (int i = 0; i < 1; i++) {
            hdn[i] = new hoadonnhap();
            hdn[i].nhaphang();
        }
    }

    public hoadonnhap[] them2() throws IOException {
        doc_file("hoadonnhap.txt");
        hoadonnhap[] temp = new hoadonnhap[hdn.length + 1];
        for (int i = 0; i < hdn.length; i++) {
            temp[i] = new hoadonnhap();
            temp[i] = hdn[i];
        }
        for (int i = hdn.length; i < (hdn.length + 1); i++) {
            System.out.println("- Hóa đơn thứ: " + (i + 1));
            temp[i] = new hoadonnhap();
            temp[i].nhaphang();

        }
        return temp;
    }

    @Override
    public void xoa() throws IOException {
        doc_file("hoadonnhap.txt");
        int i, j;
        if (hdn.length < 1) {
            System.out.println("- Danh sách rỗng");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+===========================+");
                System.out.println("|        Xóa hóa đơn        |");
                System.out.println("+===========================+");
                System.out.println("| 1. Theo mã hóa đơn        |");
                System.out.println("| 2. Theo mã khách hàng     |");
                System.out.println("| 0. Exit                   |");
                System.out.println("+===========================+");
                System.out.println("- Bạn hãy nhập lựa chọn: ");
                chon = sc.nextLine();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        String mahoadon;
                        System.out.println("- Nhập mã hóa đơn: ");
                        mahoadon = kt.KiemTraNhapMaHoaDon();
                        hoadonnhap[] temp = new hoadonnhap[hdn.length - 1];
                        for (i = j = 0; i < hdn.length; i++) {
                            if (!hdn[i].getMahoadon().equals(mahoadon)) {
                                temp[j++] = hdn[i];
                                dem++;
                            }
                        }
                        if (dem == hdn.length) {
                            System.out.println("- Không hóa đơn cần xóa");
                        } else {
                            System.out.println("- Xóa thành công.");
                        }
                        file.ghi_file(temp, "hoadonnhap.txt");
                        break;
                    case "2":
                        String manhacungcap;
                        System.out.println("- Nhập mã nhà cung cấp: ");
                        manhacungcap = kt.KiemTraNhapMaKhachHang();
                        hoadonnhap[] temp1 = new hoadonnhap[hdn.length - 1];
                        for (i = j = 0; i < hdn.length; i++) {
                            if (!hdn[i].getNhacc().manhacungcap.equals(manhacungcap)) {
                                temp1[j++] = hdn[i];
                                dem++;
                            }
                        }
                        if (dem == hdn.length) {
                            System.out.println("- Không có hóa đơn cần xóa");
                        } else {
                            System.out.println("- Xóa thành công.");
                        }
                        file.ghi_file(temp1, "hoadonnhap.txt");
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                        break;
                }
            } while (!chon.equals("0"));
        }
    }

    public void TimKiem() throws IOException {
        doc_file("hoadonnhap.txt");
        if (hdn.length < 1) {
            System.out.println("- Danh sách rỗng!!!!");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+==========================+");
                System.out.println("|         Tìm kiếm         |");
                System.out.println("+==========================+");
                System.out.println("| 1. Theo mã hóa đơn       |");
                System.out.println("| 2. Theo mã nhân viên     |");
                System.out.println("| 3. Theo mã khách hàng    |");
                System.out.println("| 4. Theo ngày             |");
                System.out.println("| 0. Exit                  |");
                System.out.println("+==========================+");
                System.out.println("- Bạn hãy lựa chọn: ");
                chon = sc.nextLine();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        System.out.println("- Nhập mã hóa đơn cần tìm: ");
                        String mahoadon = kt.KiemTraNhapMaHoaDon();
                        table();
                        for (int i = 0; i < hdn.length; i++) {
                            if (hdn[i].getMahoadon().equals(mahoadon)) {
                                dem++;
                                hdn[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có hóa đơn cần tìm");
                        }
                        footer();
                        break;
                    case "2":
                        System.out.println("- Nhập mã nhân viên: ");
                        String manhanvien = kt.KiemTraNhapMaNhanVien();
                        table();
                        for (int i = 0; i < hdn.length; i++) {
                            if (hdn[i].getNvnh().manv.equals(manhanvien)) {
                                dem++;
                                hdn[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có hóa đơn cần tìm");
                        }
                        footer();
                        break;
                    case "3":
                        System.out.println("- Nhập mã nhà cung cấp: ");
                        String manhacungcap = kt.KiemTraNhapMaKhachHang();
                        table();
                        for (int i = 0; i < hdn.length; i++) {
                            if (hdn[i].getNhacc().manhacungcap.equals(manhacungcap)) {
                                dem++;
                                hdn[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có hóa đơn cần tìm");
                        }
                        footer();
                        break;
                    case "4":
                        System.out.println("- Nhập ngày cần tìm: ");
                        String ngay = kt.KiemTraNhapChuoi();
                        table();
                        for (int i = 0; i < hdn.length; i++) {
                            if (hdn[i].getNgaynhap().equals(ngay)) {
                                dem++;
                                hdn[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có hóa đơn cần tìm");
                        }
                        footer();
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                        break;
                }
            } while (!chon.equals("0"));
        }
    }

    public void XuatNhanVienNhap() throws IOException {
        int dem = 0;
        doc_file("hoadonnhap.txt");
        super.doc_file("objnhanvien.txt");
        String ngaynhap;
        System.out.println("- Ngày nhập: ");
        ngaynhap = sc.nextLine();
        super.table();
        for (int i = 0; i < hdn.length; i++) {
            if (hdn[i].getNgaynhap().equals(ngaynhap)) {
                dem++;
                for (int j = 0; j < super.nv.length; j++) {
                    if (super.nv[j].getmanv().equals(hdn[i].getNvnh().manv) && super.nv[j].getChucvu().equals("Nhập hàng")) {
                        super.nv[j].HienThi();
                    }
                }
            }
        }
        if (dem == 0) {
            System.out.println("- Không tim thấy hóa đơn.");
        }
        super.footer();
    }

    public void XuatNhaCungCap() throws IOException {
        int dem = 0;
        doc_file("hoadonnhap.txt");
        HienThi();
        dsncc = new danhsachnhacungcap();
        dsncc.doc_file("nhacungcap.txt");
        String manhacungcap;
        System.out.println("- Mã nhà cung cấp: ");
        manhacungcap = kt.KiemTraNhapMaNhaCungCap();
        dsncc.table();
        for (int i = 0; i < hdn.length; i++) {
            if (hdn[i].getNhacc().manhacungcap.equals(manhacungcap)) {
                dem++;
                for (int j = 0; j < dsncc.nhacc.length; j++) {
                    if (dsncc.nhacc[j].manhacungcap.equals(hdn[i].getNhacc().manhacungcap)) {
                        dsncc.nhacc[j].xuatncc();
                    }
                }
            }
        }
        if (dem == 0) {
            System.out.println("- Không có nhà cung cấp này!");
        }
        dsncc.footer();
    }

    @Override
    public void HienThi() throws IOException {
        int dem = 0;
        doc_file("hoadonnhap.txt");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tDanh sách sản phẩm\t\t\t\t|");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "Mã HD", "Mã NCC", "Mã NV", "Ngày xuất", "Tổng tiền");
        System.out.println("+-------------------------------------------------------------------------------+");
        for (int i = 0; i < hdn.length; i++) {
            hdn[i].HienThi();
            dem++;
        }
        if (dem == 0) {
            System.out.println("|\t\t\t\tDanh sách rỗng!\t\t\t\t\t|");
        }
        System.out.println("+-------------------------------------------------------------------------------+");
    }

    @Override
    public void menu() throws IOException {
        String chon1;
        do {
            System.out.println("");
            System.out.println("+============================+");
            System.out.println("|            MENU            |");
            System.out.println("+============================+");
            System.out.println("| 1. Nhập mới                |");
            System.out.println("| 2. Xuất                    |");
            System.out.println("| 3. Thêm                    |");
            System.out.println("| 4. Xóa                     |");
            System.out.println("| 5. Tìm kiếm                |");
            System.out.println("| 6. Xuất nhân viên nhập     |");
            System.out.println("| 7. Thông tin nhà cung cấp  |");
            System.out.println("| 0. Kết thúc                |");
            System.out.println("+============================+");
            System.out.println("- Nhập lựa chon: ");
            chon1 = kt.KiemTraNhapChuoi();
            switch (chon1) {
                case "0":
                    break;
                case "1":
                    nhaphoadon();
                    file.ghi_file(hdn, "hoadonnhap.txt");
                    break;
                case "2":
                    HienThi();
                    break;
                case "3":
                    hdn = them2();
                    file.ghi_file(hdn, "hoadonnhap.txt");
                    break;
                case "4":
                    xoa();
                    break;
                case "5":
                    TimKiem();
                    break;
                case "6":
                    XuatNhanVienNhap();
                    break;
                case "7":
                    XuatNhaCungCap();
                    break;
                default:
                    System.out.println("- Lựa chọn không hợp lệ.");
            }
        } while (!chon1.equals("0"));
    }

    public static void main(String[] args) throws IOException {
        danhsachhoadonnhap dsn = new danhsachhoadonnhap();
        dsn.menu();
    }
}
