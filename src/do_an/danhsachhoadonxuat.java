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
public class danhsachhoadonxuat extends danhsachnhanvien {

    protected hoadonxuat[] hdx;
    private int soluong;
    protected khachhang[] kh;

    public danhsachhoadonxuat() {
        hdx = null;
        soluong = 0;
    }

    public danhsachhoadonxuat(hoadonxuat[] hdx, int soluong) {
        this.hdx = hdx;
        this.soluong = soluong;
    }

    public hoadonxuat[] getHdx() {
        return hdx;
    }

    public void setHdx(hoadonxuat[] hdx) {
        this.hdx = hdx;
    }

    @Override
    public int getSoluong() {
        return soluong;
    }

    @Override
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public void doc_file(String link) throws IOException {
        FileInputStream in = null;
        ObjectInputStream InputStream = null;
        try {
            in = new FileInputStream(link);
            InputStream = new ObjectInputStream(in);
            hdx = (hoadonxuat[]) InputStream.readObject();
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
    
    public void doc_file_kh(String link) throws IOException {
        FileInputStream in = null;
        ObjectInputStream InputStream = null;
        try {
            in = new FileInputStream(link);
            InputStream = new ObjectInputStream(in);
            kh = (khachhang[]) InputStream.readObject();
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
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "Mã HD", "Mã KH", "Mã NV", "Ngày xuất", "Tổng tiền");
        System.out.println("+-------------------------------------------------------------------------------+");

    }

    @Override
    public void footer() {
        System.out.println("+-------------------------------------------------------------------------------+");
    }

    public void nhaphoadon() throws IOException {
        System.out.println("- Nhập hóa đơn: ");
        hdx = new hoadonxuat[1];
        kh = new khachhang[1];
        for (int i = 0; i < 1; i++) {
            hdx[i] = new hoadonxuat();
            kh[i]=new khachhang();
            hdx[i].nhap();
            System.out.println("- Nhập thông tin khách hàng");
            kh[i].nhapkh();
            kh[i].ngaymua=hdx[i].ngayxuat;
            kh[i].makh=hdx[i].kh.getmakh();
        }
    }

    public hoadonxuat[] them1() throws IOException {
        doc_file("hoadonxuat.txt");
        doc_file_kh("khachhang.txt");
        hoadonxuat[] temp = new hoadonxuat[hdx.length + 1];
        khachhang[] tempkh=new khachhang[kh.length+1];
        for (int i = 0; i < hdx.length; i++) {
            temp[i] = new hoadonxuat();
            temp[i] = hdx[i];
            tempkh[i]=kh[i];
        }
        for (int i = hdx.length; i < (hdx.length + 1); i++) {
            System.out.println("- Nhập hóa đơn thứ: " + (i + 1));
            temp[i] = new hoadonxuat();
            tempkh[i]=new khachhang();
            temp[i].nhap();
            tempkh[i].nhapkh();
            tempkh[i].ngaymua=temp[i].ngayxuat;
            tempkh[i].makh=temp[i].kh.getmakh();
        }
        file.ghi_file(tempkh,"khachhang.txt");
        return temp;
    }

    @Override
    public void xoa() throws IOException {
        doc_file("hoadonxuat.txt");
        int i, j;
        if (hdx.length < 1) {
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
                        hoadonxuat[] temp = new hoadonxuat[hdx.length - 1];
                        for (i = j = 0; i < hdx.length; i++) {
                            if (!hdx[i].getMahoadon().equals(mahoadon)) {
                                temp[j++] = hdx[i];
                                dem++;
                            }
                        }
                        if (dem == hdx.length) {
                            System.out.println("- Không hóa đơn cần xóa");
                        } else {
                            System.out.println("- Xóa thành công.");
                        }
                        file.ghi_file(temp, "hoadonxuat.txt");
                        break;
                    case "2":
                        String makhachhang;
                        System.out.println("- Nhập mã khách hàng: ");
                        makhachhang = kt.KiemTraNhapMaKhachHang();
                        hoadonxuat[] temp1 = new hoadonxuat[hdx.length - 1];
                        for (i = j = 0; i < hdx.length; i++) {
                            if (!hdx[i].getKh().makh.equals(makhachhang)) {
                                temp1[j++] = hdx[i];
                                dem++;
                            }
                        }
                        if (dem == hdx.length) {
                            System.out.println("- Không có hóa đơn cần xóa");
                        } else {
                            System.out.println("- Xóa thành công.");
                        }
                        file.ghi_file(temp1, "hoadonxuat.txt");
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                        break;
                }
            } while (!chon.equals("0"));
        }
    }

    public void TimKiem() throws IOException {
        doc_file("hoadonxuat.txt");
        if (hdx.length < 1) {
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
                        for (int i = 0; i < hdx.length; i++) {
                            if (hdx[i].getMahoadon().equals(mahoadon)) {
                                dem++;
                                hdx[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có hóa đơn cần tìm");
                        }
                        footer();
                        break;
                    case "2":
                        System.out.println("- Nhập tên mã nhân viên: ");
                        String manhanvien = kt.KiemTraNhapMaNhanVien();
                        table();
                        for (int i = 0; i < hdx.length; i++) {
                            if (hdx[i].getNvbh().manv.equals(manhanvien)) {
                                dem++;
                                hdx[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có hóa đơn cần tìm");
                        }
                        footer();
                        break;
                    case "3":
                        System.out.println("- Nhập mã khách hàng: ");
                        String makhachhang = kt.KiemTraNhapMaKhachHang();
                        table();
                        for (int i = 0; i < hdx.length; i++) {
                            if (hdx[i].getKh().makh.equals(makhachhang)) {
                                dem++;
                                hdx[i].HienThi();
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
                        for (int i = 0; i < hdx.length; i++) {
                            if (hdx[i].getNgayxuat().equals(ngay)) {
                                dem++;
                                hdx[i].HienThi();
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

    public void XuatNhanVienBan() throws IOException {
        int dem = 0;
        doc_file("hoadonxuat.txt");
        super.doc_file("objnhanvien.txt");
        String ngayban;
        System.out.println("- Nhập ngày bán");
        ngayban = sc.nextLine();
        super.table();
        for (int i = 0; i < hdx.length; i++) {
            if (hdx[i].getNgayxuat().equals(ngayban)) {
                dem++;
                for (int j = 0; j < super.nv.length; j++) {
                    if (super.nv[j].getmanv().equals(hdx[i].getNvbh().manv) && super.nv[j].getChucvu().equals("Bán hàng")) {
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

    @Override
    public void HienThi() throws IOException {
        int dem = 0;
        doc_file("hoadonxuat.txt");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tDanh sách sản phẩm\t\t\t\t|");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "Mã HD", "Mã KH", "Mã NV", "Ngày xuất", "Tổng tiền");
        System.out.println("+-------------------------------------------------------------------------------+");
        for (int i = 0; i < hdx.length; i++) {
            hdx[i].HienThi();
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
            System.out.println("+=======================+");
            System.out.println("|          MENU         |");
            System.out.println("+=======================+");
            System.out.println("| 1. Nhập mới           |");
            System.out.println("| 2. Xuất               |");
            System.out.println("| 3. Thêm               |");
            System.out.println("| 4. Xóa                |");
            System.out.println("| 5. Tìm kiếm           |");
            System.out.println("| 6. Xuất nhân viên bán |");
            System.out.println("| 0. Kết thúc           |");
            System.out.println("+=======================+");
            System.out.println("- Nhập lựa chon: ");
            chon1 = kt.KiemTraNhapChuoi();
            switch (chon1) {
                case "0":
                    break;
                case "1":
                    nhaphoadon();
                    file.ghi_file(hdx, "hoadonxuat.txt");
                    file.ghi_file(kh, "khachhang.txt");
                    break;
                case "2":
                    HienThi();
                    break;
                case "3":
                    hdx = them1();
                    file.ghi_file(hdx, "hoadonxuat.txt");
                    break;
                case "4":
                    xoa();
                    break;
                case "5":
                    TimKiem();
                    break;
                case "6":
                    XuatNhanVienBan();
                    break;
                default:
                    System.out.println("- Lựa chọn không hợp lệ.");
            }
        } while (!chon1.equals("0"));
    }

    public static void main(String[] args) throws IOException {
        danhsachhoadonxuat dshd = new danhsachhoadonxuat();
        dshd.menu();
    }
}
